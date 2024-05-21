package com.sist.main;
import java.util.*;
// Exception / RuntimeException 
// => CheckedException UnCheckedException 
class MinusException extends Exception{ // Exception 상속을 받으면 예외처리 전체 처리  
	public MinusException(String msg) {
		super(msg);
	}
}
public class 예외처리_03 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("양수만 입력>>");
		int no=scan.nextInt();
		try {
			// catch는 자바에서 제공하는 예외 클래스는 인식 => 사용자 정의는 인식 하지 못한다 
			// => 따라서 에러를 임의로 발생 => throw
			if(no<0) { // 에러 발생이 아니다, 일부로 발생 
				throw new MinusException("음수는 사용 불가!!"); // new를 통해 호출!! 
				//throw 사용자정의 에외처리 할 때 많이 사용 
				//catch절을 호출한다 
			}
		}catch(MinusException e) {
			System.out.println("에러메세지:"+e.getMessage());
			System.out.println("===== 에러 발생 위치 ======");
			e.printStackTrace();
		}
	}

}
