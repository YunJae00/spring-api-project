package com.spring.web.api.service;

import org.springframework.stereotype.Service;

import com.spring.web.api.dto.LetterDto;
import com.spring.web.api.entity.Letter;
import com.spring.web.api.entity.Member;
import com.spring.web.api.repository.LetterRepository;
import com.spring.web.api.repository.MemberRepository;

@Service
public class LetterService {

	private final LetterRepository letterRepository;
	private final MemberRepository memberRepository;

	public LetterService(LetterRepository letterRepository, MemberRepository memberRepository) {
		this.letterRepository = letterRepository;
		this.memberRepository = memberRepository;
	}

	public LetterDto saveLetter(LetterDto letterDto, String email) {
		Member receiver = memberRepository.findByEmail(email)
				.orElseThrow(() -> new IllegalArgumentException("Receiver not found"));

		Letter letter = new Letter();
		letter.setContent(letterDto.getContent());
		letter.setCreateUsername(letterDto.getCreateUsername());
		letter.setReceiver(receiver);
		letter.setLetterNumeber(letterDto.getLetterNumber());

		receiver.getLetters().add(letter); // 양방향 관계 설정

		letterRepository.save(letter);

		return letterDto;
	}
}
