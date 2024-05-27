package com.sist.io;

import java.io.FileWriter;
import java.io.*;

// 파일 쓰기 => 문자 스트림 (2byte) => 한글 사용이 편리

public class 라이브러리_09 {

	public static void main(String[] args) {
		FileWriter fw=null;
		try {
			fw=new FileWriter("c:\\java_data\\board.txt",true); // 없는 경우에 자동 생성
			// 폴더는 생성하지 않는다
			String msg="써보자\r\n"; // \r\n필수 (다음줄)
			fw.write(msg);
			System.out.println("저장완료!!");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		finally {
			try {
				fw.close();
			}catch(Exception ex) {}
		}
	}

}
