/*
 * 	국어 영어 수학 점수를 입력받아서
 * 	총점, 평균
 * 	학점 => 100~90 A => + , 0 , - , A+ A0 A-
 * 		   89~80  B 
 * 		   79~70  C
 * 		   69~60  D
 * 			 F
// 변수 많이 잡으면 6개, 적으면 4개 
 */
import java.util.Scanner;
public class 제어문_단일조건문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 입력값
		Scanner scan=new Scanner(System.in);
		//필요한 변수 선언
		int kor,eng,math;
		char score='A'; //지역변수는 꼭 초기화 필수 
		
		//입력값을 받아서 초기화
		System.out.print("국어 점수 입력:");
		kor=scan.nextInt();

		System.out.print("영어 점수 입력:");
		eng=scan.nextInt();
		
		System.out.print("수학 점수 입력:");
		math=scan.nextInt();
		
		// 학점 계산
		int avg=(kor+eng+math)/3;
		if(avg>=90 && avg<=100)
		{
			score='A';
		}
		if(avg>=80 && avg<90)
		{
			score='B';
		}
		if(avg>=70 && avg<80)
		{
			score='C';
		}
		if(avg>=60 && avg<70)
		{
			score='D';
		}
		if(avg<60)
		{
			score='F';
		}
		// 출력
		System.out.println("=====결과값=====");
		System.out.println("국어 점수 :" +kor);
		System.out.println("영어 점수 :" +eng);
		System.out.println("수학 점수 :" +math);
		System.out.println("총점 :" +(kor+eng+math));
		System.out.printf("평균 :%.2f\n",(kor+eng+math)/3.0);
		// printf는 붙여서 출력하기 때문에 \n (new line)을 붙여줘야 다음 줄에 출력한다.
		// => \n => new line 
		// => \t => tab => 일정간격을 띈다
		System.out.println("학점 :"+score+"학점");
	}

}
