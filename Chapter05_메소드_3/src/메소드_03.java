// => 사용자가 년 월 일을 전송하면 => 출력 
// 받아서 출력 / 메소드 출력 => 리턴형 / 리턴형 없이 
import java.util.*;
// 재사용
// 반복 제거 
public class 메소드_03 {
	// 리턴형 없이 
	static void print(int year, int month, int day) {
		System.out.println(year+"년도 "+month+"월 "+day+"일");
		
	}
	// 반복 제거
	static int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		return scan.nextInt();
	}
	public static void main(String[] args) {
//		Scanner scan=new Scanner(System.in);
//		System.out.print("년도 입력:");
//		int year=scan.nextInt();
//		
//		System.out.print("월 입력:");
//		int month=scan.nextInt();
//		
//		System.out.print("일 입력:");
//		int day=scan.nextInt();
		// 3번 반복 => 줄이기
		
		int year=input("년도");
		int month=input("월");
		int day=input("일");
		print(year,month,day);
	}

}
