package com.sist.main;
import java.awt.image.DataBufferByte;
import java.util.*;
// Diary.class /  클래스구성요소_메소드2.class
class Diary2{
	private int year;
	private int month;
	private int week;
	private int lastday;
	
	//private => Diary2 클래스 안에서는 사용이 가능 => 다른 클래스에서 사용해야 한다면 getter/setter
	public int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		return scan.nextInt();
	}
	//요일 구하기
	public void getWeek() {
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year); 
		cal.set(Calendar.MONDAY, month-1);
		cal.set(Calendar.DATE,1);
		week=cal.get(Calendar.DAY_OF_WEEK)-1; // -1 
		lastday=cal.getActualMaximum(Calendar.DATE);
	}
	//달력 출력 => 전역변수 없이 => 전역변수(멤버변수)
	public void print() {
		System.out.println(year+"년도 "+month+"월");
		String[] strWeek= {"일","월","화","수","목","금","토"};
		for(String s:strWeek) {
			System.out.print(s+"\t"); // err은 빨간색으로 출력 (에러 출력)
		}
		System.out.println("\n");
		for(int i=1;i<=lastday;i++) {
			if(i==1) {
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			 System.out.printf("%2d\t",i);
			week++; 
			if(week>6) {
				week=0;
				System.out.println();
			}
		}
	}
	public void process() {
		 year=input("년도");
		 month=input("월");
		getWeek();
	    print();
	}
}
public class 클래스구성요소_메소드02 {
	public static void main(String[] args) {
		Diary2 d=new Diary2();
		d.process();
	}
}
