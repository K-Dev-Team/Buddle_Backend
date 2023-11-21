package com.kdt.buddle.test;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Log4j2
@RestController
@Api(tags = {"테스트용 API"})
public class TestCtl {

  private final TestDao testDao;
  @Autowired
  public TestCtl(TestDao testDao) {
    this.testDao = testDao;
  }

  @GetMapping(value = "/test")
  @ApiOperation(value = "테스트1번 API", response = TestDto.class)
  public List<TestDto> testCtl() {

//    List<TestDto> memberList = new ArrayList<>();
//    memberList = test
    return testDao.getTestData();

  }


}
