package com.kdt.buddle.meditation.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class MeditationReqDto {

  @NotNull(message = "이번달을 입력하세요")
  Integer reg_month;
  @NotNull(message = "주차를 입력하세요")
  Integer reg_week_num;
}
