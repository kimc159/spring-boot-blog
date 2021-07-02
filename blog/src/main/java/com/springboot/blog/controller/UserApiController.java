package com.springboot.blog.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.dto.ResponseDto;
import com.springboot.blog.model.User;

@RestController
public class UserApiController {
	
	@PostMapping("/api/user")
	public ResponseDto<Integer> save(@RequestBody User user) {
		
		// 실제 DB에서 insert하고 아래에서 return
		return new ResponseDto<Integer>(HttpStatus.OK, 1); 
	}
}
