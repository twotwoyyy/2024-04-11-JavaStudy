package com.sist.lang;
/*
 *	Object : 객체와 관련된 메소드를 가지고 있다
 *  생성 = 소멸, 객체 비교, 객체 복제 => 새롭게 생성...
 *  Object는 모든 객체의 기능을 가지고 있다 => 모든 클래스에 상속을 내려서 사용
 *  
 *  => 소멸자 : finalize()
 *  => 복제  : clone()
 *  => toString() => 거의 모든 프로그램의 오버라이딩 (쌍속을 받아서 기능을 변경) 
 *     ---------- 라이브러리는 오버라이딩이 되어있다 
 *  => 모든 클래스는 extends Object
 *  => 모든 데이터형, 클래스는 Object로 묶어서 사용이 가능 
 *  => Object로 묶었을 때 단점, 항상 형변환을 해서 사용해야 한다 
 *  => 상속을 내리면 상속을 받은 클래스의 추가적인 변수/메소드에는 접근이 불가하다
 */
class Sawon{ // extends Object
	int sabun;
	String name;
	public Sawon(int sabun,String name) {
		this.sabun=sabun;
		this.name=name;
	}
	@Override
	public String toString() {
		return "사번:"+sabun+",이름:"+name;
	}
	/*
	 *  clone()
	 *  toString()
	 *  finalize()
	 *  equals()
	 *  hashCode()
	 *  
	 */
}
class Member{
	int mno;
	String name;
	
	public Member(int mno,String name) {
		this.mno=mno;
		this.name=name;
	}
	@Override
	public String toString() {
		return "회원번호:"+mno+",이름:"+name;
	}
	public void print() {
		System.out.println("회원번호:"+mno+",이름:"+name);
	}
	// Object => 클래스는 어떤 것이든 만들어서 사용 
}
// 상위 클래스로 객체 생성시에는 연결 => 상위 클래스에서 받은 메소드를 재정의 
// ------------------------ 여러 개 클래스를 한 개로 제어할 때 
// ------------------------ 라이브러리는 return형 (Object)
public class 라이브러리_활용_01 {

	public static void main(String[] args) {
		Object obj=new Sawon(1,"홍길동");
		System.out.println(obj.toString());
		obj=new Member(2,"심청이");
		System.out.println(obj); //toString은 호출하지 않아도 자동 호출 (생략 가능)
		/*Object obj=new Sawon();
		Sawon s=(Sawon)obj;
		s.sabun=1;
		s.name="홍길동";
		s.print();*/
		
	}
}
