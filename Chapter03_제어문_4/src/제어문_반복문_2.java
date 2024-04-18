/*
 * 		단을 입력을 받는다
 * 		=> 구구단 출력
 * 
 * 	단 >> 2
 * 	2 * 1 = 2 
 *  ..
 *  2 * 9 = 18 => 1~9까지 증가 9바퀴 돌려야 함 
 *  1) 반복 횟수
 *  2) 어디부터 어디까지 출력 
 *     -----  -----
 *     초기값   조건식  => int i=1;i<=9,i++
 *     
 */
import java.util.Scanner;
public class 제어문_반복문_2 {

	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.println("단을 입력하세요:");
		int dan=scan.nextInt();		
		for(int i=1;i<=9;i++) //한 개씩 증가=> 1부터 9까지만 수행 => 종료 
		{
			// 시작점 종료점 => 출력 횟수(증감)
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		}
	}

}
