package com.sist.io;
// inputStream / outputStream => 도스
// HTML/Window => 입력할 수 있는 창을 따로 만든다 
// 파일 입출력, 객체 단위 입출력 
// FileInputStream / FileOutputStream 
//  => 파일 복사 / 파일 다운로드 
// FileReader / FileWriter
//  => 크롤링 후 파일 저장, 파일을 이용한 관리 프로그램
// ObjectInputStream / ObjectOutputStream
//  => 파일을 읽어 화면에 출력
/*
 *   ArrayList => 파일 읽어서 저장
 *                --------
 *  --------------------------
 *       |
 *     자체 저장 
 */
import java.io.*;
/*
 *   파일 
 *    => 모드
 *       r => 읽기 => FileReader
 *       w => 쓰기 => FileWriter fw=new FileWriter("경로명") => w
 *        ------------> 파일 Create 
 *       a => append => 파일에 연속해서 출력 
 *       -----------------------------
 *                  FileWriter fw=new FileWriter("경로명",true) 
 */
public class 라이브러리_06 {

	public static void main(String[] args) {
		FileInputStream fis=null; //초기화 먼저 수행
		FileOutputStream fos=null; //초기화 먼저 수행
		// 파일 업로드 / 다운로드 / 파일 복사
		// 파일 제어 => 읽기/쓰기 => 한글이 가능 => FileReader / FileWriter
		
		try {
			fis=new FileInputStream("C:\\javaDev\\back.jpg");
			fos=new FileOutputStream("c:\\java_data\\back.jpg");
			int i=0;
			byte[] buffer=new byte[1024];
			/*
			 *  파일 읽기 
			 *  => read() => 한 글자씩 읽는다
			 *  => read(byte[] buffer, int s, int e) => 지정된 개수만큼 한번에 읽는다 
			 */
			while((i=fis.read(buffer, 0, 1024))!=-1){
				// i=> 읽은 byte 수
				fos.write(buffer,0,i); // 클라이언트에서 서버로 파일을 전송
				// => TCP : 1025,UDP
			}
			System.out.println("파일 복사 완료!!");
		}catch(Exception ex) {
			ex.printStackTrace();  
		}finally {
			try {
				fis.close();
				fos.close();
			}catch(Exception ex) {}
			
		}
	}

}
