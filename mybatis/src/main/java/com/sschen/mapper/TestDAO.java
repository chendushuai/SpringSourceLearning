package com.sschen.mapper;

import com.sschen.dao.Test;
import org.springframework.stereotype.Repository;

/**
 * TestDAO继承基类
 */
@Repository
public interface TestDAO extends MyBatisBaseDao<Test, Integer> {
}