package com.sist.main;
/*
 *	멀티 예외처리 
 *  ---------
 *  catch 여러 개 사용 => catch (1개로 통합)
 *  
 */
public class 예외처리_04 {
	// throws 뒤에 있는 예외가 예상이 된다 => 사용시에는 예외처리 후에 사용해라 => 대처하기 쉽다
	// 처리는 개발자에게 맡긴다 => 떠맡기기 
	
	public void display() throws NumberFormatException,NullPointerException,ArithmeticException{
		
	}
	
	public void print() throws NumberFormatException,NullPointerException,ArithmeticException{
		display();
	}
	
	public void print2() throws Exception {
		display();
	}
	
	public void print3() {
		try {
			
		}catch(NumberFormatException e) {}
		 catch(NullPointerException e) {}
		 catch(ArithmeticException e) {}
	}
	///////////////////////////////
	public void print4() {
		try {
			display();
		}catch(Exception ex) {}
	}
	///////////////////////////////
	public void print5() {
		try {
			display();
		}catch(NumberFormatException | NullPointerException | ArithmeticException e) {}
	}
	// => throws (알림) => 알림, 직접처리가 가능하다
	// try => 직접 처리 => 알림을 줄 필요가 없다 
	public static void main(String[] args) throws Exception{
		Thread.sleep(1000);

	}

}
