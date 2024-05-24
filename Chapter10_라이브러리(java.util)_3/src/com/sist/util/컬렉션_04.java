package com.sist.util;
import java.util.*;
public class 컬렉션_04 {
	//sublist 부분적 복사!! (인기순위)
	public static void main(String[] args) {
		ArrayList<String> names1=new ArrayList<String>();
		names1.add("홍길동");
		names1.add("박문수");
		names1.add("이순신");
		names1.add("강감찬");
		names1.add("심청이");
		System.out.println("===== names1 출력 =====");
		for(String name:names1) {
			System.out.println(name);
		}
		ArrayList<String> names2=new ArrayList<String>();
		names2.add("홍길수");
		names2.add("박문수");
		names2.add("이순신");
		names2.add("강찬수");
		names2.add("춘향이");
		System.out.println("===== names2 출력 =====");
		for(String name:names2) {
			System.out.println(name);
		}
		System.out.println("===== 데이터 복사 =====");
		ArrayList<String> temp=new ArrayList<String>();
		temp.addAll(names1); // 전체 데이터 추가, 다른 컬렉션에 있는 것을 가져올 때
		for(String name:temp) {
			System.out.println(name);
		}
		System.out.println("===== 교집합 출력 ====="); // 오라클 => INTERSECT => JOIN(INNER JOIN)
		temp.retainAll(names2); // 교집합을 가져와라 
		for(String name:temp) {
			System.out.println(name);
		}
		System.out.println("===== 차집합 출력 ======"); // 오라클 => MINUS => OUTER JOIN (LEFT,RIGHT)
		// 차집합은 누구를 기준으로 하냐에 따라 다르다 
		ArrayList<String> temp2=new ArrayList<String>();
		temp2.addAll(names1);
		temp2.removeAll(names2);
		names1.removeAll(names2);
		for(String name:names1) {
			System.out.println(name);
		}
		/*
		 *  1 2 3 4 5 => A
		 *  3 5 7 8 9 => B
		 *  
		 *  A와 B의 교집합 => 3 5 => retainAll()
		 *  A-B 차집합 => removeAll() 
		 *  --- A만 가지고 있는 데이터 
		 */
		ArrayList<String> names3=new ArrayList<String>(names1.subList(0, 3));
		//sublist 부분적 복사!! (인기순위)
		/*                                            ------------0~2까지라는 소리(3개) 
		 *                                             자바는 항상 마지막 번호는 제외!!! 
		 *   홍길동 0
		 *   박문수 1
		 *   이순신 2 
		 *   강감찬 3
		 *   심청이 4
		 * 
		 */
		System.out.println("===== 부분적 카피 subList(시작 인덱스:끝+1인덱스)=====");
		for(String name:names3) {
			System.out.println(name);
		}
		// JOIN
		
	}
}
