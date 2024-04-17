/*
 *  6) 100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D,
 *     60점 이하면 F를 출력하라 (다중조건문 사용)
 */

import java.util.Scanner;

public class 제어문_문제_0417_6 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("성적 입력(100점 만점):");
		int jumsu=scan.nextInt();
		System.out.println("======결과값======");
		if(jumsu<=100 && jumsu>=90)
		{
			System.out.println(jumsu+"은(는) A학점입니다.");
		}
		else if(jumsu<=89 && jumsu>=80)
		{
			System.out.println(jumsu+"은(는) B학점입니다.");
		}
		else if(jumsu<=79 && jumsu>=70)
		{
			System.out.println(jumsu+"은(는) C학점입니다.");
		}
		else if(jumsu<=69 && jumsu>=60)
		{
			System.out.println(jumsu+"은(는) D학점입니다.");
		}
		else
		{
			System.out.println(jumsu+"은(는) F학점입니다.");
		}

	}

}
