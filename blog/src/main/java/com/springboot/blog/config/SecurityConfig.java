package com.springboot.blog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration // 빈 등록
@EnableWebSecurity // 시큐리티 필터가 등록이 된다.시큐리티가 모든 request요청을 가로챔
@EnableGlobalMethodSecurity(prePostEnabled = true) // 특정 주소로 접근을 하면 권한 및 인증을 미리 체크하겠다는 뜻
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean // IcC가 된다.
	public BCryptPasswordEncoder encodePWD() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable() // csrf 토큰 비활성화 (테스트시 걸어두는게 좋음)
			.authorizeRequests() // request가 들어오면
				.antMatchers("/", "/auth/**", "/js/**", "/css/**", "/images/**")  
				.permitAll()// 누구나 들어올 수 있다. 
				.anyRequest() // 이게 아닌 다른 요청은
				.authenticated() // 인증이 되야됨
			.and()
				.formLogin()
				.loginPage("/auth/loginForm");  
		
	}
}
