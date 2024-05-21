package com.sist.main;
/*
 *	9장 => 메소드 
 *  java.lang
 *  java.util
 *  
 *  10장 
 *  자료구조 => 웹 => 크롤링 => 배열을 대체 => 컬렉션 / 제네릭스
 *  
 *  11장
 *  파일 입출력 관련 
 *  
 *  12장 
 *  핵심 부분 (java.sql) => 오라클 연동 
 *  ----------------------------- 사용자 정의 메소드는 없다 => 조립 
 *  
 *  1. 데이터형 / 변수 / 연산자 / 제어문 
 *  2. 클래스 구성요소 : 멤버변수 (static), 메소드, 생성자 
 *  3. 재사용기법 => 상속 / 포함 클래스 
 *  4. 클래스의 종류 : 추상 클래스 / 인터페이스 
 *  5. 예외처리 방법 : try~catch / throws 
 *  ---------------------------------- 자바의 기본 문법
 *  6. 라이브러리 
 *  7. 조립 (라이브러리 이용해서 프로그램 제작)
 *  ----------------------------------
 *   => 사용 (웹) => 자바는 변경사항이 없다 
 *                 출력 (윈도우, 도스, 브라우저가 다 다르다)
 *                                ------ HTML/CSS (Java+HTML)
 *              => java와 HTML 분리 => MVC
 *                                  ----- Spring 
 *              => 기술 => 자바스크립트 
 *              => 배포 => AWS (리눅스) 
 *   => 데이터베이스 라이브러리 : MyBatis / JPA 
 *   => Full Stack : Ajax, VueJS, React(React-Query), Redux
 *                                                    ------ MVC구조
 *   => 서버가 분리 (역할별 => 서버를 따로 제작) => MSA구조
 *  -------------------------------------------------------------------
 *   파이썬 => 데이터 분석 => 브라우저 (장고) => React 
 *           -------- 넘파이 / 판다스 / MatPlotLib
 *  -------------------------------------------------------------------
 *   자격조건 : Spring(Spring-Boot), Vue/React(React-Query), MyBatis, JPA
 *          => 리눅스 사용자 
 *          => MSA
 *          => 정보처리 기사 (산업기사)
 *          
 *   예외처리 : 에러 발생에 대한 사전 방지 프로그램
 *    => 비정상 종료를 방지하고 정상 수행이 가능하게 만들어 준다 
 *    => 에러가 나면 에러를 자동 수정해주는 것이 아니라 에러 부분을 점프한다
 *    => 에러부분의 문장을 컴파일시 무시(통과)한다 => 예외처리 
 *    *에러발생
 *     - 처리 (조건문=고려) => 조건문으로 처리 어려운 경우 => 예외처리 이용
 *     - 프로그래머의 실수 (배열 인덱스 초과, 파일명 오류 ...) 
 *     - 사용자 입력값 오류 => 웹(유효성 검사 => 자바스크립트) 
 *    *에러 종류 
 *     Error : 수정이 불가능한 에러 (메모리 부족, 이클립스 오류...)  
 *     Exception : 수정이 가능한 에러 => 가벼운 에러 
 *                 ------------ 프로그램 소스 안에서 수정 
 *                 IP 연결시 IP 오류, 크롤링시 사이트 URL오류, 파일명 오류 등..
 *                 라이브러리 사용시 라이브러리를 로드 안 한 경우 
 *    *정상처리 방법 (예외처리 방법)
 *      = 직접 처리 (프로그래머가 에러를 직접 잡아 복구) => 예외복구 
 *        try~catch~finally 
 *      = 간접 처리 (떠맡기기) => 메소드 호출시에 처리 
 *        예측되는 에러만 선언 => 라이브러리, 복잡한 소스가 있는 경우 
 *        메소드() throws 예외 종류
 *        메소드를 호출해서 사용하려면 뒤에 선언된 예외를 처리하고 호출한다
 *        => 복구 불가, 예외를 피해간다 => 예외 회피  
 *      = 임의 발생 : 테스트 (에러발생시 => 경고) 
 *        throw
 *      = 사용자 정의 : 자바에서 전체적인 예외처리를 지원하지 않는다 => 필요시에는 직접 제작 
 *      
 *    * catch에는 순서가 존재
 *      = throws는 순서가 없다
 *      = 예외처리의 상속도 (반드시 예외처리(CheckedException), 필요시 처리(UnCheckedException)
 *                     ----- 컴파일시 예외처리 확인         ----- 실행시에 처리 (사용자 입력값 받아서) 
 *    * 상속도
 *       Object => java.lang.* => 모든 클래스의 최상위 클래스 (모든 클래스는 Object 상속을 받는다)
 *          |
 *       Throwable => 예외 처리의 최상위 클래스 => Error/Exception 
 *          |
 *      ------------------------
 *      |                      |
 *      Error               Exception => 예외처리의 기본 클래스 
 *                             |
 *                   ---------------------------------------
 *                  |                                       |
 *          CheckedException                       UnCheckedException 
 *          ----------------                       -------------------
 *          컴파일시 예외 처리 확인                       컴파일시 예외 처리 미확인
 *          => 반드시 예외처리 사용                  => 필요시에만 예외 처리 사용 (생략 가능)
 *                 |                                       |
 *      = IOException : 입출력                      = RuntimeException (최상위 클래스)
 *            파일, 메모리                                     |
 *      = SQLException : 오라클 연결/해제              = ArrayIndexOfBoundsException 
 *         연결시 => 오라클 서버 주소                       배열의 인덱스 초과
 *         SQL 문장 오류, 입력값 오류                   = NumberFormatException 
 *         자바(입력값 전송) => 오라클에서 결과값              정수가 필요한데 웹이나 윈도우는 문자열만 전송 => 정수로 변환후 사용
 *         오라클: 전체프로그램에서 사용되는 데이터 저장          Integer.ParseInt() => 문자열을 정수로 변환시 주로 발생
 *         ---- 데이터 저장 : 크롤링                      ----- 기본형 int를 사용하기 쉽게 클래스화
 *      = MalFormedURLException                      기본데이터형을 클래스화 => Wrapper
 *         IP,URL 주소 틀린 경우                      = ArithmeticException 
 *         크롤링 (정적: Jsoup, 동적: 셀레니움)             0으로 나누기
 *      = IntteruptedException : 쓰레드             = NullPointerException
 *      = ClassNotFoundException                     배열의 값 등이 null 
 *         클래스 이름으로 메모리 할당                    = ClassCastException
 *         new 대신                                   클래스 형변환이 올바르지 않은 경우 
 *         
 *    * 사용법
 *     1) try ~ catch ~ finally
 *     
 *        try 
 *        {
 *           정상적으로 실행되는 코드
 *           => 예상못한 에러가 발생할 수 있다 => 프로그래머의 실수, 사용자 입력값 오류
 *           => 프로그램에서 중요시 : 에러에 대한 대비 
 *        } catch (예외처리 클래스) => 멀티 가능 (여러 개 사용 가능) 
 *        {
 *           에러를 잡아서 복구 => 에러 확인 
 *           *에러 확인 : getMessage() , PrintStackTrace() => 에러 메세지 및 에러 위치 확인
 *        }
 *        finally 
 *        {
 *           try/catch 상관없이 무조건 수행하는 문장 
 *           => 파일 닫기, 오라클 닫기, 서버 닫기 ... 
 *           => 연결 => 회수 (메모리 회수가 안된다) 
 *        }
 *     
 *     2) throws => 선언, 라이브러리 
 *        ------------------------
 *        메소드() throws 예외처리 등록 => 떠맡기기
 *        -----------------------
 *        | 메소드를 호출하려면 등록 예외처리를 하고 사용
 *        | 이미 소스가 만들어진 경우 
 *        | 호출하게 되면 날 수 있는 에러 언급, 처리해서 쓸 것 
 *        
 *      void disp() throws ArrayIndexOutOfBoundsException,NumberFormatException
 *      {
 *      }
 *      => 호출에 등록된 예외처리를 한 후에 사용한다 
 *      public void print()
 *      { 
 *        disp() => 정상 수행 (예외처리가 없어도 된다) => UnCheckedException 
 *      }
 *      
 *      public void disp() throws Exception 
 *                                ---------- CheckedException (반드시 오류처리)
 *      {
 *      }
 *      
 *      public void disp()
 *      {
 *        disp(); => 오류 발생
 *      }
 *      
 *      1. 떠맡긴다 
 *      public void print() throws Exception 
 *                                 --------- 이런 에러가 발생할 수 있다 시스템에 알려만 준다 
 *      {
 *      }
 *      
 *      2. 직접 처리한다
 *      public void print()
 *      {
 *         try 
 *         {
 *           disp();
 *         }catch(Exception ex){} ==> 예외처리 후에 사용
 *      }
 *      
 *      ----------------------------------------------
 *      public void disp() throws IOException, SQLException, InterruptedException,
 *                         ClassNotFoundException 
 *      {
 *      
 *      }
 *      
 *      public void print() throws IOException, SQLException, InterruptedException,
 *                          ClassNotFoundException 
 *      {
 *         disp();
 *      }
 *      
 *      public void print()
 *      {
 *        try
 *        {
 *          disp();
 *        }catch(throws IOException){}
 *         catch(SQLException){}
 *         catch(InterruptedException){}
 *         catch(ClassNotFoundException){}
 *      }
 *      
 *      ==> 예외처리 전체 통합 (가장 큰 클래스를 쓴다 Exception)
 *      pubic void print()
 *      {
 *        try
 *        {
 *          disp();
 *        }catch(Exception e){}
 *      }
 *      
 *      라이브러리 => 이미 소스 코딩이 되어 있는 상태 => try~catch보다 throws가 더 편리하다
 *                                                        ------ 유지보수 
 *             
 */
public class 예외처리_01 {
	// display()호출시에 => 이런 에러가 발생할 수 있다고 예상
	// 사용시에는 반드시 예외처리를 하고 사용한다
	// throws뒤에는 예외 등록 => 순서가 없다
	// throws뒤에 예외 등록은 보통 CheckedException 
	/*
	 *	try~catch: 초기화 블록, 생성자, 메소드에서 사용 가능
	 *  throws : 생성자, 메소드에서만 사용가능 
	 *  *** 권장사항 : 가급적이면 try~catch를 사용한다
	 *  *** 라이브러리는 프로그래머에게 처리 요청 => throws 문장으로 메소드가 정의 
	 */
	public void display() throws ArrayIndexOutOfBoundsException, NumberFormatException,
								 NullPointerException, IllegalArgumentException
								 {
		
								 }
	public void print() throws ArrayIndexOutOfBoundsException, NumberFormatException,
	NullPointerException, IllegalArgumentException {
		display();
	}
	
	public void print2() throws Exception{
		display();
	}
	public void print3() { // UnCheckedException (생략 가능)
		display();
	}
	public void print4() {
		try {
			
		}catch(ArrayIndexOutOfBoundsException e) {}
		catch(NumberFormatException e) {}
		catch(NullPointerException e) {}
		catch(IllegalArgumentException e) {}
	}
	public void print5() {
		try {
			display();
		}catch(Exception ex) {}
	}
	
	
	public void disp() throws Exception{
		
	}
	//예외처리는 축소할 수 없다 // 더 크거나 같아야 한다 
	public void print6() throws Throwable{
			disp();
	}
	public static void main(String[] args) {

	}

}
