
public class 자바반복문_문제_8 {
//8. 3이상 4462 이하에서 짝수인 정수의 합을 구하여라.
	//--------------- ---------변수 1개
	//for의 범위
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		int sum1=0;
		for(int i=3;i<=4462;i++)
		{
			if(i%2==0)
				sum+=i;
			else
				sum1+=i;
		}
		System.out.println("짝수의 합: "+sum);
		System.out.println("홀수의 합: "+sum1);

	}

}
