package com.springboot.blog.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@ControllerAdvice // Exception이 발생했을 때 여길로 들어옴
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=Exception.class) // IllegalArgumentException이 발생하면 이 함수를 실행하고 e 안에 해당 내용이 들어감
	public String handleArgumentException(Exception e) {
		return "<h1>" + e.getMessage() + "</h1>"; 
	}
}
