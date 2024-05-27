package com.sist.util;
/*
 *   java.util
 *   => 가장 많이 사용되는 라이브러리 
 *   => 난수 : Random => 정수, 지정된 범위
 *           1) 객체 생성 
 *            Random r=new Random()
 *           2) 난수 발생
 *            r.nextInt(100) => 맨 마지막 수는 제외 => 0~99
 *   => 날짜 : Date => 기능 없다, 오라클/MySQL에서 전송하는 날짜를 받는 경우 (데이터 베이스 호환)
 *           Calendar => 기능 부여 (요일, 마지막 날짜 구하기 => 달력 제작)
 *   
 *   => 데이터 관리 : 컬렉션(자료 구조) 
 *      데이터를 쉽고 효율적으로 관리할 수 있게 표준화된 라이브러리 : 컬렉션 프레임워크 
 *      단점) Object=> 모든 데이터를 저장해서 관리할 수 있게 만들어져 있어 형변환 후에 사용해야하며
 *           어떤 데이터가 첨부되어 있는지 모른다 (가독성이 떨어진다) => 이를 보완 : 제네릭
 *        제네릭: 형변환 없이 사용, 가독성 좋게 만든다
 *              소스가 간결하다, 데이터형을 통일화 시킨다 
 *              <클래스형> => 기본형은 사용할 수 없다 => Wrapper를 제공 
 *              Wrapper 기본형을 클래스화 !! (parse~)
 *              int = Integer (parseInt())
 *              double = Double (parseDoulbe())
 *              booleaan = Boolean (parseBoolean()) 
 *              => 기본형 사용 가능, 기본형에 기능 부여
 *              => 웹이나 윈도우 => 기본형만 사용 가능 => String을 기본형으로 변경 가능 
 *              제네릭을 쓰지 않으면 모든 메소드의 리턴형과 매개변수가 Object 
 *              Object를 프로그램에서 필요한 데이터형으로 한번에 변경 
 *              => 사용자 정의도 가능하다 
 *     컬렉션 클래스 종료
 *                    Collection : interface
 *                         |
 *        --------------------------------------------------------
 *              |                            |                   |
 *             List                         Set                 Map
 *  ArrayList  Vector  LinkedList    HashSet  TreeSet    HashMap  Hastable
 *                        Queue
 *                        
 *    컬렉션 : 데이터 관리 (메모리)
 *           ---------------
 *           1. 읽기(데이터를 가지고 온다)
 *           2. 추가
 *           ----------------------
 *           3. 수정
 *           4. 삭제
 *           5. 검색
 *           ---------------------- 데이터 구분자 
 *                                  ---------
 *                                 *List: 인덱스
 *                                    set(int index,추가할 데이터)
 *                                    remove(int index)
 *                                 *Set : 실제 저장된 데이터가 구분자
 *                                        인덱스 번호가 없다 => 중복이 있으면 안된다
 *                                 *Map : 키   
 *                                        키,값을 쌍으로 저장
 *                                        키는 중복이 없다 / 값은 중복 허용
 *                                 *오라클 : primary key => 중복이 없는 데이터
 *                                         -----------
 *                                       ex) id => 회원가입 : id 중복 체크
 *                                           번호 (자동 증가 번호)
 *                        
 *     1) List 
 *      특징 
 *       1. 순서를 가지고 있다 (인덱스=자동처리) => 순차적으로 저장
 *       2. 중복 데이터 저장을 허용
 *       3. 주로 사용자 => 데이터베이스 (오라클) *****웹은 데이터 베이스가 핵심이다
 *       4. 구현된 클래스
 *         ArrayList : 비동기화 처리 => 데이터베이스(오라클)에 저장된 데이터를 읽어서 브라우저에 전송
 *           비동기화 - 계속 저장만, 순서가 없이 읽어오는 대로 저장            
 *           (장점) 속도가 빠르다 
 *         Vector : 동기화 
 *           동기화 - 저장이 완료가 되면 다음 저장 : 네트워크의 접속자 정보 (IP,PORT) 
 *           (단점) 속도가 느리다 
 *         LinkedList / Queue / Stack : 사용빈도가 거의 없다
 *       5. ArraList/Vector/LinkedList는 List라는 인터페이스를 구현
 *          => 메소드가 동일 (표준화)
 *          => 주요기능 (메소드)
 *             add() : 추가 ***
 *             remove() : 삭제 
 *             set() : 수정
 *             get() : 읽기 ***
 *             size() : 저장된 개수 확인 *** 
 *             isEmpty() : 데이터의 존재 여부 ***
 *             clear() : 전체 삭제 ***
 *         
 *     2) Sat
 *       특징 
 *        1. 순서를 가지고 있지 않다
 *        2. 중복 데이터 저장을 허용하지 않는다 
 *        3. 구현된 클래스
 *        ***HashSat : 중복 없는 데이터를 저장, 웹에서 채팅을 할 때 => 접속자 관리
 *                     add(), remove(), clear(), isEmpty() 
 *           TreeSat : 검색 속도가 빠르다 => 애플리케이션에서 많이 쓴다 
 *        
 *     3) Map
 *       특징
 *        1. key, value를 동시에 저장한다 
 *           ---------- 우편번호 (우편번호, 실제 주소)
 *           key : 중복이 불가능
 *           value : 중복이 가능
 *           Map<K,V>
 *            = K => key
 *            = V => value
 *            = T => type
 *            = E => element
 *           ArrayList<E> 
 *           Vector<E>
 *           Set<E>
 *           
 *           1) 사용처 
 *              = Spring : 클래스 저장(사용자)
 *                ------ 클래스 관리 (생성~소멸)
 *              = 웹 : 전송 / 응답 / 저장 (클라이언트, 서버) => Cookie / Session 
 *              = ?id=admin
 *              = MyBatis : 키(id), 값(sql)
 *           2) 주요 기능 
 *              = put() : 저장 put(키,값)
 *              = get() : 읽기 get(키)
 *              = clear() : 전체 삭제
 *           3) 순서가 없다 
 *              = 키 : 구분자로 사용
 *              = 값 : 모든 값을 설정할 수 있다
 *              
 *              
 *     -----------------------------------------------------
 *      ArrayList가 여러 개 있는 경우 
 *      = 차집합 removeAll() => MINUS
 *      = 교집합 retainAll() => INTERSECT
 *      = 합집합 addAll()    => UNION
 *     ---------------------------> 오라클 : JOIN
 *                                  ---- 오라클은 로직이 없다 (제어문이 없다) : 명령문이 많다
 *                                                                    ---- SQL PL~SQL
 *     
 *     4) Properties
 *      
 *   
 *   java.text
 *   => 변환 
 *     날짜 변환 : SimpleDateFormat => format() 
 *               패턴 => new SimpleDateFormat("yyyy-MM-dd") yyyy/MM/DD
 *                      년도 : yy/yyyy
 *                      월  : MM/M
 *                      일  : dd/d
 *                      시  : hh/h
 *                      분  : mm/m
 *                      초  : ss/s
 *     숫자 변환 : DecimalFormat => format()
 *               패턴 => new DecimalFormat("###,###,###") => 오라클 (9,999,999)
 *               
 *  
 */
import java.util.*;
public class 라이브러리_01 {

	public static void main(String[] args) {
		Map<String,String> map=new HashMap<String, String>();
		// ket,value값이 String으로 들어간다는 뜻 => key는 보통 String (구분)
		// 값을 저장 => put
		map.put("id", "damin");
		map.put("password", "1234");
		map.put("name", "홍길동");
		map.put("sex", "남자");
		map.put("age", String.valueOf(20));
		map.put("password", "4567"); // 이것을 출력 
		// => key는 중복을 허용하지 않기에 중복되면 덮어쓴다 Cookie 
		// 값을 읽기 map.get(키)
		/*System.out.println("아이디:"+map.get("id"));
		System.out.println("비밀번호:"+map.get("password"));
		System.out.println("이름:"+map.get("name"));
		System.out.println("성별:"+map.get("sex"));
		System.out.println("나이:"+map.get("age"));*/
		Set<String> s=map.keySet(); // 키만 저장 => Set이용 : 중복을 허용하면 안되기 때문이다 
		for(String ss:s) {
			// Object로 받게 되면 String 변환을 해줘야 하기에 제네릭 쓰는 게 편하다
			//String key=(String)ss;
			System.out.println(ss+":"+map.get(ss));
		}
		// Set은 순서가 없기 때문에 무작위로 값을 가져온다 
		// 가급적이면 출력시 List 이용 (순차적) 
		// Map은 클래스 관리시 많이 이용한다 
	}

}
