package com.chenss.servlet;

import com.chenss.annotation.Controller;
import com.chenss.annotation.RequestMapping;
import com.chenss.annotation.ResponseBody;
import com.chenss.dao.UserInfoParam;
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
import java.lang.reflect.Field;
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

        Element viewElement = rootElement.element("view");
        prefix=viewElement.attribute("prefix").getValue();
        suffix=viewElement.attribute("suffix").getValue();

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
        String requestURI = req.getRequestURI();
        Method method = urlMethodMap.get(requestURI);
        if (method != null) {
            Parameter[] parameters = method.getParameters();
            Object[] args = new Object[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
                Parameter parameter = parameters[i];
                String name = parameter.getName();
                Class<?> type = parameter.getType();
                if (type.equals(String.class)) {
                    args[i]=req.getParameter(name);
                } else if (type.equals(HttpServletRequest.class)) {
                    args[i]=req;
                } else if (type.equals(HttpServletResponse.class)) {
                    args[i] = resp;
                } else {
                    try {
                        UserInfoParam userInfo = (UserInfoParam) type.newInstance();
                        for (Field declaredField : type.getDeclaredFields()) {
                            declaredField.setAccessible(true);
                            String fieldName = declaredField.getName();
                            declaredField.set(userInfo,req.getParameter(fieldName));
                        }
                        args[i]=userInfo;
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
            try {
                Object o = method.getDeclaringClass().newInstance();
                Object invokeValue = method.invoke(o, args);
                if (!method.getReturnType().equals(Void.class)) {
                    ResponseBody responseBody = method.getAnnotation(ResponseBody.class);
                    if (responseBody != null) {
                        resp.getWriter().write(String.valueOf(invokeValue));
                    } else {
                        req.getRequestDispatcher(prefix + String.valueOf(invokeValue) + suffix).forward(req,resp);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            resp.setStatus(404);
        }
    }
}
