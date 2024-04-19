//7.  5~16까지의 합을 구하시오


// + 1~100==> 좌우대칭 숫자를 추출해서 출력
public class 자바반복문_문제_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=5;i<=16;i++)
		{
			sum+=i;
		}
		System.out.println("결과값:"+sum);
		
		for(int i=1;i<=100;i++)
		{
			if(i%11==0)
				System.out.println(i+" ");
		}
	}

}
