package com.kdt.buddle.meditation.service.impl;

import com.kdt.buddle.meditation.dto.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MeditationDao {

  private final SqlSessionTemplate sqlSessionTemplate;

  @Autowired
  public MeditationDao(SqlSessionTemplate sqlSessionTemplate) {
    this.sqlSessionTemplate = sqlSessionTemplate;
  }


  public MeditationResDto getWeeklyMeditation(MeditationReqDto MeditationReqDto) throws Exception {

    return sqlSessionTemplate.selectOne("com.kdt.buddle.meditation.service.impl.MeditationDao.getWeeklyMeditation", MeditationReqDto);
  }

  public List<MeditationCmtDto> getMeditationCmtList(Integer mdt_idx) throws Exception {
    return sqlSessionTemplate.selectList("com.kdt.buddle.meditation.service.impl.MeditationDao.getMeditationCmtList", mdt_idx);
  }

  public int meditationWrite(MeditationWriteDto meditationWriteDto) {
    return sqlSessionTemplate.insert("com.kdt.buddle.meditation.service.impl.MeditationDao.meditationWrite",meditationWriteDto);
  }


}
