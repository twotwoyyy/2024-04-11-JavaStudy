package com.sist.util;
/*337p
 *   컬렉션(Collection)
 *    => 데이터가 많은 경우에 처리가 쉽고 효율적으로 관리할 수 있도록 한다 
 *    => 라이브러리 => 표준화 (모든 개발자가 같은 코딩으로 사용)
 *    => 자료 구조 : 데이터 수정, 데이터 추가, 데이터 삭제, 데이터 읽기 => CRUD
 *    => 배열은 고정적이라 선언과 동시에 저장 개수를 지정 (추가, 삭제가 불가능) => 이를 보완 : 컬렉션
 *    => 배열 보완 => 컬렉션 => 가변형 => 자동 증가, 자동 축소 
 *    => 데이터 관리 => 컬렉션 사용법 숙지, 컬렉션 구조 => 검색 가능
 *     구조) 
 *                                 Collection ===> interface (메소드가 동일)
 *                                     |
 *           -----------------------------------------------------
 *           |                         |                         |
 *          List                      Set                       Map
 *          일자배열                     묶음                     라이브러리 
 *         --------                인터페이스                   두 개를 동시에 저장 
 *         1, 2, 3 ..              데이터 중복이 없다             웹에서 주로 사용한다
 *         --------                검색 가능(데이터)             -----
 *       데이터 중복 허용               인덱스 번호x                 Key : 중복이 불가
 *       데이터 구분을 인덱스로           순서가 없다                  (구분자)
 *       (순서가 존재)                 저장용도로 주로 쓰임           value : 중복이 가능
 *     ** 인덱스는 자동 추가                                       (데이터)
 *       (인덱스 번호 조정)                                      ex) name="홍길동"
 *                                                               key   value 
 *     *구현된 클래스                  *구현된 클래스               *구현된 클래스
 *     ArrayList***                Hashset                  HashMap
 *       데이터 베이스의 저장된             중복 제거                   비동기, Hashtable보완
 *       값을 저장후 브라우저 전송        Treeset                   Hashtabel
 *       (Vector 단점 보완)             검색 => 속도 빠름             동기
 *       웹프로그램에서 주로 사용            Binary search          * 웹관련 저장
 *       비동기적인 방식                                           requset
 *       => 접속 속도 빠르게 개선                                   response
 *       단점) 데이터 순차적 저장 x                                  session
 *       => 정렬 후 저장해 사용                                     cookie
 *       => 오라클에서 정렬                                     
 *          ORDER BY no                                      저장: put(key,value)
 *                                                           읽기: get(key)
 *     Vector
 *       네트워크 접속자 정보 저장                                  
 *       (네트워크 => 서버)
 *       동기적인 방식 
 *       => 접속 속도가 느림
 *       
 *     Stack
 *       LIFO 구조 
 *       변수 저장
 *       사용을 권장하지 않는다
 *       
 *     LinkedList
 *       추가, 삭제가 빠르나
 *       접근 속도가 늦다
 *       C언어 호환
 *        |
 *     Queue
 *       FIFO 구조
 *       네트워크 전송
 *       운영체제 스케줄러
 *      
 * ---------------------------------------------------------------------------------
 *   *오라클 
 *    정렬 : ORDER BY no
 *    데이터 검색(읽기) : SELECT
 *    데이터 추가 : INSERT
 *    데이터 수정 : UPDATE
 *    데이터 삭제 : DELETE
 *    
 *    => ArraysList, HashSet, HashMap ==> 일반 기본값을 저장, 클래스 저장이 가능
 *       모든 데이터 저장이 가능하게 한다 
 *       매개변수 / 리턴형 => Object 
 *       중요!! Object는 모든 데이터의 가장 큰 데이터형이기에 항상 형변환을 해야한다!!! 
 *       필요시에는 매개변수 / 리턴형을 프로그램에 맞게 변경이 가능하게 만든다 => "제네릭"
 *    
 *    *제네릭 : 데이터형을 한번에 통일 (라이브러리 자체 매개변수/리턴형을 한번에 통일)
 *      장점) 간결하다, 가독성이 좋다 (어떤 데이터를 저장해 관리하는지 금방 알 수 있다) 
 *       ex) ArrayList list=new ArrayList() => 무슨 정보 저장하는지 모름
 *         => ArrayList<String> list=new ArrayList<String>() 
 *            : 이 안에 String을 저장하고 있다는 것을 한눈에 알아볼 수 있다 => 가독성 좋다
 *            
 *    자료 구조 : 메모리에서 데이터 관리 
 *      => 추가 : add() => 데이터베이스(오라클) => 데이터 담기
 *      => 삭제 : remove()
 *      => 읽기 : get() => 화면 => 데이터 읽기 => HTML 이용해서 브라우저 출력
 *      => 수정 : set()
 *      => 전체 삭제 : clear()
 *      => 저장 개수 확인 : size() => for를 이용해서 출력 횟수 확인   
 *         -배열은 length
 *      
 */
import java.util.*;
public class 컬렉션_01 {

	public static void main(String[] args) {
		ArrayList list=new ArrayList();
		//ArrayList<String> list=new ArrayList<String>();
		// 문자열만 저장해서 관리 <String>
		// 원래는 add(Object) => 제네릭스 이용 후 add(String) => 사용자 정의 데이터형 
		// => 가급적이면 1개의 데이터형을 저장한다 
		//            --------- 데이터형 통일 : 반복문 수행이 편리하다 
		list.add("홍길동");
		list.add(10);
		list.add(10.5);
		list.add(true);
		list.add('A');
		
		for(int i=0;i<list.size();i++) {
			if(i==0) {
				String name=(String)list.get(i);
				System.out.println(name);
			}
			else if(i==1) {
				int no=(int)list.get(i);
				System.out.println(no);
			}
			else if(i==2) {
				double d=(double)list.get(i);
				System.out.println(d);
			}
			else if(i==3) {
				boolean b=(boolean)list.get(i);
				System.out.println(b);
			}
			else if(i==4) {
				char c=(char)list.get(i);
				System.out.println(c);
			}
		}
		
	}

}
