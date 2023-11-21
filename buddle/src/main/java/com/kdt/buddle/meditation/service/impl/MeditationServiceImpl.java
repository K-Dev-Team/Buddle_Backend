package com.kdt.buddle.meditation.service.impl;

import com.kdt.buddle.meditation.dto.*;
import com.kdt.buddle.meditation.service.MeditaionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeditationServiceImpl implements MeditaionService {

  private final MeditationDao meditationDao;

  @Autowired
  public MeditationServiceImpl(MeditationDao meditationDao) {
    this.meditationDao = meditationDao;
  }

  @Override
  public MeditationResDto getWeeklyMeditaion(MeditationReqDto meditationReqDto) throws Exception {
    return meditationDao.getWeeklyMeditation(meditationReqDto);
  }

  @Override
  public List<MeditationCmtDto> getMeditationCmtList(Integer mdt_idx) throws Exception {
    return meditationDao.getMeditationCmtList(mdt_idx);
  }

  @Override
  public int meditationWrite(MeditationWriteDto meditationWriteDto) throws Exception {
      return meditationDao.meditationWrite(meditationWriteDto);
  }
}
