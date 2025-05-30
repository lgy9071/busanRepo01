package com.example.securityEx02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration //빈 등록
@EnableWebSecurity //시큐리티 관련 권한 인가 부분 담당
public class SecurityConfig {

	@Bean //패스워드 암호화
	BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean //여기가 핵심 ("/", "/regMember", "/regist") 인증 안해도 되도록
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/", "/regMember", "/regist").permitAll()
				.requestMatchers("/member/**").hasAnyRole("ADMIN", "MEMBER")
				.requestMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated()
				);
		
		http.formLogin((auth) -> auth
					.loginPage("/login")
					.loginProcessingUrl("/loginProc")
					.defaultSuccessUrl("/member/welcome")
					.failureUrl("/fail")
					.permitAll()
				);
		
		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
}
