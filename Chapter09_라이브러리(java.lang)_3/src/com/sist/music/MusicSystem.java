package com.sist.music;

import java.io.*;

public class MusicSystem { // 데이터를 갖고 있다 
// 뮤직 데이터 공유 => 모든 유저가 같은 화면을 볼 수 있게 한다 / 같은 데이터 사용 => static 
/*
 *	  A B C D E F G H J I K 
 *    
 *    String s="A"
 *     s
 *    ----
 *    100   
 *    ---- 100------
 *            "A"
 *           ------
 *    s=s+"B"
 *      s
 *    ----
 *    100 => 200 
 *    ----  100------
 *             "A"
 *            ------
 *          200-----
 *             "AB"
 *           -------
 *    sb
 *    ----
 *    100
 *    ---- 100 -------
 *              AB
 *             ------- 메모리가 바뀌지 않고 붙여나가기 때문에 속도가 빠르다
 *                    = 하나의 공간 안에 데이터를 모아준다 
 */
	private static Music[] musics=new Music[200];
	
	// 파일 읽기 => 데이터 저장 
	// 클래스 영역에서는 사용이 불가 class는 선언만 가능한 영역
	
	//초기화 블록
	
	static {
		FileReader fr=null;
		try {
			// CheckedException => 컴파일시 예외 감시
			// 초기화 블록은 throws는 사용이 불가 => 메소드에서만 사용 가능 (생성자 포함) 
			fr=new FileReader("c:\\javaDev\\Genie.txt");
			int i=0;
			StringBuffer sb=new StringBuffer();
			// 데이터 문자열 결합이 많은 경우 => 읽기: StringBuffer(비동기) / StringBilder(동기)
			//                          저장: ArrayList             Vector
			while((i=fr.read())!=-1) {
				sb.append((char)i);
			}
			//System.out.println(sb.toString());
			String data=sb.toString();
			//분리 \n
			String[] temp=data.split("\n");
			i=0;
			for(String s:temp) {
				String[] m=s.split("\\|"); // | => 정규식 기호 일반 문자로 바꾸려면 \\
				// 정규식 기호 . , + * | ? ^ $  + \\ 붙여서 사용!! 
				musics[i]=new Music();
				musics[i].setMno(Integer.parseInt(m[0])); // String을 정수형으로 바꿔서 사용
				musics[i].setTitle(m[1]);
				musics[i].setSinger(m[2]);
				musics[i].setAlbum(m[3]);
				musics[i].setPoster(m[4]);
				musics[i].setKey(m[5]);
				i++;
			}
		}catch(Exception ex) {
			// 에러가 발생시 복구 => 에러 위치 확인
			ex.printStackTrace(); // FileNotFoundException/ IOException 
		}
		finally {
			try {
					fr.close();
			}catch(Exception ex) {}
		}
	}
	public Music[] musicListData() {
		return musics;
	}
	//
	public Music MusicDetailData(int mno) {
		Music m=new Music();
		for(Music mm:musics) {
			if(mm.getMno()==mno) {
				m=mm;
				break;
			}
		}
		return m;
	}
	public int musicTotalPage() {
		return (int)(Math.ceil(musics.length/20.0)); // 총페이지 구하기 ceil 올림함수 
	}
	//검색
	public Music[] musicFindData(String fd) {
		int count=0;
		for(Music m:musics) {
			if(m.getTitle().contains(fd)) {
				count++;
			}
		}
		
		Music[] mm=new Music[count];
		int i=0;
		for(Music m:musics) {
			if(m.getTitle().contains(fd)) {
				mm[i]=m;
				i++;
			}
		}
		return mm;
	}

}

