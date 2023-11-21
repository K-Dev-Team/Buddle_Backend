package com.kdt.buddle.meditation.dto;

import lombok.Data;

@Data
public class MeditationCmtDto {
  int mdt_cmt_idx;
  int mdt_idx;
  String contents;
  int member_idx;
  String reg_date;
  String udt_date;
  String del_yn;

}
