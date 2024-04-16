
public class 연산자문제_6 {

	public static void main(String[] args) {
	       int num1=10, num2=10;   
	       int a, b;   
	       a = ++num1;
	     //    --
	     //    전치연산자 => 먼저 증가
	     // -- 증가된 값읋 대입
	     // a=11, num=11
	       b = num2++;
	     //        --
	     //     후치연산자 => 대입
	     //      -----후에 증가

	       System.out.printf("%d, %d \n", b, num2);
	       //                           대입 먼저 : 10, 그 후 증가 11 

	}

}
