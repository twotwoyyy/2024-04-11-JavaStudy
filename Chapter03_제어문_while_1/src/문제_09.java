/*
 * 9.1~1000까지에서 7의 배수의 합 ,9의 배수의 합
 */
public class 문제_09 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a7=0;
		int a9=0;
		for(int i=1;i<=1000;i++) {
			if(i%7==0)
				a7+=i;
			if(i%9==0)
				a9+=i;
		}
		System.out.println("1~1000까지에서 7의 배수의 합:"+a7);
		System.out.println("1~1000까지에서 9의 배수의 합:"+a9);

		
		
		System.out.println("===== while =====");
		a7=0;
		a9=0;
		int i=1;
		while(i<1000)
		{
			if(i%7==0)
				a7+=i;
			if(i%9==0)
				a9+=i;
		i++;
		}
		System.out.println("1~1000까지에서 7의 배수의 합:"+a7);
		System.out.println("1~1000까지에서 9의 배수의 합:"+a9);

		System.out.println("===== do while =====");
		a7=0;
		a9=0;
		i=1;
		do
		{
			if(i%7==0)
				a7+=i;
			if(i%9==0)
				a9+=i;
		i++;
		}while(i<=1000);
		System.out.println("1~1000까지에서 7의 배수의 합:"+a7);
		System.out.println("1~1000까지에서 9의 배수의 합:"+a9);

		
	}
	
	

}
