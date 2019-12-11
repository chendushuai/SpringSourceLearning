package com.chenss.util;

import com.chenss.event.FileUploadEvent;
import com.chenss.event.ListenerManager;

import java.io.*;

public class FileUtils {
    public static final int STANDARD_BYTE_SIZE = 5000;

    public static void fileUploadWrite(FileInputStream fis, FileOutputStream fos) {
        fileUploadWrite(fis,fos,null);
    }

    public static void fileUploadWrite(FileInputStream fis, FileOutputStream fos,FileListener fileListener) {
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        try {
            int fileSize = bis.available();
            int readSize = 0;
            byte[] bytes = new byte[STANDARD_BYTE_SIZE];
            boolean runFlag=true;
            while (runFlag) {
                if (fileSize <= STANDARD_BYTE_SIZE) {
                    bytes = new byte[fileSize];
                    bis.read(bytes);
                    bos.write(bytes);
                    readSize=fileSize;
                    runFlag=false;
                } else if (readSize + STANDARD_BYTE_SIZE >= fileSize) {
                    bytes = new byte[fileSize - readSize];
                    bis.read(bytes);
                    bos.write(bytes);
                    readSize=fileSize;
                    runFlag=false;
                } else {
                    bis.read(bytes);
                    bos.write(bytes);
                    readSize += STANDARD_BYTE_SIZE;
                }

                ListenerManager.publishEvent(new FileUploadEvent(fileSize,readSize));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                bos.close();
                fis.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
