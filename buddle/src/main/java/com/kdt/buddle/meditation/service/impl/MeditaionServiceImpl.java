package com.kdt.buddle.meditation.service.impl;

import com.kdt.buddle.meditation.service.MeditaionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Service
public class MeditaionServiceImpl implements MeditaionService {

  @Autowired
  MeditaionDao meditaionDao;
  @Override
  public Map<String, Object> getMeditationList(Map<String, Object> jsonMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
    return meditaionDao.getMeditationList(jsonMap);
  }

  @Override
  public Map<String, Object> getMeditationDetils(Map<String, Object> jsonMap, HttpServletRequest request, HttpServletResponse response) throws Exception {
    return meditaionDao.getMeditationDetils(jsonMap);
  }
}
