package com.chenss.test;

import com.chenss.dao.SerialDao;

import java.io.*;

public class SerialReadTest {
    public static void main(String[] args) throws Exception {
        File file = new File("E:\\sss.txt");

        FileInputStream inputStream= new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        SerialDao serialDao = (SerialDao) objectInputStream.readObject();
        objectInputStream.close();
        inputStream.close();
        System.out.println(serialDao);
    }
}
