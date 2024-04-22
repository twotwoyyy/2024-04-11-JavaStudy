/*
 * 7.1~30 짝수합,홀수합을 출력하는 프로그램을 작성
 */
public class 문제_07 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int even=0;
		int odd=0;
		for(int i=1;i<=30;i++)
		{
			if(i%2==0)
				even+=i;
			if(i%2!=0)
				odd+=i;
				
		}
		System.out.println("짝수합:"+even);
		System.out.println("홀수합:"+odd);
		
	}

}
