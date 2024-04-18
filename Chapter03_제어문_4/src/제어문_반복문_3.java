//1~100까지의 합 ==> 반복횟수 ==>100
public class 제어문_반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0; //합 누적 => 초기값 0
		for(int i=1;i<=10;i++) // i=1 ++ i=2 ++ i=3 ... 
		{
			//sum=sum+i;
			sum+=i;
			System.out.println("i="+i+",sum="+sum);
		}
		System.out.println("1~10까지의 합:"+sum);
	}

}
