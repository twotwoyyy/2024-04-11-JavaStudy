/*
 *	static 메소드 
 *	-----------
 *		=> static 변수만 사용이 가능
 *		=> 멤버변수를 사용하려면 => 객체 생성 (new)
 *   예) 멤버변수_활용03 ss=new 멤버변수_활용03();
		System.out.println("a="+ss.a);
 *	
 *	멤버메소드 (***)
 *		=> static 변수, 멤버변수를 사용할 수 있다 
 */
public class 멤버변수_활용03 {
	int a=10;
	// static 공통으로 사용되는 메소드 
	static int b=10; // 카드놀이 => width/height => 한번에 동시에 변경, 이럴때 static을 쓴다 
	public static void main(String[] args) {
		멤버변수_활용03 ss=new 멤버변수_활용03();
		System.out.println("a="+ss.a);
	}
	//클래스 멤버 메소드
	void print() {
		System.out.println("a="+a);
		System.out.println("b="+b);
	}

}
