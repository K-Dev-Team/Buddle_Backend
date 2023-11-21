package com.kdt.buddle.member.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SignRequest {
  private int idx;
  @NotBlank(message = "아이디를 입력해주세요")
  private String account;
  @NotBlank(message = "비밀번호를 입력하세요")
  private String password;
  private String name;
  private String birth;
}