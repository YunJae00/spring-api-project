package com.spring.web.api.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.spring.web.api.entity.Authority;
import com.spring.web.api.entity.Member;

public class MemberRequestDto {

	private String email;
	private String password;
	private String nickname;

	public MemberRequestDto() {

	}

	public MemberRequestDto(String email, String password, String nickname) {
		super();
		this.email = email;
		this.password = password;
		this.nickname = nickname;
	}

	public Member toMember(PasswordEncoder passwordEncoder) {
		Member member = new Member();
		member.setEmail(email);
		member.setPassword(passwordEncoder.encode(password));
		member.setAuthority(Authority.ROLE_USER);
		member.setNickname(nickname);
		member.setProvider("local");

		return member;
	}

	public UsernamePasswordAuthenticationToken toAuthentication() {
		return new UsernamePasswordAuthenticationToken(email, password);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

}