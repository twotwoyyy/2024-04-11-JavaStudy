/*
 *	변수 => 초기화 (프로그램에 필요한 데이터 값을 저장) 
 *  | 필요한 값을 지정 
 *  -------------------
 *  | 파일 읽기
 *  | 웹 읽기 (크롤링)
 *  | 메소드를 이용하는 방법 
 *  | 입력값을 받아 처리
 *  ------------------- 선언이 아니라 구현 
 *                      ------------- 클래스 {} 안에서는 사용이 불가 
 *                      | 초기화 블록 / 생성자 => 로는 가능  
 *  = 선언과 동시에 값을 지정하는 것은 가능 
 *  	int a=100; 가능
 *  	나중에 값을 대입하는 것은 불가능
 *  	int a;
 *  	a=100; 불가능
 *  	==================> 클래스 블록에서
 *  = 모든 클래스에는 생성자가 반드시 1개 이상이 있어야 한다 
 *  = 생성자가 없는 경우에는 컴파일시에 자동으로 1개 추가한다 
 *  
 *  *** 자바 프로그램에서 자동으로 추가되는 내용
 *  	1. import java.lang.*;
 *                ------------
 *                String, Math, System 
 *      2. extends Object : 모든 클래스는 Object 상속을 가지고 있디
 *      3. 메소드 => void => return 생략 
 *      4. 모든 클래스 생성자가 없는 경우 => 자동 추가 
 *       
 *       
 */
class Student{
	// 변수
//	String name;
//	int hakbum;
//	String school_name;
//	String sbject;
//	int year;
	/*
	 * 자동초기화 
	 */
	
	// 명시적인 초기화!!! 
	String name="홍길동";
	int hakbum=1;
	String school_name="SIST";
	String sbject="컴퓨터";
	int year=2;
	/*
	 * 명시적인 초기화
	 */
	// 초기화
	// 메소드
}
public class 클래스_03 {

	public static void main(String[] args) {
		//1. 학생 생성
		//hong메모리 주소 => name, subject,school_name,hakbun => .을 이용해서 접근 
		Student hong=new Student(); 
//		                 ------- 생성자 => 리턴형이 없다, 클래스명과 동일 => 외부에서 데이터 읽어서 변수에 대입
//                               사용자로부터 입력값을 받아서 초기화
//                               시작과 동시에 연결 => 서버 구동, 화면 UI, 데이터베이스 연동 
//                               생략이 가능 => 자동으로 컴파일러가 추가
		System.out.println("이름:"+hong.name);
		System.out.println("학년:"+hong.year);
		System.out.println("학과:"+hong.sbject);
		
		//2. 핵생 생성
		//shim메모리 주소 => name, subject,school_name,hakbun => .을 이용해서 접근 
		Student shim=new Student();
		//변경
		shim.name="심청이";
		shim.year=3;
		shim.sbject="자바";
		System.out.println("이름:"+shim.name);
		System.out.println("학년:"+shim.year);
		System.out.println("학과:"+shim.sbject);
		//3. 학생 생성 => park => 박문수 , 1학년 , 파이썬
		Student park=new Student();
		park.name="박문수";
		park.year=1;
		park.sbject="파이썬";
		System.out.println("이름:"+park.name);
		System.out.println("학년:"+park.year);
		System.out.println("학과:"+park.sbject);
	}

}
