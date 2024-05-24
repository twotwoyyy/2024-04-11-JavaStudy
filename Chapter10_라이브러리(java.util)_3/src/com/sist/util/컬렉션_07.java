package com.sist.util;
/*
 *  ArrayList
 *  ---------
 *   1. 데이터 중복 허용 (오라클은 데이터 중복 허용) => 0~ (인덱스 번호 순차적으로 만들어준다)
 *      -----------
 *      => 반드시 !구분자! 있어야 함 => 인덱스로 구분
 *      오라클 
 *      => id, 게시물 번호, 영화번호, 장바구니 번호
 *      => 중복이 없는 데이터 첨부 => PRIMARY KEY
 *   2. 기능(메소드) => 라이브러리는 메소드 
 *     1) 추가 => add(데이터)
 *     2) 수정 => set(int index, 데이터)
 *     3) 삭제 => remove(int index)
 *     4) 저장개수 확인 => size() => 댓글, 장바구니...
 *     5) 읽기 => get(int index)
 *     6) 전체 삭제 => clear()
 *     7) 데이터 존재 여부 => isEmpty()
 *   3. ArrayList가 여러 개인 경우 
 *      영화 목록 / 예약 목록 
 *      쇼핑 목록 / 결제 
 *      ------   ---- 상품 번호 / ID 
 *      1. 상품명
 *      2. 가격..
 *      3. 상품번호 
 *      
 *      파일 = 테이블 
 *      ---------------------------
 *      => retailAll() : 교집합
 *      => addAll() : 전체 복사
 *      => removeAll() : 차집합 
 *      => subList() : 부분적 복사 
 *      --------------------------- 오라클에선 JOIN이라고 한다 // SUBQUERY => 여러 테이블 연동 
 *      
 */
import java.util.*;
public class 컬렉션_07 {

	public static void main(String[] args) {
		ArrayList<String> list=new ArrayList<String>();
		list.add("홍길동");
		list.add("홍길동");
		list.add("박문수");
		list.add("이순신");
		list.add("홍길동");
		System.out.println(list);
		System.out.println("현재 저장된 개수:"+list.size());
		list.remove("홍길동");
		System.out.println("현재 저장된 개수:"+list.size()); 
		System.out.println(list);
		//중복이 있는데도 한 개만 삭제된다  
		
	}

}
