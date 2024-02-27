package com.spring.web.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.api.dto.MemberRequestDto;
import com.spring.web.api.dto.MemberResponseDto;
import com.spring.web.api.dto.TokenDto;
import com.spring.web.api.dto.TokenRequestDto;
import com.spring.web.api.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final AuthService authService;

	public AuthController(AuthService authService) {
		this.authService = authService;
	}

	@PostMapping("/signup")
	public ResponseEntity<MemberResponseDto> signup(@RequestBody MemberRequestDto memberRequestDto) {
		return ResponseEntity.ok(authService.signup(memberRequestDto));
	}

	@PostMapping("/login")
	public ResponseEntity<TokenDto> login(@RequestBody MemberRequestDto memberRequestDto) {
		return ResponseEntity.ok(authService.login(memberRequestDto));
	}

	@PostMapping("/reissue")
	public ResponseEntity<TokenDto> reissue(@RequestBody TokenRequestDto tokenRequestDto) {
		return ResponseEntity.ok(authService.reissue(tokenRequestDto));
	}

}
