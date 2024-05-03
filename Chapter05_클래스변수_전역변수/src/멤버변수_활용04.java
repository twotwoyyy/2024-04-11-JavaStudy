class Human{
	static String name;
	static String sex;
	// static을 쓰지 않으면 new를 사용할 때마다 다른 메모리가 생성
	// static은 공통으로 사용하는 메모리가 생성된다 
}
public class 멤버변수_활용04 {

	public static void main(String[] args) {
		Human hong=new Human();
		hong.name="홍길동";
		hong.sex="남자";
		
		Human shim=new Human();
		hong.name="심청이";
		hong.sex="여자";
		
		System.out.println(hong.name);
		// 결과는 심청이 => static은 공유변수이기 때문이다, 한번에 저장
		// 따라서 따로따로 저장 공간을 쓰려면 static을 빼야한다 
	}

}
