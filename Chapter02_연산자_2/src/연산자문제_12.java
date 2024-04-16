/*
 * 사용자로부터 세 개의 정수를 입력받은 다음에 곱과 합을 순서대로 진행해서 그 결과를 출력하는 프로그램을 작성해 보 자. 
 * 예를 들어 사용자로부터 순서대로 입력받은 세 개의 정수가 1, 2, 3 이라면 
 * 1 * 2 + 3의 계산 결과를 출력해야 한다. 단 출력 양식은 다음과 같아야 한다.
 */
import java.util.Scanner;

public class 연산자문제_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("세 개의 정수 입력 (10 20 30)");
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		int num3=scan.nextInt();
		System.out.println("====결과값====");
		System.out.printf("%d * %d + %d = %d",num1,num2,num3,num1*num2+num3);
	}

}
