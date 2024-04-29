//3. 1~n까지 합을 구하는 메소드를 구현하시오.
// 리턴형(o) 매개변수(o) ==> n => 사용자 요청값 / 결정되지 않았을 경우 매개변수가 있다 
import java.util.Scanner;
public class 메소드_문제_03 {
	static int munje_3(int n) {
		int sum=0;
		for(int i=1; i<=n;i++) {
			sum=sum+i; //sum+=i;
}
		return sum;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력:");
		int n=scan.nextInt();
		int sum=munje_3(n);
		System.out.println("1부터"+n+"까지의 합:"+sum);
	}

}
