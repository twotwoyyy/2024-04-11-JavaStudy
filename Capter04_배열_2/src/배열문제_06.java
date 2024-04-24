//6. int[] num = { 94, 85, 95, 88, 90 };다음 배열에서 최대값,최소값을 출력하는 프로그램을 작성하시오
import java.util.*;
public class 배열문제_06 {

	public static void main(String[] args) {

// 생성과 동시에 초기화 
		int num[]={ 94, 85, 95, 88, 90 };
		int max=num[0]; // 값 초기화 할때 0
		int min=num[0]; 
		for(int i:num)
		{
			if(max<i)
				max=i;
			if(min>i)
				min=i;
		}
		System.out.println(Arrays.toString(num));
		System.out.println("최댓값:"+max);
		System.out.println("최솟값:"+min);
	}	
}
