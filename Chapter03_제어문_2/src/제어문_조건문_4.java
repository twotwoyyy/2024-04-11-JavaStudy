/*
 *	if~else => 삼항연산자 
 *			    (조건) ? 값1 : 값2
 *			   ------
 *				|  true
 *				|------값1
 *				|  false
 *				|-----------값2
 *	if(조건문)
 *  {
 *  	조건true
 *  }
 *  else
 *  {
 *      조건false
 *   }
 *   
 *   ----------------
 *   
 *   3개의 정수 (국어, 영어, 수학)
 *   => A , B , C , D , F
 *   	=> A+, A0, A-
 *        100~97 +
 *        96~93 0
 *        92~90 -
 *   1. 국어 영어 수학 입력 => 사용자가 입력
 *   -------------------------------
 *   2. 조건에 맞게 => 학점 부여
 *   -------------------------------프로그래머
 */
import java.util.Scanner;
public class 제어문_조건문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in); // System.in은 키보드 입력값을 읽어오는 것
		/*
		 * Scanner
		 * 1) 정수 : nextInt() => int
		 * 2) 실수 : nextDouble() => double
		 * 3) 논리 : nextBoolean() => boolean
		 * 4) 문자열 : next() => String
		 * 	  문자 추출 => next().charAt(index) => char // 6을 입력하면 G, 0을 입력하면 A
		 * 	  ABCDEFG
		 * 	  0123456
		 */
		System.out.println("국어 점수 입력:");
		int kor=scan.nextInt();
		System.out.println("영어 점수 입력:");
		int eng=scan.nextInt();
		System.out.println("수학 점수 입력:");
		int math=scan.nextInt();
		
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("총점:"+(kor+eng+math));//문자열이 있기에 괄호
		System.out.printf("평균:%.2f\n",(kor+eng+math)/3.0); // %.2f
		
		// 학점 구하기 = 중첩 조건문
		// 1. 학점 => A~F
		char score=' ';
		char op=' '; // 값을 꼭 줘야함, 공백이라도 
		// => 지역변수: main블록에 들어감, 반드시 초기화 후에 사용한다 
		// 2. op => +,0,-
		
		int avg=(kor+eng+math)/3;
		if(avg>=90 && avg<=100) // =>A
		{
			score='A';
			if(avg>=97)
				op='+';
			if(avg>=93 && avg<97)
				op='0';
			if(avg>=90 && avg<93)
				op='-'; // 중첩 if문 조건 안 조건 
		}
		if(avg>=80 && avg<90) // =>B
		{
			score='B';
			if(avg>=87)
				op='+';
			if(avg>=83 && avg<87)
				op='0';
			if(avg>=80 && avg<83)
				op='-';
		}
		if(avg>=70 && avg<80) // =>C
		{
			score='C';
			if(avg>=77)
				op='+';
			if(avg>=73 && avg<77)
				op='0';
			if(avg>=70 && avg<73)
				op='-';
		}
		if(avg>=60 && avg<70) // =>D
		{
			score='D';
			if(avg>=67)
				op='+';
			if(avg>=63 && avg<67)
				op='0';
			if(avg>=60 && avg<63)
				op='-';
		}
		if(avg<60) // =>F
		{
			score='F';
		}
		System.out.println("학점:"+score+""+op);
		}

}
