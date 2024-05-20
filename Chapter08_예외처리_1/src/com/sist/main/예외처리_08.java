package com.sist.main;
// finally
/*
 *	예외처리
 *	try
 *  {
 *    정상 수행하는 코드 
 *    => 에러 발생할 수도 있음 
 *  }catch(예외처리 클래스)
 *  {
 *    => 에러에 대한 대비 => 사전에 에러 방지 ==> 에러 복구 => 다시 입력 (continue)
 *  }catch(예외처리 클래스)
 *  {
 *    => 에러에 대한 대비 => 사전에 에러 방지 ==> 에러 복구 => 다시 입력 (continue)
 *  }
 *  finally => 생략이 가능 (필요시에만 사용)
 *  {
 *    파일 닫기 / 서버 닫기 / 오라클 닫기 => 닫지 않으면 DDOS 
 *    => try 수행, catch 수행 => 무조건 수행이 된다 
 *  }
 *  
 *  흐름
 *  => 에러가 없는 상태 
 *  문장 1
 *  문장 2
 *  try {
 *    문장 3
 *    문장 4
 *    문장 5
 *  }catch(예외처리 클래스){
 *    문장 6
 *  }
 *  finally{
 *    문장 7
 *  }
 *  
 *  1=>2=>3=>4=>5=>7=>종료
 *  
 *  => 에러가 있는 상태 
 *  문장 1
 *  문장 2 ==> 에러 발생 => 종료 
 *  try {
 *    문장 3
 *    문장 4
 *    문장 5
 *  }catch(예외처리 클래스){
 *    문장 6
 *  }
 *  finally{
 *    문장 7
 *  }
 *  
 *  
 *  => 에러가 있는 상태 
 *  문장 1
 *  문장 2  
 *  try {
 *    문장 3
 *    문장 4 ==> 에러 발생 => catch이동
 *    문장 5
 *  }catch(예외처리 클래스){
 *    문장 6
 *  }
 *  finally{
 *    문장 7 : 에러가 있든 없든 문장을 무조건 수행한다, 필요시에만 사용한다 
 *  }
 *  
 *  1=>2=>3=>6=>7 종료
 *  
 */
public class 예외처리_08 {

	public static void main(String[] args) {
		// 에러가 없는 상태 
		System.out.println("1");
		System.out.println("2");
		try {
			System.out.println("3");
			System.out.println(10/0); // 오류시 catch로 이동 
			System.out.println("5");
			// 수행문장 
		}catch(Exception e) {
			System.out.println("에러 처리 => 6"); //catch절은 error가 있을시에만 수행 
			// 에러 확인 => printStackTrace(), getMessage()
		}finally {
			System.out.println("7"); // 파일 닫기, 오라클 닫기 => 서버 부하가 심하다 
		}
	}
}
