package org.spring.util;

import com.chenss.anno.Chenss;

import java.io.File;

public class AnnotationConfigApplicationContext {
    public void scan(String basePackage) {
        String basePackagePath = this.getClass().getResource("/").getPath() + basePackage.replace('.','/');
        File classFile = new File(basePackagePath);
        File[] files = classFile.listFiles();
        for (File file : files) {
            try {
                Class clazz = Class.forName(basePackage + "." + file.getName().replace(".class",""));
                if (clazz.isAnnotationPresent(Chenss.class)) {
                    Chenss chenss = (Chenss) clazz.getAnnotation(Chenss.class);
                    System.out.println(chenss.value());
                    System.out.println(clazz.newInstance());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
