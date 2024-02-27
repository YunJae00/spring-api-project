package com.spring.web.api.dto;

import com.spring.web.api.entity.Member;

public class MemberResponseDto {
	private String email;

	public MemberResponseDto() {

	}

	public MemberResponseDto(String email) {
		super();
		this.email = email;
	}

	public static MemberResponseDto of(Member member) {
		return new MemberResponseDto(member.getEmail());
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
