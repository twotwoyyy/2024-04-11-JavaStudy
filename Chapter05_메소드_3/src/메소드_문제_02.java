/*
 * 2. 임의의 정수를 배열로 생성해서 입력하고 정렬하는 프로그램 작성 
	임의의 정수 입력 (배열 생성후)
	정렬 처리
	출력 

	형식) 
		static 리턴형 메소드명 (매개변수)
		------ 메소드는 반드시 메모리에 저장 => 사용이 가능 
		       JVM에 의해 자동으로 저장할 때 쓴다  
		       모든 사람이 동일하게 쓸 수 있도록 하는 것
		       주로 쓰이지 않음 (공유)
		{
			return 값; 
		}
		static int aaa(int a)
		{
			int b=10; => 전송 
			return b;
		}
		static int[] bbb(int[] arr)
		{
			return arr;  // 배열 => 매개변수에 있는 변수를 리턴으로 사용 
		}
		
		static int input()
		{
			Scanner scan=new Scanner(System.in);
			System.out.print("입력");
			int a=scan.nextInt();
			return a; => return scan.nextInt(); // 호환가능
		}
		
		고려 사항
		=> 1. 리턴형
		=> 2. 매개변수 
		=> 3. 변수명 , 메소드명이 동일할 때도 있다 => 가급적 사용 x
		
		버블 정렬 ==> 뒤에서부터 고정 / 선택 정렬은 앞에서부터 고정  
		30 10 40 20 50 => j,j+1
		== ==
		10 30
		   == ==
		   30 40
		      == ==
		      20 40
		         == == 
		         40 50
	    --------------- for 1
	    10 30 20 40 50
	    == ==       --
	    10 30 
	       == == 
	       20 30
	          == ==
	          30 40 
	   ---------------- for 2
	    10 20 30 40 50
	    == ==    -----
	    10 20
	       == ==
	       20 30
	  ----------------- for 3
	    10 20 30 40 50
	    == == --------
	    10 20
	  ----------------- for 4
	    10 20 30 40 50 
		
 */

import java.util.Scanner;

public class 메소드_문제_02 {
	static int[] input() { // 정수 여러 개를 전송한다는 뜻
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.println("==== 변경전 ====");
		for(int i:arr) {
		System.out.print(i+" ");
		}
		System.out.println("\n==== 변경후 ====");
		for(int i=0;i<arr.length-1;i++) {
			for(int j=0;j<arr.length-(1+i);j++) {
				if(arr[j]>arr[j+1]) {
					int temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
		}
		for(int i:arr) {
			System.out.print(i+" ");
		}
	return arr; // 배열은 배열명만 전송 => 배열명(메모리 주소) 
	}
	
	public static void main(String[] args) {
		input();
	}

}
