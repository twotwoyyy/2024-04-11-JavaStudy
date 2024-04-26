// 중첩 for 연습 
public class 중첩_for_03 {

	public static void main(String[] args) {
/*
 * 	1차 => 줄수 4    => 1~4
 *	2차 => 칸수(★) 5 => 1~5
 *
 *	★★★★★
 *	★★★★★
 *	★★★★★
 *	★★★★★
 *
 */
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				System.out.print("★");
			}
			System.out.println();
		}
/*
 *	ABCD
 *	EFGH
 *	IJKL
 *	MNOP
 *
 */		
		
		System.out.println("=====");
		char c='A'; // for밖에 들어가면 증가하면서 반복 
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=4;j++) {
				System.out.print(c++);
			}
			System.out.println();
		}
/*
 *	ABCD
 *	ABCD
 *	ABCD
 *	ABCD
 *
 */
		System.out.println("=====");
		for(int i=1;i<=4;i++) {
			c='A'; // for안에 들어가면 증가하지 않고 반복
			for(int j=1;j<=4;j++) {
				System.out.print(c++);
			}
			System.out.println();
		}
/*
 * 	★★☆★★
 * 	★★☆★★
 * 	★★☆★★
 * 	★★☆★★
 */
		System.out.println("=====");
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				if(j==3) 
					System.out.print("☆");
				else
					System.out.print("★");
			}
			System.out.println();
		}
/*
 * 	☆★★★★
 * 	★☆★★★
 * 	★★☆★★
 * 	★★★☆★
 * 
 */
		System.out.println("=====");
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				if(i==j) 
					System.out.print("☆");
				else
					System.out.print("★");
			}
			System.out.println();
		}
/*
* 	★★★★☆
* 	★★★☆★
* 	★★☆★★
* 	★☆★★★
* 
* 	i   j
*   1   5 => i+j=6 1=6-j
*   2   4
*   3   3
*   4   2
*   5   1 => i+j=6
*/
		System.out.println("=====");
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				if(i==6-j) 
					System.out.print("☆");
				else
					System.out.print("★");
			}
			System.out.println();
		}
/*
 * ☆★★★☆
 * ★☆★☆★
 * ★★☆★★
 * ★☆★☆★
 * 
*/
		System.out.println("=====");
		for(int i=1;i<=4;i++) {
			for(int j=1;j<=5;j++) {
				if(i==6-j || i==j) 
					System.out.print("☆");
				else
					System.out.print("★");
			}
			System.out.println();
		}
		/*
		 * ♠♥♣◈
		 * ♠♥♣◈
		 * ♠♥♣◈
		 * ♠♥♣◈ // 패턴이 있으면 배열 사용 
		 * 
		*/
				System.out.println("=====");
				String[] img= {"","♠","♥","♣","◈"}; // 배열을 사용한다 
				for(int i=1;i<=4;i++) {
					for(int j=1;j<=4;j++) {
						System.out.print(img[j]);
					}
					System.out.println();
				}
	}

}
