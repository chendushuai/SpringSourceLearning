package com.chenss.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Scope("singleton")//默认是单例的
//@Scope("prototype")
public abstract class IndexService {
    //也需要描述关系
    private IndexDao dao;

    /*@Resource//默认使用byName进行处理，可能是根据参数名称进行匹配类名
    private IndexDao indexDaoImpl1;*/

    public void setDaowessss(IndexDao dao) {
        this.dao = dao;
    }

    @Lookup
    public abstract IndexDao getDao();

    public void service() {
        getDao().test();
        System.out.println("dao == " + getDao().hashCode());
        System.out.println("service == " + this.hashCode());
    }
}
