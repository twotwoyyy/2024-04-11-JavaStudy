package com.sist.util;
import java.util.*;
public class 라이브러리_05 {

	public static void main(String[] args) {
		// 배열의 크기 => 작은 배열, 큰 배열 => 고정 (한번 지정하면 변경 불가) 
		// 변경이 있는 경우에는 새로운 배열을 만들어서 처리 => copyOf
		Random r=new Random();
		int[] arr=new int[7];
		//초기화
		for(int i=0;i<arr.length;i++) {
			arr[i]=r.nextInt(100)+1;
		}
		System.out.println(Arrays.toString(arr));
		// 배열 => 작게 생성 => 값은 arr에 있는 데이터 그대로 저장 => 3 
		int[] sub=new int[3];
		for(int i=0;i<sub.length;i++) {
			sub[i]=arr[i];
		}
		System.out.println(Arrays.toString(sub));
		
		//////////// copyOf /////////////
		int[] sub2=Arrays.copyOf(arr, 3); 
		System.out.println(Arrays.toString(sub2));
		
		int[] sup=new int[10];
		for(int i=0;i<arr.length;i++) {
			sup[i]=arr[i];
		}
		System.out.println(Arrays.toString(sup));
		
		///////// CopyOf ////////////
		int[] sup2=Arrays.copyOf(arr, 10);
		System.out.println(Arrays.toString(sup2));
		
		// Arrays => toString() , sort(), copyOf() => 326page 
	}

}
