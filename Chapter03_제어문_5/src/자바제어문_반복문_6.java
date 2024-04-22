/*
 * 사용자로부터 2~9사이의 정수를 입력받아서 구구단을 출력
 * 단, 입력이 2~9까지가 아닐 경우에는 다시 입력을 요청하게 만든다
 */
import java.util.Scanner;
public class 자바제어문_반복문_6 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		int dan=0; // 블록변수=> {}을 벗어나면 자동으로 삭제
		//블록이 어디까지 사용되는지 확인을 잘 해야한다 
		// 프로그램에 필요한 데이터를 사용자로부터 받아서 => 오류 체크 
		/*
		 * for(int i=0;i<10;i++)
		 * {
		 * 	  int j=10;
		 * } // for 안에서만 사용이 가능 i,j
		 *  // for안에서 변수를 설정 => 밖에서 사용 불가 
		 */
		for(;;) // 무한 루프 => 사용자가 입력값을 2~9까지 
		{
			System.out.println("2~9사이의 정수 입력:");
			dan=scan.nextInt();
			if(dan<2 || dan>9)
			{
				System.out.println("잘못된 입력입니다.");
				// for 처음으로 이동 continue< for문 다시 시작
				continue;
			}
			break;//빠져나오는것 
		}
		System.out.println("단="+dan);
		System.out.println("====="+dan+"단=====");
		for(int i=1;i<=9;i++)
		{
			System.out.printf("%d*%d=%d\n",dan,i,dan*i);
		}

	}

}
