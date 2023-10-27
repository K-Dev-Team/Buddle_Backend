package com.kdt.buddle.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kdt.buddle.common.util.CommUtil;
import com.kdt.buddle.meditation.service.MeditaionService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@CrossOrigin
@RestController
public class KdtController {

  @Autowired
  MeditaionService meditaionService;


  @PostMapping("/ktdController.do")
  @ResponseBody
  public Object getKdtControllerJSON(HttpServletRequest request, HttpServletResponse response, @RequestParam Map<String, String> params) throws JsonProcessingException {
    String jsondata = (String) params.get("jsondata");

    long startTime = System.currentTimeMillis();

    log.info("=========================================================");
    log.info("/kdtController.do 데이타수신 ");
    log.info("=========================================================");

    Map<Object, Object> resMap = new HashMap<>();

    try {
      jsondata = URLDecoder.decode(jsondata, "UTF-8");
      log.info("[URLDecoder.decode후(1)..]>jsondata=" + jsondata);
    } catch (Exception var17) {
      log.info(var17);
      resMap.put("retCode", "999");
      resMap.put("retMsg", "수신데이타 파싱에러:" + var17);
      return resMap;
    }

    try {
      ObjectMapper mapper = new ObjectMapper();
      HashMap jsonMap = mapper.readValue(jsondata, HashMap.class);

      String serviceTp = (String) jsonMap.get("service_tp");
      String inputcheckret = null;

      CommUtil commUtil = new CommUtil();

      switch (DefineKdtService.Service.valueOf(serviceTp)) {
        case get_meditation_list:
          if ((inputcheckret = commUtil.check_intpufield(jsonMap,
                  (new String[]{"service_tp"}))) != null)
            break;

          resMap = meditaionService.getMeditationList(jsonMap, request, response);
          break;
        case get_meditaion_detail:
          if ((inputcheckret = commUtil.check_intpufield(jsonMap, (new String[]{"service_tp", "name"}))) != null)
            break;


          resMap = meditaionService.getMeditationDetils(jsonMap, request, response);
          break;
        default:
          resMap.put("retCode", "991");
          resMap.put("retMsg", "알수없는 구분값임.service_tp=[" + serviceTp + "]");
          break;
      }

      if (inputcheckret != null) {
        resMap.put("retCode", "992");
        resMap.put("retMsg", inputcheckret);
      }

    } catch (Exception e) {
      try {
        resMap.put("retCode", "999");
        resMap.put("retMsg", "시스템오류입니다.[" + e.getMessage() + "]");
        log.error("error 시스템오류입니다 " + e);
      } catch (Exception e1) {
        e1.printStackTrace();
      }

      log.error("error 'kdtController.do', jsondata=" + jsondata);
      log.error(e);
    }


    log.info("=========================================================");
    log.info("결과:" + resMap.get("retCode") + "|" + resMap.get("retMsg"));
    long endTime = System.currentTimeMillis();
    log.info("/ktdController.do 결과전송, 처리시간(TimeMillis)=[" + (endTime - startTime) + "]");
    log.info("=========================================================\n\r");
    return resMap;
  }


}

