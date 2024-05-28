package com.sist.io;

/*
 *    ObjectInputStream / ObjectOutputStream 
 *    => 객체 단위 저장 
 *       ----------
 *       직렬화                역직렬화 
 *                          ----------
 *                            -----
 *                            -----
 *                            -----
 *                            -----
 *                            -----
 *                          ----------
 *      ------------------------------
 *         |    |    |    |     |  ==> 직렬화
 *      ------------------------------
 *       
 *       
 */
import java.util.*;
import java.io.*;


class Student implements Serializable {
		private int hakbun;
		private String name;
		private int kor,eng,math;
		public Student(int hakbun, String name, int kor, int eng, int math) {
			this.hakbun = hakbun;
			this.name = name;
			this.kor = kor;
			this.eng = eng;
			this.math = math;
		}
		// 디폴트 생성자 
		public Student() {}
		public int getHakbun() {
			return hakbun;
		}
		public void setHakbun(int hakbun) {
			this.hakbun = hakbun;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getKor() {
			return kor;
		}
		public void setKor(int kor) {
			this.kor = kor;
		}
		public int getEng() {
			return eng;
		}
		public void setEng(int eng) {
			this.eng = eng;
		}
		public int getMath() {
			return math;
		}
		public void setMath(int math) {
			this.math = math;
		}
		
	}
	public class 라이브러리_01 {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
	        ArrayList<Student> list=new ArrayList<Student>();
	        list.add(new Student(1,"홍길동",90,80,70));
	        list.add(new Student(2,"이순신",70,60,70));
	        list.add(new Student(3,"심청이",80,80,80));
	        list.add(new Student(4,"김두한",60,70,60));
	        list.add(new Student(5,"박문수",90,90,90));
	        // 객체단위 저장 => list를 통으로 저장
	        ObjectOutputStream oos=null;
	        try
	        {
	        	File file=new File("c:\\java_data\\std.txt");
	        	if(!file.exists())
	        	{
	        		file.createNewFile();
	        	}
	        	// ObjectOutputStream 생성 => FileOutputStream 객체를 매개변수로 전송 
	        	FileOutputStream fos=new FileOutputStream(file);
	        	oos=new ObjectOutputStream(fos);
	        	// 객체단위 파일 저장 
	        	oos.writeObject(list); // 병렬 => 직렬 
	        	System.out.println("객체단위 저장 완료!!");
	        }catch(Exception ex)
	        {
	        	// 에러 확인 
	        	ex.printStackTrace();
	        }
	        finally
	        {
	        	try
	        	{
	        		oos.close();
	        	}catch(Exception ex) {}
	        }
	        
		}

	}