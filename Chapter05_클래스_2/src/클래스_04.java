// 초기화 블록 => 자동 호출 / 클래스 블록 안에 {} 
import java.util.*;
class Sawon{
	int sabun;
	String name;
	String dept;
	String job;
	String loc;
	int pay;
	// 초기화, 초기화시킬때 블록을 열고 시킬 수 있다
	// ==> 파일 읽기, 라이브러리 읽기, 데이터베이스 연동 할 때 주로 쓴다 {} 구현이 가능해서 
	//for(int i=0;i<10;i++) 여기선 사용 불가, 초기화 블록에서 사용해야 한다 
	{
//		sabun=1;
//		name="홍길동";
//		dept="개발부";
//		job="대리";
//		loc="서울";
//		pay=3600;
		for(int i=0;i<10;i++) {
			sabun=i;
		}
	}
	
	//생성자
	/*
	 * => 멤버변수의 초기화를 담당 
	 * => 메모리에 저장시 호출되는 메소드
	 * => 모든 클래스에 1개 이상 존재
	 * => 없는 경우에는 자동으로 추가
	 * 특징
	 * => 리턴형이 없다
	 * => 클래스명과 동일하다 
	 * => 생성자는 여러 개인 경우도 있다 
	 */
	// 생성자가 아니라 일반 메소드다 
	void Sawon() { // 클래스명과 동일해야한다
		
	}
	// 생성자는 앞에 아무것도 붙이지 않고 쓴다 
	// ---- 반드시 호출시에 new가 붙는다/ new 생성자() 
	/*
	 * 기본 초기값 = 명시적 초기화 = 초기화 블록 = 생성자
	 *                        | static {}
	 * -------------------------------------- 보통은 생성자를 주로 사용한다
	 * 관련된 데이터 여러 개 저장시에는 메모리 주소를 이용해서 접근한다 => 참조변수 
	 * 일반 1개의 변수만 이용 
	 * 
	 *  객체지향프로그램은
	 *  ** 여러 개의 데이터 + 여러 개의 메소드를 한곳에 저장한 후에 동시에 제어 
	 *  ------------------------------저장 공간을 객체
	 *                                         -- 한번에 기능을 만들어서 사용
	 *                                         1. 재사용
	 *                                         2. 수정/추가 편리
	 *                                         3. 데이터 보호
	 *                                         
	 *  1970년도 
	 *   SW                                    HW => SW언어 / HW 언어(저급언어_
	 *                                               ----- 고급언어
	 *  C언어 : 절차적 언어                         집적회로 : 필요시마다 재사용을 가능하게 만든다
	 *        => 재사용이 안됨
	 *        => 편집기 => 한번 사용하면 저장이 안됨
	 *     1980년도
	 *  C++ :갹체 지향 프로그램 => 집적회로를 이용 => 저장후에 다시 서용이 가능하게 만든다
	 *                                      ------------------------------객체 지향
	 *    | 수투덥 => 몸값을 불리기 위해 일부로 어려운 언어를 만든다
	 *     1980년도 IBM => C언어 개발자 양성
	 *       
	 */
	Sawon(){
		Scanner scan=new Scanner(System.in); // 생성자 
		System.out.print("사번입력:");
		sabun=scan.nextInt();
		System.out.print("이름입력:");
		name=scan.next();
		System.out.print("부서입력:");
		dept=scan.next();
	}
	
}
public class 클래스_04 {

	public static void main(String[] args) {
		Sawon hong=new Sawon(); // 저장 => 메모리 공간 
		System.out.println("사번:"+hong.sabun);
		System.out.println("이름:"+hong.name);
		System.out.println("부서:"+hong.dept);
		new Sawon(); // 앞에 꼭 new를 붙여야 생성자 호출 가능 
	}

}
