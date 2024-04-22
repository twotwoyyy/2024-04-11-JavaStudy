import java.util.Scanner;
public class 자바제어문_반복문_05 {
/*
 *	for => updown
 *	1.난수 => 난수를 맞추는 프로그램
 *	  --- 힌트 : UP/DOWN
 * -----------------------반복횟수가 명확하지 않는다 => while
 * 	=> 종료 : break
 *  => 잘못 입력시 continue
 *  ----------------------반복제어문
 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		//1.난수 발생
		int com=(int)(Math.random()*100)+1;
		while(true) //무한루프
		{
			System.out.print("1~100사이의 정수를 입력:");
			int user=scan.nextInt();
			if(user<1 || user>100)
			{
				System.out.println("잘못된 입력입니다!!");//while 처음으로 이동
				continue; // 조건식으로 이동
			}
			
			// 힌트
			if(com>user)
			{
				System.out.println("입력값보다 큰 숫자를 입력하세요");
			}
			else if(com<user)
			{
				System.out.println("입력값보다 작은 숫자를 입력하세요");
			}
			else // com=user
			{
				System.out.println("정답입니다!!");
				// 종료한다
				break;
			}
		}
		System.out.println("프로그램 종료!!");
	}

}
