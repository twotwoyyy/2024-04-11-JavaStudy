package com.sist.main3;
interface A{
	public void aaa();
}
interface B{
	public void bbb();
}
// 다중 상속 => ,로 구분
/*
 *	자신의 클래스 = 자신의 생성자() 
 *  -----------------------
 *  상위 클래스 = 하위 클래스 생성자()
 *  
 *  class A
 *  class B extends A
 *  
 *  A a=new A()
 *  B b=new B()
 *  A c=new B()
 *  -----------
 *  
 *  interface A
 *  class B implements A
 *  
 *  A a=new A() => 불가능!! 인터페이스나 추상클래스는 메모리 할당 불가 (미완성)
 *  B b=new B()
 *  A c=new B() => 구현된 클래스를 이용해서 메모리 저장 
 *  -----------
 *   => 구현한 클래스, 오버라이딩 
 */
class C implements A,B{

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		System.out.println("C:bbb() Call...");
	}

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		System.out.println("C:aaa() Call...");
	}
	
}
/*
 *	상속을 받은 경우
 *	-----------
 *	1. 변수 ===========> 클래스 선언
 *	2. 메소드 ==========> 생성자 => 메소드를 덮어쓴다 
 *
 *  class A 
 *  {
 *    int a,b;
 *    public void aaa(){}
 *  }
 *  A aa=new A();
 *  -------------
 *  |변수  |메소드    => aa.a  aa.b  aa.aaa()
 *  
 *  class B
 *  {
 *    int c;
 *    public void bbb(){}
 *  }
 *  B bb=new B();
 *  => bb.c => bb.bbb()
 *  
 *  class C extends A
 *  {
 *   //int a,b;
 *   //public void aaa(){}
 *    int d;
 *    public void ddd(){}
 *  }
 *  C c=new C(); => c가 가지고 있는 전체 호출 
 *  A a=new C(); => 
 *  --  --------- aaa()는 C가 가지고 있는 aaa를 사용하겠다 (ddd 사용불가)
 *  A안에 있는 a,b
 *  
 *  
 *  interface A
 *  {
 *    void aaa();
 *  }
 *  interface B
 *  {
 *    void bbb();
 *  }
 *  class C implements A,B
 *          ---------- 상속 
 *  {
 *    aaa()
 *    bbb()
 *  }
 *  
 *  A a=new C() => a.aaa() 
 *  // A가 가지고있는 걸 호출하되, 덮어쓴 걸 가져오겠다 
 *  B b=new C() => b.bbb()
 *  C c=new C() => a.aaa(), b.bbb() 동시접근가능
 *  
 *  A a; => a가 가지고 있는 것만 제어가능 
 *  B b; => b가 가지고 있는 것만 제어가능
 *  
 */
interface AA{
	void aaa();
}
interface BB extends AA{
	void bbb();
}
class CC implements BB{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}


}
public class 인터페이스_01 {

	public static void main(String[] args) {
		A a=new C(); // => aaa() 호출 가능
		B b=new C(); // => bbb() 호출 가능
		b.bbb();
		// => 다중 상속시에는 상속받은 클래스 이용 => 모든 메소드를 가지고 있기 때문에
		C c=new C(); // => aaa(),bbb() 호출 가능 
		c.aaa();c.bbb();
		
		BB bb=new CC();
		b.bbb();
		bb.aaa();
		bb.bbb();
	}
}
