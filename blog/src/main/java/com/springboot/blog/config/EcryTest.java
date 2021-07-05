package com.springboot.blog.config;

import org.junit.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class EcryTest {
	
	@Test
	public void psswordTest() {
		String password =  new BCryptPasswordEncoder().encode("1234");
		
		System.out.println(password);
	}
}
