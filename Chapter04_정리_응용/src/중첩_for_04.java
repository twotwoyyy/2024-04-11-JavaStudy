/*
 * ★
 * ★★
 * ★★★
 * ★★★★
 */
public class 중첩_for_04 {

	public static void main(String[] args) {
		for(int i=1;i<=4;i++) {
			//한 줄에 ★을 출력
			for(int j=1;j<=i;j++) {
			System.out.print("★");
			}
			System.out.println();
		}
/*	★★★★ i=1 j=4 ==> i+j=5 => j=5-i // 모든 for는 수열을 가지고 있음 
 * 	★★★  i=2 j=3
 * 	★★
 * 	★
 * 
 */
		for(int i=1;i<=4;i++) {
			//한 줄에 ★을 출력
			for(int j=1;j<=5-i;j++) {
			System.out.print("★");
			}
			System.out.println();
		}
/*
 *     *
 *    **
 *   ***
 *  ****
 *  
 *  ****
 *   *** 
 *    **
 *     *
 *     
 * 줄수  공백 별포   공백 => i+j=4 ==> j=4-i  / k=i
 *  i   j   k
 *  1   3   1
 *  2   2   2
 *  3   1   3
 *  4   0   4
 */
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4-i;j++) {
			System.out.print(" ");
			}
			for(int k=1;k<=i;k++) {
			System.out.print("*");
			}
			System.out.println();
		}
/*
 * 줄수  공백 별포   j+1=i j=i-1 / i+k=5 k=5-i
 *  i   j   k
 *  1   0   4
 *  2   1   3
 *  3   2   2
 *  4   3   1
 */
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=i-1;j++) {
			System.out.print(" ");
			}
			for(int k=1;k<=5-i;k++) {
			System.out.print("*");
			}
			System.out.println();
		}
	}
}
