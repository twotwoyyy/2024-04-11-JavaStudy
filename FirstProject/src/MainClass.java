/*
	프로그램 ㅣ 컴퓨터에 명령을 수행하게 만든다
	---------------------------------
	데이터 저장 ====> 데이터 가공 ========> 가공된 데이터 출력 
	               (유저의 요청에 의해)          |
	                                      솔루션
	                                      윈도우 (명령프롬프트) => Application
	                                      
	                                      SI/SM
	                                      ---------------------------------------
	                                      브라우저           => Web Application
	                                      핸드폰             => Mobile Application
	                                      ---------------------------------------
	                                      
	  |                   ==> 연산자 / 제어문
	한 개 : 변수                ------------ 반복 (묶어서 사용) => 메소드
	여러 개 : 배열 / 클래스
    ===> 단점 (프로그램 종료시에 자동 삭제)
    ===> RAM
    --------------------------
    | 영구적인 저장 장치
     1) 파일 
     2) RDBMS => 오라클
     	               
 */
import java.io.*;
public class MainClass {

	public static void main(String[] args) throws Exception{
		FileReader fr=new FileReader("c:\\javaDev\\movie.txt");
		int i=0;
		StringBuffer data=new StringBuffer(); // Buffer 임시 기억 장치 ; 모아두었다가 한번에 출력 이를 이용하는 프로그램이 리액트, 속도 빠름 
		while((i=fr.read())!=-1) // 파일 끝일 때 종료 => -1 EOF
			{
			data.append((char)i);
			}
		fr.close();
		System.out.println(data);
	}
}
