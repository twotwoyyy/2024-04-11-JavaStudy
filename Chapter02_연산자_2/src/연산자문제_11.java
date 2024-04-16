import java.util.Scanner;
/*
 * 사용자로부터 두 개의 정수를 입력 받아서 뺄셈과 곱셈 연산의 결과를 출력하는 프로그램을 작성
 */

public class 연산자문제_11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("두 개의 정수 입력 (10 20):");
		int num1=scan.nextInt();
		int num2=scan.nextInt();
		System.out.println("=====결과값=====");
		
		
		System.out.println(num1+"-"+num2+"="+(num1-num2));
		System.out.println(num2+"*"+num2+"="+num1*num2);
		//System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
		//System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
		//printf는 dos에서만 사용 
		// +, -는 연산 순위가 동일
		// *=> +보다 연산 순위가 우선
	}

}
