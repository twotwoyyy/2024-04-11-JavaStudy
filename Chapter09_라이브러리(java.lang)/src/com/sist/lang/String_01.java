package com.sist.lang;
/*
 *	String: 문자열 관리 => char[]을 제어 
 *          => 오버라이딩 X, 있는 그대로 써야한다 
 *          => 종단 클래스 (final) => 상속이 불가능한 클래스 
 *             ---------------
 *             Math,System,StringBuffer,Wrapper
 *             
 *  => String에 문자열을 저장하는 방법 
 *     일반 기본형처럼 사용
 *      String s=""; 
 *     객체 생성
 *      String s=new String("") => 한글 코드 변환 
 *     *** 문자열은 자체가 메모리 주소 
 *         ------------------- 
 *     ex) "Hello" => 이 자체가 메모리 주소 => {'H','e'...}
 *     String s1="Hello"    
 *     String s2="Hello"
 *     s1==s2 => true  ====>   ' == ' 은 메모리 주소값 비교할 때 사용, 
 *                             'equals()' 은 실제 저장된 문자열을 비교 !!! 
 *                             
 *  => 기능 (메소드)
 *   1. public char charAt(int index) : 원하는 위치의 문자 한 개를 가지고 올 때 사용 
 *      문자열은 char[] => index 번호는 0부터 시작한다
 *       "Hello Java"
 *        0123456789 
 *        charAt(6) => 'J'
 *        
 *   2. length() : 문자열의 개수를 가져올 때 사용
 *      public int length()
 *       "Hello Java"
 *       length() => 10개 (영문이나 한글이나 동일, 공백 포함)
 *      ex) ..., 비밀번호 확인, MMS 
 *      
 *   3. toUpperCase() / toLowerCase()
 *      대문자로 변환       소문자로 변환 
 *      public String toUpperCase()
 *      public String toLowerCase()
 *      => 한글 사용 
 *   ---------------검색------------------- 
 *   4. startsWith() : 시작 문자열이 같을 때 검색 
 *      public boolean startsWith(String start)
 *       => 서제스트를 만드는 경우에 주로 사용
 *          ----- 자동완성기
 *       => cookie 저장 => cookie 읽기
 *          문자열만 저장이 가능 
 *       => 방문한 맛집 찾기, 레시피 찾기 
 *          food_        recipe_
 *       => ^A (정규식) , A% (오라클)
 *       
 *   5. endsWith() : 끝 문자열이 같을 때 검색
 *      public boolean endsWith(String end)
 *      => 확장자 찾기
 *      => 그림 파일 gif,jpg,png,bmp ...
 *      => A$ (정규식) , %A (오라클) 
 *     
 *   6. contains() : 포함된 단어, 문자열 (검색)
 *      public boolean contains(String s)
 *      => 검색, 사이트에 나오는 모든 검색 
 *      => [A] (정규식), %A% (오라클)
 *   
 *   7. equals() : 문자열이 같을 때, 대소문자 구분
 *      public boolean equals(String e)
 *      => 주로 사용 : 로그인, 아이디 찾기... 
 *      *** equalsIgnoreCase() : 대소문자 구분하지 않는다 
 *   
 *   8. indexOf() : 앞에서부터 찾기 (일반문자열)
 *      public int indexOf(찾는 문자,문자열)
 *   
 *   9. lastIndexOf() : 뒤에서부터 찾기 (경로명,확장자)
 *      public int lastIndexOf(찾는 문자,문자열)
 *      ---------------변경------------------- 
 *  10. replace() : 문자나 문자열을 변경
 *      => 오버로딩이 되어있다
 *      public String replace(char c1, char c2)
 *      public String replace(String s1, String s2)
 *      c1/s1 를 c2/s2로 변경 
 *      => 크롤링 => 오라클에 저장할 때 자주 사용 
 *        오라클에서 ||(문자열 결합), &(Scanner) 
 *      
 *  11. replaceAll() : 정규식 이용 
 *                     -------- 문자 형태
 *      ex) 맛있다 맛있고 맛있는 .. 
 *          => 맛있+ 으로 한번에 찾을 수 있다 
 *      데이터
 *       = 정형화된 데이터 => 프로그램에 필요한 데이터만 수집 (데이터베이스 안에 저장)
 *       = 반정형화 데이터 => 구분 => HTML/XML/JSON 
 *       = 비정형화 데이터 => 구분이 없는 데이터 (트위터, facebook)
 *         ----------> 정형화 (빅데이터) => 통계, 분석 
 *     public String replaceAll(String regex(정규식), String 변경문자열)
 *      ex) ABCDEFG한글입니다
 *          replace([A-Z],"") => 영어 공백으로, 영어 지우기 // 한글은 [가-힣] 숫자[0-9]
 *  
 *  12. substring() : 문자열을 자르는 경우에 사용
 *      public String substring(int start)
 *       "Hello Java"
 *              ----
 *        0123456789 => substring(6) => 6부터 잘라온다 => Java
 *      public String substring(int start,int end)
 *       "Hello Java"
 *          ---
 *        0123456789 => substring(2,5) => llo 
 *                      *** end-1 : 맨 마지막 번호는 포함이 안 된다!! 그래서 무조건 +1 
 *  
 *  13. valueOf() : 모든 데이터형을 문자열로 변환 (static !!!) 
 *      public static String valueOf(Object o)
 *      public static String valueOf(int o)
 *      public static String valueOf(double o)
 *      public static String valueOf(float o)
 *      public static String valueOf(boolean o)
 *      => String s="Hello Java";
 *         s.length() / s.subString() ..
 *         그러나 valueOf()는 static이기에 //String.valueOf(10) => "10"//
 *         
 *  14. split() : 구분자별로 문자열을 잘라서 배열에 저장 
 *      public String[] split(String regex(정규식)) 
 *      
 *  15. trim() : 좌우의 공백 제거
 *      public String trim()
 * ----------------------------------------------------------자바 스크립트 동일 
 *     
 *        
 */
public class String_01 {

	public static void main(String[] args) {
		// 문자열 저장 공간 만들기 
		String s1="Hello";
		String s2="Hello";
		//같은 문자열을 다른 메모리에 저장 
		String s3=new String("Hello");
		
		System.out.println("\"==\" 사용, 메모리 주소값 비교");
		if(s1==s2) {
			System.out.println("s1과 s2는 같다");
		}
		else {
			System.out.println("s1과 s2는 다르다");
		}
		if(s1==s3) {
			System.out.println("s1과 s3는 같다");
		}
		else {
			System.out.println("s1과 s3는 다르다");
		}
		System.out.println("\"equals\" 사용, 저장된 문자열 비교");
		if(s1.equals(s2)) {
			System.out.println("s1과 s2는 같다");
		}
		else {
			System.out.println("s1과 s2는 다르다");
		}
		if(s1.equals(s3)) {
			System.out.println("s1과 s3는 같다");
		}
		else {
			System.out.println("s1과 s3는 다르다");
		}
		
	}

}
