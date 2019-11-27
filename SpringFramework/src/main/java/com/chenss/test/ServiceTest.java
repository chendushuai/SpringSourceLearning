package com.chenss.test;

import com.chenss.dao.DataObject;

import java.io.*;

public class ServiceTest {
    public static void main(String[] args) {
        DataObject dataObject = new DataObject();
        dataObject.setI(2);
        dataObject.setWord("123");

        try {
            File file = new File("D:/122.txt");
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(dataObject);


            FileInputStream fileInputStream = new FileInputStream("D:/122.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            DataObject dataObject1 = (DataObject) objectInputStream.readObject();
            System.out.println(dataObject1);
        } catch (Exception ex) {

        }


    }
}
