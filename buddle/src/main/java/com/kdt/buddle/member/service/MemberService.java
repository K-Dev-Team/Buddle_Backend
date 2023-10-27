package com.kdt.buddle.member.service;

import com.kdt.buddle.member.dto.SignRequest;
import com.kdt.buddle.member.dto.SignResponse;

public interface MemberService {
  public boolean register(SignRequest request) throws Exception;
  public SignResponse login(SignRequest request) throws Exception;
}
