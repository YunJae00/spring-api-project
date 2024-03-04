package com.spring.web.api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.spring.web.api.dto.LetterDto;
import com.spring.web.api.dto.MemberDetailsDto;
import com.spring.web.api.entity.Member;
import com.spring.web.api.repository.MemberRepository;

@Service
public class MemberService {

	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	public boolean exsistMember(String email) {
		return memberRepository.existsByEmail(email);
	}

	public MemberDetailsDto getMemberDetails(String email) {
		Member member = memberRepository.findMemberByEmail(email);
		List<LetterDto> letterDetailsDtoList = member.getLetters().stream().map(LetterDto::of)
				.collect(Collectors.toList());
		return new MemberDetailsDto(member.getEmail(), member.getProvider(), member.getNickname(),
				letterDetailsDtoList);
	}
}
