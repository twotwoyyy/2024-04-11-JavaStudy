package com.sist.lang;
/*
 *	Wrapper : 모든 기본형 데이터형을 클래스화 시켜서 사용이 쉽게 한다 (기능 부여) 
 *  ------- 
 *  *Integer : int 
 *   문자열 => 정수로 변환
 *   Integer.parseInt(String) 
 *  *Double  : double
 *   문자열 => 실수로 변환
 *   Double.parseDouble(String)
 *  *Boolean : boolean
 *   문자열 => 논리형으로 변환
 *   Boolean.parseBoolaen(String) 
 *   Float   : float
 *   Byte    : byte
 * ---------------------------------------
 *   오토박싱 
 *   Integer i=10;
 *   언박싱 (기본형에 객체명 넣기)
 *   int ii=i;
 *   
 *   Integer/int 교환이 가능 
 *   
 *   제네릭스 : 데이터형을 변경 => 이미 만들어져있는 라이브러리의 데이터형 변경
 *                         --------------------------------
 *                         메소드의 리턴형 / 매개변수
 *          => 등록할 때 클래스만 가능 
 *          <데이터형>
 *          <int> (X) => <Integer>
 *          => 라이브러리 매개변수/리턴형이 변경할 수 있다 => 형변환 없이 사용 
 */
class A<T>{ // T 임시변수 여기다 String을 넣으면 데이터형 바뀜 
	T t;
	public T getT() {
		return t;
	}
	public void setT(T t) {
		this.t=t;
	}
}
public class Wrapper_01 {

	public static void main(String[] args) {
		Integer i=100;
		System.out.println(i);
		int ii=i;
		System.out.println(ii);
		// 형변환 없이 사용가능 
		
		String s="1000";// 웹에서 자바로 보내는 모든 정수는 문자열
		System.out.println(Integer.parseInt(s)+1);
		A<String>a=new A<String>();
		
		
	}
}
