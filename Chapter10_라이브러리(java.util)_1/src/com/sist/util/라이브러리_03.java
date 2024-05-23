package com.sist.util;
/*
 *	java.lang 제외 모두 import 
 */
import java.util.*;
// 한 개를 사용할 때는 impor java.util.Scanner
// 두 개 이상 나올 때는 *
public class 라이브러리_03 {

	public static void main(String[] args) {
		Random r=new Random();
		for(int i=1;i<=10;i++) {
			System.out.print(i+"번 학생 학점: ");
			int score=r.nextInt(5)+1; //1~5
			switch(score) {
			case 1:
				System.out.println('A');
				break;
			case 2:
				System.out.println('B');
				break;
			case 3:
				System.out.println('C');
				break;
			case 4:
				System.out.println('D');
				break;
			case 5:
				System.out.println('F');
				break;
			}
		}
	}

}
