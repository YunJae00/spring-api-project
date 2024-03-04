package com.spring.web.api.dto;

import com.spring.web.api.entity.Letter;
import com.spring.web.api.entity.Member;

public class LetterDto {

	private String createUsername;
	private String content;
	private Long letterNumber;

	public LetterDto() {
		super();
	}

	public LetterDto(String createUsername, String content, Long letterNumber) {
		super();
		this.createUsername = createUsername;
		this.content = content;
		this.letterNumber = letterNumber;
	}

	public static LetterDto of(Letter letter) {
		return new LetterDto(letter.getCreateUsername(), letter.getContent(), letter.getLetterNumber());
	}

	public Letter toLetter(Member receiver) {
		Letter letter = new Letter();
		letter.setContent(content);
		letter.setCreateUsername(createUsername);
		letter.setReceiver(receiver);
		letter.setLetterNumeber(letterNumber);
		return letter;
	}

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getLetterNumber() {
		return letterNumber;
	}

	public void setLetterNumber(Long letterNumber) {
		this.letterNumber = letterNumber;
	}

}
