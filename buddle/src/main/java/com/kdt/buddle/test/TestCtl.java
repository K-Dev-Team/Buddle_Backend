package com.kdt.buddle.test;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@RestController
public class TestCtl {
  @Autowired
  private TestDao testDao;

  @RequestMapping("/test")
  public Map<String, Object> testCtl() {
    TestDto testDto = testDao.getTestData();
    Map<String, Object> resMap = new HashMap<>();
    if (testDto == null) {
      resMap.put("retCode", "999");
      resMap.put("retMsg", "에러");
      return resMap;
    }

    resMap.put("uid", testDto.getIdx());
    resMap.put("content", testDto.getAccount());
    resMap.put("retCode", "000");
    resMap.put("retMsg", "정상 처리");

    return resMap;

  }


}
