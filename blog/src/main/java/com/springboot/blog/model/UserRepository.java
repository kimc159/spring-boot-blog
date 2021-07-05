package com.springboot.blog.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// DAO
// 자동으로 bean 등록이 된다.
// @Repository 생략 가능하다.
public interface UserRepository extends JpaRepository<User, Integer> {
	
}

// JPA Naming 쿼리
// Select * from user Where username = ? and password = ?로 자동적으로 실행
// User findByUsernameAndPassword(String username, String password);

// 이렇게 하면 native Query가 실행된다.
//	@Query(value="Select * from user Where username = ? and password = ?", nativeQuery = true)
//	User login(String username, String password);
