package com.spring.web.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.api.dto.MemberDetailsDto;
import com.spring.web.api.dto.MemberEmailDto;
import com.spring.web.api.service.MemberService;

@RestController
@RequestMapping("/api/members")
public class MemberController {

	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@PostMapping("/member")
	public ResponseEntity<Boolean> exsistsByEmail(@RequestBody MemberEmailDto memberEmailDto) {
		if (memberService.exsistMember(memberEmailDto.getEmail())) {
			return ResponseEntity.ok(true);
		} else {
			return ResponseEntity.ok(false);
		}
	}

	@GetMapping("/member/details/{email}")
	public ResponseEntity<MemberDetailsDto> findMemberDetailsByEmail(@PathVariable String email) {
		return ResponseEntity.ok(memberService.getMemberDetails(email));
	}
}
