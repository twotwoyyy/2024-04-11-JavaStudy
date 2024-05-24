package com.sist.main;

import java.util.Arrays;

/*
 *	자바에서 지원하는 클래스의 집합 => 라이브러리 (완제품 => 특별한 경우가 아니면 그대로 사용)
 *  => 운영체제와 연결 => API (Application Program Interface)
 *  => 분류 : 패키지 => 관련된 클래스끼리 모아서 제공 
 *     *java.lang : 자바의 기본 클래스 => import를 생략할 수 있다 
 *       Object : 최상위 클래스 => 모든 클래스에 상속을 내려주는 클래스
 *                extends Object 
 *                --------------
 *                객체와 관련된 기능(메소드)을 제공
 *                = 메모리 할당시 주소값 확인 : toString 
 *                = 객체 사용시 복제해서 사용 : clone() => 주로 Spring에서 사용: prototype 
 *                           -- 새로운 메모리를 만들어서 사용이 가능하게 한다
 *                = 객체 소멸자, 메모리 해제시 호출되는 함수 : finalize()
 *                = 객체 메모리 주소를 리턴 => 필요시 변경 가능 : hashCode()
 *                = 객체 비교 : equals()
 *                *** Object가 가지고 있는 기능은 모든 클래스에서 사용 가능 
 *                    ------------- 필요시에는 오버라이딩을 해서 사용 가능하다 
 *                                         --------- 메소드 내용을 변경 => toString(), hashCode()
 *       String : 문자열을 저장하는 클래스
 *         String s=""
 *         String s=new String("") => 새로운 메모리에 저장해서 사용, 한글 변환 코드
 *         C 언어    자바 언어
 *         -----    ------
 *          ASC     Unicode => 모든 각국의 언어 사용이 가능 (2byte)
 *        => c언어에서는 한글이 깨진다 (알파벳,숫자만 사용 가능) 한글 사용시 : 포인터 (1byte)
 *        
 *              Encoding : %EC%9E%90%EB%B0%94
 *          자바  ===> 브라우저 (C언어)
 *              <====   
 *              Decoding : 자바
 *          기능(메소드)
 *           1. 문자 개수 : length()
 *           2. 문자를 있는 그대로 가지고 오기 : toString()
 *           3. 문자 변환 : replace(), replaceAll()
 *           4. 문자 위치 찾기 : indexOf(), lastIndexOf()
 *           5. 문자 제어 (자르기) : substring(), split()
 *           6. 공백 문자 제거 : trim()
 *           7. 모든 데이터형을 문자열 변환 : valueOf()
 *           8. 비교 : equals()
 *           9. 검색 : startsWith(), endsWith(), contains()
 *            => 웹의 핵심 
 *              1) 문자열 제어
 *              2) 데이터베이스 연동 
 *              ----------------- => 웹 프로그램 (92%)
 *        
 *       StringBuffer : 문자열 결합 (속도 빠름)
 *         append()
 *       
 *       Math : 수학과 관련 
 *         ceil() : 올림 함수
 *         random() : 난수 발생 => Random 클래스 이용이 더 편하다
 *       
 *       System
 *         exit() : 프로그램 종료
 *         gc() : 메모리 회수 
 *       
 *       Wrapper : 제네릭스에서 사용
 *         = Integer : parseInt() 문자열을 정수로 변환
 *         = Double : parseDoble() 문자열을 실수로 변환
 *         = Boolean : parseBoolean() 문자열을 논리형 변환 
 *         
 *     *java.util : 프로그램 사용시 유용하게 사용할 수 있게 만든 클래스의 집합
 *       Random : 난수 발생
 *         nextInt() => nextInt(100) => 0~99 
 *       Date : 메소드(기능)이 없다 Date date=new Date(); => 오라클 날짜 데이터와 호환 
 *       Calendar : Date에 없는 기능 첨부 
 *         Calendar cal=Calendar.getInstance();
 *         추상 클래스로 되어 있다 / new 사용할 수 없다  
 *         요일 구하기, 마지막날 구하기, 예약/예매 => 달력
 *         
 *       StringTokenizer : 문자열을 단어별로 분리할 때 주요 사용
 *         nextToken() : 단어 하나씩을 읽어 올 때 사용한다
 *         countToken() : 분리된 단어 개수 확인 
 *         hasMoreTokens() : 반복문 수행  
 *    -------------------------- **제네릭 (데이터형 변경 => Object 형변환) <클래스명>
 *                                  => 단점: 기본형은 사용할 수 없다 
 *                                     ---------- 각 데이터형마다 클래스를 지원 (Wrapper)
 *       ArrayList 
 *        중복된 데이터가 있는 경우 
 *        순서가 있어 인덱스 번호가 자동 조절 
 *        구분자 : 인덱스 번호 
 *          add() : 추가
 *          set() : 수정
 *          remove() : 삭제
 *          clear() : 전체 삭제 
 *          size() : 저장 개수
 *          get() :읽기
 *        ArrayList가 여러 개 있는 경우
 *          retainAll() : 같은 값(교집합)
 *          removeAll() : 다른 값(차집합)
 *          addAll()    : 뒤에 전체 데이터를 추가, 데이터 복사 
 *          subList()   : 부분 데이터 복사 
 *         
 *       HashSet
 *        중복이 없는 데이터
 *        순서가 없기에 원하는 순서대로 출력이 안되는 경우도 있다 
 *        중복 제거하려면 list로 변경해서 사용
 *        구분자 : 자체 값 
 *          add() : 추가
 *          clear() : 삭제
 *          iterator() 반복자
 *          
 *       HashMap
 *       
 *     java.text : 변환 (숫자, 날짜 변환) 
 *       DecimalFormat : format()
 *         DecimalFormat df=new DecimalFormat("###,###,###,###"); 오라클 => 9,999,999
 *       SimpleDateFormat : format()
 *         SimpleDateFormat sdf=new SimpleDateFormat("");
 *           년도 : yyyy
 *           월 : MM/M
 *           일 : dd/d
 *           시간 : hh/h
 *           분: mm/m
 *           초: ss/s
 *    -----------------------------------------
 *     java.io   : 입출력 (메모리, 파일, 네트워크) 
 *     java.net  : 네트워크 프로그램 개발 
 *     java.sql  : 데이터베이스 프로그램 개발  
 *    -----------------------------------------
 */
import java.net.*;
public class 라이브러리_정리 {

	public static void main(String[] args) throws Exception{
		//System.out.println(Arrays.toString("자바".getBytes()));
		String s=URLEncoder.encode("자바","UTF-8");
		System.out.println(s);
		s=URLDecoder.decode(s,"UTF-8");
		System.out.println(s);

	}
}
