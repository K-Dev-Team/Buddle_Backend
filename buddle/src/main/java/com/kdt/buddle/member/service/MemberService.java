package com.kdt.buddle.member.service;

import com.kdt.buddle.member.dto.SignInRequest;
import com.kdt.buddle.member.dto.SignRequest;
import com.kdt.buddle.member.dto.SignResponse;

import java.util.Map;

public interface MemberService {
  public Map<String,Object> register(SignRequest request) throws Exception;
  public SignResponse login(SignInRequest request) throws Exception;
}
