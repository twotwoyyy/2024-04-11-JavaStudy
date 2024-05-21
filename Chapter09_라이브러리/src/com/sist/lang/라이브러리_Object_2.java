package com.sist.lang;
import java.util.*;
class Sawon{
	private String name;
	private String sex;
	// 메소드를 통해 접근이 가능하게 만든다 (읽기/쓰기) get/setter => 변수 은닉화 메소드를 통해 접근 (캡슐화)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	// this는 Sawon의 객체 => 지역변수 우선순위이기 때문에 this를 사용해야 한다 
    // 지역변수명 = 멤버변수가 같은 경우에 => 구분 => this를 이용한다 
    // 변수가 같을 수 있다 => 멤버변수=Heap, 지역변수=Stack  
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	// toString() => 오버라이딩 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "이름:"+name+",성별:"+sex;
	}
	// toString() => default (메모리 주소 출력)
	// 오버라이딩 시켜서 이름, 성별 출력하도록 바꿈 
	// Object에서 오버라이딩은 toString이 가장 많다 => 멤버변수 값 확인 
	// 문자열 변환 => 자바에서 지원하는 메소드의 리턴형이 대부분 Object로 되어 있다
	// 클래스 저장 => Object 
}
public class 라이브러리_Object_2 {

	public static void main(String[] args) {
		/*Sawon s=new Sawon(); // 메모리에 name,sex가 저장됨
		s.setName("홍길동");
		s.setSex("남자");
		System.out.println(s);// 주소값 (자동으로 toString 호출)
		System.out.println(s.toString()); // toString() 생략이 가능 */
		ArrayList <Sawon> list=new ArrayList<Sawon>(); // <Sawon> 데이터형 통일 : 제네릭스 
		list.add(new Sawon());
		list.add(new Sawon());
		list.add(new Sawon()); // add가 Object 
		
		
	}

}
