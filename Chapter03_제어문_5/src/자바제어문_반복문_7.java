/*
 * 알파벳을 입력을 받아서
 * 		=> 대문자 : 소문자
 * 		=> 소문자 : 대문자 출력
 * 	=> 결과값 출력 위치
 *    => for에서 출력 => for안에 변수 설정 
 *    => for종료 후에 출력 => for위에 설정
 *  => 변수 유지하는 범위 => {} => 블록변수, 지역변수
 *  						  --------------- 반드시 사용전에 초기화
 *  => 멤버변수, 공유변수, 지역변수
 *     --------------초기화가 되어있다
 *    * 지역변수는 반드시 초기화해야한다 
 *    
 *    class A 
 *    {
 *    	inta; => 0
 *    	static int b; => 0
 *    -----------------------5장에서 나온다
 *      pubilc static void main(String[] arg)
 *      {
 *      	int c=10;
 *      }
 *     }
 *     1~4장 => 자바의 기본 문법
 *     5~7장 => 객체지향 프로그램
 *     8장 => 예외처리 => 프로그램을 종료하지 않게 만든다
 *     ----------------------------------------자바 기초
 *     9장 ~ 라이브러리 (조립식) => 암기 
 *     모든 프로그램 
 *     ----------
 *     | 마지막 단위 (오라클 연동) => JDBC (웹 : 85%)
 *     | C/C++ => 네트워크 
 */

import java.util.Scanner;

public class 자바제어문_반복문_7 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<5;i++)
		{
		System.out.println("알파벳을 입력:");
		char c=scan.next().charAt(0);
		System.out.println("입력된 알파벳:"+c);
		
		if(c>='A' && c<='Z')
		{
			System.out.println("소문자로 변경:"+(char)(c+32)); // A=65; a=97
		}
		else if(c>='a' && c<='z')
		{
			System.out.println("대문자로 변경:"+(char)(c-32));
		}
		else
		{
			System.out.println("알파벳이 아닙니다!!");
		}
		}
	}

}
