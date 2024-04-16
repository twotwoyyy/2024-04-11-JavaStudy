/*
 * public  static void main(String[] arg) 
{  1번 문제 
   int a;   
   int b;   
   a=3;   
   b=a+5;       
   System.out.printf("a의 값: %d \n", a);   
   System.out.printf("b의 값: %d \n", b);   
} a=3
  b=8

   프로그램
   1. 변수 선언 => 데이터 저장 공간 확보 => 메모리
   2. 변수의 초기화
   -----------------------------------------선언+초기화
   int a
   a=10;
   int a=10;
   3. 사용자 요청에 대한 처리
      => 연산처리 / 제어문
   -----------------------------------------웹, 일반 자바, 모바일 동일 
   4. 처리된 결과를 출력 
   
 */
import java.util.Scanner;
public class 연산자문제_1 {

	public static void main(String[] args) {
		// 1. 변수 선언
		int a;
		int b;
		// 2. 초기화
		a=3;
		b=a+5;
		// a=3 ==> b=3+5 => b=
		   System.out.printf("a의 값: %d \n", a);   
		   //                               3
		   //                        |
		   // %d => 정수값 첨부
		   // %f => 실수값 첨부 => %.2f ==> 실수 출력, 소수점 2자리 출력
		   // %c => 문자 첨부
		   // %s => 문자열 첨부
		   // 출력형식을 만들어서 처리 ==> printf() ==> C언어의 출력형식 도입
		   System.out.printf("b의 값: %d \n", b);  
		   //
		   int money=369;
		   // 100 => 몇개
		   int won100=money/100;
		   // 10  => 몇개
		   int won10=(money%100)/10;
		   // 1   => 몇개
		   int won1=money%10;
		   // %은 윤년 구하기 
		   System.out.println("100원 동전:"+won100);//3
		   System.out.println("10원 동전:"+won10);//6
		   System.out.println("1원 동전:"+won1);//9
		   
		   Scanner scan=new Scanner(System.in);
		   System.out.print("년도 입력:");
		   int year=scan.nextInt();
		   
		   if((year%4==0 && year%100!=0) || (year%400==0))
		   {
			   System.out.println(year+"년도는 윤년입니다");
		   }
		   if(!((year%4==0 && year%100!=0) || (year%400==0)))
		   {
			   System.out.println(year+"년도는 윤년이 아닙니다");
		   }
	}
}

