package com.sist.util;
// StringTokenizer : 문자열 분리
/*
 *	nextToken() : 분리된 데이터를 가지고 오는 경우 
 *  hasMoreToken() : 분리된 토큰 개수(데이터)만큼 루프 돌릴 때 사용 
 *  counterToken() : 분리된 개수가 몇개인지 확인할 때 사용
 */
import java.util.*;
public class 라이브러리_06 {

	public static void main(String[] args) {
		String colors="red,green,blue,black,white,yellow,magenta,pink,gray";
		StringTokenizer st=new StringTokenizer(colors,",");
		// 뒤에 구분자가 없으면 공백 별로 자른다 
		System.out.println("color의 개수:"+st.countTokens()); // 개수 몇 개인지 
		/*System.out.println(st.nextToken()); // 분리된 데이터 가져오기 
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());
		System.out.println(st.nextToken());*/
		while(st.hasMoreTokens()) { // 루프 돌릴 때 사용
			System.out.println(st.nextToken());
		}
		
		/*
		 *	hasMoreTokens() => 이미지 => 전체 분리된 데이터를 가지고 올 때 
		 *  
		 *  susor------------------------
		 *         before / first
		 *       ------------------------
		 *         red => st.nextToken() => true
		 *       ------------------------
		 *         green => st.nextToken() => true
		 *       ------------------------
		 *         blue => st.nextToken() => true
		 *       ------------------------
		 *       ...
		 *       ------------------------
		 *         after / last st.nextToken() => false 종료
		 */
	}

}
