package com.springboot.blog.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.blog.model.User;
import com.springboot.blog.model.UserRepository;

// 인증이 안된 사용자들이 출입할 수 있는 경로  /auth/** 허용
// 그냥 주소가 /이면 index.jsp허용
// static 이하에 있는 /js/**, /css/**, /images/**

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/auth/joinForm")  
	public String joinForm() { 
		 
		return "user/joinForm";  
	}

	@GetMapping("/auth/loginForm")  
	public String loginForm() { 
		 
		return "user/loginForm";    
	}
}
