package com.sist.main;
// 메서드 오버라이딩 => 204page => 가장 많이 사용
class Music {
	int count=10;
	public void list() {
		System.out.println("목록 출력");
	}
	public void detail() {
		System.out.println("상세 보기");
	}
	public void find() {
		System.out.println("뮤직 검색");
	}
}
class Genie extends Music{ // 오버라이딩 => 오른쪽 마우스 => 소스 => 오버라이딩

	@Override
	public void list() {
		System.out.print("Genie 뮤직에서 ");
		super.list();
	}

	@Override
	public void detail() {
		System.out.print("Genie 뮤직에서 ");
		super.detail();
	}

	@Override
	public void find() {
		System.out.print("Genie 뮤직에서 ");
		super.find();
	}
	// 목록 출력
	// 상세보기
	// 검색 
}
class Melon extends Music{

	@Override
	public void list() {
		System.out.print("Melon 뮤직에서 ");
		super.list();
	}

	@Override
	public void detail() {
		System.out.print("Melon 뮤직에서 ");
		super.detail();
	}

	@Override
	public void find() {
		System.out.print("Melon 뮤직에서 ");
		super.find();
	}
	// 목록 출력
	// 상세보기
	// 검색 
}
class Mnet extends Music{

	@Override
	public void list() {
		System.out.print("Mnet에서 ");
		super.list();
	}

	@Override
	public void detail() {
		System.out.print("Mnet에서 ");
		super.detail();
	}

	@Override
	public void find() {
		System.out.print("Mnet에서 ");
		super.find();
	}
	// 목록 출력
	// 상세보기
	// 검색 
}
public class MainClass_08 {
	// 유사한 클래스를 여러 개 모아서 1개 객체로 제어 => 상속 
	/*
	 *	*상속을 받는 경우
	 *	 
	 *	변수 : 선언하는 클래스명 
	 *	메서드 : 생성자 
	 *	생성자 => 상속의 제외 조건 
	 *
	 *	class A
	 *	class B extends A
	 *
	 *	A a=new B() 변수 : A  메서드 B => 클래스가 여러 개일 때 많이 씀 
	 *  A a=new A() 변수 : A  메서드 A
	 *  B b=new B() 변수 : B  메서드 B *****
	 *  ---------------
	 *  *B b=new A() => 라이브러리(값을 받는 경우)
	 *  => 오류가 난다 
	 */
	public static void main(String[] args) {
		System.out.println("===== 지니뮤직 ====");
		Music m=new Genie();
		// Genie g=new Genie()
		// 메서드 호출 => 생성자 
		m.detail();
		m.list();
		m.find();
		System.out.println("===== 멜론 =====");
		m=new Melon();
		m.detail();
		m.list();
		m.find();
		System.out.println("===== Mnet =====");
		m=new Mnet();
		m.detail();
		m.list();
		m.find();
	}
}
