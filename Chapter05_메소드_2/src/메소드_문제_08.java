// 8. 학점을 구하는 메소드를 구현하시오. => ChoiceFormat
import java.util.Scanner;
public class 메소드_문제_08 {
	static char munje_8(int score) {
		char c=' ';
		switch(score/10) {
		case 10: case 9:
			c='A';
			break;
		case 8:
			c='B';
			break;
		case 7:
			c='C';
			break;
		case 6:
			c='D';
			break;
		default:
			c='F';
			break;
		}
		return c;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("점수 입력:");
		int num =scan.nextInt();
		char c=munje_8(num);
		System.out.println(c);
		
	}

}
