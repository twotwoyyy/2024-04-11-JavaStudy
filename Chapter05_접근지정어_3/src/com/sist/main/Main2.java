package com.sist.main;
class A{
	// 생성자 => 클래스가 메모리에 저장 
	public A(){
		System.out.println("메모리에 저장");
	}
	// 메모리 해제 => 소멸자 함수 

	@Override
	protected void finalize() throws Throwable {
		System.out.println("메모리 해제");
	}
	
}
public class Main2 {
	public static void main(String[] args) {
		A a=new A(); //충전
		a=null; // 방전 => 객체가 null이 되면 사용할 수 없다 
		System.gc(); // 빠르게 해제 
	}
}
