package com.sist.set;
import java.util.*;
public class Set_04 {

	public static void main(String[] args) {
		//System.out.println(("심청이"+20).hashCode());
		//System.out.println(("심청이"+20).hashCode());
		// 변수값이 같은 경우 => 같은 객체 => hashCode()를 이용해서 처리
		// 같은 학생인지 확인할 수 있다 
		
		// tailSet => ~이상
		// headSet => ~이하 
		Set<Integer> set=new HashSet<Integer>();
		Random r=new Random();
		for(int i=0;i<10;i++) {
			int k=r.nextInt(100)+1;
			set.add(k);
			System.out.print(k+" ");
		}
		System.out.println("\n저장된 개수 확인:"+set.size()+"개");
		TreeSet<Integer> set2=new TreeSet<Integer>();
		set2.addAll(set);
		// 개수 중 50이상
		System.out.println("===50이상 출력 ===");
		System.out.println(set2.tailSet(50));
		/*for(int i:set) {
			if(i>=50) 
				System.out.print(i+" ");
		}*/
		System.out.println("\n===50이하 출력 ===");
		System.out.println(set2.headSet(50));
		/*for(int i:set) {
			if(i<50) 
				System.out.print(i+" ");
			
		}*/
		
	}

}
