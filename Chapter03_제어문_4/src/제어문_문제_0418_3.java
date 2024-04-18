/*
 * 3) 2+4+6+....100까지의 정수의 합을 구하고 출력하라 (for 사용)
 * 초기화/ 범위 / 증가식 
 * 
 *    for => 반복문 => 반복 횟수가 있는 경우에 주로 사용 
 *    			     -------------------------
 *    초기값: int i=0, int i=1, int i='A'...
 *    조건식: 어디까지 출력 (범위) i<=10
 *    증가: 2씩, 1씩 ...
 */
public class 제어문_문제_0418_3 {

	public static void main(String[] args) {
		int sum=0;
		for(int i=2;i<=100;i+=2)
		{
			sum+=i;
			System.out.println("i="+i+"sum="+sum);
		}
		System.out.println("2+4+5+...100까지의 합:"+sum);
		/*
		 * 수열이 아닌 경우에는 for를 사용할 수 없다 
		 * ---패턴 
		 */
	}

}
