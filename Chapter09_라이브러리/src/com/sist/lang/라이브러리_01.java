package com.sist.lang;
/*
 *	라이브러리 => 자바에서 지원하는 클래스
 *             => J2SC / J2EE
 *                |기본   | 웹에서 사용하는 라이브러리 => servlet-api => JSP
 *             외부에서 지원하는 클래스 => Jsoup/SimpleJSON/CSV/Spring
 *             
 *   => java.lang(자바의 기본클래스) => import를 생략할 수 있다 
 *     = Object **
 *     = String **
 *     = Math 
 *     = System
 *     = StringBuffer
 *     = Wrapper : 데이터형을 클래스화해서 사용이 쉽게 하는 것 
 *       = Integer **
 *       = Double **
 *       = Boolean **
 *       = Float
 *       = Byte
 *       
 *   => java.util => 필수적으로 import를 추가해야 한다 
 *     = Scanner
 *     = Calender / Date** 
 *     = StringTokenizer**
 *     = Collection 
 *       = List : ArrayList**, LinkedList, Vector
 *       = Set : HashSet**, TableSet
 *       = Map : Hashtable, hashMap**
 *       
 *   => java.io => 입출력 관련
 *       = FileInputStream **
 *       = FileOutputStream **
 *       = FileReader **
 *       = FileWriter **
 *       = InputStream
 *       = OutputStream
 *       ----------------
 *       = BufferedReader **
 *       = BufferedWriter
 *       = BufferedInputStream
 *       = BufferedOutputStream
 *   
 *   => java.net
 *       = URLEncoder **
 *       = URLDecoder
 *       = Socket
 *       = ServerSocket
 *       = URL
 *   
 *   => java.sql => 오라클 *** 특히 중요! ***
 *       = Connection **
 *       = Statement **
 *       = ResultSet **
 *   ----------------------------------------------------
 *   => 2차 자바 (웹) => HttpServletRequest / HttpServletResponse / HttpSession / Cookie
 *                    -------------------   -------------------   ----------    -----
 *                    | 브라우저에서 전송한 값을    | 자바에서 브라우저      | 서버에 정보 저장  | 클라이언트 브라우저에 저장 
 *                    | 자바에서 받을 때 사용      | 결과값 전송 
 *                    
 *   *라이브러리 (자바를 사용해서 프로그램을 만들 수 있게 미리 제작한 클래스의 집합)
 *    java.lang, java.util, java.io, java.sql 
 *     => 사용하기 위해서 반드시 import를 사용해서 클래스를 읽어야 한다 (java.lang 제외)
 *     
 *   = java.lang
 *    1. Object 
 *     1) 모든 클래스에 상속을 내린 클래스 (최상위 클래스) => extends Object
 *     2) Object가 가지고 있는 기능 (제공된 메소드) 
 *        = toString() ** => 객체를 문자열로 변환 => 리턴형 String 
 *          원형) public String toString() 
 *          => 문자열 변환 (String) 형변환, toString(), valueOf()
 *        = Clone() ** => 메모리를 복제 (새로운 메모리 생성) 
 *                     참조 => 같이 공동으로 사용 
 *                  => 메모리 주소 이용 (배열,클래스)
 *                  => 아바타
 *        = finalize() : 소멸자 => 메모리에서 해제 => 자동으로 호출
 *        = 객체 비교 : equals()
 *        = -------  hashCode() ** 
 *                   
 *     
 */
import java.util.*;
public class 라이브러리_01 {
	
	public static void main(String[] args) {
	  int[] arr1= {10,20,30};
		int[] temp1=arr1; // 참조 => 같은 주소를 제어하면 동시에 변경이 된다 => 별칭을 준 것 
		System.out.println("/////////// 참조 이용 ////////////");
		System.out.println("======arr======");
		System.out.println(Arrays.toString(arr1));
		System.out.println(arr1);
		System.out.println("======temp======");
		System.out.println(Arrays.toString(temp1));
		System.out.println(temp1);
		System.out.println("======temp 변경======");
		temp1[0]=100;
		temp1[1]=200;
		temp1[2]=300;
		System.out.println("======temp======");
		System.out.println(Arrays.toString(temp1));
		System.out.println("======arr======");
		System.out.println(Arrays.toString(arr1)); 
		// 같은 메모리 공간을 제어 => 참조 (같은 메모리)
		// 메소드를 통해서 데이터를 변경할 때 ==> Call By Reference (메모리 주소에 의한 참조)
		System.out.println("/////////// 클론 이용 ////////////");
		int[] arr= {10,20,30};
		int[] temp=arr.clone(); // 메모리 복제 (새로운 메모리 생성) 
		System.out.println("======arr======");
		System.out.println(Arrays.toString(arr));
		System.out.println(arr);
		System.out.println("======temp======");
		System.out.println(Arrays.toString(temp));
		System.out.println(temp);
		System.out.println("======temp 변경======");
		temp[0]=100;
		temp[1]=200;
		temp[2]=300;
		System.out.println("======arr======");
		System.out.println(Arrays.toString(arr));
		System.out.println("======temp======");
		System.out.println(Arrays.toString(temp));
	}

}
