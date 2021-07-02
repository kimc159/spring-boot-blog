package com.springboot.blog.handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.dto.ResponseDto;

@ControllerAdvice // Exception이 발생했을 때 여길로 들어옴
@RestController
public class GlobalExceptionHandler {
	
	@ExceptionHandler(value=Exception.class) // Exception이 발생하면 이 함수를 실행하고 e 안에 해당 내용이 들어감
	public ResponseDto<String> handleArgumentException(Exception e) { 
		return new ResponseDto<String>(HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage()); 
	}
}
