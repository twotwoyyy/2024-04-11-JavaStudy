/*
 * 
 * 
 * 
 * 	*****
 *	*****
 *	*****
 *	*****
 *	1. 줄수 : 4 (1-4) for (줄수)
 *	2. 출력물 : * ==>5개 (1-5) 2차for
 *	
 *	2*1=2... 9*1=9
 *	..
 *	..
 *	2*9=18... 9*9=81
 *	
 *	1. 일차 for => 9줄을 만든다
 *	2. 이차 for => 8개를 출력
 *	----------------------
 */
public class 중첩_for_01 {

	public static void main(String[] args) {
		//실행 순서
		for(int i=1;i<=5;i++) { //줄수 ==> for 횟수 25
			for(int j=1;j<=5;j++) { //출력
				System.out.println("i="+i+",j="+j); // 실제 출력물 2차 for
			} 
			System.out.println();
		}
		// i=1 => j=1 j=2 j=3 j=4 j=5
		// i=2 => j=1 j=2 j=3 j=4 j=5
		// i=3 => j=1 j=2 j=3 j=4 j=5
		// i=4 => j=1 j=2 j=3 j=4 j=5
		// i=5 => j=1 j=2 j=3 j=4 j=5
	}

}
