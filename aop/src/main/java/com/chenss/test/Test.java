package com.chenss.test;

import com.chenss.entity.CityEntity;
import com.chenss.util.CommonUtil;

public class Test {
    public static void main(String[] args) {
        CityEntity cityEntity = new CityEntity();
        cityEntity.setId("1");
        cityEntity.setName("test");
        String sql = CommonUtil.buildQuerySqlForEntity(cityEntity);
        System.out.println(sql);
    }
}
