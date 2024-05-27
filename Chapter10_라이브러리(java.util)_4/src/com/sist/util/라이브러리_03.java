package com.sist.util;
/*
 *   데이터를 묶어서 한번에 처리 
 *    *** iterator
 *     = haseNext() => 위에서부터 아래로 처리 
 *     = next()
 *     = remove()
 *     = hasProvious() => 아래부터 위로 올라가서 처리
 *     
 *      Iterator은 단방향, 재출력이 불가, 한 번만 출력할 수 있다
		소진이 되면 없어진다 => 재출력하려면 재선언을 해야 한다 
 *     
 */
// Set/ Map => 크롤링 시에 사용 
import java.util.*;
public class 라이브러리_03 {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("홍길동");
		list.add("심청이");
		list.add("박문수");
		list.add("이순신");
		list.add("강감찬");
		
		System.out.println("===== 일반 형식 출력 =====");
		for(String name:list) {
			System.out.println(name);
		}
		System.out.println("===== 일반 형식 재출력 ====");
		for(String name:list) {
			System.out.println(name);
		}
		System.out.println("===== Iterator 출력 =====");
		Iterator<String> it=list.iterator();
		while(it.hasNext()) { // it에 존재하는 개수만큼 출력 // next() => 데이터를 가지고 온다
			System.out.println(it.next());
		}
		System.out.println("===== Iterator 재출력 =====");
		while(it.hasNext()) { // it에 존재하는 개수만큼 출력 // next() => 데이터를 가지고 온다
			System.out.println(it.next());
		} // Iterator은 단방향, 재출력이 불가, 한 번만 출력할 수 있다
		  // 소진이 되면 없어진다
		System.out.println("===== 다시 출력 =====");
		Iterator<String> it2=list.iterator();
		while(it2.hasNext()) {
			System.out.println(it2.next());
		}
		// 다시 출력하려면 다시 선언해야 한다 
		System.out.println("==== ListIterator ====");
		ListIterator<String> it3=list.listIterator();
		while(it3.hasNext()) {
			System.out.println(it3.next());
		}
		
	}

}
