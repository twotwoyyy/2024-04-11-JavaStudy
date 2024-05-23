package com.sist.util;
/*
 *	제네릭
 *  ClassName<클래스명>
 *            ----- Object를 지정한 <클래스명>으로 변경한다 
 *  ex) A<Integer>
 *   = 데이터형을 통일화 : 리턴형, 매개변수를 한번에 변경 => 프로그램에 맞게 => 변경해서 사용 
 *   = ArrayList는 이미 만들어져 있는 상태 
 *                ------------------
 *                프로그래머가 어떤 데이터를 저장할지 모른다 
 *                ------------------------------ 아무 데이터나 관리 => Object 
 *                리턴형/매개변수 => Object 
 *                => Object일 때는 데이터 사용시 형변환을 항상 해서 사용해야 한다 
 *                => 이를 방지 : "제네릭"
 *   = 소스가 간결해진다 (형변환을 하지 않기 때문에) 
 *   = 가독성이 좋다 => 어떤 데이터를 저장했는지 한눈에 확인이 가능하다 
 *   = 컬렉션에서 주로 사용 
 *   
 *   = ArrayList => ArrayList<String> 
 *   = ArrayList<Music>
 *   = ArrayList<Movie> // 어떤 클래스를 관리하는지 눈에 보이게
 *   ---------------------------------------------------------
 *   데이터형을 변경할 수 있는 제네릭
 *   <T> type => class 
 *   <E> element => class
 *   <K> key
 *   <V> value
 *   
 *   class Box<T>
 *   {
 *     T t;
 *     public void setT(T t){
 *      this.t=t;
 *    } 
 *    public T getT(){
 *      return t; 
 *     }
 *   }
 *   ==> Box box=new Box() => T (Object)
 *   ==> Bpx bpx<String> box=new Box<String>()
 *    T => String 
 *    
 *    
 */
class Box<E>{
	E e;
	public void setE(E e) {
		this.e=e;
	}
	public E getE() {
		return e;
	}
}
public class 컬렉션_제네릭_01 {

	public static void main(String[] args) {
		//Box box=new Box();
		// 현재는 E => Object 
		// E => String 으로 바꿔라
		Box <String>box=new Box<String>();
		// E => String 
	}

}
