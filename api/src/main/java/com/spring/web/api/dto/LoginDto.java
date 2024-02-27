package com.spring.web.api.dto;

import org.antlr.v4.runtime.misc.NotNull;

public class LoginDto {

	@NotNull
	private String name;

	@NotNull
	private String password;

	public LoginDto() {
		super();
	}

	public LoginDto(String name, String password) {
		super();
		this.name = name;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
