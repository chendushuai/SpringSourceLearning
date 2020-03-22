package com.chenss.util;

import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;

import java.io.File;

public class FileUtilListener extends FileAlterationListenerAdaptor {
    @Override
    public void onFileChange(File file)  {
        if (file.getName().indexOf(".class")!=-1) {
            try {
                MyClassLoader myClassLoader = new MyClassLoader(MyApplication.ROOTPATH,MyApplication.ROOTPATH + "/com/chenss");
                MyApplication.stop();
                MyApplication.start0(myClassLoader);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
