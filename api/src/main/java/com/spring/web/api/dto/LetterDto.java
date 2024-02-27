package com.spring.web.api.dto;

import com.spring.web.api.entity.Letter;
import com.spring.web.api.entity.Member;

public class LetterDto {

	private String createUsername;
	private String content;

	public LetterDto() {
		super();
	}

	public LetterDto(String createUsername, String content) {
		super();
		this.createUsername = createUsername;
		this.content = content;
	}

	public static LetterDto of(Letter letter) {
		return new LetterDto(letter.getCreateUsername(), letter.getContent());
	}

	public Letter toLetter(Member receiver) {
		Letter letter = new Letter();
		letter.setContent(content);
		letter.setCreateUsername(createUsername);
		letter.setReceiver(receiver);
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

}
