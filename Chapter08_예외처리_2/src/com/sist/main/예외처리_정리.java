package com.sist.main;
/*
 *	예외처리가 필요한 곳
 *   => 컴파일시에 예외처리가 되어있는지 확인
 *   ------------------------------ 반드시 예외처리 후에 사용 (메소드) => CheckedException
 *   java.io / java.sql / java.net / javax.http.servelet 
 *   
 *   => 예외처리를 확인하지 않는 곳 UnCheckedException 
 *      java.lang => 예외처리가 필수가 아니다 (생략가능) 
 *      그러나 사용자의 에러가 많이 발생하는 위치에는 예외처리를 하는 것이 좋다
 *           ------------------------
 *           | 사용자 입력창
 *           | 나의 입력 => TextField ==> 받는 경우 int
 *             -----------------------------------
 *  
 *   => try ~ catch ~ finally
 *   => throws가 있는 경우 어떻게 처리 
 *   --------------------------- Exception < Throwable 
 *      throws Exception => 모든 예외처리 클래스 포함 
 *      try
 *      {
 *      }catch(Exception e){}
 *      
 *      ** 상속이 있는 경우에는 => 상위 클래스가 하위 클래스보다 크다 
 *         --- 위로 올라갈 수록 크다 
 *         
 *     try는 내가 원하는 위치에서 사용이 가능하다 
 *      for()
 *      {
 *        try
 *        {
 *        }catch(){}
 *      }
 *   
 */
public class 예외처리_정리 {

	public static void main(String[] args) {

	}

}
