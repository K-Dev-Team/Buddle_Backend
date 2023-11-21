package com.kdt.buddle.meditation.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class MeditationWriteDto {

  @NotBlank(message = "콘텐츠 내용을 입력해주세요")
  private String contents;

  @NotNull(message = "이번달을 입력하세요")
  private Integer reg_month;

  @NotNull(message = "주차를 입력하세요")
  private Integer reg_week_num;
}
