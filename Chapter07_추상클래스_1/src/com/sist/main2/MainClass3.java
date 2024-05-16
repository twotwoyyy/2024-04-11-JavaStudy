package com.sist.main2;
class AA{
	int a=10;
	int b=20;
	public void aaa() {
		System.out.println("A;aaa() Call...");
	}
}
// AA a=new AA() ==> a,b,aaa()
class BB extends AA{
// int a=10, b=20; aaa() => 수정 (오버라이딩)
	int c=30;
	public void aaa() {
		System.out.println("A;aaa() Call...");
	} // aaa() 수정(오버라이딩)
	public void bbb() {
		System.out.println("B;bbb() Call...");
	}
}
// BB b=new BB() => c,aaa(),bbb()
public class MainClass3 {

	public static void main(String[] args) {
		System.out.println("===== AA =====");
		AA aa=new AA(); // AA에 설정된 변수,메소드에만 접근 가능 
		System.out.println(aa.a);
		System.out.println(aa.b);
		aa.aaa();
		
		System.out.println("===== BB =====");
		BB bb=new BB();
		System.out.println(bb.c);
		bb.aaa();
		bb.bbb();
		System.out.println(bb.a);
		System.out.println(bb.b);
		System.out.println("===== AA:new BB() =====");
		AA cc=new BB();
		// 변수는 AA가 가지고 있는 것만 사용 가능
		// 메소드는 BB가 가지고 이는 것을 호출 
		// cc=> a,b (c는 사용이 불가능) => 변경된 aaa()를 호출 (오버라이딩)
		System.out.println(cc.a); // AA
		System.out.println(cc.b); // AA 
		cc.aaa(); // BB가 가지고 있는 메소드 호출 
		/*
		 *	기본
		 *  클래스명 객체명=new 생성자()
		 *  -----          ------- 같은게 기본, 상속을 받았을 땐 다르다 
		 *  
		 *  상속을 내리는 클래스와 상속을 받는 클래스의 변수나 메소드가 동일해야 한다 ( 추가된 변수,메소드가 있는 경우 사용하지 않는다) 
		 *  => 상속받은 클래스가 여러 개인 경우에 주로 사용한다 
		 *     한 개의 객체로 모든 클래스를 제어하기 위해서 
		 *     
		 *  목적 ) 여러 개의 관련된 클래스를 한 개로 묶어서 관리할 목적 (추상 클래스)
		 *        설계용이라 다음에 재사용할 수 있게 하기 위해 
		 *  단점 ) 단일 상속
		 *        => 일반 클래스와 동일 하다
		 *           멤버변수, 생산자, 구현된 메소드
		 *           : 구현이 안된 메소드가 포함
		 *  형식)
		 *   public abstract class ClassNeame{
		 *      -----------------------------------
		 *      	변수
		 *      	static/인스턴스 변수
		 *      -----------------------------------
		 *      	생성자 : default 권장 
		 *      -----------------------------------
		 *      	구현된 메소드 => 사이트에서 같은 기능
		 *      -----------------------------------
		 *      	구현이 안 된 메소드 => 추상 메소드 
		 *      		=> 기능은 같은데 출력내용이 다른 경우 
		 *      -----------------------------------
		 */
	}

}
