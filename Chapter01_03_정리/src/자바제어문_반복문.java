/*
 * 	반복문 => 중복을 제거 할 떄 많이 사용 
 * 	---- 메소드
 * 	for : 반복 횟수가 지정된 경우 
 *  ---------------웹 (Back-End => While , Front-End => for)
 *  
 *  프로그램
 *  ------
 *  1. 변수 => 합, 정수 받아서 =>
 *  2. 조건 / 반복
 *  3. 결과값 출력
 *  
 *  ==> 1~45까지의 정수 중에 6개를 추출해서 출력하는 프로그램 
 *  
 *  반복문 ==> 1. 반복횟수 확인
 *  		 10번 반복 ==> 어디서부터 ~ 어디까지
 *  		 for(int i=0;i<10;i++)
 *                  ---- --- -----
 *           2. 처리 문장
 *           3. 처리된 결과값 
 */
public class 자바제어문_반복문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/*	int num1=(int)(Math.random()*45)+1;
		System.out.print(num1+" ");
		int num2=(int)(Math.random()*45)+1;
		System.out.print(num2+" ");
		int num3=(int)(Math.random()*45)+1;
		System.out.print(num3+" ");
		int num4=(int)(Math.random()*45)+1;
		System.out.print(num4+" ");
		int num5=(int)(Math.random()*45)+1;
		System.out.print(num5+" ");
		int num6=(int)(Math.random()*45)+1;
		System.out.print(num6+" ");
	*/
		
		for(int i=1;i<=6;i++)
		{
			int num=(int)(Math.random()*45)+1;
			System.out.println(num+" ");
		}

	}

}
