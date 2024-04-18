import java.util.Scanner;
public class 제어문_문제_0417_1 {
/*
 * 1) Scanner 클래스를 이용하여 한 개의 정수를 입력 받아 양수인지 음수인지 판별하여 출력하라
 */
	// if~else : 경우의 수 2개이면 / 웹(로그인, 아이디중복,아이디찾기,비밀번호찾기,검색,우편번호 등 많이 쓰임
	
	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.println("정수 입력:");
		int num=scan.nextInt();
		
		if(num>=0)
		{
			System.out.println(num+"은(는) 양수입니다");
		}
		else
		{
			System.out.println(num+"은(는) 음수입니다");
		}
	}

}
