package com.spring.web.api.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class RefreshToken {

	@Id
	@Column(name = "rt_key")
	private String key;

	@Column(name = "rt_value")
	private String value;

	public RefreshToken() {

	}

	public RefreshToken(String key, String value) {
		this.key = key;
		this.value = value;
	}

	public RefreshToken updateValue(String token) {
		this.value = token;
		return this;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
