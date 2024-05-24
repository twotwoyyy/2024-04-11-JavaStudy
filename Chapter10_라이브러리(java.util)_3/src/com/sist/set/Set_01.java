package com.sist.set;
//345page
/*  
 *	         Set : 인터페이스
 *           ---
 *            |
 *     ----------------
 *     |              |
 *   HashSet        TreeSet
 * 접근 속도 빠름      검색 속도 빠름
 *  
 *  특징) 
 *    1. 순서가 없다 (인덱스 존재 x)
 *    2. 데이터 중복을 허용하지 않는다 
 *     => DISTINCT (오라클)
 *    3. 주요 메소드
 *      add() => 데이터 추가
 *      remove() => 데이터 삭제
 *      clear() => 데이터 전체 삭제
 *      *** 데이터를 한번에 모아서 관리 : iterator() ***
 *   주 사용처)
 *      ----- ArrayList에 존재하는 데이터의 중복을 제거할 때 주로 사용한다 
 *       => 객체는 중복 제거가 어렵다 => 같은 메모리 주소를 이용하기에
 *        따라서 equals() 재정의 해야지만 가능
 *        
 *      
 */
import java.util.*;
public class Set_01 {

	public static void main(String[] args) {
		// 장르별 / 부서명 / 상품명 ....
		Set<String> set=new HashSet<String>();
		// 저장 장소 선언 10개
		set.add("사과");
		set.add("배");
		set.add("체리");
		set.add("수박");
		set.add("메론");
		set.add("참외");
		set.add("사과"); // 중복
		set.add("배"); // 중복
		set.add("오렌지");
		set.add("딸기"); 
		System.out.println("===== 저장된 내용 출력 =====");
		// HasSet은 index 번호가 없기 때문에 반드시 for-each 이용
		for(String f:set) {
			System.out.print(f+" "); 
			// 중복된 데이터는 저장이 안된다 따라서 8개만 저장
			// 순서가 없다
		}
	}

}
