//9. 0~12까지 2의 배수, 3의 배수의 합을 구하여라.
// 1~100까지 7의 배수, 9의 배수의 합 구하기 
public class 자바반복문_문제_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a2=0,a3=0;
		for(int i=0;i<=12;i++)
		{
			if(i%2==0)
				a2+=i; // 2의 배수 합
			if(i%3==0) 
				a3+=i; // 3의 배수 합 // 6은 둘 다 해당되기 대문에 else쓰면 안됨 
		}
		System.out.println("2의 배수 합:"+a2);
		System.out.println("3의 배수 합:"+a3);
		
		int a7=0,a9=0;
		for(int i=1;i<=100;i++)
		{
			if(i%7==0)
				a7+=i;
			if(i%9==0)
				a9+=i;
		}
		System.out.println("7의 배수 합:"+a7);
		System.out.println("9의 배수 합:"+a9);
	}

}
