import java.util.Scanner;

public class 제어문_반복문_8 {
//계산기 (사칙연산)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		for(;;)
		{
			System.out.print("첫 번째 정수 입력:");
			int num1=scan.nextInt();
			System.out.print("연산자 입력(+,-,*,/):");
			char op=scan.next().charAt(0);
			System.out.print("두 번쨰 정수 입력:");
			int num2=scan.nextInt();

			
			switch(op)
			{
			case '+':
				System.out.println(num1+"+"+num2+"="+(num1+num2));
				break;
			case '-':
				System.out.println(num1+"-"+num2+"="+(num1-num2));
				break;
			case '*':
				System.out.println(num1+"*"+num2+"="+(num1*num2));
				break;
			case '/':
				if(num2==0)
					System.out.println("0으로 나눌 수 없습니다!!");
				else
					System.out.println(num1+"/"+num2+"="+(num1/num2));
				break;
			//case'q': case'Q':
				//System.out.println("프로그램 종료");
				// 프로그램 자체 종료
				//System.exit(0); // 0 정상종료, 0이 아닌 경우 비정상 종료 
				default:
					System.out.println("잘못된 입력입니다!!");
			}
			System.out.print("종료할까요?(y/n)");
			char exit=scan.next().charAt(0);
			if(exit=='y')
			{
				System.out.println("프로그램 종료");
				break;
			}
			if(exit=='n')
			{
				System.out.println("계산을 다시합니다");
				continue;
			}
		}
	}  

}
