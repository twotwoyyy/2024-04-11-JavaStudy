//4. 배열 arr에 담긴 모든 값을 더하는 프로그램을 완성하시오.
//
//      public static void main(String[] args)
//	{
//		int[] arr = {10, 20, 30, 40, 50};
//		int sum = 0;
//
//	  //(1) 알맞은 코드를 넣어 완성하시오.
//
//		System.out.println("sum="+sum); // 결과 : sum=150
//	}

public class 자바배열문제_04 {

    public static void main(String[] args)
{
	int[] arr = {10, 20, 30, 40, 50};
	int sum = 0;
	
	for(int i:arr) { // 배열에 저장된 실제값을 가지고 온다  => 받는 변수는 배열의 데이터형과 일치
		sum+=i;
	}
	
//	for(int i=0;i<arr.length;i++) {
//		sum+=arr[i];
//	}
	System.out.println("sum="+sum); // 결과 : sum=150
}


}
