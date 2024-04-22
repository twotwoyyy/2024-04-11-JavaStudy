/*	스프링 / 마이바티스 / JPA / 스프링 부트
 * -----------------------------------
 * 라이브러리+변수+연산자+제어문
 * --------------------------------메소드
 * while: =:> 데이터베이스, 페이지 나누기
 * 
 * => 반복하는 횟수를 모르는 경우에 주로 사용
 * 	=> *** for/while/do~whil의 나 상이
 * 형식)
 * 	초기값
 * 	while (조건식)
 *  {
 *  	반복 수행문장
 *  	증가식
 *  }
 *   => 1부터 입력한 정수까지 합을 구해서 출력 
 * 	
 *	
 */
import java.util.Scanner;
public class 자바제어문_반복문_09 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
//		Runtime.getRuntime().exec("\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"");
		Scanner scan=new Scanner(System.in);
		System.out.println("정수(1~100) 입력:");
		int num=scan.nextInt();
		// 합을 누적하는 변수
		int sum=0;
		
		int i=1;
		while(i<=num)
		{
			sum+=i;
			i++;
		}
		System.out.println("while:결과값 sum="+sum);
		
		System.out.println("===== for문 =====");
		//sum = 55 따라서 sum을 0값으로 다시 초기화해야함 
		sum=0;
		for(i=1;i<=num;i++)
		{
			sum+=i;
		}
		System.out.println("for:결과값 sum="+sum);

	}

}
