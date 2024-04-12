/*
 * 		돈 : 5600원
 *         => 지출
 *            점심 : 3000원
 *            커피 : 1500원
 *            심심풀이 : 250원
 *            
 */
public class 변수_4 {

	public static void main(String[] args) {
		int money=5600;
		int a=3000;
		int b=1500;
		int c=250;
		int d=a+b+c;
		int total=money-d;
		
		System.out.println(money-a-b-c+"원");
		System.out.println("남은돈"+total+"원");

	}

}
