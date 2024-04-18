// 사칙연산 => 연산 한번만 처리 => 다중조건문 
import java.util.Scanner;
public class 제어문_조건문_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 사용변수
		int num1,num2;
		char op=' ';
		System.out.println("첫 번째 정수 입력:");
		num1=scan.nextInt(); // 변수=> 1개의 데이터를 저장하는 공간
		System.out.println("연산자 입력(+,-,*,/):");
		op=scan.next().charAt(0);
		System.out.println("두 번째 정수 입력:");
		num2=scan.nextInt();
		
		if(op=='+')
		{
			System.out.println(num1+"+"+num2+"="+(num1+num2)); // 문장 수행 후 종료
		} // false면 아래로 넘어감 
		else if(op=='-')
		{
			System.out.println(num1+"-"+num2+"="+(num1-num2));
		}
		else if(op=='*')
		{
			System.out.println(num1+'*'+num2+"="+(num1*num2));
		}
		else if(op=='/')
		{
			if(num2==0)
			{
				System.out.println("0으로 나눌 수 없습니다");
			}
			else
			{
				System.out.println(num1+"/"+num2+"="+(num1/num2));
			}
		}
		else
		{
			System.out.println("잘못된 연산자입니다");
		}
	}

}
