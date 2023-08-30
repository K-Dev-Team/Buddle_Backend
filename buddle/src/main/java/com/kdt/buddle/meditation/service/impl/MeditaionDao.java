package com.kdt.buddle.meditation.service.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class MeditaionDao {

  @Autowired
  SqlSessionTemplate sqlSessionTemplate;


  public Map<String, Object> getMeditationList(Map<String, Object> jsonMap) throws Exception {
    List<Map<String, Object>> list = new ArrayList<>();
    Map<String, Object> listMap1 = new HashMap<>();
    Map<String, Object> listMap2 = new HashMap<>();
    listMap1.put("name", "한우");
    listMap1.put("age", "31");
    listMap2.put("name", "장미");
    listMap2.put("age", "몰라");
    list.add(listMap1);
    list.add(listMap2);

    Map<String, Object> resMap = new HashMap<>();
    resMap.put("list", list);
    resMap.put("retCode", "000");
    resMap.put("retMsg", "성공");

    resMap.put("result", "success");
    return resMap;
  }


  public Map<String, Object> getMeditationDetils(Map<String, Object> jsonMap) throws Exception {
    Map<String, Object> resMap = new HashMap<>();
    resMap.put("result", "success");
    resMap.put("name", "한우");
    resMap.put("age", "31");
    resMap.put("job", "web develper");
    resMap.put("hobby", "shor track speed skate");
    resMap.put("retCode", "000");
    resMap.put("retMsg", "성공");
    return resMap;
  }


}
