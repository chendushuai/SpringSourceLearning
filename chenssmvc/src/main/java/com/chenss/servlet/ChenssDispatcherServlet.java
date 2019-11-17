package com.chenss.servlet;

import com.chenss.annotation.Controller;
import com.chenss.annotation.RequestMapping;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParser;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class ChenssDispatcherServlet extends HttpServlet {
    private static final String COMPENT_SCAN_ELEMENT_ATTRIBUTE_PACKAGE_NAME = "package";
    private static final String COMPENT_SCAN_ELEMENT_NAME = "compentScan";
    private static final String XML_PATH_LOCAL_ELEMENT_NAME = "xmlPathLocal";

    private static String prefix = "";
    private static String suffix = "";

    private static String projectPath = ChenssDispatcherServlet.class.getResource("/").getPath();

    private static Map<String, Method> urlMethodMap = new HashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        // 解析XML  解析web.xml 解析spring配置的xml
        projectPath = projectPath.replaceAll("%20", "");
        String initParam = config.getInitParameter(XML_PATH_LOCAL_ELEMENT_NAME);

        // 扫描项目
        File file = new File(projectPath + "//" + initParam);
        Document document = parse(file);
        Element rootElement = document.getRootElement();
        Element compentScan = rootElement.element(COMPENT_SCAN_ELEMENT_NAME);
        String classPath = compentScan.attribute(COMPENT_SCAN_ELEMENT_ATTRIBUTE_PACKAGE_NAME).getValue();

        String filePath = projectPath + classPath.replaceAll("\\.", "/");
        File packageFile = new File(filePath);
        scan(packageFile);
        //super.init(config);
    }

    private void scan(File file) {
        if (file.isDirectory()) {
            for (File listFile : file.listFiles()) {
                scan(listFile);
            }
        } else {
            String filePath = file.getPath();
            if (filePath.substring(filePath.lastIndexOf(".")).equals(".class")) {
                String projDirPath = new File(projectPath).getPath();
                String classPath = filePath.replace(projDirPath+"\\", "").replaceAll("\\\\", ".");
                String className = classPath.substring(0, classPath.lastIndexOf("."));
                try {
                    Class<?> scanClass = Class.forName(className);
                    if (scanClass.isAnnotationPresent(Controller.class)) {
                        RequestMapping classRequestMapping = scanClass.getAnnotation(RequestMapping.class);
                        String classPrefix = "";
                        if (classRequestMapping != null) {
                            classPrefix = classRequestMapping.value();
                        }
                        for (Method method : scanClass.getDeclaredMethods()) {
                            RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                            if (methodAnnotation != null) {
                                String url = classPrefix + methodAnnotation.value();
                                System.out.println(String.format("类[%s]的方法[%s]被映射到了地址[%s]", scanClass.getName(), method.getName(), url));
                                urlMethodMap.put(url, method);
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private Document parse(File file) {
        SAXReader reader = new SAXReader();
        try {
            return reader.read(file);
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /*super.doPost(req, resp);*/
        StringBuffer requestURL = req.getRequestURL();
        Method method = urlMethodMap.get(requestURL);
        if (method != null) {
            Parameter[] parameters = method.getParameters();
            for (int i = 0; i < parameters.length; i++) {
                System.out.println(parameters[i].getName());
            }
        }
    }
}
