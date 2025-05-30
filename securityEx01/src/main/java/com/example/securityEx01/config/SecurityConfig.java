package com.example.securityEx01.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//	@Bean //스트레오 컨트롤러 외 메서드에 붙임 > 메서드의 반환 자료가 bean으로 등록
//	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http.authorizeHttpRequests(auth -> auth
////				.requestMatchers("/").permitAll() // "/" 모두에게 개방해라
//				.anyRequest().permitAll() // 이렇게 쓸 일은 없을거다~
//				);
//		
//		return http.build(); 
//	}
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http.authorizeHttpRequests((auth) -> auth
				.requestMatchers("/").permitAll()
				.anyRequest().permitAll()
				);
		http.formLogin(auth -> auth
					.loginPage("/login")
					.loginProcessingUrl("/loginProc")
					.defaultSuccessUrl("/welcome")
					.permitAll()
					);
		//http.formLogin(Customizer.withDefaults());
		//http.httpBasic(Customizer.withDefaults());
		
		http.csrf(csrf -> csrf.disable());
		
		http.logout(Customizer.withDefaults()); // 기본 /logout 처리
		
		return http.build(); 
	}
	
	
}
