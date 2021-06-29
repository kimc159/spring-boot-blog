package com.springboot.blog.test;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.blog.model.RoleType;
import com.springboot.blog.model.User;
import com.springboot.blog.model.UserRepository;

@RestController
public class DummyControllerTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/dummy/users")
	public List<User> userAll() {
		
		return userRepository.findAll();
	}
	
	// 한 페이지당 2건에 데이터를 리턴받아 볼 예정
	@GetMapping("/dummy/user")
	public List<User> pageList(@PageableDefault(size=2, sort="id", direction = Sort.Direction.DESC) Pageable pageable) {
		Page<User> pagingUser = userRepository.findAll(pageable);
		System.out.println(pagingUser.isFirst());
		System.out.println(pagingUser.isLast());
		System.out.println(pagingUser.getSize()); 
//		if(pagingUser.isFirst()) {
//			
//		}
		
		List<User> users = pagingUser.getContent();
		return users;  
	}
	
	//{id} 주소로 파라미터를 전달 받을 수 있음.
	// http://localhost:8000/blog/dummy/user/5
	@GetMapping("/dummy/user/{id}")
	public User detail(@PathVariable int id) {
		// user/4을 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 되니
		// return null이 리턴 되니, 프로그램에 문제가 됨
		// Optional로 너의 User객체를 감싸서 가져올테니 null인지 판단해서 return (findById의 리턴값이 Optional
		// userRepository.findById(id).get()은 null이 없다고 판단하는 함수 (조금위험)
		//userRepository.findById(id).orElseGet(new Supplier<User>() {@Overridepublic User get() { // 값이 없을 경우 빈 user 반환return new User();}	});
		User user = userRepository.findById(id).orElseThrow(new Supplier<IllegalArgumentException>() {
			@Override
			public IllegalArgumentException get() {
				// TODO Auto-generated method stub
				return new IllegalArgumentException("해당 유저는 없습니다. + id : " + id);
			}
		});
		
		// user 객체 = 자바 오브젝트
		// 변환(웹브라우저가 이해할수 있는 데이터) -> json(Gson 라이브러리)
		// 스프링부트 = MessageConverter라는 애가 응답시에 자동 작동
		// 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 Jackson 라이브러리를 호출해서
		// user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
		return user;
	} 
	
	@PostMapping("/dummy/test")  
	public String dummyTest(User user) {
		System.out.println("username : "  + user.getUsername());
		System.out.println("password : "  + user.getPassword());
		System.out.println("email : "  + user.getEmail());
		
		user.setRole(RoleType.USER);
		userRepository.save(user);
		return "회원가입이 완료되었습니다.";
	}
}
