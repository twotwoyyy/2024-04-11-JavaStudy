//86page

/*
 *	배열 선언
 *	------
 *	=> 선언과 동시에 초기화
 *	   int[] arr={10,20,30,40,50} ; 사용빈도는 거의 없다
 *				  -------------- 개수 확인 => 데이터형 => 연속적으로 메모리를 만든다 
 *	 *0x100로부터 두 번재 값 => arr[1] // 인덱스값=첨자
 *	   => String[]에서는 값을 설정하고 사용한다 
 *	   => int => 5개의 공간을 만들어준다 
 *		arr[1]=200 => 변경 
 *	=> 선언/초기값
 *		데이터형[] 배열명;
 *              ----- 변수의 식별자와 동일
 *      데이터형 배열명[]; //C언어 
 *      
 *      => 데이터형 : 배열에 저장되는 데이터가 종류 (어떤 데이터를 저장할 지)
 *         정수  : int[]
 *         실수  : double[]
 *         문자열 : char[]
 *         ---
 *         문자 : char[]
 *       => [] : 같은 데이터를 모아서 관리 => 배열 기호
 *       => 배열명 : 실제값을 가지고 있는 것이 아니라 실제 데이터가 저장디어 있는 위치 주소를 참조
 *         ---
 *	=> 기본값으로 초기화
 *    데이터형[] 배열명=new 데이터형[개수]
 *    ---------------------------
 *    int = 0 , double= 0.0, bollean = false
 *    
      int[] arr=new int[3]; ==> 0 0 0
      double arr=new double[3] ==> 0.0 0.0 0.0
      boolean arr=new boolean[3] ==> false false false 
      
      ** 변수
        => 실제 저장값
      ** 배열 / 클래스
      *  => 저장된 위치 메모리 주소값 
      *                  ------ 여러 개 데이터를 관리 => 참조형
      *  배열 : 인덱스를 이용해서 데이터를 가지고 안다, 수정
      *  클래스 : 인덱스가 없다
      *  -----------------
      *  주소 접근 연산자 => .  
 */
public class 배열_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr= {10,20,30,40,50};
		System.out.println("arr="+arr);
		
/*
 *      ----------------------
 *        10  20  30  40  50
 *      ----------------------
 *      [[I@6f2b958e => 메모리 주소값 
 */
	}

}
