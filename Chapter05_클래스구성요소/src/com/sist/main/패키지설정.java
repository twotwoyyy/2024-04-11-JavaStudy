package com.sist.main;
import java.util.*; // util => 여러 개의 클래스 사용 => Scanner / Calander 
// 한 개만 불러올 때 import.util.클래스이름;
import static java.lang.Math.random; //static 클래스 불러올 때 
import static java.lang.Math.max;
import static java.lang.Math.min;
public class 패키지설정 {

	public static void main(String[] args) {
		int a=(int)(random()*100)+1;
//		int a=(int)(Math.random()*100)+1; // import를 주고 일반 함수처럼 줄여 쓸 수 있다
		int b=(int)(random()*100)+1;
		System.out.println("최대값:"+max(a,b));
		System.out.println("최소값:"+min(a,b));
	}

}
