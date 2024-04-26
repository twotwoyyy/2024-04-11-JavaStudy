// API

import java.util.Arrays;

public class 중첩_for_11 {
	// 전부 지원하지 않는다 => 직접 만들어서 사용 (오버로딩) , 기존 라이브러리 수정해서 사용 (오버라이딩)

	public static void main(String[] args) {
		int[] arr=new int[10];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("정렬 전:");
		System.out.println(Arrays.toString(arr));
		
		//정렬
		Arrays.sort(arr);
		System.out.println("정렬 후:");
		System.out.println(Arrays.toString(arr)); // 라이브러리 ASC만 지원한다 
		
		// DESC
		for(int i=arr.length-1;i>=0;i--) {
			System.out.print(arr[i]+" ");
		}
	}

}
