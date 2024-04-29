//4. 두 정수의 나눗셈 결과를 구하는 메소드를 구현하시오. (실수)
import java.util.Scanner;
public class 메소드_문제_04 {
	static double munje_4(int a, int b) {
		double d=0.0;
		try {
			d=a/(double)b; // 정상 수행
		}catch(Exception e) {
			System.out.println("0으로 나눌 수 없습니다!!"); // 오류 발생 
		}
		return d; // 뒤를 실수로 바꾸어주어야 한다!! 
	}

		
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("첫 번째 정수 입력:");
		int num1=scan.nextInt();
		System.out.print("두 번째 정수 입력:");
		int num2=scan.nextInt();
		double res=munje_4(num1,num2);
		System.out.println("res="+res);
	}

}
