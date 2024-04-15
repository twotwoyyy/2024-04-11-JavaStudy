/*
 * 		대입연산자 => 메모리에 저장
 * 	               -----변수
 * 		=   => int a=10;
 * 				   : 10을 'a'라는 메모리에 저장 (대입)
 *          => 형변환
 *             int a='A'
 *             ---   --
 *           4byte  2byte => 작은 값은 대입이 가능
 *           => 'A'= 65로 변경 후에 저장 
 *           long l=20;
 *           ----   ---
 *          8byte  4byte
 *          => 20 --> 20L (long형으로 바뀜)
 *          ; 작은 값은 큰 값의 데이터형으로 바뀜 
 *          double d=20; -> 20.0으로 바뀌어 들어감 
 *          
 *        = 대입연산자
 *        
 *        --------------------
 *         복합대입연산자
 *         
 *         +=
 *          int a=10;
 *                   <====뒤에 연산이 먼저 옴
 *          a+=1; => a = a+1;
 *          ----         ----
 *                      10+1 => a=11
 *                      
 *         a+10   ==>    a=a+10 =20
 *         a+=20  ==>    a=a+20
 *         
 *         -=
 *         a-=1 ==> a=a-1
 *         a-=10 ==> a=1-10 // a값을 바꿔나가라
 *         
 *         *=
 *         a*2 ==> a=a*2
 *         
 *         /=
 *         a/2 ==> a=a/2
 *         
 *         --------------
 *         
 *         => 누적, 문자열 결합 
 *         
 */
public class 연산자_대입연산자_1 {

	public static void main(String[] args) {
		double d=20;
		System.out.println(d);
		
		int a=10;
		a++;
		a++;
		a++;
		a++;
		a++;
		
		System.out.println(a);

		int b=10;
		b+=5;
		System.out.println(b);
		
	/*
	 * 한 개 증가 / 한 개 감소
	 *   ++          ==
	 * 여러 개 증가 / 여러 개 감소
	 *   +=          -=
	 *   
	 * 한개 증가/ 한개 감소
	 * int a=10; 
	 * a++ / ++a / a+=1 / a=a+1
	 * int a=10
	 * a-- / --a / a-=1 / a=a-1
	 * 
	 * 여러개 증가/ 여러개 감소
	 * int a=10;   ==> 41page
	 * a-=5 ==> a=a-5
	 * a+=5 ==> a=a+5
	 */
		
		int score1=10;
		int score2=5;
		score1+=score2;
		// score1=score1+score2 ==>score1=15
		System.out.println("score1="+score1); //15
		score1-=score2;
		// score1=score1-score2
		//          15      5   ==> 10
		System.out.println("score2="+score2); //10
		
		// 변수값이 변경 ==> ++, -- , +=, -=
		// 나머지 연산자는 변수값 변경이 안된다
		int m=10;
		m++;
		m+=10;
		int n=20;
		System.out.println(n=m+n);
		System.out.println("n="+n);
		
	}

}
