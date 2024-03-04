package com.spring.web.api.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.spring.web.api.entity.Member;

public class MemberDetailsDto {

	private String email;
	private String provider;
	private String nickname;
	private List<LetterDto> letters;

	public MemberDetailsDto() {
		super();
	}

	public MemberDetailsDto(String email, String provider, String nickname, List<LetterDto> letters) {
		super();
		this.email = email;
		this.provider = provider;
		this.nickname = nickname;
		this.letters = letters;
	}

	public static MemberDetailsDto of(Member member) {
		List<LetterDto> letterDtoList = member.getLetters().stream().map(LetterDto::of).collect(Collectors.toList());

		return new MemberDetailsDto(member.getEmail(), member.getProvider(), member.getNickname(), letterDtoList);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public List<LetterDto> getLetters() {
		return letters;
	}

	public void setLetters(List<LetterDto> letters) {
		this.letters = letters;
	}

}
