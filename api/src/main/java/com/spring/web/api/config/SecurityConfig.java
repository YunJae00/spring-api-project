package com.spring.web.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.CorsFilter;

import com.spring.web.api.jwt.JwtAccessDeniedHandler;
import com.spring.web.api.jwt.JwtAuthenticationEntryPoint;
import com.spring.web.api.jwt.JwtSecurityConfig;
import com.spring.web.api.jwt.JwtTokenProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
	private final JwtTokenProvider jwtTokenProvider;
	private final CorsFilter corsFilter;
	private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
	private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

	public SecurityConfig(JwtTokenProvider jwtTokenProvider, CorsFilter corsFilter,
			JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint, JwtAccessDeniedHandler jwtAccessDeniedHandler) {
		super();
		this.jwtTokenProvider = jwtTokenProvider;
		this.corsFilter = corsFilter;
		this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
		this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// CSRF 설정 Disable
		http.csrf().disable()

				.addFilterBefore(corsFilter, UsernamePasswordAuthenticationFilter.class)

				// exception handling 할 때 우리가 만든 클래스를 추가
				.exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
				.accessDeniedHandler(jwtAccessDeniedHandler)

				.and().headers().frameOptions().sameOrigin()

				// 시큐리티는 기본적으로 세션을 사용
				// 여기서는 세션을 사용하지 않기 때문에 세션 설정을 Stateless 로 설정
				.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

				// 로그인, 회원가입 API 는 토큰이 없는 상태에서 요청이 들어오기 때문에 permitAll 설정
				.and().authorizeHttpRequests()
				.requestMatchers("/api/auth/**", "/h2-console/**", "/api/test", "/api/members/**", "/api/letters/**").permitAll()
				.anyRequest().authenticated() // 나머지
				// API
				// 는
				// 전부
				// 인증
				// 필요

				// JwtFilter 를 addFilterBefore 로 등록했던 JwtSecurityConfig 클래스를 적용
				.and().apply(new JwtSecurityConfig(jwtTokenProvider));

		return http.build();
	}

}
