package com.sist.main;
/*
 *	try절 ==> 정상수행이 가능한 문장, 1개만 사용 가능
 *  catch절 => try안에 문장을 수행하는 과정에서 에러가 발생할 시에 처리하는 문장, 여러 개 사용 가능 
 *            예외 처리 클래스의 순서가 있다 (크기)
 *            ---------------------------
 *            크기 : 상속에 따라 달라진다 => 위로 올라갈 수록 에러 처리의 기능이 많다 
 *       ex) Exception > RuntimeException > NumberFormatException, NullPointerException, ClassCastException ...
 */
import java.util.*;
//class A{
//	
//}
//class B extends A{
//	
//}
public class 예외처리_04 {

	public static void main(String[] args) {
		try {
//			A a=new A();
//			B b=(B)a; // 오류 발생 => ClassCastException 
//		}catch(RuntimeException e) { // 큰 거로 잡아주면 아래는 쓸 필요가 없다 		
		}catch(ArithmeticException e) {// 0으로 나눌 때 에러 처리
			
		}catch(ArrayIndexOutOfBoundsException e) { // 배열범위 초과시에만 처리
			
		}catch(NumberFormatException e) { // 문자열을 정수로 변환할 때 오류 처리
			
		}catch(RuntimeException e) {
			// 아래에 쓰면 된다 
		}
		System.out.println("프로그램 종료!");
	}

}
