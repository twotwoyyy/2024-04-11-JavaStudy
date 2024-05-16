package com.sist.main2;
class A{
	int c;
	public int add(int a,int b) {
		int c=a+b; //지역변수 => 메소드 호출과 동시에 사라진다 
		return c; 
	}
	public void plus(int a,int b) {
//         ---- 멤버변수 사용하기에 
		c=a+b;
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a=new A();
		int c=a.add(10, 20); // 다시 받아서 처리 => 리턴형 
		System.out.println(c);
		a.plus(10, 20);
		System.out.println(a.c); // 프로그램 종료시까지 사라지지 않는다 
	}
}
