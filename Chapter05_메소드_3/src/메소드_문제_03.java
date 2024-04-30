/*3. 년도를 입력 받아 윤년여부를 확인하는 프로그램 작성
	년도 입력 메소드
	윤년 처리 
	출력  
 */
import java.util.*;
public class 메소드_문제_03 {
	static int input() {
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		//return scan.nextInt();
		int a=scan.nextInt(); 
	 	return a;
	}
	//윤년 처리
	static void isYear(int year) {
		if((year%4==0 && year%100!=0) || (year%400==0))
			System.out.println(year+"년도는 윤년입니다");
		else
			System.out.println(year+"년도는 윤년이 아닙니다");
	}
	public static void main(String[] args) {
		int year=input();
		isYear(year);
		//Scanner scan=new Scanner(System.in);
		// System.in (키보드 입력값 받을 때) System.out (화면에 출력할 때)
		//    inputStream               outStream
		// System.in을 이용해서 키보드 입력값을 가지고 올 수는 있다
	    // 단, 모든 문자를 정수형으로 가져온다 => 따라서 Scanner 이용 
		// System.in=> 클래스 => 키보드 입력값을 받아서 메모리에 저장
		// 입력 부분
	}
}
