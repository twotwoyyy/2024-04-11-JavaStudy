/*
 * 4) 5,10,15,20,25,30,35,40,45,50을 출력하는 프로그램을 만들어라 (for 사용)
 */
public class 제어문_문제_0418_4 {

	public static void main(String[] args) {
		for(int i=5;i<=50;i+=5)
		{
			if(i!=50)
			System.out.print(i+",");
			else
				System.out.println(i);
		}

	}

}
