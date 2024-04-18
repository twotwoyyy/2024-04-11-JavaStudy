/*
 * 8) 1-2+3-4+5-6+7-8+9-10 계산 값을 for문을 이용하여 출력하라 
 */
public class 제어문_문제_0418_8 {

	public static void main(String[] args) {
        int sum=0;
        for(int i=1;i<=10;i++)
        {
        	if(i%2==0) // 패턴을 읽어서 해결하자 짝수땐 빼고 홀수 때 더한다 
        	{
        		sum-=i;
        	}
        	else
        	{
        		sum+=i;
        	}
        }
        System.out.println("1-2+3-4+5-6+7-8+9-10 계산 값:"+sum);
	}

}
