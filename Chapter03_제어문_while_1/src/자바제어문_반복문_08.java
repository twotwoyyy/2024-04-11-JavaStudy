import java.util.Scanner;
public class 자바제어문_반복문_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		//사칙 연산자 => q누르면 빠져나오기
		while(true)
		{
			System.out.print("첫 번째 정수 입력:");
			int num1=scan.nextInt();
			System.out.print("연산자 입력(+,-,*,/)=> 종료시에는 q입력:");
			char op=scan.next().charAt(0);
			if(op=='q' || op=='Q')
			{
				System.out.println("계산기 종료");
				break;
			}
			
			System.out.println("두 번째 정수 입력:");
			int num2=scan.nextInt();
			
			switch(op)
			{
			case'+':
				System.out.printf("%d+%d=%d\n",num1,num2,num1+num2);
				break;
			case'-':
				System.out.printf("%d-%d=%d\n",num1,num2,num1-num2);
				break;
			case'*':
				System.out.printf("%d*%d=%d\n",num1,num2,num1*num2);
				break;
			case'/':
				if(num2==0)
					System.out.println("0으로 나눌 수 없습니다!!");
				else
					System.out.printf("%d/%d=%d\n",num1,num2,num1/num2);
				break;
			default:
				System.out.println("잘못된 연산자입니다!!");
			}
		}
	}

}
