package com.sist.main2;
// 모든 클래스에는 this.super; 상속 내린 클래스에 접근 
// 모든 클래스는 상속을 받는다 => extends Object (생략)
public class Music {
//  다른 클래스에서 사용 한다 
	private String mno;
	private String mtitle;
	private String singer;
	private String album;
	private String poster;
	// private 변수 => 다른 클래스 연결하려면 메소드를 이용해 접근 (데이터 보호) => 캡슐화 
	public String getMno() {
		return mno;
	}
	public void setMno(String mno) {
		// 임시 변수 => 메소드 안에서만 사용, 다른 클래스에서는 사용 불가 
		this.mno = mno;
		// this는 자신의 클래스 객체 주소를 저장해서 사용 
		// this는 static 모든 객체는 this를 가지고 있다 
		// this가 많이 사용되는 곳 => 멤버변수/지역변수의 이름이 같은 경우에 구분 
		// this.mno => Music이 가지고 있는 변수 
	}
	public String getMtitle() {
		return mtitle;
		// 1. 지역변수, 매개변수 찾고 없는 경우 => 2. 멤버변수 찾기 
		// 지역변수 우선순위!! 
		// 없는 경우에는 this. 를 생략 가능 // 충돌이 안되면 this. 생략 가능 
	}
	public void setMtitle(String mtitle) {
		this.mtitle = mtitle;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public String getAlbum() {
		return album;
	}
	public void setAlbum(String album) {
		this.album = album;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	
}
