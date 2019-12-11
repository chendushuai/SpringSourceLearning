package com.chenss.test;

import com.chenss.util.FileListener;
import com.chenss.util.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUploadTest {
    public static void main(String[] args) throws IOException {
        File fileIn = new File("e://user.txt");
        File fileOut = new File("e://userOut.txt");
        if (!fileOut.exists()) {
            fileOut.createNewFile();
        }
        FileUtils.fileUploadWrite(new FileInputStream(fileIn), new FileOutputStream(fileOut), new FileListener() {
            @Override
            public void updateLoad(int fileSize, int readSize) {
                double percent = readSize / (double)fileSize;
                System.out.println(String.format("当前文件上传百分比：{%s}",percent));
            }
        });
    }
}
