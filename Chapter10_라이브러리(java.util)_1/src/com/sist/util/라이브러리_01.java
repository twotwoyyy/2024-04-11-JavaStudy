package com.sist.util;
/*
 *	라이브러리 : 자바에서 지원하는 클래스의 집합 
 *                        ---------- 관련된 클래스 모음 (패키지)
 *  1. java.lang : import 사용하지 않음 (생략 가능)
 *     => Object : 최상위 클래스 => 모든 클래스(사용자 정의)의 상속을 내리는 클래스 
 *        기능(메소드)
 *          toString() : 객체를 문자열화
 *          clone() : 복제 (새로운 메모리 생성) => prototype
 *          equals() : 객체 비교 
 *          finalize() : 소멸자
 *          hashCode() : 객체 주소값을 반환
 *     => String : 문자열을 저장하는 데이터형
 *        웹에서 가장 많이 사용되는 데이터형
 *        기능(메소드)
 *          length() : 문자의 개수 확인 (리턴형 int)
 *          equals() : 실제 저장되어 있는 문자열 비교 (대소문자 구분)
 *          substring() : 문자열을 자르는 경우 => 화면 UI => CSS /...으로 자를 때
 *          trim() : 좌우의 공백을 제거, 사용자 입력값을 받을 때 자주 사용 (실수 방지)
 *          valueOf() : 모든 데이터형을 문자열로 변환
 *          replace(), replaceAll() : 문자 변환
 *          indexOf(), lastIndexOf() : 문자나 문자열의 위치 찾기
 *     => StringBuffer : 임시 저장 장소를 만들어서 문자열 결합시 최적화 (속도)
 *          append() : 문자열 결합
 *     => Math : 수학 연산
 *          random() : 임의 추출
 *          ceil() : 올림 함수 
 *     => System : 운영 체제와 연결 
 *          print,printf,println() : 출력
 *          gc() : 메모리 해소
 *          exit() : 프로그램 종료  
 *     => Wrapper : 기본 데이터형 (int,long,double..)을 쉽게 사용할 수 있도록 기능 부여
 *        문자열 변환시 자주 사용 
 *          int => Integer ===> Integer.parseInt()
 *          double => Double ==> Double.parseDouble()
 *          boolean => Boolean => Boolean.parseBoolean()
 *          byte => Byte
 *     
 *     라이브러리 공부법: 
 *      1) 어떤 클래스의 메소드를 갖고 있는지 
 *      2) 원형을 반드시 공부 => 리턴형, 매개변수는 무엇인지 (static,instance)
 *      3) 어떤 기능을 가지고 있는지 
 *      4) 사용처가 어딘지
 *      
 *      
 *  2. java.util
 *     = 클래스를 사용하기 위해서는 반드시 import 사용한다 
 *     = 프로그램에 많이 유용하게 사용할 수 있는 클래스의 집합
 *     날짜 관련
 *      Date : 기능이 거의 없다 (오라클에서 저장된 날짜를 읽어와 저장)
 *      Calendar : 날짜 관련 기능 Date에서 추가된 것 
 *     문자열 분해
 *      StringTokenizer => 단어별 추출 (split()이 배열이라 제어하기 어렵다는 단점 보완) 
 *     자료구조 => ***데이터를 저장해서 쉽게 관리 => 배열 x => 배열 단점 보완 => Collection
 *      Collection : interface, 이들은 모두 CRUD가 가능 (추가,수정,삭제,읽기) 
 *        = List 
 *           ArrayList ** 
 *           LinkedList
 *           Vector
 *           Stack / Queue
 *        = Set
 *           HashSet **
 *           TreeSet
 *        = Map (Spring/Mybatis에 많이 쓰임)
 *           HashMap ** 
 *           Hashtable
 *     --------------------------------------------------------
 *     
 *     List
 *      1. 중복을 허용한다
 *      2. 순서가 존재 => 인덱스 번호 
 *      3. 데이터베이스의 데이터를 저장해서 브라우저로 전송할 때 많이 쓴다 
 *       형식) 
 *          ---------
 *           0 데이터 
 *          ---------
 *           1 데이터 
 *          ---------
 *           2 데이터
 *          ---------
 *     
 *     Set
 *      1. 중복을 허용하지 않는다 
 *      2. 순서가 존재하지 않는다 => 인덱스 번호 X
 *      3. 중복을 제거할 때 주로 사용 => ex) 장르/카테고리 읽어올 때 중복 제거 
 *       형식) 
 *          ---------
 *           데이터 1
 *          ---------
 *           데이터 2
 *          ---------
 *           데이터 3
 *          ---------
 *     Map
 *      1. 키와 값을 동시에 저장 (키,값으로 구성된다)
 *      2. 키는 중복될 수 없고 값은 중복이 허용
 *      3. 세션 ("id","hong"), 브라우저에서 자바로 요청값 전송, 쿠키, 클래스 등록
 *       형식)
 *          --------------
 *           키     값
 *          --------------
 *           id    hong
 *          --------------
 *           pwd   1234
 *          --------------
 *           
 *           
 *     ----- 라이브러리 => 표준화 
 *     
 *  3. java.text
 *  4. java.io
 *  5. java.net : 데이터 수집 => 크롤링 
 *  6. java.sql : 오라클 연동
 *  
 *  String / ArrayList / Integer => 웹에서 가장 많이 사용하는 3대 클래스 
 */
//323page => Random 
//Random => 임의로 추출 => 정수
/*
 *  정수 => nextInt() => 정수형 전체 => 0~21억 4천
 *         nextInt(10) => 0~9 (마지막 숫자는 제외) 
 */
import java.util.*; //Random 
public class 라이브러리_01 {

	public static void main(String[] args) {
		Random r=new Random();
		int num=r.nextInt(10); // 0~9 => 사이의 정수를 임의로 추출 
		System.out.println(num);
		//A~Z (10개 발생) => 26
		
		for(int i=1;i<=10;i++) {
			char c=(char)(r.nextInt(26)+65); // 0=> A
			System.out.print(c+" ");
		}
		System.out.println();
		for(int i=1;i<=6;i++) {
			int lotto=r.nextInt(45)+1; // 1~45
			System.out.print(lotto+" ");
		}
	}

}
