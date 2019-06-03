package com.chenss.service;

import com.chenss.dao.IndexDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IndexService {
    //也需要描述关系
    @Autowired(required = false)
    @Qualifier("indexDaoImpl1")
    private IndexDao dao;

    public void service() {
        dao.test();
    }
}
