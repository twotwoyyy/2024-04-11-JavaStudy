/*
 *	정렬
 *	---
 *	선택 정렬
 *		30 20 40 10 50 => ASC(올림차순) / DESC(내림차순)
 *                                     => 50 40 30 20 10 
 *                       => 10 20 30 40 50
 *   ASC
 *   30 20 40 10 50
 *   -- --
 *   20 30
 *   --    --
 *   20    40
 *   --       --
 *   10       20
 *   --          --
 *   10          50
 *   ------------------- 1round => for 한 바퀴
 *   10    30 40 20 50
 *   --    -- -- 
 *   고정   30 40 
 *         --    --
 *         20    30
 *         --       --
 *         20       50
 *  -------------------- 2round => for 두 바퀴
 *  10 20  40  30  50
 *  -----  --  --
 *  고정    30  40
 *         --      --
 *         30      50
 *  -------------------- 3round => for 세 바퀴
 *  10 20 30 40 50
 *  -------- -- --
 *  고정      40 50
 *  -------------------- 4round => for 네 바퀴
 *  10 20 30 40 50
 *  -----------
 *  고정  ----------------> length-1 
 *  
 *  버블 정렬
 */
import java.util.*;
public class 중첩_for_08 {

	public static void main(String[] args) {
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("정렬전:");
		System.out.println(Arrays.toString(arr));
		System.out.println("정렬후:");
		/*
		 * int a=10
		 * int b=20
		 * a=b / a=20,b=20
		 * b=a ==>20
		 * 따라서 temp 써야 한다
		 * int temp=a; 
		 * a=b; 
		 * b=temp; 
		 */
		for(int i=0;i<arr.length-1;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp; //temp 임시기억장소를 써야 값이 달라짐, 안 쓰면 값이 같아진다 
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
