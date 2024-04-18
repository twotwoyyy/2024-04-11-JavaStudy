/*
 * 5) 100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D,
   60점 이하면 F를 출력하라 (if 사용
   
   if => 단독 수행 문장 => if마다 조건을 검색
   		=> 전체 범위 설정 

 */
import java.util.Scanner;
public class 제어문_문제_0417_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("성적 입력(100점 만점):");
		// 입력하기 싫으면 int score=(int)(Math.random()*101); 랜덤 주면 된다 
		int jumsu=scan.nextInt();
		System.out.println("======결과값======");
		if(jumsu<=100 && jumsu>=90)
		{
			System.out.println(jumsu+"은(는) A학점입니다.");
		}
		if(jumsu<=89 && jumsu>=80)
		{
			System.out.println(jumsu+"은(는) B학점입니다.");
		}
		if(jumsu<=79 && jumsu>=70)
		{
			System.out.println(jumsu+"은(는) C학점입니다.");
		}
		if(jumsu<=69 && jumsu>=60)
		{
			System.out.println(jumsu+"은(는) D학점입니다.");
		}
		if(jumsu<60)
		{
			System.out.println(jumsu+"은(는) F학점입니다.");
		}
	}

}
