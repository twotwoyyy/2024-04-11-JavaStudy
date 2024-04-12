/*
 * 		값을 교환
 * int a=100;
 * int b=200; 둘 값을 교환하고 싶을 경우 임시 저장
 * int temp=a; 
 * a=b;
 * b=a
 */
public class 변수_7 {

	public static void main(String[] args) {
		// 값 교환 
		int a=100;
		int b=200;
		int temp=a; //임시 저장 변수 
		a=b;
		b=temp; // 바뀐 값이 대입되기 때문에 임시 저장을 한 변수로 대입 
		System.out.println("a="+a);
		System.out.println("b="+b);
		
		char c1='A';
		char c2='B';
		char temp2=c1;
		c1=c2;
		System.out.println("c1="+c1);
		System.out.println("c2="+temp2);
	}

}
