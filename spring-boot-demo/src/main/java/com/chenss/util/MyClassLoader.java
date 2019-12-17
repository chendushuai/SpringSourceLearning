package com.chenss.util;

import com.chenss.dao.TestDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyClassLoader extends ClassLoader {
    /**
     * 需要加载的类的根路径
     */
    public String rootPath;
    /**
     * 所有由我加载的类的集合
     */
    public List<String> classes;

    public MyClassLoader(ClassLoader parent, String rootPath, List<String> classes) {
        super(parent);
        this.rootPath = rootPath;
        this.classes = classes;
    }

    public MyClassLoader(String rootPath, String... classPaths) throws Exception {
        this.rootPath = rootPath;
        this.classes = new ArrayList<>();
        for (String path : classPaths) {
            scanPath(new File(path));
        }
    }

    private void scanPath(File file) throws Exception {
        if (file.isDirectory()) {
            for (File listFile : file.listFiles()) {
                scanPath(listFile);
            }
        } else {
            String fileName = file.getName();
            String filePath = file.getPath();
            String fileExtend = fileName.substring(fileName.lastIndexOf(".") + 1);
            if ("class".equals(fileExtend.toLowerCase())) {
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int)file.length()];
                inputStream.read(bytes);

                String className=fileNameToClassName(filePath);

                defineClass(className,bytes,0,bytes.length);
                classes.add(className);
            }
        }
    }
    public String fileNameToClassName(String filePath) {
        String className = filePath.replace(rootPath,"").replaceAll("\\\\",".");
        className = className.substring(1,className.lastIndexOf("."));
        return className;
    }

    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        if (null == loadedClass) {
            // 1. 不需要有我们加载
            // 2. 如果需要，但是没有加载到的情况

            if (classes.contains(loadedClass)) {
                throw new ClassNotFoundException("");
            } else {
                loadedClass = getSystemClassLoader().loadClass(name);
            }
        }

        return loadedClass;
    }

    public static void main(String[] args) throws Exception{
        String rootPath = MyClassLoader.class.getResource("/").getPath().replaceAll("%20"," ");
        rootPath = new File(rootPath).getPath();
        while (true) {
            MyClassLoader myClassLoader = new MyClassLoader(rootPath,"",rootPath + "/com/chenss/dao");
            Class testDao = myClassLoader.loadClass("com.chenss.dao.TestDao");
            testDao.getMethod("test").invoke(testDao.newInstance());

            new TestDao().test();

            Thread.sleep(2000);
        }
    }
}
