package com.chenss.test;

import com.chenss.event.FileUploadListener;
import com.chenss.event.ListenerManager;
import com.chenss.util.FileListener;
import com.chenss.util.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUploadTest {
    public static void main(String[] args) throws IOException {
        ListenerManager.addListener(new FileUploadListener());

        File fileIn = new File("e://user.txt");
        File fileOut = new File("e://userOut.txt");
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }
        FileUtils.fileUploadWrite(new FileInputStream(fileIn), new FileOutputStream(fileOut));
    }
}
