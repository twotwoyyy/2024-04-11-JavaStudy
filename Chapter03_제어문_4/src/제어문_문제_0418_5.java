/*
 * 5) B,D,F,H,J,L,N을 출력하는 프로그램을 작성하라 (for 사용)
 */
public class 제어문_문제_0418_5 {

	public static void main(String[] args) {
		for(char c='B';c<='N';c+=2)
		{
			if(c!='N')
				System.out.print(c+",");
			else
				System.out.print(c);
		}

	}

}
