package com.spring.web.api.dto;

public class MemberEmailDto {

	private String email;

	public MemberEmailDto() {
		super();
	}

	public MemberEmailDto(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
