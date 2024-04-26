// 구구단
/*
 * 	줄수 => 1차 for ==> 9번 수행
 *  
 *	2*1=2 ........9*1=9
 *  -----         ----- => 8번 수행 (2~9) (2차 for)
 *	.
 *	.
 *	.
 *	2*9=18 .......9*9=81
 */
public class 중첩_for_02 {

	public static void main(String[] args) {
		for(int i=1;i<=9;i++) { //줄수
			for(int j=2;j<=9;j++) { //출력을 몇개 : 2단부터니까 2부터 
				//구구단 출력
				System.out.printf("%2d * %2d = %2d\t",j,i,i*j);
			}
			// 줄수 => 다음 줄에 출력
			System.out.println();
		}
	}

}
