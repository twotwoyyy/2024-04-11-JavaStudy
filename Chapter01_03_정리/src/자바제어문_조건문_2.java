// 초를 받아서 => 시간 / 분 / 초 출력 
// 63    1분 3초 ==> 라이브러리 (시간 => 초단위) 60*60*24
import java.util.Scanner; // (/ , %)
public class 자바제어문_조건문_2 {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("초를 입력:");
		int num=scan.nextInt();
		
		int hour=num/3600;
		System.out.print(hour+"시 ");
		int minute=(num%3600)/60;
		System.out.print(minute+"분 ");
		int second=(num%3600)%60;
		System.out.print(second+"초 ");
	}

}
