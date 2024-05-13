package com.sist.main;
/*     200page    207page
 *	  ---------   --------
 *                상속에서 접근지정어
 *                
 *     오버로딩 / 오버라이딩
 *     오버로딩 : 중복 메서드 정의 => 같은 기능 
 *      예) print(int) print(char) print(char[]) ...
 *         -----------------------------------------
 *      => 버스 
 *         버스 => 일반버스
 *         버스(좌석)
 *         버스(마을)
 *         버스(고속) ==> 매개변수가 다를 때마다 다른 것으로 인식
 *         
 *      오버라이딩 : 기존의 클래스를 상속을 받아서 => 재정의 (메소드 기능을 변경)
 *                --------------                -------------
 *     -----------------------------------------------------------------
 *                  오버 로딩                             오버라이딩 
 *     -----------------------------------------------------------------
 *      상태     같은 클래스내에서                        상속 
 *            class A
 *            {
 *              public void aaa(){}
 *              public void aaa(int a){}
 *              public void aaa(char c){}
 *              public void aaa(int a, int b){}
 *              public int aaa(double d){}
 *            }
 *              * 매개변수 명칭은 관련 없다 
 *     -----------------------------------------------------------------
 *      메서드명           동일                              동일
 *     -----------------------------------------------------------------
 *      매개변수     개수/데이터형이 다르다                       동일
 *     -----------------------------------------------------------------
 *      리턴형           관계없다                             동일
 *     -----------------------------------------------------------------
 *      접근지정어        관계없다                          확대만 가능
 *     -----------------------------------------------------------------
 *     
 *     * 접근지정어 크기 
 *     		private < default < protected < public 
 *     
 *     * 오버라이딩 => 상속 
 *                 * !! 예외 조건
 *                 static : 상속은 안된다 => 사용이 가능하게 만든다 (공유) 
 *                 private
 *                 생성자
 *                 초기화 블록
 *                 ------------- x
 *                 * 상속 가능 조건
 *                 멤버변수 (인스턴스) ====> 변수값 변경 (변수 오버라이딩)
 *                 메서드 ==============> 기능 변경 (메서드 오버라이딩) 
 *                 // 상속을 받아야만 오버라이딩이 가능하다
 *      => 오버라이딩은 멤버변수(인스턴스), 멤버 메서드(인스턴스)만 상속이 되기 때문 
 *      
 *      	메서드의 종류 
 *      	1. 인스턴스 메서드 : NEW에 의해 따로 저장
 *      	2. 공통 메서드 : static => 상속의 예외 조건 => 변경(전체변경) => 오버라이딩이 안됨
 *      	3. 종단 메서드 : 확장이 불가능 => 변경이 불가능 => final
 *      	-----------------------------------------------------------------
 *      	권장) 메서드의 접근지정어는 가급적이면 public 
 *      	-----------------------------------
 *      	
 *      	접근지정어
 *      	-------
 *      	public : 생성자, 클래스, 메서드, 인터페이스
 *      	=> 다른 클래스와 연결  
 *      	private : 멤버변수 => 데이터 노출 방지 (데이터 보호)
 *      	=> 다른 클래스에서 사용 => 변수 기능의 메서드 제작 
 *                               -----------------
 *                               메모리 저장  / 메모리에 읽어오기
 *                               |set변수명() | get변수명{}
 *                          ex) class A 
 *                            { 
 *                            	private String name;
 *                            	private boolean login;
 *                            	public void setName(String name)
 *                              ***public void setLogin(boolean login)
 *                               => boolean만 get,set이 아니라 is 
 *      
 */
class ABC{
	public void display1() {} // 멤버메소드
	public static void display2() {} // 공통메소드
	public final void display3() {} // 종단 메소드
}
class BCD extends ABC{
	public void display1() {} // 멤버메소드 (오버라이딩)
	//public static void display2() {} // 공통메소드 => 전체를 바꿔버리는 것 static
	//public final void display3() {} // 종단 메소드
}
class DGB{
	// this. ==> DGB가 가지고 있는 변수 
	// this는 생성자, 멤버 메서드에만 존재 => static에서는 존재x
	private String name;
	private boolean login;
	private static int age;
	public void display() {
		String name="";
		this.name="홍길동";
		// 멤버 메서드 => this. 사용 가능하다 
		// 그러나 변수 충돌하지 않으면 생략해도 된다
		// 충돌시 반드시 this. 이용 
		name="홍길동";
		age=100;
	}
	public static void aaa() {
		// static는 클래스의 멤버변수가 아니다 
		// 공통 사용부분을 구사
		System.out.println(age); // static은 static을 갖다 쓸 수 있다 
		// static은 static만 가능하다 
		//DGB d=new DGB(); // 객체 생성 후 쓰는 것은 가능 그러나 다른 메모리
		
	}
	public String getName() {
		return name;
	}
	// 변수가 충돌되지 않으면 this. 생략 가능 
	public void setName(String name) {
		this.name = name; // this로 구분자, 지역변수와 충돌시 class 변수인 멤버변수임을 구분 this.
		// 지역변수,매개변수 우선순위이기때문에 this로 멤버변수 구분  
	}
	public boolean isLogin() {
		// boolean만 get이 아니라 is~
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	
}
public class MainClass_10 {

	public static void main(String[] args) {
	

	}
}
