package com.sist.util;
/*
 *	ArrayList
 *    => add(), remove(), set(), size(), get(), isEmpty(), clear()
 *    => ArrayList는 한 개만 저장 
 *    => 두 개 이상인 경우 => JOIN (연결해서 가져와야 한다)
 *    => retainAll() : 두 개 리스트 중 같은 값 가져오기 (교집합) 
 *       addAll() : 전체 데이터를 복사
 *       removeAll() : 한쪽에 없는 데이터만 출력
 *       subList() : 부분 가져오기, 부분 복사
 *       asList() => 배열 => ArrayList로 변경 
 *     --------------------------------------- 교재에 없는 내용!!
 */
import java.util.*;
public class 컬렉션_05 {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		list.add("E");
		// addAll => Set => 복사가 가능
		for(String s:list)
			System.out.println(s);
		
		// asList 클래스는 첨부가 불가능 => 기본형 / String만
		ArrayList<String> list2=new ArrayList<String>(Arrays.asList("A","B","C","D","E"));
		for(String s:list2)
			System.out.print(s+" ");
	}

}
