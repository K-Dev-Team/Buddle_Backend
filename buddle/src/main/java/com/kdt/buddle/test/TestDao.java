package com.kdt.buddle.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestDao {
  @Autowired
  SqlSessionTemplate sqlSessionTemplate;

  public TestDto getTestData() {
    return sqlSessionTemplate.selectOne("com.kdt.buddle.test.TestDao.selectTest");
  }

}
