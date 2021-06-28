package com.springboot.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {
	
	@GetMapping("/temp/home")
	public String tempHome() {
		System.out.println("tempHome()"); 
		// 파일 기본 경로 : src/main/resources/static
		return "/home.html";
	}
	
	@GetMapping("/temp/jsp")
	public String tempJsp() { 
		System.out.println("tempJsp()"); 
		// 파일 기본 경로 : src/main/resources/static 
		return "test";
	}
}
