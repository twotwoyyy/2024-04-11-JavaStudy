import java.util.*;
//14. 메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 수를 출력하는 프로그램을 작성하시오. 
public class 메소드_문제_14 {
	static void munje_14(int num) {
		System.out.println(num);
		String s=String.valueOf(num);
		// valueOf ==> 모든 데이터형을 문자열로 변환 
		// 뒤집는 것은 문자열, 배열 변환이 쉬움 
		for(int i=s.length()-1;i>=0;i--) {
			System.out.print(s.charAt(i));
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		int num=scan.nextInt();
		munje_14(num);

	}

}
