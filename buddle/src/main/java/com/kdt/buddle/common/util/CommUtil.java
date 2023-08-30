package com.kdt.buddle.common.util;

import lombok.extern.log4j.Log4j2;

import java.util.Map;

@Log4j2
public class CommUtil {

  public String check_intpufield(Map<String, Object> jsonMap, String field[]) {

    String retmsg = null;
    for (String s : field) {
      try {
        if (jsonMap.get(s) == null || String.valueOf(jsonMap.get(s)).trim().length() == 0) {
          retmsg = "입력필드를 확인하세요. 필드[" + s + "]가 없거나 데이타가 셋팅이 안되어있음.";
          break;
        }
      } catch (Exception ee) {
        log.error(ee);
      }
    }
    return retmsg;
  }


}
