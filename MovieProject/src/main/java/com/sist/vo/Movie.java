package com.sist.vo;

import lombok.Data;

@Data
public class Movie {
	//접근지정어 => default => 같은 패키지에서만 접근이 가능 
	private String mno;
	private String title; 
	private String genre;
	private String poster;
	private String actor;
	private String regdate;
	private String grade;
	private String director;
	//Movie라는 클래스 안에서만 사용이 가능하다 private => 다른 클래스 사용 불가 
	//사용이 가능하도록 기능을 추가 => (변수: 저장/값읽기) => getter/setter

	
	

}
