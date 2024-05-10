package com.sist.manager;
//사용자의 요청이 있는 경우 처리 
//모든 데이터 관리
/*
 *	1. 데이터 읽기 => 시작과 동시에 => 초기화
 *                              ---- 자동 초기화 / 생성자 
 *  2. 요청에 대한 처리 => 메서드 
 *    => 전체 목록 (페이지 나누기)
 *    => 검색 결과 출력 
 *    => 상세보기
 * --------------------------- 윈도우
 *  3. 패키지 => 관련된 클래스를 모아서 관리 
 *    => 접근지정어 => public
 */
import java.io.*;
import java.util.*;
import java.security.DomainCombiner;

import com.sist.vo.*;
public class MovieManager {
	//Movie에 있는 모든 데이터를 읽어서 저장 => 변수 => 모든 User가 공통된 데이터를 사용한다 
	private static Movie[] movies=new Movie[1938]; // 목록을 저장 => 모든 데이터가 동일
/*
 *	변수 => 기본형 / 배열 / 클래스 
 *	Movie : 사용자 정의 데이터형 => 배열, 형변환도 가능하다 
 *	
 *	초기화 
 *  static
 *  {
 *  }
 *  생성자
 */
 // 초기화 => 생성자 이용 => userMain에서 사용
 // public 써야한다 
	public MovieManager() {
	 // 파일에서 데이터를 읽어서 저장 => 예외처리 => 컬렉션

		try {
			// 정상적으로 수행할 경우 => 명령문 
			// => 예외처리는 모든 문장에 있다 => 생략 가능 => 파일 입출력/ 네트워크 / 데이터베이스 연동시엔 필수적으로 예외처리 
			FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
			int i=0; // fr.read() => 리턴형 => int (문자의 번호를 읽어 온다)
			StringBuffer sb=new StringBuffer();// 읽어서 데이터를 누적 (속도 개선) 
			while((i=fr.read())!=-1) { // -1 파일의 끝 EOF
				sb.append((char)i);
			}
			// 읽게되면 반드시 파일을 닫아야 한다
			fr.close();

			String data=sb.toString(); // 전체 데이터를 모은다 
			String[] temp=data.split("\n"); // 한 줄씩 저장
			i=0;
			for(String s:temp) {
				String[] movie=s.split("\\|");
				// split, replaceAll=> ?, ., +, *, | 기호 자체를 가져올 때 \\를 사용해야한다 
				// \\를 사용하지 않으면 연산자로 처리되기 때문이다 
				// \" \' \\ => ",',\출력할 때 역슬래시 사용
				movies[i]=new Movie();
				movies[i].setRank(movie[0]);
				movies[i].setTitle(movie[1]);
				movies[i].setGenre(movie[2]);
				movies[i].setPoster(movie[3]);
				movies[i].setActor(movie[4]);
				movies[i].setRegdate(movie[5]);
				movies[i].setGrade(movie[6]);
				movies[i].setDirector(movie[7]);
				i++;
			}
			
		}catch(Exception ex) {}
	}
//	public static void main(String[] args) {
//		MovieManager m=new MovieManager();
//		for(Movie movie:m.movies) {
//			System.out.println(movie.getRank()+"."+movie.getTitle());
//		}
//	}
	// 목록 출력
	public Movie[] movieListData(int page) {
		int total=movieTotalPage();
		int leng=20;
		if(page==total)
			leng=18;
		// 배열의 단점 => 고정이 되어있음 => 보완 (컬렉션)
		Movie[] movie=new Movie[leng];
		
		int j=0; // 20개씩 나눠주는 변수
		int pagecnt=(20*page)-20;
		/*
		 * 1page => 0~19 (20)
		 * 2page => 20~39 
		 * 3page => 40~59
		 * .
		 * .
		 */
		for(int i=0; i<movies.length;i++) {
			if(j<20 && i>=pagecnt) {
				movie[j]=new Movie();
				movie[j]=movies[i];
				j++;
			}
		}
		return movie;
	}
	public int movieTotalPage() {
		return (int)(Math.ceil(movies.length/20.0)); // ceil 올림함수 
	}
	//상세보기
	public Movie movieDetailDate(int mno) {
		return movies[mno-1];
	}
	//검색
	public Movie[] movieFindData(String title) {
		int count=0;
		for(Movie m:movies) {
			if(m.getTitle().contains(title)) {
				count++;
			}
		}
		// 선언 => 배열 개수 확인 => 데이터 값 채우기 => 동일하면 선언 => 동일하지 않는 경우 
		Movie[] movie=new Movie[count]; //동적 => 가변형 
		int i=0;
		for(Movie m:movies) {
			if(m.getTitle().contains(title)) {
				movie[i]=m;
				i++;
			}
		}
		
		return movie;
	}
	// 웹 => 목록 츌력 (페이징) 
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		MovieManager m=new MovieManager();
		/*int total=m.movieTotalPage();
		System.out.print("1~"+total+"사이의 페이지 입력:");
		int page=scan.nextInt();
		
		//데이터 읽기
		Movie[] movie=m.movieListData(page);
		for(Movie mm:movie) {
			System.out.println(mm.getRank()+"."+mm.getTitle());
		}*/
		System.out.print("검색어 입력:");
		String title=scan.next();
		
		Movie[] movie=m.movieFindData(title);
		for(Movie mm:movie) {
			System.out.println(mm.getRank()+"."+mm.getTitle()+"/"+mm.getDirector());
		}
		System.out.println("===========================================");
		System.out.print("상세보기 할 영화 번호:");
		int mno=scan.nextInt();
		
		Movie mmm=m.movieDetailDate(mno);
		// 메서드 (요청에 처리 => 기능)
		// 처리 기능 / 데이터만 있는 클래스
		// 파일 / 오라클 => 데이터만 있는 클래스에 값을 채워서 전송 
		System.out.println("순위."+mmm.getRank());
		System.out.println("영화명:"+mmm.getTitle());
		System.out.println("감독:"+mmm.getDirector());
		System.out.println("출연:"+mmm.getActor());
		System.out.println("장르:"+mmm.getGenre());
		System.out.println("등급:"+mmm.getGrade());
		System.out.println("개봉일:"+mmm.getRegdate());
		
		// => 목록 출력 / 상세보기 / 검색 
	}
	/*
	 *	주력
	 *  --- 
	 *    데이터 모으기 : movie => 멤버변수
	 *    ---------
	 *    기능 설정 => 목록/ 상세/ 검색/ 예약/ 댓글 .... => 메소드 => 액션클래스
	 *              데이터 읽기 => 초기화 (전체 목록) => 생성자
	 *    ---------
	 *    다른 클래스에 활용 : 접근지정어
	 *    -------------- private/protected/default => 사용할 수 없다 (접근이 안 된다)
	 *    public
	 *                 
	 */
}
