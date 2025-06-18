package com.example.rest_jwt_ex00_2.auth;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.rest_jwt_ex00_2.entity.User;

import io.jsonwebtoken.Jwts;

@Component
public class JWTUtil {

	private SecretKey secretKey;
	
	public JWTUtil(@Value("${spring.jwt.secret}")String secret) {
		this.secretKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
											Jwts.SIG.HS256.key().build().getAlgorithm());
		System.out.println("secretKey : " + secretKey.toString() + ", algrithm : " + secretKey.getAlgorithm());
	}
	
	//토큰에서 사용자 정보 추출
	public String getUsername(String token) {
		String username = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
						  .getPayload().get("username", String.class);
		
		return username;
	}
	
	public String getName(String token) {
		String name = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
				  .getPayload().get("name", String.class);
		
		return name;
	}
	
	public String getRole(String token) {
		String role = Jwts.parser().verifyWith(secretKey).build().parseSignedClaims(token)
				  .getPayload().get("role", String.class);
		
		return role;
	}
	
	//로그인 성공시 토큰 생성 : 시간 계산 - 1000 * 60 * 3L
	public String createJwt(User user) {
		Long expirationMs = 1000 * 60 * 3L;
		String token = Jwts.builder()
						   .claim("username", user.getUsername())
						   .claim("name", user.getName())
						   .claim("role", user.getRole())
						   .issuedAt(new Date(System.currentTimeMillis()))
						   .expiration(new Date(System.currentTimeMillis()+ expirationMs)) 
						   .signWith(secretKey)
						   .compact();
		return token;
	}

	
}
