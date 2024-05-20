package com.sist.main;
/*
 *	266page ==> 예외처리 상속도
 *  상위 예외처리 클래스 일수록 예외처리 기능을 많이 가지고 있따
 *  catch 1개로 여러 개를 처리 할 경우 : Exception (모든 예외처리 기능을 가지고 있다) 
 *  실행시 예외 RuntimeException 
 *  
 *    CheckedException : 컴파일시에 예외처리가 있는지 확인 => 반드시 예외처리를 해서 사용
 *    ---------------- 파일 입출력, 오라클 연동, 크롤링시, 네트워크, 웹 (예외처리 필수)
 *    UnCheckedException : 실행시에 예외처리를 처리하기 때문에 생략이 가능하다
 *    ---------------- 문법 사항 
 *    
 *    => 예외처리의 종류 267page
 *     ClassNotFoundException : 클래스를 찾을 수 없는 경우 
 *     ----------- Class.forName("패키지명.클래스명"); => JSP/Spring => CheckedException (반드시예외처리)
 *     IOException : 입출력 => (메모리 입출력, 파일 입출력, 네트워크 입출력)
 *     SQLException : 핵심*** (오라클 실행 => SQL) 
 *     
 *     ----------------------------------------------
 *     InterruptedException : 쓰레드 관련
 *     MalformedURLException : 네트워크 관련 
 *     ------------------------------------- 반드시 예외 처리 (CheckedException)
 *     * RuntimeException (아래 있는 모든 예외를 처리 할 수 있는 기능이 있다) 
 *      = NumberFormatException : 정수 변환 => Integer.parseInt() => 웹, 네트워크, 윈도우(정수 없음, 문자열만 있음)
 *      = ClassCastException : 클래스 형변환 문제 
 *      = ArrayIndexOutOfBoundsException : 배열의 인덱스 초과 
 *      = NullPointerException : 클래스에 주소값이 배정이 되지 않은 상태
 *      = ArithmeticException : 0으로 나눴을 때 오류 
 *      = IllegalArgumentException : 매개변수 값이 다른 값이 전송이 된 경우 : 웹에서 전송 받는 경우 
 *      ---------------------------------------------------------------------------------
 *      catch 1개로 처리 가능 : Exception / Throwable
 *      
 *    
 *    *예외처리의 종류 (모든 프로그램 언어에서 존재, 자바 스크립트, 오라클)
 *     = try ~ catch : 가장 많이 사용되는 예외처리 형식 
 *     = throws      : 라이브러리에 주로 사용된다
 *     
 *     268page
 *     try ~ catch의 형식 
 *     
 *     try{
 *       정상 수행 => 에러가 의심되는 소스 
 *     }catch(예외처리 클래스){
 *       에러가 발생시 처리하는 과정 => 가벼운 에러 (소스에서 수정이 가능한 에러) => 에러 (예외처리에서 처리가 불가능)
 *       에러 : 소스상에서 수정이 불가능한 에러
 *             ex) 브라우저 문제, 메모리 부족... 
 *       예외처리 : 소스상에서 수정이 가능 (잡을 수 있는 가벼운 에러)
 *             ex) 파일명 오류, IP오류, 매개변수 값 전송 오류... 
 *     }
 *     
 *     try ~ catch 
 *     : 부분 사용도 가능하다 (의심되는 영역 처리) 
 *      
 */
public class 예외처리_05 {

	public static void main(String[] args) {
//		try {
//			for(int i=1; i<=10;i++) {
//				int n=(int)(Math.random()*3); // 0,1,2
//				System.out.println(i/n);
//			}
//		}catch(Exception e) {
//			System.out.println("오류 발생:"+e.getMessage());
//			// 어떤 오류가 발생했는지 확인: e.getMessage()
//		}
		for(int i=1;i<=10;i++) {
			try {
				int n=(int)(Math.random()*3);
				System.out.println(i/n); // catch 수행 후 for 증가식으로 이동 => 10바퀴 전부 수행 
			}catch(Exception ex) {
				System.out.println("오류 발생 :"+ex.getMessage());
			}
		}
		// 이처럼 for안에 예외처리 할 수도 있음 특히 크롤링 할 때 많이 쓴다 => 모든 HTML이 동일하지 않다 => 스킵할 수 있게 예외처리 
	}

}
