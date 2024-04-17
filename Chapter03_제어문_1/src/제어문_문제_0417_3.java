// 3) Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 정수의 절대값을 출력하라
import java.util.Scanner;
public class 제어문_문제_0417_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("정수 입력:");
		int num=scan.nextInt();
		
		/*if(num<0) // 음수
		{
			num=num*-1; // -1을 곱하면 양수만 출력 => 양수=> 절대값 
		}
		System.out.println(num);*/
		
		System.out.println(Math.abs(num)); // abs가 절대값

	}

}
