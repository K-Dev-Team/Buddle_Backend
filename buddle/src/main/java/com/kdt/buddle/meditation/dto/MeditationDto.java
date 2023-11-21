package com.kdt.buddle.meditation.dto;

import lombok.Data;

import java.util.Date;

@Data
public class MeditationDto {

  int mdt_idx;
  String contents;
  int member_idx;
  String reg_date;
  String udt_date;
  String del_yn;
  int reg_month;
  int reg_week_num;
}
