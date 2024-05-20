package com.sist.main;
/*
 *	문자열 2개 받아서 
 *  정수 배열에 저장 ==> 정수 변환 (사용자 의심), 배열 인덱스 번호 (프로그래머 실수) 
 *  배열 값을 나누기 해서 출력 => 사용자가 나누기 값을 0을 입력한 경우 
 *  --------------------------------------------------
 *  1. 예상되는 에러 3가지
 *  2. 기타 발생 => 4개 
 *  --------------------------------------------------
 *  1. 사전에 에러 방지할 수 있는 프로그램 제작 
 *     -----------------------------
 *     웹 => 사용자 => 사이트에서 오류 발생하면 => 탈퇴 
 *     => 배포 => 의뢰자가 일부러 오류 => 유지하는지 확인 
 *     
 *  2. 조건문으로 가능한지 확인
 *    안되는 경우 예외 처리 => 예상되는 에러를 도출 
 *                       -------------- 
 *                       catch 1개로 처리?
 *                       catch 에러별 처리?
 *                       
 */
import java.util.*;
public class 예외처리_06 {

	public static void main(String[] args) {
		try {
			String s1="3";
			String s2="0";
			int n1=Integer.parseInt(s1);
			int n2=Integer.parseInt(s2);
			int[] arr= {n1,n2};
			System.out.println(arr[0]/arr[1]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("배열 범위 초과");
		}catch(NumberFormatException e) {
			System.out.println("정수 변환 오류");
		}catch(ArithmeticException e) {
			System.out.println("0으로 나눌 수 없다");
		}catch(Exception e) {
			System.out.println("예상하지 못한 에러 발생"); //가장 큰 에외처리를 마지막에 두면서 처리 => 예상치 못한 에러 잡아준다 
			
			// 멀티블록 
		}
	}

}
