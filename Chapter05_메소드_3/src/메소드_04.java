/*
 *	자바 ===== 오라클 ===== HTML/CSS/JavaScript
 *
 *	JSP ==== MVC ==== Spring === Python ==== Django
 *                                             | 차이썬 웹
 *            |        | 2차 (Vue3) | 데이터분석(Numpy,Pandas,MatplotLib)
 *           1차(Ajax,Jquary)
 *  Spring-Boot ==== AWS
 *        |           | 리눅스 명령어 => Hosting
 *      개인 (React , Redux, React-Query , NextJS)
 *      ------------------------------------------ MSA(Spring-Cloud) 
 *      
 *  자바
 *    = 변수 / 연산자 / 제어문 / 메소드
 *    --------------------------- 메소드 여러 개 묶음 (클래스) => 재사용 
 *    
 *    = 메소드 
 *      => 매개변수 : 사욪자로부터 받는 값 
 *      => 결과값 => 여떤 데이터를 넘겨주는지 
 *      => 메소드명 
 *      => 구현 => 결과값을 도출 
 *      => 어느 위치에서 호출 
 *    --------------------------------
 *    1) 사용자 로그인 요청 
 *    	매개변수: if,password
 *    	리턴형: boolean
 *    2) 아이디 중복 체크
 *    	매개변수: id
 *    	리턴형: boolean
 *    3) 우편 번호 검색 
 *    	매개변수: dong
 *    	리턴형: String[]
 *    4) 맛집 검색 
 *    	매개변수: 검색어(String)
 *    	결과값: String[]
 *    5) 노래 검색 
 *    	매개변수: 검색어(String)
 *    	결과값: String[]
 *      ---- 결과값을 브라우저에 출력 (웹)
 *      
 *      => 형식)
 *      	어떤 값을 받아서 어떤 값을 보내줄지 확인!! 
 *      	리턴형 메소드명(매개변수...)
 *      	---- 데이터형이 동일 
 *      	{
 *      		구현 ... (요청 처리) 
 *      		return 결과값 
 *      			   ---- 데이터형
 *      	}
 *      
 *      	데이터형 변수=메소드()
 *      	----- 리턴형에 설정한 데이터형이 동일 
 *      
 *      => 기능 분리
 *      	= 입력 부분 
 *      	= 처리 부분
 *      	= 출력 부분
 *         -------------- 모든 자바는 3가지 형태로 나눠서 처리 
 *         
 *      => 리턴형
 *      	한 가지 데이터형 (기본형) => 정수형/실수형/논리형/믄자형
 *      	ex) int 메소드명()
 *      		char 메소드명()......
 *      	여러 개 데이터형 (배열)
 *      	int[] 메소드명()
 *      	double[] 메소드명()
 *      
 *      => 매개변수는 여러 개 사용이 가능
 *      	=> 5개의 정수를 보내서 정렬하는 프로그램
 *      	   -------
 *      	   메소드명(int a,int b,int c, int d, int e) => (x) 매개변수는 최대 3개까지
 *      	   메소드명(int[] arr) => (o) 배열을 이용한다 
 *      
 *      => 메소드는 호출이 되면 항상 메소드 처음부터 실행 
 *      
 *      => 메소드 안에 선언되는 변수 : 메소드가 종료가 되면 사라진다 (지역변수)
 *         ----------------- 지역변수 (반드시 초기화)
 *         ----------------- 매개변수 => 지역변수 동일 
 */
// 배열
// 5개의 정수를 임의로 추출 => 최대값/최소값 
public class 메소드_04 {
	// 1. 정수 추출 => 입력
	static int[] input() { // 정수 여러 개를 전송한다는 뜻
		int[] arr=new int[5];
		for(int i=0;i<arr.length;i++) {
			arr[i]=(int)(Math.random()*100)+1;
		}
	return arr; // 배열은 배열명만 전송 => 배열명(메모리 주소) 
	}
	////////////////처리
	// 2. 최대값 구하기
	static int max(int[] arr) {
		int max=arr[0];
		for(int i:arr) {
			if(max<i)
				max=i;
		}
		return max;
	}
	// 3. 최소값 구하기
	static int min(int[] arr) {
		int min=arr[0];
		for(int i:arr) {
			if(min>i)
				min=i;
		}
		return min;
	}
	////////////////
	// 4. 출력
	static void process() {
		//1. 정수 5개 받기
		int[] arr=input();
		int max=max(arr);
		int min=min(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println("\n최대값:"+max);
		System.out.println("최소값:"+min);
	}
	public static void main(String[] args) {
		process();
//		// 1. 배열 선언 
//		int[] arr=new int[5];
//		// 2. 배열에 임의 추출된 값 저장
//		for(int i=0;i<arr.length;i++) {
//			arr[i]=(int)(Math.random()*100)+1;
//		}
//		// 3. 최대값/최소값 구하기
//		int max=arr[0];
//		int min=arr[0]; // 있는 값 하나 지정, 0,100 쓸 필요 x
//		
//		for(int i=0;i<arr.length;i++) {
//			if(max<arr[i])
//				max=arr[i];
//			if(min>arr[i])
//				min=arr[i];
//		}
//		// 전체 정수 출력
//		for(int i:arr) {
//			System.out.print(i+" ");
//		}
//		System.out.println();//다음줄 출력
//		System.out.println("최대값: "+max);
//		System.out.println("최소값: "+min);
//		
	}

}
