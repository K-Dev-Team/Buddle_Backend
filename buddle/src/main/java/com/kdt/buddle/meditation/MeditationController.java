package com.kdt.buddle.meditation;

import com.kdt.buddle.meditation.dto.*;
import com.kdt.buddle.meditation.service.MeditaionService;
import io.swagger.annotations.Api;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@Log4j2
@Api(tags = {"한줄사색 API"})
@RequestMapping("/meditation")
public class MeditationController {

  private final MeditaionService meditaionService;

  @Autowired
  public MeditationController(MeditaionService meditaionService) {
    this.meditaionService = meditaionService;
  }

  @PostMapping("/getWeekly.do")
  public ResponseEntity<MeditationResDto> getWeeklyMeditation(@Validated @RequestBody MeditationReqDto meditationReqDto) {
    try {
      MeditationResDto result = meditaionService.getWeeklyMeditaion(meditationReqDto);

      if (result != null) {
        return ResponseEntity.ok(result);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 예: 데이터가 없음
      }
    } catch (Exception e) {
      log.error("Error while processing getWeeklyMeditation", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @GetMapping("/getCmt.do/{mdt_idx}")
  public ResponseEntity<List<MeditationCmtDto>> getMeditationCmtList(@PathVariable Integer mdt_idx) {
    try {
      List<MeditationCmtDto> result = meditaionService.getMeditationCmtList(mdt_idx);

      if (result != null && !result.isEmpty()) {
        return ResponseEntity.ok(result);
      } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // 예: 데이터가 없음
      }
    } catch (Exception e) {
      log.error("Error while processing getMeditationCmtList", e);
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
  }

  @PostMapping("/write.do")
  public ResponseEntity<String> meditationWrite(@Validated @RequestBody MeditationWriteDto meditationWriteDto) {
    try {
      int insertCode = meditaionService.meditationWrite(meditationWriteDto);
      return (insertCode == 1) ?
              ResponseEntity.ok("업로드 성공") :
              ResponseEntity.badRequest().body("업로드 실패");
    } catch (Exception e) {
      log.error("Error while processing meditationWrite", e);
      return ResponseEntity.badRequest().body("업로드 실패");
    }
  }
}
