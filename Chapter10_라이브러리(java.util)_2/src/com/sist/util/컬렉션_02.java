package com.sist.util;
import java.util.*;
public class 컬렉션_02 {

	public static void main(String[] args) {
		ArrayList list=new ArrayList();
	//  add(Object)
		list.add(100);
		list.add("홍길동");
		list.add('A');
		list.add(true);
		list.add(10.5);
		// 어떤 데이터든 집어 넣을 수 있다 => 그러나 관리가 어렵고 반복문 쓰기 어렵다 
		// 반복문은 패턴이 있어야 하기 때문이다 
		// 가급적 동일한 데이터형을 저장해 사용하는 것이 좋다 
		int a=(int)list.get(0);
		String name=(String)list.get(1);
		char c=(char)list.get(2);
		boolean b=(boolean)list.get(3);
		double d=(double)list.get(4);
		// 형변환이 부담스럽다면 338page => 제네릭 
		
		
	}

}
