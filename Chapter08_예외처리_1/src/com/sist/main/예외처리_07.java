package com.sist.main;
// 에러메세지 => 출력 
/*
 *	에러 확인
 *	getMessage() : 에러 내용만 출력
 *	printStackTrace() : 에러 위치 확인 (권장사항)
 *  ----------------------------------------  
 */
public class 예외처리_07 {
	String msg;
	class A{
		
	}
	class B{
		
	}
	public static void main(String[] args) {
		try {
//			int a=Integer.parseInt(" 10"); // 정수 변환 => 공백이 있으면 안됨 
			int[] arr=new int[2];
			arr[0]=10;
//			arr[2]=20; // index 초과 => 0,1 
//			System.out.println(10/0);
			예외처리_07 a=new 예외처리_07();
			String s=a.msg.concat("Java"); // concat : 문자열 결합 
			// NullPointerException
			
			System.out.println(s);
		}catch(Exception ex) {
			// Exception 자바에서 지원하는 모든 오류 처리가 가능 => Throwable : Error도 출력 => 웹
			ex.printStackTrace();  // 에러 위치 확인
			System.out.println(ex.getMessage()); // 에러 내용만 출력 : sysout 후에 출력 
//          에러가 자주 나는 경우 try~catch
		}
	}

}
