/*
 *	A~Z까지 = for
 *	Z~A까지 출력 =while
 */
public class 자바제어문_반복문_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(char c='A';c<='Z';c++)
		{
			System.out.print(c+" ");
		}
		System.out.println();
		
		char c='Z';
		while(c>='A')
		{
			System.out.print(c+" ");
			c--;
		}
		
		
	}

}
