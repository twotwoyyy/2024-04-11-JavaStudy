/*
 * 11.정수 입력을 받아서 60이상 합격 =>불합격  if~else
 */
import java.util.Scanner;
public class 문제_11 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
//		System.out.print("정수 입력(0~100):");
//		int num=scan.nextInt();
//		if(num<=60)
//		{
//			System.out.println("불합격입니다.");
//		}
//		else
//			System.out.println("합격입니다.");
		int num=0;
		while(true)
		{
			System.out.println("정수 입력:0~100>>");
			num=scan.nextInt();
			if(num<0 || num>100)
			{
				System.out.println("잘못된 입력입니다");
				continue;
			}
			break;
		}
		if(num<=60)
		{
			System.out.println(num+"점은 불합격입니다.");
		}
		else
			System.out.println(num+"점은 합격입니다.");

	}

}
