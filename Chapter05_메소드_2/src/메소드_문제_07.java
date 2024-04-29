// 07. 문자열을 거꾸로 출력하는 메소드를 구현하시오.
import java.util.*;
public class 메소드_문제_07 {
	static void munje_7(String msg) {
		for(int i=msg.length()-1;i>=0;i--) {
			System.out.print(msg.charAt(i));	
		}
		System.out.println();
		System.out.println(new StringBuffer(msg).reverse()); // 이렇게 출력할 수도 있음 [라이브러리]
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("문자열 입력:");
		String str=scan.next();
		munje_7(str);
		
	}

}
