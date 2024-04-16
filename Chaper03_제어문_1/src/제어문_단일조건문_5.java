
import java.util.Scanner;
public class 제어문_단일조건문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int num1,num2;
		char op;
		System.out.print("첫 번째 정수입력");
		num1=scan.nextInt();
		
		System.out.print("연산자 입력(+,-,*,/,):");
		op=scan.next().charAt(0);
		
		System.out.print("두 번째 정수 입력:");
		num2=scan.nextInt();
		
		if(op=='+')
		{
			System.out.println(num1+"+"+num2+"="+(num1+num2));
		}
		if(op=='-')
		{
			System.out.println(num1+"-"+num2+"="+(num1-num2));
		}
		if(op=='*')
		{
			System.out.println(num1+"*"+num2+"="+(num1*num2));
		}
		if(op=='/')
		{
			if(num2==0)
			{
				System.out.println("0으로 나눌 수 없다");
			}
			if(num2!=0)
			{	
				System.out.println(num1+"/"+num2+"="+(num1/num2));
			}
		}
	}
}


