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

@Controller
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/joinForm")  
	public String joinForm() { 
		 
		return "user/joinForm";  
	}

	@GetMapping("/loginForm")  
	public String loginForm() { 
		 
		return "user/loginForm";    
	}
	
	@ResponseBody
	@PostMapping("/user/join")
	public Map<String, Integer> join(@RequestBody User user) { 
		int result = 0;
		
		User saveUser = userRepository.save(user); 
		
		if(saveUser != null) {
			
		}
		
		Map<String, Integer> map = new HashMap<String, Integer>();	
		map.put("result", result); 
		
		return  map;  
	} 
}
