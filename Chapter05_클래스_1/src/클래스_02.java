//데이터형
//클래스이름은 동일하면 안된다

import java.util.Scanner;

class Student2{
	// 멤버 변수, 인스턴스 변수, 객체 변수... 
	// 인스턴스는 메모리에 저장된 상태 => new를 이용해서 메모리를 따로 만든 후에 저장 
	String name; // null
	int kor,eng,math; // 0
	double avg; // 0.0
	char score; //'\0'
	int rank; // 0 
	int total;
	// ==> 자동 초기화 , 초기값을 주지 않아도 된다 
	
}
public class 클래스_02 {

	public static void main(String[] args) {
		/*Student2 hong=new Student2();
		System.out.println("이름:"+hong.name);
		System.out.println("국어:"+hong.kor);
		System.out.println("평균:"+hong.avg);
		System.out.println("학점:"+hong.score);*/
		// 3명의 학생
		Student2[] std=new Student2[3]; // 배열 만들기
		// 사용자 정의 데이터형 => 배열 사용이 가능
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<std.length;i++) {
			std[i]=new Student2(); // 메모리 할당 먼저 해야한다 
			System.out.println((i+1)+"번째 국어 입력:");
			std[i].kor=scan.nextInt();
			System.out.println((i+1)+"번째 영어 입력:");
			std[i].eng=scan.nextInt();
			System.out.println((i+1)+"번째 수학 입력:");
			std[i].math=scan.nextInt();
			
			std[i].total=std[i].kor+std[i].eng+std[i].math;
			std[i].avg=std[i].total/3.0;
		}
		for(int i=0; i<3;i++) {
			System.out.println("국어 점수:"+std[i].kor);
			System.out.println("영어 점수:"+std[i].eng);
			System.out.println("수학 점수:"+std[i].math);
			System.out.println("총점:"+std[i].total);
			System.out.printf("평균%.2f\n",std[i].avg);
			System.out.println();
		}
	}

}
