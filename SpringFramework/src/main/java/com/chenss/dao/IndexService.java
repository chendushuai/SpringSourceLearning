package com.chenss.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

public class IndexService {
    //也需要描述关系
    /*@Autowired//默认使用byType注入形式
    private IndexDao dao;*/

    @Resource//默认使用byName进行处理，可能是根据参数名称进行匹配类名
    private IndexDao indexDaoImpl1;

    public void setDaowessss(IndexDao dao) {
        this.indexDaoImpl1 = dao;
    }

    public void service() {
        indexDaoImpl1.test();
    }
}
