package com.chenss.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public class IndexService {
    //也需要描述关系
    private IndexDao dao;

    public void setDao(IndexDao dao) {
        this.dao = dao;
    }

    public void service() {
        dao.test();
    }
}
