package com.spring.web.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.web.api.entity.Letter;

public interface LetterRepository extends JpaRepository<Letter, Long> {

}
