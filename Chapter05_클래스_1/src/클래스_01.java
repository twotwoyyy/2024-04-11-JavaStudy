/*
 *	클래스
 *	 = 사용자 정의 데이터형 : 데이터만 모아서 관리 
 *						---- 다른 데이터를 모아서 관리
 *	 = 액션 클래스 : 메소드를 여러 개 모아서 관리
 *
 *	** 클래스는 한 개에 대한 정보
 *	class 사원
 *	{
 *		이름 
 *		부서
 *		근무지
 *		입사일
 *		직위
 *		연봉
 *		성과급
 *		...
 *	}
 *
 *	class 학생
 *	{
 *	  이름 String
 *	  학년 int
 *	  학점 char
 *	  주소 String ... 
 *	  전화
 *	  나이
 *	}
 */
// 데이터형 => 형변환
// 개발자마다 
class Student{
	String name;
	int age;
	// 인스턴스 변수 : 메모리 공간을 따로 생성
	static String school_name; // static 공유 변수. 안쓰면 따로 저장 
	// 공유 변수 : 한 개의 공간에서 사용 
}
// => 저장 
public class 클래스_01 {

	public static void main(String[] args) {
		Student hong=new Student();
		// name , age , school_name
		hong.name="홍길동";// .을 찍어 접근
		hong.age=25;
		hong.school_name="쌍용";
		Student shim=new Student();
		shim.name="심청이";
		shim.age=20;
		shim.school_name="SIST";
		// name , age , school_name
		Student park=new Student();
		park.name="박문수";
		park.age=30;
		park.school_name="SIST강북"; //바꾸면 전체가 바뀐다 static 공유변수 
		//                           => 따라서 static은 함부로 사용해서는 안 된다 
		// name , age , school_name
		
		System.out.println("===== hong영역 =====");
		System.out.println("이름:"+hong.name);
		System.out.println("나이:"+hong.age);
		System.out.println("학교명:"+hong.school_name);
		// school_name은 static이 붙은 공유 변수이기 때문이다 메모리가 같음 
		System.out.println("===== shim영역 =====");
		System.out.println("이름:"+shim.name);
		System.out.println("나이:"+shim.age);
		System.out.println("===== park영역 =====");
		System.out.println("이름:"+park.name);
		System.out.println("나이:"+park.age); // new는 메모리를 따로 만들어준다 

	}

}
