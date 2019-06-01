package com.chenss.dao;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
@Scope("singleton")//默认是单例的
//@Scope("prototype")
public class IndexService implements ApplicationContextAware {
    //也需要描述关系
    @Autowired//默认使用byType注入形式
    private IndexDao dao;

    /*@Resource//默认使用byName进行处理，可能是根据参数名称进行匹配类名
    private IndexDao indexDaoImpl1;*/

    public void setDaowessss(IndexDao dao) {
        this.dao = dao;
    }

    public void service() {
        IndexDao dao = (IndexDao) this.applicationContext.getBean("dao");
        System.out.println("dao -- " + dao.hashCode());
    }
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext=applicationContext;
    }
}
