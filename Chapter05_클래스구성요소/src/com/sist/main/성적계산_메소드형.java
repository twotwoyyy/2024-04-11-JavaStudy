package com.sist.main;
// 국어 영어 수학 점수 입력 받아서 => 메소드 1
// 총점 평균 학점 출력 => 메소드 4
import java.util.*;
class Student{
	// 반복 제거 => 메소드 목적 => 반복적인 소스 제거
	public int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.println(msg+" 입력:");
		return scan.nextInt();
	}
	//총점
	public int totalData(int kor,int eng,int math) {
		return kor+eng+math;
	}
	//평균
	public double avgData(int total) {
		return total/3.0;
	}
	//학점
	public char scoreData(int avg) {
		char c='A';
		switch(avg/10) {
			case 10:
			case 9:
				c='A';
				break;
			case 8:
				c='B';
				break;
			case 7:
				c='C';
				break;
			case 5:
				c='D';
				break;
			default:
				c='F';
			}
		return c;
	}
	//출력                          ===== 데이터형이 섞여있어서 배열도 불가 = > 멤버(전역)변수 쓰기
	public void print(int kor,int eng, int math,int total, double avg, char score) {
		System.out.println("국어 점수 :"+kor);
		System.out.println("영어 점수 :"+eng);
		System.out.println("수학 점수 :"+math);
		System.out.println("총점 :"+total);
		System.out.printf("평균 :%.2f",avg);
		System.out.println("\n학점 :"+score);
	}
	// 프로그램 실행 => 조립
	public void process() {
		int kor=input("국어");
		int eng=input("영어");
		int math=input("수학");
        //총점
		int total=totalData(kor, eng, math);
		//평균
		double avg=avgData(total);
		//학점
		char score=scoreData((int)avg);
		print(kor,eng,math,total,avg,score);
	}

	
}
public class 성적계산_메소드형 {
	public static void main(String[] args) {
		Student s=new Student();
		s.process();
	}
}
