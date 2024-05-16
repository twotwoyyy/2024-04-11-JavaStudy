package com.sist.main3;
abstract class A{ 
	public abstract void aaa();
	public abstract void bbb(); // 모든 클래스가 구현
	// B, D 클래스만 구현 ==> C / E 
	public void ccc() {
		
	}// 필요한 클래스에서 오버라이딩 해서 쓰면 된다 
	public void ddd() {} // !!! 프로젝트 구현이 끝난 다음에 추가하는 기능이 있는 경우 => 구현된 메소드를 만들어서 처리해야 한다!!! 
	// 필요한 클래스에서만 오버라이딩을 할 수 있다 
	/*
	 * 	추상 클래스를 보완 
	 *  ------------- 인터페이스
	 *  1. 다중 상속이 가능 
	 *  2. 모든 메소드가 추상 메소드 
	 *  3. 모든 변수는 상수
	 *  ---------------- 1.8 변경 => 구현이 된 메소드 존재.... 
	 */
}
class B extends A{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
class C extends A{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
class D extends A{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
class E extends A{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
public class MainClass {
	public static void main(String[] args) {
	
	}
}
