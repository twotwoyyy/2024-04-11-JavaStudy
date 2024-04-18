// 무한루프
/*
 * 	간단한 게임 : UpDown게임
 * 	=> 1~100 사이의 난수 => 맞추는 프로그램
 *  => 힌트 
 *  	67 => 55 => UP
 *  => 1~100까지 사이의 수가 입력이 안된 경우 => 제외하고 다시 입력으로 이동 
 *  => 정답일 경우 => break (for문 종료)
 *  => 반복제어문: break,continue
 *  => 다시 처음부터 실행 
 *     --------------
 *     => 반복문 
 *     => 메소드 
 */
import java.util.Scanner;
public class 제어문_반복문_7 {

	public static void main(String[] args) {
		int count=0;
		Scanner scan=new Scanner(System.in);
		// 1. 난수 발생
		int com=(int)(Math.random()*100)+1; // 1~100사이 정수 한개 추출
		// 2. 사용자가 난수를 맞추는 코딩
		// while (true) => 데이터베이스
		// 오라클 => MySQL / MariaDB
		// 3차 프로젝트 
		for(;;) // 종료하지 않는 프로그램 => 무한루프 => 반드시 종료하는 프로그램 => q/Q
		{
			// 사용자 입력받기 
			System.out.print("1~100사이의 정수를 입력하시오:");
			int user=scan.nextInt();
			
			if(user<1 || user>100) // 범위를 벗어난 경우 => ||
			{
				System.out.println("입력값에 오류가 있습니다!!"); // 다시 입력하게 해야할 땐 continue
				continue; // for의 처음으로 다시 돌아간다
			}
			
			count++;
			
			// 정상적으로 입력이 된 경우
			if(com>user)
			{
				System.out.println("입력값보다 큰 수를 입력하세요!!");
			}
			else if(com<user)
			{
				System.out.println("입력값보다 작은 수를 입력하세요!!");
			}
			else
			{
				System.out.println("정답입니다!!");
				break; // for종료 => 게임 종료 => System.exit(0)
			}
		}
		System.out.println(100-(count*5)+"점");

	}

}
