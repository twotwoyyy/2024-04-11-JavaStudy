package com.sist.io;
// FileReader
import java.io.*;
/*
 *   java.io 
 *   -------
 *   | 특징 : 데이터 이동 통로를 만들어서 데이터를 입출력을 한다
 *            ----------
 *            | 스트림 : 단점 (단방향 통신) // 읽기면 읽기, 쓰기면 쓰기, 동시 불가능 
 *                     => 네트워크는 읽기/쓰기 동시에 처리해야함 (쓰레드)
 *                     ---------------------------------------
 *                     채팅 => 서버에서 보내는 값 / 서버로 보내는 값이 동시에 처리되어야 한다 
 *                     
 *   IO => InputStream / OutputStream 
 *         송신 / 수신 => 1byte => 자바에서는 각국의 언어를 사용할 수 있게 2byte를 사용할 수 있게 제작
 *         ----------
 *         1byte => 바이트 스트림 
 *                  ~InputStream, ~OutStream
 *         2byte => 문자 스트림
 *                  ~Reader, ~Writer
 *         
 *         상속도
 *           InputStream       OutputStream
 *               |                  |
 *         FileReader           FileWriter
 *         BufferedReader       BufferedWriter
 *          
 *       => ObjectInputStream / ObjectOutputStream 
 *          객체 단위 저장    => 직렬화 / 역직렬화 
 *       ----------------------------------------------
 *        메모리 입출력 : Scanner 
 *        파일 입출력 : IO
 *        네트워크 : IO
 *     ** io 사용시 반드시 예외처리를 한다 (CheckedException)
 *     입출력 
 *      ------------------------- 바이트 스트림 -----------------------------
 *      => 입력 메소드 : read() => 한 글자 읽기 read(), 여러 글자 읽기 read(byte[])
 *      => 쓰기 메소드 : writer() => 한 글자 츌력, 여러 글자 출력 write(byte[]) write(int)
 *      ------------------------------------------ 파일 닫기 : close()
 *       FileInputStream / FileOutStream 
 *       => 웹 : 파일 업로드 / 파일 다운로드 / 파일 복사 
 *      -------------------------- 문자 스트림 ------------------------------
 *      => 읽기 메소드 : read(), read(char[])
 *      => 쓰기 메소드 : write(char), write(char[]), write(String)
 *       FileReader / FileWriter
 *      ------------------------------------------------------------------
 *      파일에 있는 데이터를 메모리에 한번에 이동 후에 사용이 가능 => 속도가 빠르다 Buffered~
 *      => 읽기 메소드 : readLine() => 한 줄씩 읽어 온다
 *      => 쓰기 메소드 : write(String)
 *        BufferedReader / BufferedWriter
 *        => 한번에 데이터를 한 줄씩 읽는 경우에 주로 사용한다 
 *        
 *        => 명사 / 조사 => 파일을 이용
 *           ----------- 형태소 분석 
 *      ------------------------------------------------------------------
 *      => FileReader => r (읽기 모드)
 *      => FileWriter => w (쓰기 모드), a(쓰기 모드)
 *                      |create      | append
 *                      덮어쓰기         기존의 데이터 결합 
 *                      ------------------------------------------
 *                      생성자 new FileWriter("파일명",true) ==> a (기존의 데이터 결합)
 *                           new FileWriter("파일명") ==> w
 *      => 파일을 읽어서 ArrayList에 저장 후에 데이터를 활용
 *                   --------- 배열
 *      => Properties (보안이 좋다)
 *         ---------- 파일의 확장자 : .properties
 *                              ===> 구분자가 있어 사용하기 편리하다 => 사용자정의
 *                                   외부 라이브러리에서 주로 사용 : 보안
 *                                   ----------
 *                                   | 데이터베이스 관련 (MyBatis, JPA, Spring)
 *                                     *** 필수적으로 사용 => 스프링 부트 (환경 설정) 
 *                                     ------------- properties 파일 / yml 파일을 주로 이용 
 *        ---------- 작성법 
 *                    변수=값 
 *                    -- key역할 : 중복 x
 *                    id=admin
 *                    name=홍길동
 *                    --------------- Map 방식
 *                    => 데이터베이스 정보 : 오라클 위치, 사용자명, 비밀번호
 *                                     ------------------------ 누구나 데이터베이스에 접근이 가능 
 *                    => Validation : 유효성 검사  
 *                    ------------------------------------------------------
 *                    => 라이브러리로 제작 : 등록만 하면 읽어온다 
 *                    
 *     => 컬렉션 + IO
 *        ----------- 배열(x)
 *          1. 데이터 수집 : 파일에 저장 => List로 저장 => 사용
 *                       | 파일 저장하지 않으면 구동시마다 데이터 수집 계속 해야한다 
 *                       | 데이터 수집 없이 파일만 읽어온다 
 *          2. 데이터 수집시 중복된 데이터 => 제거 => Set
 *          3. 관리하는 클래스가 많은 경우 
 *             -------------------
 *             new => 메모리 누수 현상 많이 발생 => 이를 한 개의 주소로만 사용할 수 있게 만든다 
 *                                          --------------------------------- 싱글턴
 *                                                                     => Map에 저장 
 *                                                                     
 *       ------------------------------------------------------------------------------
 *       1. network
 *       2. sql
 *       3. J2EE
 *       4. 외부라이브러리 : Jsoup ... mbnrepository.com
 *       5. Spring
 *       6. python 연동
 *       
 *             
 */
public class 라이브러리_11 {

	public static void main(String[] args) {
		FileReader fr=null;
		try {
			fr=new FileReader("c:\\java_data\\seoul_location.txt"); // Reader는 자동생성이 안된다 
			int i=0;
			long start=System.currentTimeMillis();
			String data="";
			while((i=fr.read())!=-1) {
				data+=(char)i;
			}
			long end=System.currentTimeMillis();
			System.out.println(data);
			System.out.println("걸린 시간>>"+(end-start)); // BufferedReader가 훨씬 빠르다 
		}catch(Exception ex) {
			
		}finally {
			try {
				fr.close();
			}catch(Exception ex) {}
		}
	}

}
