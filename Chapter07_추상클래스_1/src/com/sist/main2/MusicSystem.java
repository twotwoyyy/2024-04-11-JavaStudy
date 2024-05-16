package com.sist.main2;
/*
 *	Movie => CGV / MegaBox / 롯데시네마 (공통으로 수행되는 기능들이 있음) 
 * => 추상클래스로 만들어놓으면 상속을 받아 사용할 수 있음 
 */
public abstract class MusicSystem {
	public static Music[] musics=new Music [50];
	public abstract void init(); // 데이터 초기화
	public abstract void find(String title);
	public abstract void list();
	public abstract void detail(int mno);
}
