package com.chenss.proxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
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
     *
     * @return
     */
    public static Object newInstance(Class targetInterface, CustomInvocationHandler invocationHandler) {
//        Class targetInterface = targetClass.getClass().getInterfaces()[0];
        String line = "\n";
        String tab = "\t";
        Object proxy = null;
        Method[] methods = targetInterface.getDeclaredMethods();
        String targetClassName = targetInterface.getSimpleName();
        String targetPackage = targetInterface.getName();
        String content = "";
        String packageContent = "package com.chenss.proxy;" + line;
        String importContent = line + "import " + targetPackage + ";" + line;
        importContent += "import com.chenss.proxy.CustomInvocationHandler;" + line;
        importContent += "import java.lang.reflect.Method;" + line + line;
        String clazzFirstLineContent = "public class $Proxy implements " + targetClassName + "{" + line;
        String fieldContent = tab + "private CustomInvocationHandler h;" + line;
        String contructContent = tab + "public $Proxy (CustomInvocationHandler h) {" + line;
        contructContent += tab + tab + "this.h = h;" + line;
        contructContent += tab + "}" + line;
        String methodContent = "";
        for (Method method :
                methods) {
            Class[] args = method.getParameterTypes();
            String returnTypeName = method.getReturnType().getSimpleName();
            String methodName = method.getName();
            String argsContent = "";
            String methodArgs = "";
            String argsClass = "";
            for (int i = 0; i < args.length; i++) {
                argsContent += args[i].getSimpleName() + " i" + i + ",";
                argsClass += args[i].getSimpleName() + ".class,";
                methodArgs += "i" + i + ",";
            }
            if (argsContent.length() > 0) {
                argsContent = argsContent.substring(0, argsContent.length() - 1);
            }
            if (methodArgs.length() > 0) {
                methodArgs = methodArgs.substring(0, methodArgs.length() - 1);
            }
            if (argsClass.length() > 0) {
                argsClass = argsClass.substring(0, argsClass.length() - 1);
            }
            methodContent += tab + "public " + returnTypeName + " " + methodName + "(" + argsContent + ") {" + line;
//            methodContent += tab + tab + "System.out.println(\"打印Log\");" + line;
            methodContent += tab + tab + "Method method = null;" + line;
            methodContent += tab + tab + "try {" + line;
            methodContent += tab + tab + tab + "method = Class.forName(\"" + targetInterface.getName() + "\").getDeclaredMethod(\"" + methodName + "\"";
            methodContent += methodArgs.length() > 0 ? ", new Class[]{" + argsClass + "});" + line : ");" + line;
            methodContent += tab + tab + "} catch (Exception e) {}" + line;
            methodContent += tab + tab;
            if (!returnTypeName.equals("void")) {
                methodContent += returnTypeName + " result = (" + returnTypeName + ") ";
            }
            methodContent += "h.invoke(method";
            methodContent += methodArgs.length() > 0 ? ", new Object[]{" + methodArgs + "});" + line : ",new Object[]{});" + line;
//            methodContent += tab + tab + "System.out.println(\"打印Log OVER\");" + line;
            if (!returnTypeName.equals("void")) {
                methodContent += tab + tab + "return result;" + line;
            }
            methodContent += tab + "}" + line;
        }
        String clazzLastLineContent = "}";

        content = packageContent + importContent + clazzFirstLineContent + fieldContent + contructContent + methodContent + clazzLastLineContent;

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
            StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
            Iterable units = fileManager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, units);
            t.call();
            fileManager.close();

            URL[] urls = new URL[]{new URL("file:E:\\\\")};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class clazz = classLoader.loadClass("com.chenss.proxy.$Proxy");
            //return clazz.newInstance();
            Constructor constructor = clazz.getConstructor(invocationHandler.getClass().getInterfaces()[0]);

            proxy = constructor.newInstance(invocationHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proxy;
    }
}
