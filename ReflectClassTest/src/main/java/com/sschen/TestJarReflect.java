package com.sschen;

import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class TestJarReflect {
    private static final String basePackage = "com.tnp.user";

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Enumeration<URL> urlEnumeration = Thread.currentThread().getContextClassLoader().getResources(basePackage.replace('.', '/'));
        while (urlEnumeration.hasMoreElements()) {
            URL url = urlEnumeration.nextElement();
            if ("jar".equals(url.getProtocol())) {
                JarURLConnection jarURLConnection = (JarURLConnection) url.openConnection();
                if (null != jarURLConnection) {
                    JarFile jarFile = jarURLConnection.getJarFile();
                    if (jarFile!=null) {
                        Enumeration<JarEntry> jarEntryEnumeration = jarFile.entries();
                        while (jarEntryEnumeration.hasMoreElements()) {
                            JarEntry jarEntry = jarEntryEnumeration.nextElement();
                            String jarEntryName = jarEntry.getName();
                            if (jarEntryName.contains(".class") && jarEntryName.replaceAll("/", ".").startsWith(basePackage)) {
                                String className=jarEntryName.substring(0, jarEntryName.lastIndexOf(".")).replace("/", ".");
                                Class cls = Class.forName(className);
                                System.out.println(cls);
                            }
                        }
                    }
                }
            }
        }
    }
}
