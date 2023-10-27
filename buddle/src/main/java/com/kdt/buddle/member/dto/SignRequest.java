package com.kdt.buddle.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {

  private int idx;

  private String account;

  private String password;

  private String name;

  private String birth;

}