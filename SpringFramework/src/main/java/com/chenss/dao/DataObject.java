package com.chenss.dao;

import java.io.Serializable;

public class DataObject implements Serializable {
    public static int i = 0;

    private String word="";

    public void setWord(String word) {
        this.word=word;
    }

    public void setI(int i) {
        DataObject.i = i;
    }

    @Override
    public String toString() {
        return "DataObject{" +
                "word='" + word + '\'' +
                '}';
    }
}
