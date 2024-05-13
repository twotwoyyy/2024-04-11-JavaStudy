package com.sist.main;
/*
 *	class A
 *	{
 *		int a,b,c,d,e,f;
 *	}
 *	class B extends A
 *	{
 *		//int a,b,c,d,e,f; => 소스가 간결해진다
 *		int k;
 *	}
 *		=> 기능을 변경 => 메서드 (오버라이딩) 
 *		단점) 실행속도가 느려진다
 *			 소스를 볼 수 없기 때문에 가독성이 떨어진다 
 *			 제약 조건이 많다
 *			 결합성이 높아진다 
 *		---------------------------- Spring 상속을 사용하지 않는다
 *		=> 상속 < 포함
 *	
 *	상속을 내리는 클래스 : super 클래스, base 클래스, 부모 클래스, 상위 클래스
 *	상속을 받는 클래스 : sub 클래스, 파생 클래스, 자식 클래스, 하위 클래스
 *		
 */
//import javax.swing.*;
//public class MainClass_4 extends JFrame{
//	public MainClass_4() {
//		setSize(500,500);
//		setVisible(true);
//	} => 상속


//public class MainClass_4{ 
//	JFrame f=new JFrame();//=> 포함 has-a
//	public MainClass_4(){
//		f.setSize(500,500);
//		f.setVisible(true);
//	}

// 
/*
 *	class 게시판{
 *		글쓰기()
 *		상세보기()
 *      검색()
 *      수정()
 *      추가()
 *      삭제()
 *	}
 *
 *	class 묻고답하기{
 *		글쓰기()
 *		상세보기()
 *      검색()
 *      수정()
 *      추가()
 *      삭제()
 *      --------
 *     +답하기()
 * 	}
 * 
 * 	class 댓글_게시판{
 *		글쓰기()
 *		상세보기()
 *      검색()
 *      수정()
 *      추가()
 *      삭제()
 *      -------
 *     +댓글()
 *  }
 * 	class 갤러리_게시판{
 *		글쓰기()
 *		상세보기()
 *      검색()
 *      수정()
 *      추가()
 *      삭제()
 *      -------
 *     +파일업로드() => 이미지 
 *  }
 *  
 *  ==> 이런 경우 상속을 받으면 됨 extends +추가 기능만 쓰면 된다 
 *  
 *  만약 변경하기 위해서는? 오버라이딩 (기존에 있는 기능을 변경해서 사용) 
 *  
 */
class Super{
	int a;
	int b;
}
class Sub extends Super{
	//a,b
	int c;
}
public class MainClass_04{
	

	public static void main(String[] args) {
//		new MainClass_4();
//		Super su=new Super();
//		System.out.println(su.a);
//		System.out.println(su.b);
////		System.out.println(su.c); super 클래스에서는 c를 쓸 수 없다 sub에만 c가 있기 때문이다 
//		Sub sub=new Sub();
//		System.out.println(sub.a);
//		System.out.println(sub.b);
//		System.out.println(sub.c); // Sub 클래스는 상속받은 a,b 그리고 본인 클래스 c를 쓸 수 있다 
		Super su=new Sub(); // a,b
	//  상위         하위
//		Sub sub=new Super(); 불가하다 / 왼쪽이 더 작기 때문에 / 받으려면 아래처럼 해야한다 (형변환)
		System.out.println(su.a);
		System.out.println(su.b);
		//Sub sub=(Sub)su; // a,b,c
		Sub sub=(Sub)su; // 형변환
		// Super > Sub
		// double  int 
		System.out.println(sub.c);
		// 
	}
}
