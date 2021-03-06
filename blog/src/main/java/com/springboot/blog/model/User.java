package com.springboot.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

// ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder // 빌더 패턴
@Entity // User클래스가 MySQL에 테이블이 생성된다.
//@DynamicInsert // insert시에 null인 데이터 제외
public class User {
	
	@Id // privmary key 명시
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY는 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다. (  ex) oracle은 sequence, mysql은 auto_increment)
	private int id; // auto_increment
	
	@Column(nullable = false, length = 30, unique = true)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	// @ColumnDefault("user")
	//DB는 RoleType이라는 게 없다.
	@Enumerated(EnumType.STRING) // 해당 enum이 스트링 타입이라고 명시
	private RoleType role; // Enum을 쓰는게 좋다. // admin, user
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
}
