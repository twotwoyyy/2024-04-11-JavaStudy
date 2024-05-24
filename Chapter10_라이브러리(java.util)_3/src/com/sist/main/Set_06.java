package com.sist.main;
/*
 *	ArrayList / HashSet / HashMap
 *  
 *  
 *  ArrayList : 중복 있이 경우
 *  HashSet : 중복 없이 저장
 *  HashMap : 두 가지 동시에 저장 (키:값)
 *  ====> 자료 구조 : 데이터 저장, 데이터 수정, 데이터 추가, 데이터 삭제, 데이터 검색 가능 
 *                 ---------------------------------------------------
 *                 자바 : 컬렉션 (여러 개 수정 => 관리)
 *        => 데이터 수정, 삭제, 검색은 데이터를 찾을 수 있는 "구분자"가 반드시 필요하다 
 *      구분자) 
 *           ArrayList : 인덱스 번호 (중복 o)
 *           Set       : 데이터 자체 (중복 x)
 *           Map       : key (중복 x, value는 중복 o)
 *      
 *      ArrayList<String> list=new ArrayList<String>(); ==> x
 *      *List<String> list=new ArrayList<String>(); ==> 권장
 *       상위 클래스를 사용 => 공통으로 된 메소드를 사용할 수 있도록 
 *       
 *       인터페이스가 공통 기반 
*             Collection 
 *                |
 *       --------------------------
 *       |          |             |
 *     List       Set           Map
 *       |
 *    ArrayList  HashSet       HashMap
 *    LinkedList TreeSet       Hashtable
 *    Vector
 *    ===> List : MyBatis , JPA 
 *                -------------
 *    => 개발자 선호 
 *       --------
 *       ArrayList<String> list=new ArrayList<String>() ==> X
 *       
 *       List<String> list=new ArrayList<String>();  ==> O
 *       List<String> list=new Vector<String>();
 *       List<String> list=new LinkedList<String>();
 *       
 *       Set<String> list=new HashSet<String>()
 *       Set<String> list=new TreeSet<String>()
 *       
 *       프로그램 단점 
 *         => 개발자마다 다르다 
 *            ------------
 *            for => while = do~while 
 *            -----------------------
 *            
 */
public class Set_06 {

	public static void main(String[] args) {
	}

}
