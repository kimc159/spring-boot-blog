package com.springboot.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

// ORM -> Java(다른언어) Object -> 테이블로 매핑해주는 기술
@Entity // User클래스가 MySQL에 테이블이 생성된다.
public class User {
	
	@Id // privmary key 명시
	@GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTITY는 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다. (  ex) oracle은 sequence, mysql은 auto_increment)
	private int id; // auto_increment
	
	@Column(nullable = false, length = 30)
	private String username; // 아이디
	
	@Column(nullable = false, length = 100)
	private String password;
	
	@Column(nullable = false, length = 50)
	private String email;
	
	@ColumnDefault("'user'")
	private String role; // Enum을 쓰는게 좋다. // admin, user, manager
	
	@CreationTimestamp // 시간이 자동 입력
	private Timestamp createDate;
}
