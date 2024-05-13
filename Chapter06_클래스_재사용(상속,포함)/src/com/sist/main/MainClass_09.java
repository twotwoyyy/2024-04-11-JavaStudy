package com.sist.main;
class Movie{
	void display() {}
}
class MegaBox extends Movie{
//  void display() {} // 상속을 받았기 때문에 여기에 있다 
	int display(int a) {
		return 10; // 오버로딩 위는 매개변수가 없는 void // 같은 메서드지만 여기는 int a이기에 오버로딩
		// 상속 받은 것이 아니라 다른 메서드를 선언한 것이다 (오버로딩) 
	}
//	void display() { // (오버라이딩), 매개변수/리턴형/메서드명 같기때문에 //녹색 화살표 
//	}
//	protected void display() {} // (오버라이딩)
	public void display() {} //(오버라이딩)
	/*  (오버라이딩 조건) 
	 *	1. 상속 => 재정의 (메서드 내용을 변경해서 사용)
	 *	2. 메서드명이 동일
	 *	3. 매개변수가 동일 (매개변수가 다른 경우 => 메서드가 다른 것을 정의 => 오버로딩) 
	 *	4. 리턴형이 동일
	 *  5. 접근지정어가 동일, 혹은 확대 
	 *  private < default < protected < public 
	 *  
	 *  => 오버라이딩은 라이브러리에서 많이 쓰인다 
	 *  => 상속이 여러 개 있는 경우는 가장 큰 클래스의 상속을 받는다 
	 *  
	 */
}
public class MainClass_09 {
	public static void maint(String[] args) {
		
	}
}
