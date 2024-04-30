import java.util.*;
public class 실무_정렬 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("==== 변경전 ====");
		for(int i:arr) {
		System.out.print(i+" ");
		}
		Arrays.sort(arr); // 실무는 for쓸 필요 없이 라이브러리 이용 
		System.out.println("\n==== 변경후 ====");
		for(int i:arr) {
		System.out.print(i+" ");
		}
		System.out.println("\n10 이진법");
		int num=10;
		System.out.println(Integer.toBinaryString(num));
	}

}
