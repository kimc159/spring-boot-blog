package com.springboot.blog.test;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

// 사용자가 요청 -> HTML파일
// @Controller

// 사용자가 요청 -> Data
// @RestController

@RestController
public class HttpControllerTest {
		private static final String TAG = "HttpControllerTest";
		
		@GetMapping("/lombok/test")
		public String lombokTest() {
			// builder를 통해 생성자에 넣고싶은 인자만 넣을 수 있고 순서 상관없이 사용 가능(lombok)
			Member m = Member.builder().email("cos@naver.com").password("1234").username("cos").build();
			System.out.println(TAG + " getter : " + m.getId());
			m.setId(5000); 
			System.out.println(TAG + " setter : " + m.getId()); 
			
			return "lombok test"; 
		}
		
		@GetMapping("/http/get")  
		public String getTest(Member m) { // url로 id=1&password=1234 보낼때 MessageConverter(스프링 부트) 가 수행
			return "get 요청 " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", "  + m.getEmail();
		}
		 
		@PostMapping("/http/post")
		public String postTest(@RequestBody Member m) { // @RequestBody Stirng text -> text/plain(텍스트형태로 값 보낼때), 
																												// @RequestBody Member m -> application/json(json형태로 데이터 보낼때) -> MessageConverter(스프링 부트) 가 수행
			return "post 요청 " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", "  + m.getEmail();
		}
		
		@PutMapping("/http/put")
		public String putTest(@RequestBody Member m) {  
			return "put 요청 " + m.getId() + ", " + m.getUsername() + ", " + m.getPassword() + ", "  + m.getEmail();
		}
		  
		@DeleteMapping("/http/delete")
		public String deleteTest() {
			return "delete 요청";
		}
}
