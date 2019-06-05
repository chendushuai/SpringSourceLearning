package com.chenss.util;

import com.chenss.annotation.Entity;

public class CommonUtil {
    /**
     * 通过一个对象构建一条查询的SQL语句
     * @param object
     * @return
     */
    public static String buildQuerySqlForEntity(Object object) {

        Class clazz = object.getClass();

        // 1. 判断是否添加了指定注解
        if(clazz.isAnnotationPresent(Entity.class)) {
            // 2. 得到添加的注解内容
            Entity entity = (Entity) clazz.getDeclaredAnnotation(Entity.class);
            // 3. 调用方法
            String tableName = entity.value();
            System.out.println(tableName);
        }
        //select * from
        String sql = "select * from city where ";
        return "";
    }
}
