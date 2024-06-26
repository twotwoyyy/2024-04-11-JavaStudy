/*
 *	메소드 : 기능 처리 (사용자 요청 처리) => 한 개의 기능만 수행이 가능하게 만드는 명령문의 집합 
 *		명령문 
 *   	1. 변수 선언
 *   	2. 연산 처리
 *   	3. 제어문 처리
 *  1) 메소드 구조
 *  	[접근지정어][옵션] 리턴형 메소드명(매개변수목록) => 선언부 (원형)
 *  	{
 *  		구현부...
 *  		......
 *  		......
 *  		return 값;
 *  			=> 메소드는 종료 => return에서 종료 
 *  			   => 중간에 올 수 있다 
 *  			=> return은 생략이 불가능
 *  			   예외 => void를 이용하는 경우엔 생략하지만 
 *  					  컴파일러에 의해 자동으로 return이 첨부된다
 *  	}
 *  
 *  	접근지정어 : 다른 클래스에서 접근하는 범위 
 *  	------- public / protected / private / default (같은 폴더에서만 접근이 가능)
 *  	옵션 : 
 *  		1) default : 없는 경우 
 *  		2) static : 자동 메모리 할당 => 공유 
 *  		3) abstract : 추상 메소드 => 선언 => 프로그램에 맞게 구현해서 사용
 *  		   -------- 버튼 클릭 / 마우스 클릭 / 키보드 입력 
 *  		4) final : 종단 메소드 => 수정이 안되는 메소드  
 *  	리턴형 : 사용자 요청에 대한 결과값을 가져오는 것 
 *  			=> 반드시 1개만 전송 , 여러 개일 때는 배열/ 클래스 사용 
 *  			   ------------ 기본형 (정수,실수,논리,문자)
 *  	메소드명 : 변수 식별자와 동일 
 *  	매개 변수 : 여러 개 사용이 가능 => 사용자가 보내주는 값 
 *  	메소드 호출 : 메소드를 호출시에는 메소드는 처음부터 끝까지 사용
 *  				=> 원래 호출한 위치로 복귀 
 *  	ex) void display() 
 *  		{
 *  		1
 *  		2
 *  		3
 *  		}
 *  
 *  		main()
 *  		{
 *  			1 ------------- 시작 1 
 *  			2 ------------- 2
 *  			display(); ----------- 메소드 블록으로 이동
 *  					1 2 3
 *  			3 ------------- 3
 *  			4 ------------- 4
 *  		}
 *  		
 *  		int display()
 *  		{
 *  			1
 *  			2
 *  			3
 *  			return 5;	
 *  		}
 *  		main()
 *  		{
 *  			(1)
 *  			(2)
 *  			int a=display(); => 1 2 3 수행 
 *  				  |    |
 *  				  ------ return 값을 전송
 *  				a=5
 *  			(3)
 *  			(4)
 *  		}
 *  		
 *  		=> 1. 반복적인 문장이 있는 경우 (반복 제거)
 *  		=> 2. 구조적인 프로그램 => 단락을 나눠준다 (수정, 오류처리 편리) 
 *  		=> 3. 재사용 => main은 다른 클래스에서 호출이 불가능
 *  				| ==> CTRL+C (o)
 *  				| ==> 있는 그대로 호출해서 사용 => 메소드
 *  		=> 4. 객체 지향 프로그램은 클래스와 클래스의 상호 연결
 *  		=> 클래스 / 기능 / 조립 
 *  				   |    | => 메인 보드 (main이 있는 클래스)
 *  				  CPU
 *  				  메모리
 *  				  하드디스크
 *  				  사운드
 *  				  ...
 *  				  ...
 *  		   ----------------
 *  		=> System.out.print() / random() ..
 *  		예)
 *  			사용자가 로그인 요청
 *  			=> id, pwd => 매개변수
 *  			=> 결과값 : boolean
 *  
 *  			사용자가 아이디 중복체크
 *  			=> id => 매개변수
 *  			=> 결과값 : boolean
 *  			
 *  			웹 => 매개변수 (이미지 클릭 , 페이지 번호 클릭, 입력 (검색어)
 *  				=> 화면 이동 => return
 *  				=> 출력할 내용이 많은 경우 => 배열 / 컬렉션
 *  		----------------------------------------------------
 *  		 매개 변수 전송법
 *  		--------------
 *  		1. 값 전송 ===> 메모리를 따로 만들어서 처리
 *  		  Call By Value 
 *  		  기본형 ==> 원본은 유지 
 *  		2. 주소 전송 ==> 메모리가 같은 곳에서 전송 
 *  	      Call By Reference
 *  		  배열 / 클래스 => 원본이 변경 
 *  		 예외) => String(일반 기본형과 동일)
 *  		
 */
public class 메소드정리_01 {
	// call by value => 실제 값만 전송 (메모리 전송 x) => 다른 메모리 생성 (기본형, String) 
	// call by reference => 메모리 주소를 넘겨준다 => 같은 메모리 제어 (배열, 클래스)
	static void rand(int[] arr) {
		System.out.println("arr="+arr);
		for(int i=0; i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
	}
	/*
	 *	얕은 복사
	 *	int[] arr=new int[5];
	 *	int[] temp=arr;
	 */
	public static void main(String[] args) {
//		int[] nums=new int[5]; // 값을 넣으면 값 자체가 변경, 메모리 주소가 동일 
//		System.out.println("nums="+nums); // 주소가 같다 => 주소가 같은 경우엔 같은 메소리를 제어
//		rand(nums);
//		for(int i:nums) {
//			System.out.print(i+" ");
//		}
		int[] arr={10,20,30,40,50};
		int[] temp=arr;
		// temp는 arr의 별칭 => temp=arr => 기본형은 주소x , 값만 전송 
		// Call By Reference 
		
		temp[1]=200; //자신의 메모리를 넘겨주기 때문에 넘겨준 배열 자체가 변경이 될 수 있다 
		System.out.println(temp[1]);
		System.out.println(arr[1]); // 주소 변경 
	}

}
