package com.chenss.dao;

import java.io.Serializable;

/**
 * @author chenss002
 */
public class SerialChildDao implements Serializable {

    private static final long serialVersionUID = -4480432144573572543L;
    private String child;

    public String getChild() {
        return child;
    }

    public void setChild(String child) {
        this.child = child;
    }

    @Override
    public String toString() {
        return "SerialChildDao{" +
                "child='" + child + '\'' +
                '}';
    }
}
