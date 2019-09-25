package com.chenss.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试提取类名
 * @author User
 * @date 2019-9-25 20:35:02
 */
public class ClassSearchTest {
    private static final String basePackage="com.chenss";
    private static final char CLASSPATHPHIEX = '.';
    private static final char RESOURCEPATHPHIEX = '/';
    public static void main(String[] args) {
        ClassSearchTest test = new ClassSearchTest();
        String basePath = test.getClass().getResource("/").getPath() +basePackage.replace(CLASSPATHPHIEX,RESOURCEPATHPHIEX);
        List<String> classesFiles = test.getFileList(basePath,"com.chenss");
        System.out.println(classesFiles);
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
