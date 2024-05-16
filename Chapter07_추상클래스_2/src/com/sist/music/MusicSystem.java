package com.sist.music;

public abstract class MusicSystem {
	//전체 데이터를 가지고 있다
	public static Music[] musics=new Music[50];
	//데이터 초기화 => 추상메소드 
	public abstract void init(); // 읽어오는 파일명이 다르기 때문에 따로 구현해야 한다 
	/////////////////////////////
	//목록 출력
	public void list() {
		System.out.println("=============== 목록 출력 ================");
		int i=1;
		for(Music m:musics) {
			System.out.println(i+"."+m.getTitle());
			i++;
		}
	}
	//상세보기
	public void detail(int mno) {
		System.out.println("=============== 상세 보기==============");
		Music m=musics[mno-1];
		// 1번부터 배열은 0번부터니까 -1
		System.out.println("제목:"+m.getTitle());
		System.out.println("가수명:"+m.getSinger());
		System.out.println("앨범명:"+m.getAlbum());
	}
	//검색
	public void find(String title) {
		System.out.println("========= 검색 =========");
		int i=1;
		for(Music m:musics) {
			if(m.getTitle().contains(title)) {
			System.out.println(m.getTitle());
			}
		}
	}
	/////////////////////////구현 
}
