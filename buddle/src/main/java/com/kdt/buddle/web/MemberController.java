package com.kdt.buddle.web;

import com.kdt.buddle.member.dto.SignRequest;
import com.kdt.buddle.member.dto.SignResponse;
import com.kdt.buddle.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@Log4j2
public class MemberController {

  @Autowired
  private MemberService memberService;
  //회원가입
  @PostMapping("/member/signUp.do")
  public ResponseEntity<Map<String, Object>> signup(@RequestBody SignRequest request, BindingResult bindingResult) throws Exception {

    Map<String, Object> result = new HashMap<>();

    try {
      result.put("failOrSucc", memberService.register(request));
    } catch (Exception e) {
      e.printStackTrace();
    }

    return ResponseEntity.ok().body(result);
  }

  @PostMapping("/member/signIn.do")
  public ResponseEntity<SignResponse> signIn(@RequestBody SignRequest request) throws Exception {

    SignResponse sr = memberService.login(request);

    if(sr.getErrorMsg() != null) {
      if (sr.getErrorMsg().equals("비밀번호가 틀렸습니다"))
        return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);

      if (sr.getErrorMsg().equals("아이디를 찾을 수 없습니다."))
        return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);
    }

    return new ResponseEntity<>(sr, HttpStatus.OK);
  }



}
