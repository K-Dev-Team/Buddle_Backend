package com.kdt.buddle.member.ctl;

import com.kdt.buddle.member.dto.SignInRequest;
import com.kdt.buddle.member.dto.SignRequest;
import com.kdt.buddle.member.dto.SignResponse;
import com.kdt.buddle.member.service.MemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin
@Log4j2
@Api(tags = {"회원관리 API"})
public class MemberController {

  private final MemberService memberService;

  @Autowired
  public MemberController(MemberService memberService) {
    this.memberService = memberService;
  }

  //회원가입
  @PostMapping("/member/signUp.do")
  @ApiOperation(value = "회원가입 API", response = ResponseEntity.class)
  public ResponseEntity<String> signup(@Validated @RequestBody SignRequest request) {
    try {
      Map<String,Object> isSignUpOk = memberService.register(request);
      String resMsg = String.valueOf(isSignUpOk.get("msg"));
      if (isSignUpOk.get("isOk").equals(true)) return ResponseEntity.ok().body(resMsg);
      else return ResponseEntity.badRequest().body(resMsg);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseEntity.badRequest().body("가입 시도 중 에러 발생");
    }
  }

  @PostMapping("/member/signIn.do")
  @ApiOperation(value = "로그인 API", response = ResponseEntity.class)
  public ResponseEntity<SignResponse> signIn(@Validated @RequestBody SignInRequest request) throws Exception {
    SignResponse sr = memberService.login(request);
    if (sr.getErrorMsg() != null) {
      if (sr.getErrorMsg().equals("비밀번호가 틀렸습니다"))
        return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);
      if (sr.getErrorMsg().equals("아이디를 찾을 수 없습니다."))
        return new ResponseEntity<>(sr, HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<>(sr, HttpStatus.OK);
  }
}
