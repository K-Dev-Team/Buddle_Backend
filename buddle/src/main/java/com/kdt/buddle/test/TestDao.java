package com.kdt.buddle.test;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TestDao {
  private final SqlSessionTemplate sqlSessionTemplate;

  @Autowired
  public TestDao(SqlSessionTemplate sqlSessionTemplate) {
    this.sqlSessionTemplate = sqlSessionTemplate;
  }

  public List<TestDto> getTestData() {
    return sqlSessionTemplate.selectList("com.kdt.buddle.test.TestDao.selectTest");
  }

}
