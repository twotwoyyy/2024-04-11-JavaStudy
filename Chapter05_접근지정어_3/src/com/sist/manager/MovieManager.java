package com.sist.manager;
import com.sist.vo.*; //Movie

import java.io.FileReader;
// 패키지가 다르면 => import를 이용해서 클래스 읽기를 한다 
/*
 *	접근지정어 
 *	--------------------------------------------------------
 *    종류         자신의 클래스   같은 패키지     모든 클래스 
 *  --------------------------------------------------------
 *   private         o           
 *  --------------------------------------------------------
 *   default         o           o
 *  --------------------------------------------------------
 *   protected       o           o + 다른 패키지=> 상속을 받은 경우
 *  --------------------------------------------------------
 *   public          o           o            o
 *  --------------------------------------------------------
 *  
 *  멤버변수 => 데이터를 보호 목적 => private
 *   = 인스턴스
 *   = 정적(공유)
 *  메소드 : 다른 클래스와 통신을 담당 (연결) => public
 *  클래스 : 메소드를 이용하거나 멤버변수를 사용 => 다른 클래스에서 사용 => 메모리 할당 => public
 *  생성자 : 메모리 할당시 호출 => public 
 *  -------------------------------------------------------------------------
 */
import java.util.*;
public class MovieManager {
	// 데이터를 고정해서 공유할 때 사용 => static 
	// 크롤링해서 저장 => static => 데이터의 모음 , 보여만 주는 상태  
	public static Movie[] movies=new Movie[1938]; // 자동으로 메모리에 저장 => new 필요 없다 => 생성자 필요없다 
	// static : 변경이 없는 경우 => 고정 (모든 사용자가 같은 내용을 보고 있는 경우 ) => 공유 
	// 데이터가 여러 개일 때 메모리 공간을 한 개만 이용해서 접근 static
	// 인스턴스변수는 각각 따로 저장 (new를 사용시에) => 보안이 많이 필요  => private를 통해 저장 => 은닉화
	// 초기화
	/*
	 *	생성자 : 초기화 => 인스턴스 변수에 대한 초기화 
	 *	초기화 블록 : static 블록을 사용하는 것이 편리하다
	 *  ---------------------------------------
	 *  static 변수는 new를 사용하지 않는다 => 접근이 가능 
	 */
	//static에 대한 초기화 블록 
	static {// 컴파일러에 의해 자동 처리 => 호출하지 않는다 (생성자는 호출이 필요한데, 얘는 호출 x 자동처리)
		try {
			FileReader fr=new FileReader("C:\\javaDev\\movie.txt");
			StringBuffer sb=new StringBuffer();
			int i=0; // read() => char를 읽지 않고 ASC를 읽어온다 => 문자 번호를 읽어온다
			//A => 65=> i는 읽어온 정수를 저장할 변수 => char로 변환
			while((i=fr.read())!=-1) { // -1 EOF(파일의 끝) => End Of File
				sb.append((char)i);
			}
			fr.close();// 파일 닫기
			
			// 읽어온 데이터를 => movies에 저장 
			String[] strMovie=sb.toString().split("\n"); //한 줄씩 배열에 저장 
			i=0;
			for(String movie:strMovie) {
				//System.out.println(movie);
				String[] m=movie.split("\\|");
				movies[i]=new Movie();
				movies[i].setMno(m[0]);
				movies[i].setTitle(m[1]);
				movies[i].setGenre(m[2]);
				movies[i].setPoster(m[3]);
				movies[i].setActor(m[4]);
				movies[i].setRegdate(m[5]);
				movies[i].setGrade(m[6]);
				movies[i].setDirector(m[7]);
				i++;
			}
		}catch(Exception ex) {ex.printStackTrace();}
	}
	public static Movie[] getMovieData(int page) {
		int total=movieTotalPage();
		int leng=20;
		if(page==total)
			leng=18;
		Movie[] movie=new Movie[leng];
		
		int j=0; // 20개씩 나눠주는 변수
		int rowSize=20;
		int pagecnt=(page*rowSize)-rowSize; // 데이터를 저장할 시작점
		for(int i=0;i<movies.length;i++) {
			if(j<20 && i>=pagecnt) {
				movie[j]=new Movie();
				movie[j]=movies[i]; // movie배열 => movies에 저장된 내용을 채워준다 
				j++;
			}
		}
		return movie;
	}
	//1938.20.0
	public static int movieTotalPage() {
		return (int)(Math.ceil(movies.length/20.0));
		// call ==> 올림메소드
	}
	
}
