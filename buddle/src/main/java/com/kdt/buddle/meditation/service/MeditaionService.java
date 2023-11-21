package com.kdt.buddle.meditation.service;

import com.kdt.buddle.meditation.dto.*;

import java.util.List;

public interface MeditaionService {

  public MeditationResDto getWeeklyMeditaion(MeditationReqDto meditationReqDto) throws Exception;
  public List<MeditationCmtDto> getMeditationCmtList(Integer mdt_idx) throws  Exception;
  public int meditationWrite(MeditationWriteDto meditationWriteDto) throws Exception;
}
