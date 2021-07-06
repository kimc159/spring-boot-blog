package com.springboot.blog.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.springboot.blog.model.User;

// 스프링 시큐리티가 로그인 요청을 가로채서 로그인을 진행하고 완료가 되면 UserDetails 타입의 오브젝트를
// 스프링 시큐리티의 고유한 세션저장소에 저장을 해준다.
public class PrincipalDetail implements UserDetails {

	private User user; // 콤포지션(객체를 품고 있는걸 이렇게 부른다.)
	
	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	// 계정이 만료되지 않았는지 리턴한다.(true:만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// true가 계정 안잠겨 있는거
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 비밀번호가 만료되지 않았는지 리턴 (true:만료안됨)
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정이 활성화(사용가능)인지 리턴한다. (true:활성화)
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	// 계정의 권한을 리턴
	// 리턴타입이 희한함
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		Collection<GrantedAuthority> collectors = new ArrayList<>();
		collectors.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return "ROLE_"+user.getRole(); // ROLE_USER, ROLE_ 이건 시큐리티 규칙
			}
		});
		
		// collectors.add(()->{return "ROLE_"+user.getRole();}); 위 문장이랑 같다, 람다표현식 
		// 함수 한개라 가능 
		return collectors;
	}
}
