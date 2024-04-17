//문자를 받아서 => 대문자/소문자/숫자/기타
//              if else if    else
import java.util.Scanner;
public class 제어문_조건문_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("문자 입력:");
		char c=scan.next().charAt(0); // 문자 하나를 받아올 떄
		// 조건문 => 형식
		// ==> 조건을 만들 줄 알아야 한다 
		// 범위 => && 
		
		if(c>='A' && c<='Z') // 대문자 조건
		{
			System.out.println(c+"은(는) 대문자입니다");
		}
		else if(c>='a' && c<='z')
		{
			System.out.println(c+"은(는) 소문자입니다");
		}
		else if(c>='0' && c<='9') //숫자 조건 -> char로 받았기 때문에 
		{
			System.out.println(c+"은(는) 숫자입니다");
		}
		else
		{
			System.out.println(c+"은(는) 알파벳, 숫자가 아닙니다");
		}
		// 난수 => 0,1,2
		/*
		 * if(num==0)
		 * else if(num==1)
		 * else if(num==2)
		 *다른값이 나올 일이 없으면 else쓰지 않아도 됨 
		 */
	}

}
