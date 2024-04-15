
public class 연산자_산술연산자_1 {
/*
 * 		+
 * 		---
 * 		 1) 산술연산자 (더하기 연산자)
 * 			10+10=20
 * 		 2) 문자열 결합
 * 			"7"+"7"="77"
 * 			7+"7"="77"
 * 			문자열이 붙으면 문자가 나옴
 * 			7+7+"7"="147"
 * 			7+"7"+7+7=
 * 			=> 7+"7"+7+7
 *             ----
 *             "77"
 *                 +7
 *            --------
 *              "777"
 *               -----
 *               "7777"
 *          7+"7"+7*7==>"7749"
 *          ====> () => 우선순위 변경
 *          / => 정수/정수 = 정수
 *          & => 나머지는 왼쪽 부호를 따라간다
 *          *** 같은 데이터형끼리 연산이 된다
 *          => 최종결과값은 가장 큰 데이터형을 결과값으로 처리된다
 *               
 */
	public static void main(String[] args) {
		//char + int
		char c='A'; //65
		int i=10;
		System.out.println(c+i);
		// c=65
		// double + int= double
		double d=10.5;
		System.out.println(d+i);
		
	
		byte b1=10;
	byte b2=20;
	//byte b3=b1+b2; // int이하 데이터형은 연산 결과는 int, byte로 처리해서 오류가 남
	int b3=b1+b2;
	System.out.println(b3);
	
	// char + char = int 
	char c1='A';
	char c2='B';
	int c3=c1+c2;
	System.out.println(c3);
	
	// char + byte + double +float=>double
	char d1='A';
	byte d2=100;
	double d3=10.5;
	float d4=10.5F;
	System.out.println(d1+d2+d3+d4);
	// int + long + float => float
	int a1=100;
	long a2=100L;
	float e3=10.F;
	
	// byte < char < int < long < float < double
	
	

	}

}
