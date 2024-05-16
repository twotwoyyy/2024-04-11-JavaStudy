package com.sist.main;
/*
 * 
  class A{}
  class B extends A{
  A a=new B(); o
  B a=new A(); x 부모객체를 자식 클래스 타입의 변수에 대입 불가
  받으려면 형변환 해야한다 A a=new B();
                    B b=(B)a;
  }
 */
class A{
	void aaa() {}
	private void bbb() {} //private는 오버라이딩이 안 된다 
	protected void ccc() {}
	public void ddd() {}
}
class B extends A{
	
	private void bbb() {
		// 오버라이딩이 안된다!! 
	}

	@Override
	void aaa() {
		// TODO Auto-generated method stub
		super.aaa();
	}

	@Override
	protected void ccc() {
		// TODO Auto-generated method stub
		super.ccc();
	}

	@Override
	public void ddd() {
		// TODO Auto-generated method stub
		super.ddd();
	}
	//오버라이딩 (변경해서 사용)
	
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
