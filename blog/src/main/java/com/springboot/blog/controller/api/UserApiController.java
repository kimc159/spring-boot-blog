package com.springboot.blog.controller.api;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.dto.ResponseDto;
import com.springboot.blog.model.RoleType;
import com.springboot.blog.model.User;
import com.springboot.blog.service.UserService;

@RestController
public class UserApiController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpSession session;
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		
		user.setRole(RoleType.USER);
		int result = userService.회원가입(user); 
		
		// 실제 DB에서 insert하고 아래에서 return 
		return new ResponseDto<Integer>(HttpStatus.OK.value(), result); 
	}
	
	@PostMapping("/api/user/login")
	public ResponseDto<Integer> login(@RequestBody User user) { 
		System.out.println("login controller");
		User principal = userService.로그인(user);
		
		if(principal != null) {
			session.setAttribute("principal", principal);
		}
		
		return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
	}
}
