package com.sist.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// 정렬
// Collection.sort()
public class 컬렉션_06 {

	public static void main(String[] args) {
		//  <> => 제네릭 : 반드시 클래스만 지정이 가능 
		// <int> <double> => 오류 
		// <Integer> <Double>
		ArrayList<Integer> list=new ArrayList<Integer>();
		// 정수 = 10
		Random r=new Random();
		for(int i=0;i<10;i++) {
			// 오토박싱 => Integer i=10 
			list.add(r.nextInt(100)+1);//1~100
		}
		System.out.println("========= list 데이터 출력 ==========");
		// 언박싱 int a=1
		for(int i:list) {
			System.out.print(i+" ");
		}
		System.out.println("\n========= list 데이터 정렬 ==========");
		Collections.sort(list); //정렬 
		for(int i:list)
		{
			System.out.print(i+" ");
		}

		ArrayList<Integer> list2=new ArrayList<Integer>(list.subList(0, 5));
		// list에 있는 데이터 5개만 복사
		System.out.println("\n======== 5개 복사된 데이터 출력 ========");
		for(int i:list2) {
			System.out.print(i+" ");
		}
		// 다섯개 추가 
		list2.add(r.nextInt(100)+1);
		list2.add(r.nextInt(100)+1);
		list2.add(r.nextInt(100)+1);
		list2.add(r.nextInt(100)+1);
		list2.add(r.nextInt(100)+1);
		
		System.out.println("\n========= list2 모든 데이터 출력 ==========");
		for(int i:list2) {
			System.out.print(i+" ");
		}
		System.out.println("\n========= list2 정렬 ==========");
		Collections.sort(list2);
		
		for(int i:list2) {
			System.out.print(i+" ");
		}
	}

}
