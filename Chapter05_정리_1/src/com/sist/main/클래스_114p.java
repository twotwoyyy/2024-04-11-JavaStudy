package com.sist.main;
/*
 *	114page
 *  1) 클래스 구성요소 : 윈도우, 웹, 모바일 
 *     클래스 
 *     ----
 *     개발자 ===> 설계 =========> 메모리에 저장 
 *               ---           ------------
 *               클래스           인스턴스/객체
 *     1. 클래스 설계
 *        ----
 *        클래스 : 데이터만 관리 (변수 여러 개를 모아서 관리) => 웹, 윈도우 => 전송 (데이터를 모아서 한번에 전송)
 *                                                            => 상세보기 
 *               데이터 활용 : 메소드를 여러 개 묶어서 관리 => Manager(사용자 요청시 => 처리)
 *                         = 액션 클래스 (동작을 정의)
 *               데이터+메소드 동시 처리 => 혼합 클래스 
 *               -------------------------------- 벤치마킹 => 요구사항 
 *        클래스 설계 내용 
 *        -------------
 *        1. 데이터 => 멤버변수 
 *        2. 기능 => 메서드 
 *        3. 필요시 멤버변수의 초기화 : 생성자, static => static{}
 *        --------------------------------------------------
 *        = 멤버변수의 종류 
 *          *인스턴스 변수 => Heap => 메모리 공간을 만들어 동시에 저장후 관리 
 *                                --------------- 연산자 => new를 이용해서 저장 (프로그래머 관리)
 *                                => 메모리를 따로 저장 (여러 개가 필요한 경우)
 *                                ex) 영화 정보, 회원 정보, 게시물..  
 *          *정적 변수 => Mathod Area => 모든 객체가 공통으로 사용하는 변수 (1개를 가지고 사용) 
 *                     => 변수 앞에 static => 변경하면 데이터값이 동시에 변경
 *                     => 공통으로 사용되는 변수값을 지정 
 *                     => 데이터 전체를 모아서 관리 => 오라클 (공유된 데이터) 
 *                     ex) 컴퓨터가 객체, 사이트는 다 동일, 공유된 데이터/ 마이페이지는 따로 있음 
 *            ** 모든 객체의 변수값을 한번에 변경할 때 => static 
 *            ex) 게임 => 아바타 => width/height 설정, 변경시 static 
 *            ** 변수는 값을 저장해야 사용이 가능하다 
 *                    -------- 초기화 
 *        = 변수의 초기화 
 *          = 인스턴스 초기화 블록
 *            class A
 *            {
 *              int a; => class는 선언만 가능 (값 대입 불가, 선언과 동시에 값 주는 건 가능) 
 *                                          예) int a;
 *                                             a=100; (x) ===> int a=100;
 *              {
 *                a=100; =>  구현: 제어문 / 연산자 / 파일읽기 .. 
 *              }
 *            }
 *            
 *          = 정적변수 초기화 블록 => static 변수는 초기화 블록에서 주로 사용
 *            class A
 *            {
 *              static int a; // static int a=100; <처럼 명시적 초기화 우선 고려
 *              
 *              static 
 *              {
 *                 a=100; => 명시적인 초기화가 안되는 경우에 사용
 *              }
 *            }
 *            *** 자동 로그인(cookie에서 읽어와야할 때) 
 *            
 *          = 생성자 ============> 가장 많이 사용 ===> 인스턴스 
 *            1) 특징 
 *               => 모든 클래스는 생성자가 1개 이상 존재 
 *                             ------------------ 없는 경우에는 컴파일러가 자동으로 1개 추가 
 *                                                           ---------------------- 디폴트 생성자
 *                                                           디폴트 생성자 => 매개변수가 없는 생성자
 *               => 클래스명과 동일
 *               => 리턴형이 없다 
 *               => 같은 이름으로 여러 개의 생성자를 만들 수 있다 
 *                  ------------------------------------- 오버로딩 (중복 메소드 정의) 
 *                  => 같은 이름으로 여러 개를 만드는 경우 
 *                     1. 매개변수의 개수가 데이터형이 달라야 한다 
 *                     2. 리턴형, 접근 지정어는 관계 없다 
 *               => 생성자는 단독으로 호출이 불가능 => 호출시 =>  new 생성자() 
 *                                                       -----------
 *            2) 역할
 *               => 멤버변수의 초기화
 *               => 시작과 동시에 처리하는 소스가 있는 경우 
 *                  = 화면 UI
 *                  = 카카오 (서버 연결)
 *                  = 데이터베이스 연결 
 *                  = 파일 읽기  
 *            -------------------------------------------------------
 *            *** static 메서드 안에서는 static 변수, static 메서드만 사용 가능
 *                  인스턴스를 사용하고 싶은 경우엔?
 *                  => new를 이용해서 메모리 할당 후 사용 ex) A aa=new A();
 *            *** 인스턴스 메서드 안에서는 모든 것이 사용 가능 
 *              class A
 *              {
 *                 int a=10; => 인스턴스
 *                 static int b=20; => 정적
 *                 A() ==> 인스턴스 
 *                 {
 *                   => a,b,aaa,bbb 모두 호출 가능 
 *                 }
 *                 void aaa()=> 인스턴스
 *                 {
 *                  => a,b,aaa,bbb 모두 호출 가능, 생성자는 호출 불가
 *                 }
 *                 static void bbb() => 정적
 *                 { 
 *                   b => static은 static 메서드, static 변수만 호출 가능 
 *                 }
 *               }
 */
class Student{
	private String name;
	private String sex;
	private int age;
	
	public Student() { // 생성자
		name="홍길동";
		sex="남자";
		age=20;
	}
	// 사용자가 입력받은 값으로 초기화
	public Student(String n,String s, int a) {
	// 생성자

		name=n;
		sex=s;
		age=a;
	}
	public Student(String n) {
		// 생성자 호출 => this()
		this();  // 매개변수가 없는 생성자 호출시 사용 !!!!첫 줄에 사용해야 한다!!! 
		// 	public Student() 호출 
		name=n;
		// 이름은 내가 지어주되, 성별 나이는 가져오겠다는 말, 호출 
	}
	public Student(String s,int a) {
		this("박문수",s,a); // 	public Student(String n,String s, int a) 호출
	}
	public void print() {
		System.out.println("이름: "+name);
		System.out.println("성별: "+sex);
		System.out.println("나이: "+age);
		
	}
}
class Member{
	// 생성자 2개이상일시==> default 생성자는 존재하지 않는다 무조건 값을 넣어주어야 한다 
	public Member(String name) { // 생성자 
		System.out.println("이름:"+name);
	}
}
class Sawon{
	//public Sawon(){} => 컴파일러가 자동으로 추가, 우리 눈엔 보이지 않음 
//                     => 생성자가 존재하지 않는 경우에 추가 
}
class Emp{
	private String name;
	private String dapt; // 오른쪽 마우스 소스, constractor using field하면 자동으로 생성자 생긴다 
	public Emp(String name, String dapt) {
		super();
		this.name = name;
		this.dapt = dapt;
	}
	
}
public class 클래스_114p {

	public static void main(String[] args) {
//		Student s1=new Student();
//		s1.print();
//		
//		System.out.println("=======사용자 입력값 받아서 최고하 ========");
//		Student s2=new Student("심청이","여자",20);
//		s2.print();
//		Student s1=new Student("박문수");
//		s1.print();
//		Student s2=new Student("여자",30);
//		s2.print();
		Sawon s=new Sawon();
//      => 생성자는 여러 개 만들 수 있다, 없는 경우에만 생성자가 추가된다 => default 생성자 (매개변수 x) 
//      클래스 안에서 생성자 호출시에는 this()를 이용한다
//		this() : 반드시 생성자 안에서만 호출 => 첫 번째 줄에서 호출 => 한 번만 사용이 가능 
		Member m=new Member("다영");
	}

}
