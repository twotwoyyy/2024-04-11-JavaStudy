/*
 *  두 개의 정수를 입력 받아서 첫째 수를 둘째 수로 나눈 나머지를 출력하는 프로그램을 작성해 보자.
 */
public class 연산자문제_13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num1=(int)(Math.random()*100)+1;
		int num2=(int)(Math.random()*100)+1;
		
		System.out.println("====결과값====");
		System.out.printf("%d %% %d = %d\n",num1,num2,num1%num2);
		// %가 앞에 이미 쓰였을 경우 %%라 써서 출력해야 한다 
	}

}
