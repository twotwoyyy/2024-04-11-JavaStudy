/*
 * 7)1부터 30까지의 정수에서 짝수만 한 줄에 3개씩 출력하라
 */
public class 제어문_문제_0418_7 {

	public static void main(String[] args) {
		int com=(int)(Math.random()*100)+1;
		for(int i=1;i<=30;i++)
		{
			if(i%2==0)
			{
				System.out.printf("%2d ",i); // 형식 외우기 "%2d,"
				if(i%3==0) // 나눠서 띄어쓰기 
					System.out.println(); // 여기를 몰랐음 
			}

		}

	}

}
