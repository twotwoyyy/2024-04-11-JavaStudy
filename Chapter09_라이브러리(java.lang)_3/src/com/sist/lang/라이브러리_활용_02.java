
package com.sist.lang;
import java.util.*;
// 변수 = 데이터
// --- 데이터와 같거나 작은 경우엔 형변환 
//		int a=(int)10.0;
public class 라이브러리_활용_02 {

	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		//배열의 단점을 보완 => 가변성
		list.add("홍길동"); //0
		list.add("심청이"); //1
		list.add(100); //2
		list.add(10.5); //3
		list.add(true); //4
		
	  //String name=list.get(0); // 리턴형이 Object라 형변환 해주어야한다
		String name=(String)list.get(0); // 리턴형이 Object라 형변환 해주어야한다
		double d=(Double)list.get(3);
		//기본형에 클래스 넣기 => 언박싱 
		int a=(int)10.0; //

	}

}
