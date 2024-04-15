import java.util.*; // 자바에서 지원하는 라이브러리를 읽어 온다 
public class 연산자_산술연산자_2 {
	/*
	 *   () : 최우선 순위 연산자
	 *   5+5*10
	 *   => * , / , % , + , - 순으로 계산
	 *   
	 */
	public static void main(String[] args) {
		// 임의로 변수 지정 int a=100
		// 변수 선언 
		int num1,num2; // 사용오류, 값을 안줬기 때문=> 변수는 초기화 (값 지정)
		// 초기화
		Random r=new Random();
		// 임의의 수를 추출
		num1=r.nextInt(101);//0~100까지의 정수 추출 => 마지막 수 제외
		num2=r.nextInt(101);//난수는 하나를 증가시켜 써야 한다 
		System.out.println("num1="+num1);
		System.out.println("num2="+num2);
		
		// + 연산
		int plus=num1+num2;
		System.out.println("plus"+(num1+num2)); // ()는 최우선순위 연산자
		
		//System.out.println(5+5*10); //55
		//System.out.println((5+5)*10); //100
		int minus=num1-num2;
		System.out.println("minus="+minus);
		
		int gop=num1*num2;
		System.out.println("gop="+gop);
		
		int a=10;
		int b=3;
		System.out.println(a/b); //3
		System.out.println(a/(double)b);
		// int => double로 변경 (double)변수명 => 데이터형 변경
		// 값이 있는 경우 => .0
		
		System.out.println(a%b); //1
		System.out.println(a%-b);
		System.out.println(-a%b);
		System.out.println(-a%-b);
		//앞에 나온 부호를 따라감, 왼쪽 
		
	}

}
