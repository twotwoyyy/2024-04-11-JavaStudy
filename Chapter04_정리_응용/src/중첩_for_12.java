/*
 *	정렬
 *	--- 버블 정렬 (인접한 수끼리 비교) ==> 뒤에부터 고정
 *	27 22 17 23 9 2 ==> 2 9 17 22 23 27   ASC(올림차순)
 *	
 *	27 22 17 23 9 2
 *	-- --
 *  22 27
 *	   -- --
 *     17 27
 *        -- --
 *        23 27
 *           -- --
 *           9  27
 *              -- --
 *              2  27  =======================> 1-5 비교
 * -------------------------- 1 round (for1)
 * 22 17 23  9  2 (27)
 * -- --
 * 17 22
 *    -- --
 *    22 23
 *       -- --
 *        9 23
 *          -- --
 *          2  23      =======================> 2-4 비교
 * -------------------------- 2 round (for2)
 * 17 22 9  2  (23 27)
 * -- --
 * 17 22
 *    -- --
 *    9  22 
 *       -- --
 *       2  22         =======================> 3-3 비교
 * -------------------------- 3 round (for3)
 * 17 9  2 (22 23 27)
 * -- --
 * 9  17
 *    -- --
 *    2  17            =======================> 4-2 비교
 *-------------------------- 4 round (for4)
 * 9  2  (17 22 23 27)
 * -- --
 * 2  9                =======================> 5-1 비교
 *-------------------------- 5 round (for5)
 * 2 9 17 22 23 27 
 * 
 *:: 인접한 것끼리 비교 : 버블 소트 
 * 
 * !! 항상 한 바퀴 덜 돌린다 length-1;
 * 
 *   i   j
 *   1   5 ==> 6
 *   2   4 ==> 6
 *   3   3 ==> 6
 *   4   2 ==> 6
 *   5   1 ==> 6
 *   
 *   i+j=6 / j=6-i
 *   
 */
import java.util.*;
public class 중첩_for_12 {

	public static void main(String[] args) {
		int[] arr= {27,22,17,23,9,2};
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr));
		System.out.println("정렬 후:");
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				// 0 1  1 2  2 3 비교
				if(arr[j]>arr[j+1]) { 
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			System.out.println((i+1)+"Round:"+Arrays.toString(arr));
		}
		System.out.println();
		System.out.println("ASC");
		System.out.print(Arrays.toString(arr));
		System.out.println();
		
		// DESC
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-1-i;j++) {
				// 0 1  1 2  2 3 비교
				if(arr[j]<arr[j+1]) { 
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			System.out.println((i+1)+"Round:"+Arrays.toString(arr));
		}
		System.out.println();
		System.out.println("DSEC");
		System.out.print(Arrays.toString(arr));
	}
}
