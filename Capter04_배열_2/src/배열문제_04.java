//4. 양의 정수 10개 입력받아 배열에 저장하고, 배열에 있는 정수 중에서 3의 배수만 출력하는 프로그램을 작성하라

import java.util.*;
public class 배열문제_04 {

	public static void main(String[] args) {
	int[] arr=new int[10];
	for(int i=0;i<arr.length;i++)
	{
		arr[i]=(int)(Math.random()*100)+1;
	}
	System.out.println(Arrays.toString(arr));// 저장된 값 확인 
	for(int i:arr)
	{
		if(i%3==0)
			System.out.print(i+" ");
	}
	}

}
