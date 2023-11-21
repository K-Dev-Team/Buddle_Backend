package com.kdt.buddle.member.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Data
public class SignInRequest {

  @NotNull(message = "아이디를 입력해주세요")
  private String account;
  @NotNull(message = "비밀번호를 입력해주세요")
  private String password;


}