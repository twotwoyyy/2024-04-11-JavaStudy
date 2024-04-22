/*
 * 	1~100 사이의 정수를 10개 추출
 * 	=> 최대값/ 최소값 구한다
 * 	   ----  ---- 변수값 2개
 * 	=> for문 10바퀴
 */
public class 자바제어문_반복문_04 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int max=1; // 가장 낮은 숫자 설정
		int min=100; // 가장 높은 숫자 설정
		
		// => 반복 수행 => 임의의 정수 10개 추출
		for(int i=1;i<=10;i++) // 출력하고 상관이 없다, 반복
		{
			int num=(int)(Math.random()*100)+1; //1~100사이의 정수 추출 
			System.out.print(num+" ");
			//최대값, 최소값 구하기
			if(max<num)
				max=num; // 최대값
			if(min>num)
				min=num; // 최소값 
		}
		System.out.println();
		System.out.println("최대값:"+max);
		System.out.println("최소값:"+min);
		/*
		 * 	int max=1;
		 * 	int a=10;
		 *  int b=20;
		 *  int c=30;
		 *  
		 *  if(max<a)
		 *  	max=a => max=> 0 =>10
		 *  if(max<b)
		 *  	max=b => max=> 10=>20
		 *  if(max<c)
		 *  	max=c => max=> 20=>30
		 */
	}

}
