package com.springboot.blog.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.model.RoleType;
import com.springboot.blog.model.User;
import com.springboot.blog.model.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/dummy/test")  
	public String dummyTest(User user) {
		System.out.println("username : "  + user.getUsername());
		System.out.println("password : "  + user.getPassword());
		System.out.println("email : "  + user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
}
