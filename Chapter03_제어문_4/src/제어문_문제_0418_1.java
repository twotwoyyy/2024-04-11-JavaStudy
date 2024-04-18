/*
 * 1)	100점 만점으로 성적을 입력 받아 90~100이면 A,80~89이면 B,70~79이면 C, 60~69이면 D, 60점 이하면 F를 출력하라 (switch~case 사용)
 * 	switch ~ case : 선택문
 * 	---------------------
 * 	if문의 조건문과 다르게 case를 사용 => case에 사용할 수 있는 것 : 정수, 문자, 문자열 
 * 	=> 값을 한 개 지정
 * 	=> 값이 입력 => switch에 값을 받는다
 * 	   switch(op)
 * 	=> case 처음부터 검색
 * 	=> 해당 문자, 정수를 찾아서 문장을 수행 
 * 	=> case를 찾아서 처리하고 break가 없는 경우에는 break가 존재하는 곳까지 문장을 수행한다 
 * 	   int a=3;
 *     switch(a)
 *     {
 *       case 1:
 *       문장1
 *       case 2:
 *       문장2
 *       case 3: ==> 시작점
 *       문장3
 *       case 4:
 *       문장4
 *       case 5:
 *       문장
 *       break ===> 여기까지 수행됨 문장 3~5까지 수행 
 *     }
 *     
 *     *** 찾은 case부터 break가 있는 case까지 수행 
 *     *** 해당 case가 없는 경우에는 default (생략 가능) => case마다 break를 주는 게 좋음
 *     *** break는 switch~case를 종료
 *     
 *     *** 보통 프로그램에서는 if를 많이 사용한다 
 *     	   경우의 수가 많은 경우에는 switch를 주로 사용한다. (게임,메뉴)
 *     	   => switch가 if보다 간결하다 
 *         => 네트워크 
 *     *** if => 범위가 있는 경우 
 *     *** 값 1개씩 여러 개인 경우 => switch
 */

import java.util.Scanner;

public class 제어문_문제_0418_1 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.print("성적을 입력하세요.(0~100)");
		int num=scan.nextInt();
		System.out.println("성적:"+num);
		switch(num/10)
		{
		case 10: 
		case 9:
			System.out.println("A학점");
			break;
		case 8:
			System.out.println("B학점");
			break;
		case 7:
			System.out.println("C학점");
			break;
		case 6:
			System.out.println("D학점");
			break;
		default:
			System.out.println("F학점");
		}
	}

}
