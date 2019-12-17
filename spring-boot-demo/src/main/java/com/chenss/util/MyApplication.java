package com.chenss.util;

import com.chenss.dao.TestDao;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

import java.io.File;

public class MyApplication {
    public static final String ROOTPATH;

    static {
        String rootPath = MyClassLoader.class.getResource("/").getPath().replaceAll("%20"," ");
        ROOTPATH = new File(rootPath).getPath();
    }

    public static void run(Class<?> clazz) throws Exception {
        MyClassLoader myClassLoader = new MyClassLoader(MyApplication.ROOTPATH,"",MyApplication.ROOTPATH + "/com/chenss");

        // 用我们自己的类加载程序入口
        startFileListener(MyApplication.ROOTPATH);
        start0(myClassLoader);
    }

    public static void start() {
        System.out.println("启动我们自己的应用程序");
        new TestDao().test();
    }

    public static void start0(MyClassLoader classLoader) throws Exception {
        Class<?> aClass = classLoader.loadClass("com.chenss.util.MyApplication");
        aClass.getMethod("start").invoke(aClass.newInstance());
    }

    public static void stop() {
        System.out.println("程序退出");
    }

    public static void startFileListener(String rootpath) throws Exception {
        FileAlterationObserver observer =  new FileAlterationObserver(rootpath);
        observer.addListener(new FileUtilListener());
        FileAlterationMonitor monitor = new FileAlterationMonitor(500);
        monitor.addObserver(observer);
        monitor.start();
    }
}
