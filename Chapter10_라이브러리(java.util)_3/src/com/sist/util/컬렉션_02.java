package com.sist.util;
import java.util.*;
public class 컬렉션_02 {

	public static void main(String[] args) {
		ArrayList<String> names=new ArrayList<String>();
		//추가
		names.add("정지나");
		names.add("김수빈");
		names.add("민다진");
		names.add("김다영");
		names.add("김영철");
		
		//출력
		System.out.println("===== 저장 데이터 출력 =====");
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("===== 마지막 데이터 추가 후에 인덱스 확인 =====");
		// 추가 => 마지막에 추가를 해야 속도가 빠르다 
		names.add("김다인");
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		// 추가
		System.out.println("===== 지정된 위치에 추가 =====");
		// add() => 오버로딩 ==> add(String), add(int index,String)
		names.add(3, "정세현"); // 인덱스 3번에 추가, 뒤에 있는 데이터는 인덱스가 한 칸씩 밀린다
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("===== 데이터 수정 =====");
		// set (int index, String) 수정
		names.set(1, "김수빈 수정");
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		// 3번째 수정
		System.out.println("===== 3번째 수정 =====");
		names.set(3, "정세현 수정");
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("===== 데이터 삭제 =====");
		names.remove(2); // 자동으로 값 변경 
		for(int i=0;i<names.size();i++) {
			String name=names.get(i);
			System.out.println(i+":"+name);
		}
		System.out.println("현재 인원:"+names.size()+"명");
		System.out.println("===== 전체 삭제 =====");
		names.clear();
		System.out.println("현재 인원:"+names.size()+"명");
	}
}
