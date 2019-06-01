package com.chenss.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    //也需要描述关系
    @Autowired
    private IndexDao dao;

    public IndexService(IndexDao dao) {
        this.dao = dao;
    }


    public void service() {
        dao.test();
    }
}
