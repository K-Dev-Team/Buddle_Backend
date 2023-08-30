package com.kdt.buddle.meditation.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public interface MeditaionService {

  public Map<String, Object> getMeditationList(Map<String, Object> jsonMap, HttpServletRequest request, HttpServletResponse response) throws Exception;
  public Map<String, Object> getMeditationDetils(Map<String, Object> jsonMap, HttpServletRequest request, HttpServletResponse response) throws Exception;

}
