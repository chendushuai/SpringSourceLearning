package com.chenss.util;

import java.io.*;

public class FileUtils {
    public static final int STANDARD_BYTE_SIZE = 100;

    public static void fileUploadWrite(FileInputStream fis, FileOutputStream fos) {
        BufferedInputStream bis = new BufferedInputStream(fis);
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        try {
            int fileSize = bis.available();
            int readSize = 0;
            byte[] bytes = new byte[STANDARD_BYTE_SIZE];
            while (true) {
                if (fileSize <= STANDARD_BYTE_SIZE) {
                    bytes = new byte[fileSize];
                    bis.read(bytes);
                    bos.write(bytes);
                    break;
                } else if (readSize + STANDARD_BYTE_SIZE >= fileSize) {
                    bytes = new byte[fileSize - readSize];
                    bis.read(bytes);
                    bos.write(bytes);
                    break;
                } else {
                    bis.read(bytes);
                    bos.write(bytes);
                    readSize += STANDARD_BYTE_SIZE;
                }
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
