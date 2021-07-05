package com.springboot.blog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springboot.blog.model.User;
import com.springboot.blog.model.UserRepository;

@Service // 스프링이 컴포넌트 스캔을 통해 Bean에 등록을 해줌. IoC를 해줌
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public int 회원가입(User user) {
		try {
			userRepository.save(user);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("UserService : 회원가입() : " + e.getMessage());
		}
		
		return -1;
		
	}
	
}
