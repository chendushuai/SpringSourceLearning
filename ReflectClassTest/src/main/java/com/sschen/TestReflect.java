package com.sschen;


import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 通过文件获取指定包下class文件信息
 *
 * @author chenss002
 * @date 2019-9-25 19:20:30
 */
public class TestReflect {
    private static final String basePackage="com.tnp.user.center.core";
    private static final String CLASSPATH_ALL_URL_PREFIX = "classpath*:";
    private static final String DEFAULT_RESOURCE_PATTERN = "**/*.class";
    private static final char PACKAGE_SEPARATOR = '.';
    private static final char PATH_SEPARATOR = '/';
    private static List<String> classFileList = new ArrayList<>();
    public static void main(String[] args) {
        String filePath = TestReflect.class.getResource("/").getPath()+resolveBasePackage(basePackage);
        doPath(new File(filePath));
        for (String strPath:
             classFileList) {
            System.out.println(strPath);
        }
    }
    private static void doPath(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File fileItem:
                 files) {
                doPath(fileItem);
            }
        } else {
            if (file.getName().endsWith(".class")) {
                classFileList.add(file.getPath());
            }
        }
    }
    private static String resolveBasePackage(String basePackage) {
        return basePackage.replace(PACKAGE_SEPARATOR,PATH_SEPARATOR);
    }
}
