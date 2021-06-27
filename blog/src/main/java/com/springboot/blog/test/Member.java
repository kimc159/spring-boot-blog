package com.springboot.blog.test;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@RequiredArgsConstructor // final 붙은 변수 생성자 생성
@Data // @Getter + @Setter 합친거
@AllArgsConstructor // 전체생성자
@NoArgsConstructor // 빈 생성자
public class Member {
	private int id;
	private String username;
	private String password;
	private String email;
	 
}
