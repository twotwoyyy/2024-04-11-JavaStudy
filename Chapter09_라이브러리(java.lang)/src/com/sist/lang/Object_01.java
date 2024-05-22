package com.sist.lang;

import java.sql.SQLClientInfoException;

/*
 *	java.lang / java.util / java.io / java.net / java.sql 
 *  ---------   ---------      |          |      --------
 *                          파일 업로드   브라우저에서
 *                          파일 다운로드  한글인식
 *                          (사용성)    (인코딩/디코딩)
 *  라이브러리 => 자바에서 지원하는 클래스의 집합 (API)
 *             --------- 사용법, 사용용도
 *  => 프로그램은 라이브러리 + 사용자 정의 => 조립             
 *
 *  *java.lang : 자바에서 기본적으로 사용이 많은 클래스를 모아 관리 => import 생략 가능  
 *   = Object : 자바의 모든 클래스(사용자 정의)의 상위 클래스 => 최상위 클래스 
 *              => 모든 클래스는 Object로부터 상속을 받는다
 *              => 생략이 가능 => extends Object 
 *              => 데이터형 중에 가장 큰 데이터형 
 *                 ---------------------- 모든 데이터를 받아서 저장이 가능
 *              => 라이브러리의 메소드의 리턴형은 대부분이 Object => 객체형변환 
 *                                                      ---------
 *                ex) class A (extends Object)
 *                    {
 *                      int a;
 *                      int b;
 *                      public void display();
 *                    }
 *                    => Object obj=new A();
 *                       obj는 a,b,display() => 가지고 있지 않다 
 *                       따라서 A a=(A)obj 로 형변환해서 가져와야 한다!!!!!
 *                    => 상위 클래스는 하위클래스의 변수나 메소드에 접근 불가 
 *                    => 형변환 => 데이터형의 크기 변경 
 *                       ---- 형변환하려면 상속, 포함 관계여야 한다 
 *                       크기) 상속내리는 클래스 > 상속받는 클래스
 *                      ----------- 상속받은 클래스의 추가된 기능에 접근 불가 => 형변환 
 *                           포함하는 클래스 > 포함되는 클래스
 *                   ex) class A
 *                       {
 *                       }
 *                       class B
 *                       {
 *                         public void display()
 *                         {  
 *                            A a=new A(); => 포함클래스 아니고 지역변수
 *                         }
 *                       }
 *                       class C
 *                       {
 *                         A a=new A(); // 포함 클래스 => 멤버일 경우에만
 *                       }
 *                       
 *                    = 제공하는 기능 (메소드)
 *                    1. toString() => 객체를 문자열화 => 객체의 주소
 *                       ---------- 묵시적, 명시적
 *                       class A
 *                       
 *                       A a=new A();
 *                       system.out.println(a) => 묵시적 (toString 생략했다는 뜻)
 *                       system.out.println(a.toString) => 명시적 
 *                       => 가장 많이 오버라이딩 : 변수의 값을 출력 
 *                   2. hashCode() => 객체의 메모리 주소값을 리턴형 
 *                      ---------- 데이터값이 같은 경우 같은 객체
 *                      => 데이터 중복 여부 확인할 때 주로 사용 (중복 제거)
 *                      => 웹에서 데이터수집 할 때 자주 사용한다 
 *                   3. clone() : 객체를 복제 => 새로운 메모리를 만들 때 필요한 객체의 내용을 그대로 복사
 *                      ------- protoType 패턴 => 예를 들어 이모티콘, 아바타 
 *                      제어를 따로 할 때 사용한다, 주소가 다르다, 깊은 복사 
 *                   4. finalize() : 소멸자 => 객체 메모리 해제 => 자동 호출
 *                                   => 호출이 안되면 메모리에 남아 있다..
 *                                   => System.gc() : 사용하지 않는 메모리 회수 요청
 *                                   => 웹/애플리케이션에서는 사용하지 않는다 => 멀티미디어(동영상,화상채팅,CCTV)
 *                   5. equals() : 객체를 비교할 때  
 *                                => 메모리 주소값을 비교하는 것이 (디폴트)
 *                                => **멤버 변수값을 비교 하려면 반드시 (오버라이딩) !!  
 *                     * 객체의 생명주기
 *        객체에 대한 설계      객체 생성 ===============> 객체 활용  ================> 객체 소멸
 *                        new 생성자()              . (변수/메소드 접근)             객체=null
 *                                                                    null은 더이상 사용하지 않는다는 뜻
 *                                                                   => GC 대상 (메모리 회수 대상)
 *                                                                   | 바로 회수하지 않는다 => 프로그램 종료시 회수
 *                                                                  **new를 많이 사용하면 누적이 된 상태 => 부하
 *                      
 *   = String
 *   = System
 *   = Math
 *   = Wrapper
 *   = StringBuffer
 */
import java.util.*;
class Sawon{
	private int sabun;
	private String name;
	//사용자로부터 값을 받아서 초기화한다 
	public Sawon(int sabun, String name) {
		this.sabun=sabun;
		this.name=name;
	}
	// 출력 
	@Override // 반드시 상속 => 재정의 (정의를 변경) 
	public String toString() {
		return "사번:"+sabun+",이름:"+name; // 메모리 주소값을 변경 => 변수의 초기화 출력 
	}
	// 디폴트 생성자는 없다 (자동 추가가 안된다) 
}
class Student{
	private int hakbun;
	private String name;
	public Student(int hakbun,String name) { // 생성자, 디폴트 사용 불가 (자동추가 불가)
		this.hakbun=hakbun;
		this.name=name;
	}
	//hashCode 변경 => 오버라이딩
	//라이브러리는 필요한 경우 대부분 오버라이딩을 해 사용한다 
	@Override
	public int hashCode() {
		return Objects.hash(hakbun,name); // hakbun,name이 같으면 해시코드를 같게 변경하는 오버라이딩 
	}
}
/*
 *	인터페이스 => 클래스 (다중상속)
 *  => 미완성된 클래스 => 완성해서 사용한다 
 *                   ------------ 상속을 받아야 가능
 *  인터페이스 =====> 인터페이스 
 *    :확장 extends
 *  인터페이스 =====> 클래스
 *    :미완성된 메소드 구현 implements 
 *  클래스 =====> 클래스
 *    :확장 extends
 *  클래스 =====> 인터페이스 (클래스에서 인터페이스 상속은 존재하지 않는다) 
 *  
 *  형식) 모든 구성요소: 변수/메소드 <= only public 
 *  interface interface면
 *  {
 *    -------------------------------------------------------------
 *     상수 (변수는 존재하지 않는다)
 *     int a=100; // 반드시 선언과 동시에 초기값 설정 => 초기값은 상수라 변경 불가 
 *     (public static final)이 생략된 것 
 *    -------------------------------------------------------------
 *     구현이 안 된 메소드
 *     (public abstract) void display();
 *    -------------------------------------------------------------
 *     구현이 된 메소드 
 *     (public) default 리턴형 메소드명 (매개변수) 
 *     {
 *     }
 *    -------------------------------------------------------------
 *  }
 */
class Box implements Cloneable{
	private int width;
	// throws 문장 뒤에 붙는 예외 클래스는 RuntimeException와 관련은 없다 => 예외처리 하고 사용해야 한다 
	// CloneNotSupportedException => CheckedException 
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHigth() {
		return higth;
	}
	public void setHigth(int higth) {
		this.higth = higth;
	}
	private int higth;
	
}
class Member{
	// C 언어 => Member(), ~Member()
	private int mno;
	private String name;
	// 생성시 호출 => 생성자 
	public Member(int mno,String name) {
		this.mno=mno;
		this.name=name;
		System.out.println("객체 메모리 할당 ..");
	}
	public void print() {
		System.out.println("회원번호:"+mno);
		System.out.println("이름:"+name);
	}
	// 소멸시 호출 => 소멸자 
	@Override
	protected void finalize() throws Throwable {
		System.out.println("객체 메모리 회수 ..");
	}
}
	
	// 멤버변수의 값을 설정 => 여러 번 변경    / 한 번만 변경 
	//                   |생성자 이용불가  | 생성자 이용 가능
	/*
	 *	Member m=new Member(1,"aaa");
	 *  m=new Member(2,"bbb")
	 *  m=new Member(3,"ccc") 
	 *  ----------------------이렇게 하면 객체가 3번 생성된 것, 주소가 다 다르다, 한번에 제어 불가 
	 *  따라서 여러번 사용하려면 setter 이용 
	 */
class Food{
	private int fno;
	private String name;
	
	public Food(int fno,String name) {
		this.fno=fno;
		this.name=name;
		//지역변수,매개변수 우선순위 
		//변수명이 같은 경우에는 반드시 구분 => this: 클래스 자신의 객체, super: 상속내린 클래스의 객체
		/*
		 *  메모리
		 *  --------------------------------
		 *     ----------super-----------
		 *       상속 내린 클래스의 변수/메소드
		 *       => clone()
		 *       => finalize()
		 *       => 
		 */
	}

	@Override // 오버라이딩!! equals 실제 값 비교하려고
	public boolean equals(Object obj) {
		// f1.equals(f2)
		// Object obj=f2; => Object클래스에는 fno,name이 존재하지 않는다 따라서 형변환 
		Food f=(Food)obj;
		return name.equals(f.name) && fno==f.fno; // 이름과 번호가 같다면 true처리 
	}
}
/*
 *  class A 
 *  {
 *    int a,b
 *    void display(){}
 *  }
 *  class B extends A
 *  {
 *    ----------------
 *    int a,b;
 *    void display(){} => 내용 변경이 가능 => 오버라이딩
 *    ----------------
 *    int c;
 *    void bbb(){}
 *  }
 *  
 *  A a=new A(); a,b,display() => 사용이 가능
 *  B b=new B(); a,b,display() + c,bbb() 
 *  A c=new B(); a,b,display() => B가 가지고 있는 A변수 값들만 호출된다, 재정의된 메소드만 달라진다 
 *-변수-  -----클래스
 */

public class Object_01 {

	public static void main(String[] args) {
		Sawon h1=new Sawon(1, "홍길동"); // 데이터베이스에서 데이터 읽기 / 파일 데이터 읽을 때 주로 사용 
		System.out.println(h1); //toString 생략한 것, 객체를 출력할 때 늘 필요하다 
	//  Sawon s2=new Sawon() => 디폴트 생성자는 x , 매개변수값을 넣어야 한다 
		Sawon h2=new Sawon(2,"박문수");
		System.out.println(h2); 
		Student s1=new Student(1, "홍길동");
		Student s2=new Student(1, "홍길동");
		// s1,s2는 같지 않다
		System.out.println("s1="+s1.hashCode());
		System.out.println("s2="+s2.hashCode());
		// 해시코드 값이 다르면 코드가 다르다
		
		if(s1.hashCode()==s2.hashCode()) {
			System.out.println("같은 학생이다");
		}
		else {
			System.out.println("다른 학생이다");
		}
		
		Box box1=new Box();
		box1.setWidth(300);
		box1.setHigth(350);
		/*
		 *	Box box4=box1; // 같은 주소 이용 (얕은복사)
		 *  box.clone // 새로운 메모리 생성 (깊은복사)
		 */
		Box box4=box1;
		System.out.println("box1=>"+box1);
		System.out.println("box4=>"+box4);
		// box1에 대한 별칭을 box4로 준 것, 같은 메모리 제어 
		Box box3=new Box();
		System.out.println("box3.width:"+box3.getWidth()); //0
		System.out.println("box3.heigth:"+box3.getHigth()); //0
		
		try {
			Box box2=(Box)box1.clone(); // clone 이용시 리턴형이 Object이기에 형변환, 예외처리 필수 
			System.out.println("box2.width:"+box2.getWidth()); //300
			System.out.println("box2.heigth:"+box2.getHigth()); //350
			System.out.println("box2=>"+box2); // 주소값이 다르다, 새로운 메모리 
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} 
		// 객체 생성
		Member m=new Member(1, "심청이");
		// 객체 활용
		m.print();
		// 객체 소멸
		m=null; // finalize() 호출 => x
		System.gc(); // 객체 메모리 회수 명령, 필요한 경우에만 사용 
		
		Food f1=new Food(1,"중국집");
		Food f2=new Food(1,"중국집");
		//equals => 재정의 , 오버라이딩을 하기 전까지는 주소값을 비교하기 때문에 지금은 다른 업체라고 나온다 
		//오버라이딩을 하면 같은 업체로 나온다 
		if(f1.equals(f2)) {
			System.out.println("f1="+f1);
			System.out.println("f2="+f2);
			System.out.println("같은 업체입니다!!");
		}
		else {
			System.out.println("f1="+f1);
			System.out.println("f2="+f2);
			System.out.println("다른 업체입니다!!");
		}
		
	}
}
