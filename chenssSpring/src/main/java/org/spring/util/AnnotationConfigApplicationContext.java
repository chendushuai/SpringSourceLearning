package org.spring.util;

import com.chenss.anno.Chenss;

import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AnnotationConfigApplicationContext {
    public void scan(String basePackage) {
        String basePackagePath = this.getClass().getResource("/").getPath() + basePackage.replace('.', '/');
        List<String> files = getFileList(basePackagePath,"");
        for (String file : files) {
            try {
                Class clazz = Class.forName(basePackage + "." + file.replace(".class", ""));
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

    public List<String> getFileList(String filePath, String prefix) {
        List<String> fileNameList = new ArrayList<>();
        File fileDic = new File(filePath);
        File[] files = fileDic.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                String directory = file.getPath();
                String currDirec = directory.substring(directory.lastIndexOf("\\") + 1);
                String thisPrefix = prefix.length() == 0 ? currDirec : prefix + "." + currDirec;
                List<String> fileChild = getFileList(directory, thisPrefix);
                fileNameList.addAll(fileChild);
                continue;
            }
            String fileName = prefix.length() == 0 ? file.getName() : prefix + "." + file.getName();
            String extendName = fileName.substring(fileName.lastIndexOf('.') + 1);
            if (!extendName.toLowerCase().equals("class")) {
                continue;
            }
            fileNameList.add(fileName);
        }
        return fileNameList;
    }
}
