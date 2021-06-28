package com.springboot.blog.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
	private int id;
	
	@Column(nullable = false, length = 100)
	private String title;
	
	@Lob // 대용량 데이터
	private String content; // 섬머노트 라이브러리 <html> 태그가 섞여서 디자인이 됨.
	
	@ColumnDefault("0")
	private int count; // 조회수
	
	@ManyToOne // Many = Board, User = One 한명의 유저는 여러개의 글을 쓸수 있다는 뜻
	@JoinColumn(name="userId") // DB에 userId라는 컬럼으로 들어간다.
	private User user; // DB는 오브젝트를 저장할 수 없다. 그래서 FK를 사용, 자바는 오브젝트를 저장할 수 있다. -> 실제로 User객체로 만들게 되면 DB에는 FK로 들어감
	
	@CreationTimestamp
	private Timestamp createDate;
}
