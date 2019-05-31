package com.chenss.dao;

public class IndexService {
    private IndexDao dao;

    public void setDao(IndexDao dao) {
        this.dao = dao;
    }

    public void service() {
        dao.test();
    }
}
