/*
 *	1. 배열 생성(선언)
 *		=> 같은 데이터형만 모아서 관리
 *		=> 데이터형[] 배열명;    // 같은 데이터형을 모은다, 사용 용도가 같을 때 ex) 이미지,제목,조회수...
 *		   --------
 *		=> 데이터형 배열명[]; => 사용은 가능 (C/C++)
 *	2. 초기화
 *		=> 배열명=new 데이터형[]{} => 초기화
 *		=> 데이터형[] 배열명={값,값...} => 변경하지 않는 데이터형 
 *		=> 데이터형[] 배열명=new 데이터형[개수] => 임의로 초기화 
 *			=> 기본 디폴트 값 
 *				int => 0
 *				char => '\0'
 *				double => 0.0
 *				long => 0L
 *				boolean => false
 *	3. 저장 개수 확인
 *		=> length => 배열명.length
 *	4. 데이터 변경
 *		=> 연속적인 메모리 공간 
 *		   --------------
 *			=> 인덱스 번호를 이용해서 데이터를 변경,읽기
 *			=> 변수,배열
 *			   -------
 *			  | 읽기/쓰기
 *		    배열 => 읽기/쓰기(수정)
 *		=> 인덱스 번호는 0번부터 시작한다
 *
 *		int[] arr=new int[3]
 *		값을 변경=> arr[0]=100; // 일반 변수 취급을 한다 
 *		----------------------------------------
 *		* 인덱스는 0부터 순차적으로 되어있다
 *		=> 반복문을 사용하기 편리하다 
 *		=> 5개 지정하면 => 변경할 수 없다 : 고정적 (가변형 => 클래스 제작)
 *		=> 소프트웨어 라인 
 *		   ----------- 하루 개발 코딩량 
 *
 *	5. for-each
 *		형식) 92page
 *		for(데이터형 변수명:배열명)
 *		{   ----------- 인덱스 번호가 아니라 => 실제 배열에 저장된 값 
 *          배열데이터형과 변수명의 데이터형 일치 .. 
 *          형변환을 할 수 없다 
 *		}
 *		=> 배열의 값을 변경하거나,초기화 (x)
 *		=> only 출력만 한다
 *		=> 웹에서 주로 사용
 *		-------------------------------
 *		배열 => 선언한 개수만큼만 사용이 가능
 *		** 개수를 늘리는 경우 : 새로운 배열을 생성 (큰게)
 *			=> 데이터 복사후 사용 arraycopy(), for ... 
 *		=> 인덱스를 이용하기 때문 => 제어문 사용이 편리 
 *		   => 인덱스는 0번부터 순차적으로 되어있다 

 * 
 * /*
 *  선언후 값 => true, false,true,true,false
 *  boolean[] boo=new boolean[4]=> false,false,false,false
 *  boo[0]=true; 값 변경
 *  --------------------------------------------------------
 *  boolean[] boo;
 *  boo=new boolean[]{true,false,true,false}
 *  --------------------------------------------------------
 *  int[] arr=new int[3];
 *  -----
 *  데이터형 ==> [] 숫자가 들어갈 수 없다 
 *  
 *  	System.out.println(Arrays.toString(arr));// 저장된 값 확인 
 */

import java.util.Arrays;

public class 배열_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 정수 10개 저장 => 용도가 같은 경우 => 배열 / 일반변수 확인 
		int[] arr=new int[10]; // 변수 10개 같다//초기값 모르는 상태 new 
		// arr이름으로 10개의 데이터를 제어 
		// char 5개 => 'A' ~ 'E' (초기값 지정)
		char[] alpha= {'A','B','C','D','E'};
		// 데이터형변환
		double[] data= {10.5,20.5,30.5,40.5,50};
		// double d=50 => d=50.0
		// 작은 데이터형은 추가가 가능 
		for(double d:data)
		{
			System.out.print(d+" ");
		}
		System.out.println();
		int[] arr2={'A','B','C','D','E'}; // {}=> int,byte,char
		for(int i:arr2)
		{
			System.out.print(i+" ");
		}
		System.out.println();
		char[] ch= {65,66,67,68,69};
		// int <=> char 형변환 없이 저장이 가능하다(예외사항) 
		for(char c:ch)
		{
			System.out.print(c+" \n");
		}
		boolean[] boo=new boolean[5];
		// false 저장
		for(boolean b:boo)
		{
			System.out.println(b);
		}
		String[] str=new String[5];
		//클래스 => null (null은 주소가 없는 경우)
		for(String s:str)
		{
			System.out.print(s+"\n");
		}
		double[] dd=new double[5];
		for(double d:dd)
		{
			System.out.println(d);
		}
	}

}
