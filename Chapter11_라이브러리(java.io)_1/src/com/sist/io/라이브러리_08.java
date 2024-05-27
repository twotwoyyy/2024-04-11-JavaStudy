package com.sist.io;
/*
 *  파일쓰기 FileWriter
 *  => 크롤링한 데이터를 저장
 *  파일읽기 FileReader
 *  => 프로그램 제어
 *  => 읽기 => 한줄씩 (파일에 있는 데이터를 메모리에 한번에 저장) / 한글자 (파일에 있는 데이터를 한 개씩) 
 *  => 
 *  
 */
//369page
/*
 *   FileWriter (FileOutputStream) => write(), close()
 *   FileReader (FileIntputStream) => read(), close()
 *   => 한 글자씩 읽기 / 한 글자씩 쓰기
 *      ---------- => 여러 글자 입력이 가능
 *          FileWriter => write(String s)
 *          RileOutputStream => write (byte[])
 *          
 *          String에서 byte[] 변경
 *          String s="aaa";
 */
import java.io.*;
public class 라이브러리_08 {

	public static void main(String[] args) {
		// 1. FileOutputStream을 이용한 저장
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream("c:\\java_data\\member.txt");
			// 파일이 없는 경우 자동 생성
			// 파일이 있는 경우에는 문자 저장이 가능 
			//한 글자 입력 (byte / 여러 개 글자 한번에 입력(byte[])
//			fos.write('A');
//			fos.write('B');
//			fos.write('C');
			String msg="ABCDEFGHIJKLMNOP";
			fos.write(msg.getBytes());
			//여러 글자 입력시 바이트 단위로 저장 => byte[] => getBytes()
			System.out.println("저장 완료!!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				fos.close();
			}catch(Exception ex) {}
		}
	}

}
