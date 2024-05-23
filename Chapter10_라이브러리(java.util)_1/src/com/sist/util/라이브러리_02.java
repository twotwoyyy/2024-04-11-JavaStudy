package com.sist.util;
import java.util.*;
// UpDownGame
public class 라이브러리_02 {

	public static void main(String[] args) {
		// 1. com 난수 발생 1~100
		Random r=new Random();
		int com=r.nextInt(100)+1;
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.print("1~100 사이 숫자 입력: ");
			int user=scan.nextInt();
			
			if(user<1 || user>100) {
				System.out.println("범위를 벗어났습니다!!");
				continue; // 처음부터 다시 실행 => while(조건식), for(증가식) 
			}
			// 힌트
			if(com>user) {
				System.out.println("Up!!");
			}
			else if(com<user) {
				System.out.println("Down!!");
			}
			else {
				System.out.println("정답입니다!!");
				break;
			}
		}
		// 2. user 입력값 받아 => 난수 맞히는 게임 => 힌트 
	}

}
