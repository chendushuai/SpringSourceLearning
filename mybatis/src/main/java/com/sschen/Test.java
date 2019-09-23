package com.sschen;

import com.sschen.mapper.TestDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //从调用者角度来讲 与数据库打交道的对象 SqlSession

        //通过动态代理 去帮我们执行SQL
        TestDAO mapper = sqlSession.getMapper(TestDAO.class);
        System.out.println(mapper.selectByPrimaryKey(1));
        sqlSession.close();
    }
}
