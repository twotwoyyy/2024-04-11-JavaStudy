// 매개변수 => 메소드 안에서만 사용 가능 => 지역변수
// 메소드 호출시에 메모리에 저장 => 메소드 종료되면 자동으로 해제 

public class 메소드_03 {
	static int i=1; // 이 영역에 선언되면 사라지지 않는다 (메소드 밖, 클래스 영역) => "전역변수" : 프로그램 종료시 메모리 해제
	static void increment() { // 호출시마다 변수는 자동 삭제 => 다시 생성 
		int i=1; // 지역변수 (우선순위) 
		System.out.println("i="+i); // 호출할때마다 다시 i생성 => 따라서 i는 증가 안되고 i=1;
		//System.out.println("i="+메소드_03.i); //클래스에서 불러주면 전역변수 불러온다 
		++i;
		// 노란색(밤색) => 지역변수
		// 하늘색(파란색) => 클래스 변수
	}
	public static void main(String[] args) {
		increment(); // {} => 선언된 모든 변수는 메모리에서 사라진다 => "지역변수"
		increment();
		increment();
	}

}
