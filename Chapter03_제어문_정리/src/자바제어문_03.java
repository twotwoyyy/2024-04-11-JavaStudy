import java.util.Scanner;
//무한루프
public class 자바제어문_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean run=true;
		int balance=0;
		Scanner scan=new Scanner(System.in);
		while(run)
		{
			System.out.println("--------------------------------------");
			System.out.println(" 1. 예금 | 2. 출금 | 3. 잔돈확인 | 4. 종료 ");
			System.out.println("--------------------------------------");
			System.out.print("메뉴 선택 >> ");
			int menu=scan.nextInt();
			switch(menu) // 필요시 다중조건문으로 변경 가능 
			{
			case 1:
				System.out.print("예금액>");
				balance+=scan.nextInt();
				break;
			case 2:
				System.out.print("출금액>");
				int input=scan.nextInt();
				if(balance<input)
					System.out.println("잔액이 부족합니다!!");
				else
					balance-=input;
			case 3:
				System.out.println("잔고>");
				System.out.println(balance);
					
			case 4:
				run=false; 
				break; // System.exit(0) => 자신의 제어문에서만 처리 (while을 제어할 수 없다)
			default:
			System.out.println("메뉴가 존재하지 않습니다!! ");
			}
			
			
		}
		System.out.println("프로그램 종료!!");
		
	}

}
