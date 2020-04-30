package com.chenss.test;

import com.chenss.dao.SerialChildDao;
import com.chenss.dao.SerialDao;

import java.io.*;

public class Serialtest {
    public static void main(String[] args) throws IOException {
        SerialChildDao childDao = new SerialChildDao();
        childDao.setChild("child");
        SerialDao serialDao = new SerialDao();
        serialDao.setName("sess");
        serialDao.setId("id");
        serialDao.setChildDao(childDao);

        File file = new File("E:\\sss.txt");
        if (!file.exists()) {
            file.createNewFile();
        }

        FileOutputStream outputStream= new FileOutputStream(file);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(serialDao);
        objectOutputStream.close();
        outputStream.close();
    }
}
