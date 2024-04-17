// 2) 한 개의 정수를 입력 받아 3의 배수인지 판별하여 출력하라
import java.util.Scanner;
public class 제어문_문제_0417_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("정수 입력:");
		int num=scan.nextInt();
		
		if(num%3==0 && num!=0) // 0일경우 3의 배수로 나오기 때문에 num!=0 조건 주어야 한다  
		{
			System.out.println(num+"은(는) 3의 배수입니다.");
		}
		else
		{
			System.out.println(num+"은(는) 3의 배수가 아닙니다.");
		}
	}

}
