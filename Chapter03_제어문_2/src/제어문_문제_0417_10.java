/*
 * 10)숫자를 입력받아 3~5는 봄, 6~8은 여름, 9~11은 가을, 12,1,2는 겨울, 그 외의 숫자를 입력한 경우 잘못입력을 출력하는 프로그램을 작성하라.
 *  if-else 문과 switch 둘 다 이용해 볼 것.

결과)
달을입력하세요(1~12) >> 9
가을

 */
import java.util.Scanner;
public class 제어문_문제_0417_10 {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("달 입력:");
		int month=scan.nextInt();
		if(month>=1 && month<=12)
		{
			if(month>=3 && month<=5) // if(month==3 || month==4 || month==5)
			{
				System.out.println("봄입니다.");
			}
			else if(month>=6 && month<=8)
			{
				System.out.println("여름입니다.");
			}
			else if(month>=9 && month<=11)
			{
				System.out.println("가을입니다.");
			}
			else
			{
				System.out.println("겨울입니다.");
			}
		}
		else
		{
			System.out.println("잘못된 입력입니다!!");
		}
	}

}
