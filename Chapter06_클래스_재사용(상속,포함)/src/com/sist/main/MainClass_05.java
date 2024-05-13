package com.sist.main;
/*
 *	상속 
 *	=> 사용자 정의 클래스는 상속으로 사용을 잘 하지 않는다
 *	=> 라이브러리 클래스 
 *	   ------------
 *	=> 단일 상속 
 *     : 상위 클래스는 가급적이면 공통 기반을 모아서 처리
 *  => 메모리에 저장
 *  	상위 클래스 = 하위 클래스 
 *  	------------------
 *      상위 클래스 = 상위 클래스
 *      하위 클래스 = 하위 클래스
 *      ------------------
 *      하위 클래스 = (하위 클래스)상위 클래스 // 반드시 형변환
 *      
 *      클래스 크키는 상속이 있어야 가능하다 // 부모 클래스가 크키가 더 크다 // 원래 클래스 크기는 4byte
 *      -------- 상속 내리는 클래스 > 상속 받는 클래스
 *      
 *      = 선언되는 클래스 : 변수  
 *      = 생성자 : 메서드 지정 
 *      
 *    class Super{
 *    	int a=10;
 *    	int b=20;
 *    	public void display(){
 *    		System.out.println("Super:display() Call...")
 *    	}
 *    }
 *    class Sub{
 *    	int a=100;
 *    	int b=200;
 *    	public void extends Super display(){
 *    		System.out.println("Sub:display() Call...")
 *    	}
 *    }
 *    
 *    Super sup=new Super(); sup=> a=10, b=20, SuperLdisplay() Call...
 *    Sub sb=new Sub(); sb=> a=100,b=200, Sub:display() Call...
 *    
 *    Super sup2=new Sub()
 *    -----      ---------
 *    a=10, b=20   Sub:display() Call... => 오버라이딩
 *                 => 생성자에 따라 메서드를 덮어쓴다 
 */
class A{
	int a=10;
	int c=20;
	public void display() {
		System.out.println("A:display Call...");
	}
}
class B extends A implements Cloneable{
	int a=100;
	int c=200;
	public void display() {
		System.out.println("B:display Call...");
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
// A aa=new B() 지금으로서는 오류, 대입할 수 없음 (상속 안 한 경우) 관계 x

public class MainClass_05 {

	public static void main(String[] args) {
		A aa=new A();
		System.out.println(aa.a);
		System.out.println(aa.c);
		aa.display();
		System.out.println("==================");
		//확장된 클래스 많이 사용 
		B bb=new B();
		System.out.println(bb.a);
		System.out.println(bb.c);
		bb.display();
		try {
			B kk=(B)bb.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("==================");
		A cc=new B(); 
		System.out.println(cc.a); //10
		System.out.println(cc.c); //20
        // 상위 = 하위  => 변수 (상위)
		// 상위 클래스에 하위 클래스가 대입되면 변수는 상위를 따라간다 
		cc.display(); // new B가 가지고 있는 메서드를 가지고 온다 (덮어씀) => 오버라이딩 변수는 안바뀌고 메서드는 바뀐다 
		
		System.out.println("==================");
		B dd=(B)cc; // B가 있는 변수를 가지고 온다 
		System.out.println(dd.a);
		System.out.println(dd.c);
		dd.display();
	}

}
