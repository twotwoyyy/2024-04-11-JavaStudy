//출력 형식
/*
 *	= System.out.println()
 *                 ====== ln() => new Line 새로운 줄로 출력
 *    System.out.println("Hello ")
 *    system.out.println("Java")
 *    Hello
 *    Java
 *    = System.out.print ==> 옆으로 출력
 *    = System.out.print("Hello ")
 *    = System.out.print("Java")
 *    Hello Java
 *    = System.out.printf()
 *    서식이 있는 출력
 *    %d => 정수
 *    %f => 실수
 *    %c => 문자
 *    %s => 문자열
 *    ------------------------------------------------
 *    = 자바에서 표현법
 *    정수표현법
 *       = 10진법 -> 10, 20 .... (0~9까지 사용)
 *       = 8진법 -> 010 =>8 (0~7까지만 사용); 앞에 0을 붙어서 구분
 *       = 16진법 -> 0x10 =>16 ;앞에 0x가 붙음; 색상 표현할 때 많이 씀
 *       = 2진법 -> 0b10 =>2 ;앞에 0b가 붙음;
 *    --------------------------------------------------
 *    10=> 32bit/ 10L => 64bit
 *    int                long
 *    실수표현법 => 10.5 ,  10.5F
 *              ------  ------- 32bit (4byte) 1byte=>8bit
 *              저장하는 메모리 크기 => 64bit
 *    문자표현법 => 'A' (한 글자만)
 *    문자열표현법 => "Hello" (여러 문자 사용이 가능)
 */
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(010); //8진법이라 8로 출력
		System.out.println(0x10); //16진법이라 16으로 출력
		System.out.println(0b10); //2진법이라 2로 출력
		System.out.println(100000000000L);//L안붙이면 오류뜸 32bit를 넘어섰기 때문 , 해결하기 위해서 L붙이면 됨> 64bit
		System.out.println("1000000000000000000"); // 숫자가 아니라 오류 발생x 문자로 변경
		System.out.println("홍길동"); // "홍길동"이라고 출력하고 싶을 경우 \역슬러시 이용\ -> \"
		System.out.println("\"홍길동\"");
		System.out.println("c;\\javaDev\\movie.txt");// 역슬러시 두 개 써야함 \\ 경로명!!
		// 명령문이 종료하면 반드시 ; 찍어야 함
		// 자바는 {를 옆으로 붙여서 출력시켜야 함
	    // {괄호열고 엔터 치면 자동으로 들여쓰기 됨
		// 홍길동 남자 <일정 간격을 띄고 싶은 경우
		System.out.println("홍길동\t남자"); // \t(탭키) 일정 간격을 띄어서 출력해줌
		// 홍길동 
		// 남자 
		//라고 출력하고 싶은 경우 \n < new line이라는 약자
		System.out.println("홍길동\n남자");
		// 홍길동 남자 26 이라고 출력하고 싶은 경우 (일정간격을 띄고 print를 써야 함 println (x))
		System.out.print("홍길동\t");
		System.out.print("남자\t");
		System.out.print("26\n");

		System.out.println("★");
		System.out.println("★★");
		System.out.println("★★★");
		System.out.println("★★★★");
		System.out.println("★★★★★");
		/*
		 * i      j    i=j -->j=i
		 * 줄수   별표
		 * 1      1
		 * 2      2
		 * 3      3
		 * 4      4
		 * 5      5
		 * 
		 * i     j     ==> 역순이면 +
		 * 줄수   별표
		 * 1      5    i+j ==> j=6-i
		 * 2      4
		 * 3      3
		 * 4      2
		 * 5      1
		 * 
		 */
		
		/*
		 * for(int i=0;i<=5;i++) { for(int j=0;j<=5-i;j++) { System.out.print("★"); }
		 * System.out.println(); }
		 */
		// 영역 드래그하고 컨트롤 쉬프트 슬러시 > 바로 주석 걸기
		  // 컨트롤 쉬프트 역슬러시 > 주석 풀기
		
		System.out.println("10 20 30 40 50");
		System.out.printf("%-3d%-3d%-3d%-3d%-3d",10,20,30,40,50);
		// ooo
		//  10 => +
		// 10  => -
		

		 
		}

}
