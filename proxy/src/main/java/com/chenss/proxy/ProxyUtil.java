package com.chenss.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class ProxyUtil {
    /**
     * content --> String
     * .java  io
     * .class
     * new
     * @return
     */
    public static Object newInstance(Object targetClass) {
        Class targetInterface = targetClass.getClass().getInterfaces()[0];
        String line = "\n";
        String tab = "\t";
        Object proxy = null;
        Method[] methods = targetInterface.getDeclaredMethods();
        String targetClassName = targetInterface.getSimpleName();
        String targetPackage = targetInterface.getName();
        String content = "";
        String packageContent = "package com.chenss.proxy;"+line;
        String importContent = "import " + targetPackage + ";"+line;
        String clazzFirstLineContent = "public class $Proxy implements " + targetClassName + "{"+line;
        String fieldContent = tab + "private " + targetClassName + " target;"+line;
        String contructContent = tab + "public $Proxy (" + targetClassName + " target) {"+line;
        contructContent += tab + tab + "this.target = target;"+line;
        contructContent += tab + "}"+line;
        String methodContent = "";
        for (Method method:
             methods) {
            Class[] args = method.getParameterTypes();
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            String argsContent = "";
            String methodArgs = "";
            for (int i = 0; i < args.length; i++) {
                argsContent += args[i].getSimpleName() + " i" + i + ",";
                methodArgs += "i" + i + ",";
            }
            if (argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.length() - 1);
            }
            if (methodArgs.length() > 0) {
                methodArgs = methodArgs.substring(0, methodArgs.length() - 1);
            }
            methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsContent + ") {"+line;
            methodContent += tab + tab + "System.out.println(\"打印Log\");" + line;
            methodContent += tab + tab + "target." + methodName + "(" + methodArgs + ");" + line;
            methodContent += tab + "}"+line;
        }
        String clazzLastLineContent = "}";

        content = packageContent+importContent+clazzFirstLineContent+fieldContent+contructContent+methodContent+clazzLastLineContent;

        try {
            File file = new File("E:\\com\\chenss\\proxy\\$Proxy.java");
            if (!file.exists()) {
                file.createNewFile();
            }

            /*FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();*/
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.flush();

            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null,null,null);
            Iterable units = fileManager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null,fileManager,null,null,null,units);
            t.call();
            fileManager.close();

            URL[] urls = new URL[]{new URL("file:E:\\\\")};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class clazz = classLoader.loadClass("com.chenss.proxy.$Proxy");
            Constructor constructor = clazz.getConstructor(targetInterface);

            proxy = constructor.newInstance(targetClass);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proxy;
    }
}
