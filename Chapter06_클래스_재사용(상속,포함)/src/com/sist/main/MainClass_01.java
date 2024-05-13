package com.sist.main;
/*
 *	1. 객체 지향 프로그램 => 하나의 규칙 (권장사항)
 *    1) 기존의 프로그램을 쉽게 제작,활용하려는 목적
 *       ---------------------
 *       = 코드의 재사용이 높다 (개발이 빠르다) => 상속,포함 
 *                                         ---  ---
 *                                              | 기존의 기능을 있는 그대로 사용 => has-a
 *                                         | 기존의 기능을 변경 (오버라이딩) => is-a
 *       = 코드관리가 용이하다 => 구조화 프로그램 (프로그램을 관련된 사항만 나눠서 작업) => 메서드 
 *       = 이미 사용중인 프로그램을 변경 
 *         -------- 신뢰성이 높다 
 *       = 보안 => 데이터를 보호 => 캡슐화 
 *    ---------------------------------
 *     객체지향의 3대 특성 : 캡슐화 => 변수 관련 => private 변수/ 메서드를 이용해서 접근하는 방식 
 *                      상속  => 재사용 기법 
 *                      다형성 => 오버로딩/오버라이딩 => 유지보수 (기능변경=> 메소드와 관련) 
 *     ** 상속을 사용하면 결합성이 높고, 제약 조건이 많이 존재, 메모리가 커짐, 속도 느림 (단점) => 가급적 사용하지 않는다
 *       => 단일 상속 
 *       => 상속 기호 : extends => 기존의 클래스를 확장해서 사용 ... 
 *          class A
 *          class B extends A 
 *               ---      ----
 *                |         |
 *              상속받는    상속을 내리는
 *                       = private
 *                       = static 
 *                       = 생성자
 *                       = 초기화 블록 
 *                       ------------ (상속 예외 조건) 이를 제외하고 나머지는 상속이 가능하다 
 *        * 상속을 내린 클래스 (상위,부모,베이스 클래스)는 상속받은 클래스의 변수,메서드에 접근할 수 없다 
 *        * 상속을 받은 클래스는 상속 내린 클래스에 접근이 가능하다 
 *          -------------  ------------
            | 자신의 객체(this) | 자신의 객체만 가지고 있다 => this
             +상위 클래스의 객체(supper)
          * 모든 클래스는 자신의 객체를 가지고 있다 => this 
            ---------------------------- 인스턴스, 생성자에서만 사용이 가능
          * static 메서드나 static 포기화 블록은 this가 없다 
          * new를 이용해서 객체를 생성시 this가 생성 
 *          ----- JVM에 의해서 자동 생성
 *  
 */
public class MainClass_01 {
	private int num; // heap이라는 영역에 저장 // 0으로 초기화 
	public MainClass_01() {// 생성자
		System.out.println("this라는 자신의 객체가 생성");
		System.out.println("this="+this);
	}
	public void numData(int num) {// stack이라는 영역에 저장
		// 적용하는 우선순위 => 지역변수와 매개변수가 우선순위, 그 다음 없으면 멤버변수를 찾는다 
		System.out.println("num="+num); // 지역변수, 매개변수 
		// 전역변수(멤버변수)를 사용할 때는 앞에 this.변수명 
		System.out.println("this.num="+this.num);
		//                             ---- 구분자 => 멤버변수
		// 색상을 잘 보아야 한다 / 밤색, 보라색 => 지역,매개변수 / 파란색, 하늘색 => 멤버변수 
		num=num; // 값을 대입하지 못함 
		//따라서 
		this.num=num;
		System.out.println("this.num="+this.num);
	}
	public void display() {
		System.out.println("this="+this);
		
	}
	public static void aaa() {
      //System.out.println(this); // static은 모든 객체가 공통으로 사용되는 객체 => this를 사용할 수 없다 
	}
	public static void main(String[] args) {
		// 객체 생성
		MainClass_01 m=new MainClass_01();
		// this=m => JVM이 자동으로 객체 주소를 대입
		System.out.println("m="+m); // 주소가 동일하다 
		m.numData(100);
		MainClass_01 m1=new MainClass_01();
		// this=m1
		System.out.println("m1="+m1);
		// 객체 생성시마다 this가 생성이 된다 => 자신의 클래스 객체를 나타내준다
		// ------------------------- this,super (상위 객체)

	}

}
