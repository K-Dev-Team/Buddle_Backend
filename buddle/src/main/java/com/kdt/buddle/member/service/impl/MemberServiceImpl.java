package com.kdt.buddle.member.service.impl;

import com.kdt.buddle.member.dto.SignRequest;
import com.kdt.buddle.member.dto.SignResponse;
import com.kdt.buddle.member.jwt.JwtProvider;
import com.kdt.buddle.member.repository.MemberRepository;
import com.kdt.buddle.member.model.Authority;
import com.kdt.buddle.member.model.Member;
import com.kdt.buddle.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.Optional;

@Service
@Log4j2
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

  private final MemberRepository memberRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtProvider jwtProvider;


  @Override
  public boolean register(SignRequest request) throws Exception {
    try {
      Member member = Member.builder()
              .account(request.getAccount())
              .password(passwordEncoder.encode(request.getPassword()))
              .name(request.getName())
              .birth(request.getBirth())
              .build();

      member.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));

      memberRepository.save(member);
    } catch (Exception e) {
      log.error(e.getMessage());
      throw new Exception("잘못된 요청입니다.");
    }
    return true;
  }

  @Override
  public SignResponse login(SignRequest request) throws Exception {

    Optional<Member> optionalMember = memberRepository.findByAccount(request.getAccount());

    if (optionalMember.isEmpty()) {
      return SignResponse.builder().errorMsg("아이디를 찾을 수 없습니다.").build();
    }

    Member member = optionalMember.get();

    if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
      return SignResponse.builder().errorMsg("비밀번호가 틀렸습니다").build();
    }

    return SignResponse.builder()
            .idx(member.getIdx())
            .account(member.getAccount())
            .name(member.getName())
            .birth(member.getBirth())
            .roles(member.getRoles())
            .token(jwtProvider.createToken(member.getAccount(),member.getRoles()))
            .build();
  }
}
