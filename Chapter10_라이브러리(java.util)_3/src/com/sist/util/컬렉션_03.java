package com.sist.util;
import java.util.*;
class Student{
	private int hakbun;
	private String name;
	private int kor,eng,math;
	// 읽기 / 쓰기 기능 추가 => 다른 클래스에서 사용이 가능하게 만든다 
	public int getHakbun() {
		return hakbun;
	}
	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMath() {
		return math;
	}
	public void setMath(int math) {
		this.math = math;
	}
	// 데이터 추가 
	// 매개변수 있는 생성자 => 매개변수를 받는다는 것 => 사용자 입력값을 받아서 초기화 한다는 뜻
	public Student(int hakbun, String name, int kor, int eng, int math) {
    // 생성자 이용 
		this.hakbun = hakbun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	// 매개변수가 있는 생성자가 있다면 디폴트 생성자 하나 만들고 시작하는 게 제어가 편리해서 좋다 
	// 자동으로 디폴트 생성자가 생성이 안되기 때문에 
	public Student() {
		// 여기서 초기화 할 경우 모든 학생 정보가 같은 것이 들어간다 
		// 디폴트 생성자는 동일한 값 초기화가 된다
		// 매개변수를 받는 생성자여야 각각 다른 값이 입력될 수 있다 
	}
	
}
class A{
	int a,b;
	public A() {
		a=10;
		b=20;
	}
	public A(int a,int b) {
		this.a=a;
		this.b=b;
	}
}
/*
 *    A aa=new A(); 
 *    
 *       --aa--
 *       
 *       ------  ----------
 *                 -----
 *                   10  => a
 *                 -----
 *                   20  => b
 *                 -----
 *               ----------
 *     A bb=new A(); 
 *    
 *       --bb--
 *       
 *       ------  ----------
 *                 -----
 *                   10  => a
 *                 -----
 *                   20  => b
 *                 -----
 *               ----------
 *     A cc=new A(100,200);
 *       --cc--
 *       
 *       ------ -------------
 *                 ------
 *                   100 => a
 *                 ------
 *                   200 => b
 *                 ------
 *              -------------
 *      A dd=new A(1000,2000);
 *       --dd--
 *       
 *       ------ -------------
 *                 ------
 *                   1000 => a
 *                 ------
 *                   2000 => b
 *                 ------
 *              -------------
 */
public class 컬렉션_03 {

	public static void main(String[] args) {
		ArrayList<Student> list=new ArrayList<Student>();
		// Object를 Student 변경
		list.add(new Student(1,"정세현",98,80,76));
		list.add(new Student(2,"민기찬",83,70,75));
		list.add(new Student(3,"염혜진",92,70,77));
		list.add(new Student(4,"양성주",77,72,80));
		list.add(new Student(5,"김다영",78,80,70));
		System.out.println("===== 데이터 출력 =====");
		// 배열 / 컬렉션 => for-each를 이용해서 출력
		/*
		 *  %d => 정수
		 *  %s => 문자열
		 *  %c => 문자
		 *  %f => 실수 
		 *  
		 *  %-3d
		 *  000
		 *  1--
		 *  -는 왼쪽 정렬
		 *  %3d
		 *  000
		 *  --1
		 *  +는 오른쪽 정렬
		 *  
		 *  %-5s
		 *  홍길동--
		 *  (홍길동하고 두 칸 띄기)
		 */
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),
					std.getEng(),std.getMath());
			// 웹 => String.format
			// ex) STring.format("%-3d%-5s%-5d%-5d%-5d\n")
		}
		System.out.println("===== 데이터 추가 1 =====");
		// Student 객체 추가
		Student s=new Student();
		s.setHakbun(6);
		s.setName("강감찬");
		s.setKor(78);
		s.setEng(90);
		s.setMath(60);
		list.add(s);
		
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),
					std.getEng(),std.getMath());
		}
		// 아래가 훨씬 편하다, 매개변수 있는 생성자 사용 
		System.out.println("===== 데이터 추가 2=====");
		list.add(new Student(7,"춘향이",89,80,70));
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),
					std.getEng(),std.getMath());
		}
		System.out.println("===== 주소값 출력 =====");
		for(Student std:list) {
			System.out.println(std);
		}
		System.out.println("===== 데이터 출력 =====");
		for(int i=0;i<list.size();i++) { // 인덱스 번호 필요한 경우엔 for
			Student std=list.get(i); // 형변환 할 필요 없다 (제네릭스 사용시)
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),
					std.getEng(),std.getMath());
		}
		System.out.println("====== 학생 삭제 ======");
		list.remove(3);
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),
					std.getEng(),std.getMath());
		}
		System.out.println("====== 학생 수정 ======");
		list.set(1, new Student(2,"수정",90,90,90));
		for(Student std:list) {
			System.out.printf("%-3d%-5s%-5d%-5d%-5d\n",
					std.getHakbun(),std.getName(),std.getKor(),
					std.getEng(),std.getMath());
		}
		System.out.println("====== 학생 졸업 ======");
		list.clear();
		System.out.println("현재 학생 수:"+list.size()+"명");
	}

}
