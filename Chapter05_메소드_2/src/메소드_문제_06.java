//문자열을 입력받아서 좌우 대칭인지 확인하는 메소드를 구현하시오.
import java.util.*;
public class 메소드_문제_06 {
	static void munje_6(String msg) {
		if(msg.length()%2!=0) { // 짝수가 아니면 좌우대칭 확인이 어렵기 때문에 오류 처리를 해야한다 
			System.out.println("잘못된 입력입니다");
			return; // 메소드 종료 
		// return은 원하는 위치에서 사용이 가능하다 
		}
		/*
		 * AB|BA  좌우대칭 비교  
		 * 01 23
		 */
		boolean bCheck=true;
		for(int i=0; i<msg.length()/2;i++) {
			char c1=msg.charAt(i);
			char c2=msg.charAt(msg.length()-1-i);
			if(c1!=c2) {
				bCheck=false;
				break;
			}
		}
		if(bCheck==true)
			System.out.println("좌우대칭입니다.");
		else
			System.out.println("좌우대칭이 아닙니다!!");
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("문자열 입력:");
		String str=scan.next();
		munje_6(str);
	}

}
