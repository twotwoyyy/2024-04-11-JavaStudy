package com.sist.util;
/*
 *	컬렉션 => 데이터 관리 (배열 보완) 
 *   : 배열의 메모리 크기 고정이라 추가, 삭제가 어려운 단점을 보완 
 *   
 *   
 *   = 종류 
 *     1) 데이터 중복 가능 여부 
 *        데이터 중복 허용 : List => ArrayList 
 *        데이터 중복 불가 : Set 
 *     2) 인덱스 이용 여부 
 *        인덱스 사용 => ArrayList 
 *        실제값 사용 => HashSet
 *        key 사용  => HashMap (key는 중복을 허용하지 않는다) 
 *     ** 데이터 관리 
 *        "구분자"가 반드시 필요!! 
 *    = List
 *      단방향 포인트를 가지고 있다 
 *      수정, 삭제가 없는 프로그램을 제작 (데이터 베이스용) 
 *      데이터를 모아서 브라우저에 전송 목적 
 *      조회가 간편하다, 검색이 빠르다, 추가시에 맨뒤에 추가하면 속도가 빠르다 
 *    
 *    = Map
 *      관리 (쿠키,세션,클래스)
 *      
 *    = Set 
 *      중복 제거 => DISTINCT
 *      코딩 테스트, 웹소켓 
 *    --------------------------------------------------------  
 *     
 *     
 */
public class 컬렉션_정리_01 {

		public class TryCatchFinallyExample {
			public static void main(String[] args){
		    	String[] strArray = { "10" , "2a" };
		        int value = 0;
		        for(int i = 0; i <= 2; i++ ){
		        	try{
		            	value = Integer.parseInt(strArray[i]);
		            } catch(ArrayIndexOutOfBoundsException e){
		            	System.out.println("인덱스를 초과했음");
		            } catch(NumberFormatException e) {
		            	System.out.println("숫자로 변환할 수 없음");
		            } finally {
		            	System.out.println(value);
		            }
		        }
		    }
		}

	}

