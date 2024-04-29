//11. 입력받은 값이 짝수인지 홀수인지 판별하는 메소드를 구현하시오.
import java.util.*;
public class 메소드_문제_11 {
	static int munje_11(int num) {
		System.out.println(num);
		return num;
	}
	public static void main(String[] args) {

		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		int num=scan.nextInt();
		munje_11(num);
	}
}
