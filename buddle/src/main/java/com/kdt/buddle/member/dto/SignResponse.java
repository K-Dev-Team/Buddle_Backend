package com.kdt.buddle.member.dto;


import com.kdt.buddle.member.model.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {

  private int idx;

  private String account;

//  private String password;

  private String name;

  private String birth;

  private List<Authority> roles = new ArrayList<>();

  private String token;

  private String errorMsg;


  public SignResponse(Member member) {
    this.idx = member.getIdx();
    this.account = member.getAccount();
    this.name = member.getName();
    this.birth = member.getBirth();
    this.roles = member.getRoles();
  }

}