//12.5개의 정수를 임의로 추출하여 
//최대값,최소값을 출력하는 프로그램을 작성하시오

public class 문제_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=====for=====");
		int max=1;
		int min=100;
		

		for(int i=1;i<=5;i++)
		{
			int num=(int)(Math.random()*100)+1;
			System.out.print(num+" ");
			if(num>=max)
			{
				max=num;
			}
			if(num<=min)
				min=num;
			}
		System.out.println();
		System.out.println("최솟값:"+min);
		System.out.println("최댓값:"+max);
		
		System.out.println("=====while=====");
		
		int i=0;
		min=100;
		max=0;
		while(i<=5)
		{
			int num=(int)(Math.random()*100)+1;
			
			i++;;
	
		System.out.print(num+" ");
		if(num>=max)
		{
			max=num;
		}
		if(num<=min)
			min=num;
		}
		System.out.println();
		System.out.println("최솟값:"+min);
		System.out.println("최댓값:"+max);

		}

}
