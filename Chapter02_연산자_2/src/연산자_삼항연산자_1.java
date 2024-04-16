import java.util.Scanner;// 자바에서 지원하는 클래스를 읽어 올 때 사용
public class 연산자_삼항연산자_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	   /*	
	    * char c='A';
		System.out.println(c>='A' && c<='Z'?"대문자":"소문자");
		*/
		Scanner scan=new Scanner(System.in);
		
		// 클래스는 저장할 때 반드시 new (동적 메모리 할당)
		// system.in => 키보드로부터 값을 받는다 
		System.out.println("알파벳 입력:");
		char c=scan.next().charAt(0);
		System.out.println("c="+c);
		// 문자 입력 scan.next().charAt(0)
		// 정수 입력 scan.nextInt()
		// 논리 입력 scan.nextBoolean()
		// 실수 입력 scan.nextDouble()
		
		/*
		 * 	변수
		 *  = 초기화 (저장방법)
		 *  = 명시적인 초기화 
		 *    int a=10
		 *  = 난수 Math.random() => 알파벳 
		 *  = 입력값 받기 => Scanner / BufferedReader
		 *  						---------------
		 *  						|예외처리
		 */
		System.out.println(c>='A' && c<='Z'?"대문자":"소문자");
	}

}
