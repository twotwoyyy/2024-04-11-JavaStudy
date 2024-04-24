//배열 alpha를 모두 출력하고자 한다. 빈칸에 적절한 코드를 삽입하시오.
import java.util.*;
public class 배열문제_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha = {'a', 'b', 'c', 'd'};

		for(int i=0;i<alpha.length;i++) // 값 변경, 초기화 (인덱스 번호가 필요하다)
		     System.out.print(alpha[i]);
		System.out.println();
		System.out.println("====== for-each ======"); // 출력용 => 웹 => for-each
		for(char c:alpha)
		{
			// 받는 변수 데이터형 = 배열 데이터형 
			// 받는 변수 데이터형이 크다 
			System.out.print(c); // 실제 값 출력 => for-each
		}
		System.out.println();
		System.out.println("====== API =====");
		System.out.println(Arrays.toString(alpha));
	}

}
