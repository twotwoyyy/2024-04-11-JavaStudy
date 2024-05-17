package com.sist.main;
/*
 *	1. 인터페이스란?
 *     = 추상클래스의 일종, 특수한 클래스 , 상속시에 상위 클래스 역할 수행 
 *     = 미완성된 클래스 => 상속을 내려 구현해서 사용해야 한다
 *       ---------- 메모리 할당이 불가하다 
 *     = 추상클래스의 단점(단일상속) 보완 => 다중 상속을 받을 수 있다 
 *     = 추상클래스는 구현된,구현이 안된 메소드 둘 다 있었으나 인터페이스는 구현이 안된 메소드만
 *     역할:
 *       1) 서로 다른 클래스를 연결해서 사용
 *       2) 관련된 클래스를 묶어서 한 개의 객체명으로 제어
 *       3) 설계와 관련 => 재사용이 가능 (기능 설계) 
 *       4) 모든 개발자가 동일한 메소드를 재정의 : 표준화 
 *          표준화 : 라이브러리,System.out.println(),Math.random() ... 
 *          ----- 소스의 통일화 => 분석이 쉽다 => 유지보수가 편리 
 *       => 요구사항 분석 : 인터페이스
 *       => 아이템 신청 => 참조할 사이트 (벤치마킹) => 기능 추출 / 데이터 추출
 *                                          |인터페이스  |크롤링 (사용자정의 데이터형)
 *       => 사이트에 사용할 데이터 크롤링 => 오라클에 저장
 *          데이터베이스 설계 => 데이터 수집
 *       => 구현 => JSP / Spring 
 *       => 테스트 => 오류 발생 여부 확인
 *       => 배포 => 발표 
 *       
 *  2. 인터페이스의 구성요소
 *     [접근지정어] interface interface명
 *     ---- default/public => 다른 클래스를 묶어서 관리 
 *    {             -----
 *      ------------------------------------------
 *       변수 : 상수형만 사용 가능 
 *             --초기값을 반드시 줘야 한다 
 *       int a=10;
 *       생략: (public static final) int a=10;
 *      ------------------------------------------
 *       구현이 안된 메소드 => 248p
 *       => void aaa(); 
 *          void bbb();
 *       생략 : (public abstract) void aaa(); 
 *              ------ 접근지정어는 public만 (자동추가) 
 *      ------------------------------------------
 *       JDK1.8부터 등장
 *       구현된 메소드
 *       => default void ccc(){구현이 가능}
 *          ------- 붙여야 한다 생략 x 
 *       생략: (public) default void ccc(){}
 *            ------- 컴파일러에 의해 자동으로 public 추가
 *            
 *      ------------------------------------------ }
 *      *** 인터페이스는 상수 / 메소드는 모두 public 
 *      *** 단점
 *          결합성이 낮은 프로그램 => 클래스 클래스 연결시 수정할때 에러부분
 *          => 인터페이스는 고정 => 수정
 *          -----------------------> default 메소드 제공
 *      
 *  3. 인터페이스의 장점
 *    => 기능 설계 => 메소드 설계 => 개발기간을 단축 가능
 *    => 메소드가 동일하다 (모든 개발자 동일한 메소드 구현) => 표준민
 *    => 인터페이스 한 개로 여러개의 클래스 관리 
 *    => 유지보수가 쉽다 
 *    => 독립적으로 사용이 가능 (클래스-클래스) 연결하는 리모콘 역할 
 *    => 결합성이 낮은 프로그램, 표준화 작업 
 *  
 *  4. 인터페이스 상속 294page
 *    => 인터페이스와 인터페이스 상속
 *       interface A
 *       interface B extends A 
 *                   -------
 *       
 *       interface A
 *       interface B extends A
 *       interface C extends B
 *       --------------------- 단일 상속 
 *       interface A
 *       interface B
 *       intergace C extends A,B
 *       --------------------- 다중 상속 
 *       
 *    => 인터페이스와 클래스 상속
 *       interface A 
 *       class B implements A
 *              ----------- A가 가지고 있는 메소드를 구현해서 사용 
 *    => 다중 상속
 *       interface A
 *       interface B
 *       class C implements A,B
 *               -----------
 *               
 *       interface A
 *       interface B
 *       class C
 *       class D extends C implements A,B
 *               --------  -----------
 *               |클래스 상속 |인터페이스 상속 
 *    => 윈도우
 *    class A extends JFrame implements ActionListener,KeyListener,MouseListener
 *                                      ----------------------------------------
 *                                      이벤트(사용자 행위) => 인터페이스로 제작되어 있다 
 *    => 컬렉션 => interface로 되어있다 
 *    => 클래스 상속 먼저 받아야하고 그 다음에 인터페이스 상속 
 *       -------- extends            --------- implements
 *       
 *    => 클래스 ========> 클래스 
 *            implements (구현)
 *       인터페이스 =====> 클래스
 *            extends 
 *       인터페이스 =====> 인터페이스 
 *       --------------------------
 *       클래스 => 인터페이스 상속 => 쫀재하지 않는다 
 *       
 *  5. 인터페이스 활용 
 *  -------------------------> 객체지향의 마지막
 *  => 예외처리 (형식)
 *  => 라이브러리 (암기) => 메소드 => 기능, 원형 (리턴형/매개변수)
 *     ------------ 컬렉션 (배열 대신) => 웹
 *                  | 개수 지정 x => 고정이 아니다 
 *                  | 제네릭스 (자동형변환)       
 *  => 웹 (데이터베이스 연동) 
 *        ------------ 브라우저 => 데이터형 클래스   
 *  => 틀을 만든다 : Spring (메인보드) 
 *                ------------- 스프링 부트로 통합 
 *  => AWS에 호스팅 => 리눅스 명령어 
 *  
 *  * 웹 프로그램
 *    자바 : 변수 (데이터형), 연산자, 제어문 
 *          = 묶어서 사용하는 방법 
 *            --------------
 *            1) 명령문 묶기 => 메소드 
 *            2) 변수 묶기 => 배열 (1차원), 클래스 
 *          = 객체 지향 프로그램 : 권장사항 
 *            1) 데이터 보호 : 캡슐화 => getter/setter
 *            2) 인터페이스 : 클래스 여러 개를 묶어서 관리 => 결합성이 낮은 프로그램 
 *            3) 오버라이딩 : 인터페이스는 오버라이딩을 주로 사용 
 *          = 프로그램 비정상 종료 방지 : 예외처리 
 *          = 사용자 정의 + 라이브러리 => 조립 
 *          ----------------------------- 사용처를 알아야 한다 (어디서,언제쓰느냐)
 *          = 2차 자바 : 오라클 연동 => JDBC  
 *          = 3차 자바 : 웹 연동 => J2EE (JSP, 타임리프, VusJS)
 *          = 4차 자바 : 스프링,스프링부트 : 어노데이션 / XML
 *          = 서버단 
 *            개인프로젝트 : 스프링 부트 => React-Query
 *                       장고 => Redux 
 *          
 */

interface 도형 {
	String COLOR="black"; //static=> 필기체 
	// public static final String COLOR="black" 
	void draw();
	// public abstract void draw(); // 자동추가
    // 접근지정자는 public만 들어간다 protected, private x
}
class 선 implements 도형{
//	void draw() { // 디폴트로 들어와 축소가 되어 오버라이딩 x
    public void draw() {	
    	System.out.println("선을 그린다..");
	}
}
class 사각 implements 도형{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("사각형을 그린다..");
	}

}
class 삼각 implements 도형{
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("삼각형을 그린다..");
	}
	
}
public class 인터페이스_01 {

	public static void main(String[] args) {
		도형 a=new 선();
		a.draw();
		a=new 사각();
		a.draw();
		a=new 삼각();
		a.draw();
		// 관련된 클래스를 여러개 모아서 => 한개의 객체명으로 제어 
	}

}
