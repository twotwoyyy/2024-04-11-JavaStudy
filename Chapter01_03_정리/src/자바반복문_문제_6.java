/*
 * 6. 사용자로부터 두개의 정수(시작,끝)를 입력받아 시작(포함)해서 
   끝(포함)까지의 곱을 출력하는 프로그램을 작성하시오.

 */
import java.util.Scanner;
public class 자바반복문_문제_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int start,end;
		int gop=1;
		Scanner scan=new Scanner(System.in); 
		System.out.println("첫 번째 정수 입력:");
		start=scan.nextInt();
		System.out.println("두 번째 정수 입력:");
		end=scan.nextInt();
		
		for(int i=start;i<=end;i++)
		{
			gop*=i;
		}
		System.out.println("결과값:"+gop);

	}

}
