package com.example.securityEx02.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.securityEx02.entity.User;
import com.example.securityEx02.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    System.out.println("로그인 시도된 username: " + username);
	    User user = userRepository.findByUsername(username);
	    System.out.println("조회된 user: " + user);

	    if (user == null) {
	        throw new UsernameNotFoundException("사용자를 찾을 수 없습니다: " + username);
	    }
	    return new CustomUserDetails(user);
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		
//		User user = userRepository.findByUsername(username);
//		if(user != null) {
//			return new CustomUserDetails(user);
//		}
//		
//		return null;
//	}

}
