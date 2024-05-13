package com.sist.main;
/*	5장 중심 공부 (객체 지향) 
 * 	=> 변수 설정
 * 	=> 저장할 내용이 여러 개 => new 인스턴스 변수 
 * 	   한 개 저장 => static 
 * 	=> 메서드 형식 => 처리 과정 
 *     -------- 연산자/제어문 
 *  => 초기화 : 생성자, static {}
 *	194page
 *	6장 상속 => 재사용
 *	=> 변경 (오버라이딩) 
 *	=> 상속 => 호출되는 과정 
 *	=> 메모리 할당 (상위,하위) 
 *	=> 형변환 
 *	--------------------------
 *	7장 추상 클래스 / 인터페이스 
 *	9장 예외처리 => 상속 기반 (다중 상속)
 *	-------------------------- 자바 기본 문법
 *	9장~ 마지막 : 라이브러리, 조립식 프로그램 (암기)
 *	------------ 컬렉션 
 *
 *	** 오라클 연동 / JSP / Spring / Spring-Boot
 *	   MyBatis / JPA
 *	----------------------------------------- 자바 기반 
 *	 Java / JavaScript / Spring 
 *	---------------------------
 *	
 *	상속 
 *	 => 멤버변수, 메서드
 *              | 변경 가능 (오버라이딩) 
 *   => 상속 => 확장된 클래스 
 *     		   ---- extends 
 * 	 => 형식 
 * 		 class A extends B => 단일 상속, 재사용
 * 	 => 단일 상속
 * 		 동물
 * 		  |
 * 		 인간     => 이다 (is-a) => 추상화 (공통점을 모아준다)
 * 		  |
 * 	   -------
 * 	   |     |  => 구체화
 *    남자    여자 
 *    
 *    공통점이 많이 존재 => 상속을 내리는 클래스는 클래스마다의 공통점을 가지고 있다 
 *                    ---------------------------------------- 확장
 *                    
 *   201page => 확장
 *   			-- 변경해서 사용 => 오버라이딩 (변수 오버라이딩, 메서드 오버라이딩)
 *              -- 추가 
 *              
 *                  추가               변경(수정)
 *                  --               ---------
 *                오버 로딩           오버라이딩(덮어쓰기)
 *  ---------------------------------------------
 *   상태       같은 클래스 내에서만     상속이 된 상태에서만 => 요즘은 익명의 클래스가 등장했기에 상속없이 오버라이딩이 가능하다 
 *  ---------------------------------------------
 *   메서드명         동일                  동일
 *  --------------------------------------------- 
 *   매개변수       개수/데이터형           개수/데이터형
 *                 다르다                 동일
 *  --------------------------------------------- 
 *   리턴형         관계 없다                동일
 *  --------------------------------------------- 
 *   접근지정어      관계 없다              축소x/확대o
 *  --------------------------------------------- 
 *   접근지정어         <------------ 축소
 *   	=> private < default < protected < public 
 *	                 ------------> 확대 
 *  ----------------------------------------------
 *  class A{
 *   void display(){
 *   }
 *   
 *   => void display (){}
 *   => protected void display(){}
 *   => public void display(){} // 확대해서 쓸 수 있다 // 오버라이딩
 *   
 */
// 202page 변수 오버라이딩
import java.util.*;
// 변수 오버라이딩
// Parant => 메모리 할당 => Child가 메모리 할당 
class Parent {
	String name;
	int age;
	public Parent() {
		name="홍길동";
		age=25;
		System.out.println("Parent 클래스 메모리 할당!!");
	}
}
class Child extends Parent{
	String name;
	int age; // 변수를 따로 설정해야 오버라이딩이 된다 
	public Child() {
		this.name="박문수"; // 자신이 가지고 있는 변수 this => this는 지역변수와 구분할 때도 쓰인다 
		this.age=30;
		super.name="심청이"; // 부모 인스턴스 변수 super (상위 클래스) 
		super.age=15; // super는 상속 받은 데이터 부모 클래스로부터 상속받은 필드나 메소드를 자식 클래스에서 참조하는데 사용하는 참조 변수

		System.out.println("Child 클래스 메모리 할당!!");
	}
}
/*
 *	Child c=new Child(); // 확장된 클래스 => 기본으로 많이 쓰인다 
 *	Parent p=new Child() => 많이 쓰지 않음 , 클래스 여러 개를 한개 이름으로 제어할 때 
 *
 *	=> 
 */
class KKK{
	public void display() {
		System.out.println("KKK:display Call...");
	}
}
class AAA extends KKK{
	public void display() {
		System.out.println("AAA:display Call...");
	}
}
class BBB extends KKK{
	public void display() {
		System.out.println("BBB:display Call...");
	}
}
class CCC extends KKK{
	public void display() {
		System.out.println("CCC:display Call...");
	}
}
class DDD extends KKK{
	public void display() {
		System.out.println("DDD:display Call...");
	}
}
class EEE extends KKK{
	public void display() {
		System.out.println("EEE:display Call...");
	}
}
/*
 *	프로그램은 여러 개를 가지고 제어하면 어렵다 
 *  int a,b,c,d,e,f;
 *  => int [] arr=new int[6]; < 이게 더 소스를 줄일 수 있다
 *  
 *  class AAA BBB CCC DDD ...
 *  => extends 상위 클래스로 제어 
 */
public class MainClass_07 {

	public static void main(String[] args) {
		Child c=new Child();
		System.out.println("이름:"+c.name);
		System.out.println("나이:"+c.age);
		// 항상 상위 클래스가 먼저 메모리 할당 
		
		Scanner scan=new Scanner(System.in);
		System.out.print("AAA(1),BBB(2),CCC(3),DDD(4),EEE(5):");
		int no=scan.nextInt();
		
		KKK k=null; // 상속받은 모든 클래스를 상위 클래스를 이용하여 한번에 제어
		// 데이터가 여러 개 => [] => 배열명
		// 클래스가 여러 개 => 상속 받아 상위클래스 이용 
		switch(no) {
		case 1:
			k=new AAA();
			break;
		case 2:
			k=new BBB();
			break;
		case 3:
			k=new CCC();
			break;
		case 4:
			k=new DDD();
			break;
		case 5:
			k=new EEE();
			break;
		}
		k.display();
		
//		if(no==1) {
//			AAA a=new AAA();
//			a.display();
//		}
//		else if(no==2) {
//			BBB b=new BBB();
//			b.display();
//		}
//		else if(no==3) {
//			CCC c=new CCC();
//			c.display();
//		}
//		else if(no==4) {
//			DDD d=new DDD();
//			d.display();
//		}
//		else if(no==5) {
//			EEE e=new EEE();
//			e.display();
//		}
//	}
	}
}


