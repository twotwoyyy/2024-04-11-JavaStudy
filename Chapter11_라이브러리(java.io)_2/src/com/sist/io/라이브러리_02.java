package com.sist.io;
//데이터 추가
import java.io.*;
import java.util.*;
/*
 *  파일 입출력 => 프로젝트
 *  ObjectInputStream / ObjectOutputStream => 사용빈도가 많이 없어진다
 *  => SQL 오라클 연동
 *  => 개인 정보 저장 => 네트워크 연결이 안되면 => 파일
 *  => 대피 (에러) => 오라클 정지 
 */
public class 라이브러리_02 {

	public static void main(String[] args) {
		ObjectInputStream ois=null;
		try {
			FileInputStream fis=new FileInputStream("c:\\java_data\\std.txt");
			ois=new ObjectInputStream(fis);
			ArrayList<Student> list=(ArrayList<Student>)ois.readObject();
			// 제네릭까지 데이터형
			for(Student s:list) {
				System.out.println(s.getHakbun()+" "
						+s.getName()+" "
						+s.getKor()+" "
						+s.getEng()+" "
						+s.getMath()+" ");
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			try {
				ois.close();
			}catch(Exception ex) {}
		}
	}

}
