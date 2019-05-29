package com.chenss.service;

import com.chenss.dao.DaoIndex;

public class DaoServiceImpl implements DaoService {
    private DaoIndex daoIndex;

    public void setDaoService(DaoIndex daoIndex) {
        this.daoIndex = daoIndex;
    }


    @Override
    public void init() {
        this.daoIndex.strQuery();
    }
}
