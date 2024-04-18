/*
 * 	if~else
 * 	=> if 정상수행문장
 *  => else 오류, 잘못된 입력일 경우 
 */
// 사칙연산 => 연산자를 잘못 입력한 경우 ... 처리
import java.util.Scanner;
public class 제어문_조건문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num1,num2;
		char op=' ';
		System.out.print("첫 번째 정수 입력:");
		num1=scan.nextInt();
		System.out.println("연산자 입력(+,-,*,/)");
		op=scan.next().charAt(0); // 문자 1개 받을 때 사용
		System.out.println("두 번째 정수 입력:");
		num2=scan.nextInt();
		
		if(op=='+' || op=='-' || op=='*' || op=='/') // 정상 연산
		{
			//정상 수행
			if(op=='+')
				System.out.printf("%d + %d = %d\n", num1,num2,num1+num2);
			if(op=='-')
				System.out.printf("%d - %d = %d\n", num1,num2,num1-num2);
			if(op=='*')
				System.out.printf("%d * %d = %d\n", num1,num2,num1*num2);
			if(op=='/')
			{
				if(num2==0)
					System.out.println("0으로 나눌 수 없다");
				else
					System.out.printf("%d / %d = %.2fd\n", num1,num2,num1/(double)num2);
			}
			/*
			 * 		%d ==> 정수값
			 * 		%f ==> 실수값 => %.2f %.1f
			 * 		%c ==> 문자
			 * 		%s ==> 문자열
			 * ==> printf : 서식이 있는 출력 
			 * 	---------------------------HTML => CSS
			 *  출력 형식을 만들어서 출력을 요청 ==> printf()
			 *  println() (형식 없음)
			 */
		}
		else
		{
			//연산자가 없는 경우
			System.out.println("잘못된 연산자입니다.");
		
	
		}
		
	}

}
