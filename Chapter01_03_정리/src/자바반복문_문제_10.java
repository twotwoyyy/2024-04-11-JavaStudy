//10. 1~100까지의 정수 중 4의 배수의 합계를 구하라

public class 자바반복문_문제_10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=1;i<=100;i++)
		{
			if(i%4==0)
				sum+=i;
		}
		System.out.println("1~100까지의 정수 중 4의 배수의 합"+sum);
		}

}
