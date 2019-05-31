package com.chenss.dao;

public class IndexService {
    private IndexDao dao;

    public IndexService(IndexDao dao) {
        this.dao = dao;
    }

    public void service() {
        dao.test();
    }
}
