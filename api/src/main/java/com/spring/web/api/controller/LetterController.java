package com.spring.web.api.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.web.api.dto.LetterDto;
import com.spring.web.api.service.LetterService;

@RestController
@RequestMapping("/api/letters")
public class LetterController {

	private final LetterService letterService;

	public LetterController(LetterService letterService) {
		this.letterService = letterService;
	}

	@PostMapping("/create/{email}")
	public ResponseEntity<LetterDto> create(@RequestBody LetterDto letterDto, @PathVariable String email) {
		return ResponseEntity.ok(letterService.saveLetter(letterDto, email));
	}

	@GetMapping("/test")
	public ResponseEntity<String> test() {
		return ResponseEntity.ok("test ok");
	}
}
