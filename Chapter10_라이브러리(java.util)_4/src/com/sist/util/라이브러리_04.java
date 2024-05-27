package com.sist.util;
import java.util.*;
/*
 *    1. ArrayList
 *    -----------
 *    2. HashSet
 *    3. HashMap
 *    ----------- Iterator 주로 이용
 */
public class 라이브러리_04 {

	public static void main(String[] args) {
		Set<String> set=new HashSet<String>();
		set.add("사과");
		set.add("배");
		set.add("수박");
		set.add("오렌지");
		set.add("메론");
		
		Iterator<String> it=set.iterator();
		// Iterator 이용해 출력하는 것이 좋다 => set/map // list는 주로 for-each
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
