package com.sist.main;
/*
 *	= 클래스의 종류 
 *	1) 추상클래스
 *	 형식) 
 *		[접근지정어] abstract class ClassName{
 *		-------------------------------------------
 *		 멤버 변수
 *		-------------------------------------------
 *		 생성자 => 생략 => 자동으로 디폴트 생성자가 추가
 *		-------------------------------------------
 *	 	 메소드 => 구현이 된 메소드
 *		 [접근지정어] 리턴형 메소드(매개변수...)
 *		 { 
 *			return 값; => void인 경우에는 생략 ...
 *		 }
 *		-------------------------------------------
 *		 추상메소드 => 구현이 안 된 메소드
 *		 [접근지정어] abstract 리턴형 메소드명(매개변수...);
 *		 => 데이터베이스(오라클/MySql연동) => 같은 메소드를 구현 
 *		-------------------------------------------
 *		*** 웹 => 데이터베이스 연동 ****
 *				 JE2EE => 웹 연결 (브라우저) ***
 *				 ----------------------- 기본 문법이 지금 배우는 과정 
 *		-------------------------------------------
 *		}
 *		=> 유지보수가 어려운 경우 => 기능 설정 => 필요시마다 구현
 *		=> 경우의 수가 많은 경우 
 *         ------ 기능은 같은데 구현이 따로 되어야 할 때 
 *
 
 *      public abstract class ClassName
 *             ------- 추상적인(공통적인)
 *      {
 *      	
 *      }
 *      공통으로 사용되는 메소드를 선언만 한 상태
 *   단점) 자신의 클래스를 메모리 할당 할 수 없다 (미완성 클래스) => new 사용 불가 
 *        상속을 받아서 오버라이딩을 하고 사용해야 한다
 *   = 요구사항 (기능 설정) => 선언만 가능 
 *   = 기능은 같지만 구현하는 내용이 다를 때 많이 사용한다
 *      예) 버튼을 클릭 => 클릭한다는 기능을 같지만 버튼마다 기능이 달라질 경우 
 *         데이터 베이스 연결 Oracle/MsSQL/MySql/Sqlite/MariaDB...
 *         => 연결시에 따로 클래스를 만들지 않고 한 개로 통합 (연동성)
 *   = 프로그램에 맞게 구현해서 사용한다 
 *   = 같은 기능끼리의 클래스를 모아서 한 개의 클래스 이름으로 관리할 때 주로 사용한다 
 *     -------------------------------------
 *     데이터 => 배열
 *     클래스 => 추상 클래스, 인터페이스 
 *     => 서로 다른 클래스를 연결할 때 주로 사용 
 *     => 클래스마다의 공통 기능을 추출 => 선언 => 필요시마다 상속받아 구현 
 *        --------------------
 *   = 이미 기능이 선언 => 요구사항 (기능), 문제 
 *   = 단점은 무조건 상속을 받아야 한다 / 단일 상속
 *                              -------- 다중 상속으로 보완 => 인터페이스 
 *   = 추상 클래스는 반드시 상속을 내려서 선언된 메소드를 구현해서 사용이 가능하게 해야한다 + 인터페이스도 
 *   = 멤버변수, 생성자도 가지고 있다
 *   = 1. 구현이 된 메소드 => 일반 메소드
 *     2. 구현이 안 된 메소드가 0개 이상이 있다 => 추상 메소드
 *     
 *     예) 
 *        일반 게시판
 *        --------
 *         목록 출력( 게시물 출력), 상세 보기, 글쓰기, 수정, 삭제, 검색 
 *        답변형 게시판
 *        ---------
 *         목록 출력(답변을 추가), 상세 보기, 글쓰기, 수정, 삭제(답변을 먼저 삭제), 검색, 답변하기
 *        갤러리 게시판
 *        ---------
 *         목록 출력(이미지 출력), 상세 보기, 글쓰기(이미지 업로드), 수정, 삭제, 검색 
 *        자료실 
 *        ----
 *         목록 출력, 상세 보기(다운로드), 글쓰기(업로드), 수정(파일수정), 삭제(파일삭제), 검색, 파일 업로드, 파일 다운로드 
 *        댓글형 게시판
 *        ---------
 *         목록 출력(댓글 개수 추가), 상세 보기(댓글 추가), 글쓰기, 수정, 삭제, 검색, 댓글 기능 
 *    
 *	2) 인터페이스
 *	3) 내부클래스 
 *    => Thread => 네트워크와 관련 (마지막)
 *    => 클래스 안에 클래스 설정 => 멤버 변수, 멤버 메소드를 쉽게 사용 
 *       class A {
 *        변수, 메소드
 *        class B{
 *         A가 가지고 있는 변수, 메소드 사용이 가능 => A 객체를 생산 할 필요가 없다
 *         }
 *       }
 *       
 *       class A{
 *         => 익명의 클래스 : 상속없이 오버라이딩이 가능 => 윈도우 프로그램 
 *         B b=new B(){
 *          public void display(){
 *             } 
 *          }
 *       }
 *       class B{
 *         public void display()
 *       }
 *       *** 상속이 없이 오버라이딩이 가능 => 익명의 클래스 오버라이딩 
 *           스프링에서는 상속을 권장하지 않는다 
 *           => (제약이 존재하며 메모리가 커지며 처리속도가 늦기 때문 + 소스 몰라서 가독성 떨어짐 : 단점)
 *	4) 종단클래스 => 사용빈도는 거의 없다 => 라이브러리에 존재 => 확장할 수 없다 (고정)
 *	              java.lang => String, System, Math, Wrapper ... (상속 받을 수 없음) 
 *                형식) public final class String 
 *                            ---- 상속을 할 수 없다 (오버라이딩 불가) 
 *                            
 *  
 */

import java.util.*;
abstract class 도형 {
	// 그리다 => 선,원,사각형,삼각형...
	public abstract void draw(); // => 메소드가 구현이 안되면 미완성된 클래스 => 메모리에 저장 불가
	// 상속을 받아서 구현 후 사용해야 한다 
	// 여러 개의 관련된 클래스를 모아서 관리 
}
class 선 extends 도형{

	@Override // 오버라이딩 써서 구현해야 한다 (재정의)
	// 1. 메소드명이 동일해야 한다 2. 매개변수가 동일해야 한다 3. 리턴형이 동일해야 한다 4. 접근지정어는 동일 or 확장만 가능

	public void draw() {
		System.out.println("선을 그린다...");
		
	}  
	// 추상 클래스는 반드시 상속을 내려서 선언된 메소드를 구현해서 사용이 가능하게 해야한다 + 인터페이스도 
}
class 사각형 extends 도형{

	@Override
	public void draw() {
		System.out.println("사각형을 그린다....");
	}
}
public class 추상클래스_01 {

	public static void main(String[] args) {
/*		선 a=new 선();
		a.draw();
		사각형 b=new 사각형();
		b.draw();
		*/
//		Calendar cal=Calendar.getInstance(); // new가 들어가지 않는다 => 추상 클래스 
		// new가 붙지 않으면 추상 클래스 혹은 인터페이스다 
		도형 a=new 선();
		a.draw();
		a=new 사각형();
		a.draw();
//      같은 종류의 클래스를 모아서 한 개의 객체명으로 연결, 사용 가능하게 만든다 
//      기능 설정 => 프로그램에 맞게 구현해서 사용 
 
	}

}
