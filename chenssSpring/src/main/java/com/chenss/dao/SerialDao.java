package com.chenss.dao;

import java.io.Serializable;

public class SerialDao implements Serializable {
    private static final long serialVersionUID = 7402146294804564618L;
    private String name;
    private String id;
    private SerialChildDao childDao;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public SerialChildDao getChildDao() {
        return childDao;
    }

    public void setChildDao(SerialChildDao childDao) {
        this.childDao = childDao;
    }

    @Override
    public String toString() {
        return "SerialDao{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", childDao=" + childDao +
                '}';
    }
}
