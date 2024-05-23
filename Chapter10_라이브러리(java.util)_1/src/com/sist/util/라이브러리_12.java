package com.sist.util;
import java.util.*;
import java.text.*;
public class 라이브러리_12 {

	public static void main(String[] args) {
		// 오늘 날짜 읽기
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-M-d");
		String today=sdf.format(date);
//		StringTokenizer st=new StringTokenizer(today,"-");
//		int year=Integer.parseInt(st.nextToken());
//		int month=Integer.parseInt(st.nextToken());
//		int day=Integer.parseInt(st.nextToken());
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		
		System.out.print("월 입력:");
		int month=scan.nextInt();
		
		System.out.print("일 입력:");
		int day=scan.nextInt();
		
		System.out.printf("%d년도 %d월 %d월\n\n",year,month,day);
		
		String[] strWeek= {"일","월","화","수","목","금","토"};
		for(String s:strWeek) {
			System.out.print(s+"\t");
		}
		System.out.println();
		//달력 출력 => 1의 요일, 마지막 날짜 
		Calendar cal=Calendar.getInstance();
		//날짜 설정 
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1); // 1일자의 요일 확인
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		week=week-1;
		
		int lastday=cal.getActualMaximum(Calendar.DATE);
		
		//출력
		for(int i=1;i<=lastday;i++) {
			if(i==1) {
				//공백
				for(int j=0;j<week;j++) {
					System.out.print("\t");
				}
			}
			System.out.printf("%2d\t",i);
			
			week++;
			
			if(week>6) { //일요일이면
	            week=0;
	            System.out.println();
	         }
		}
	}
}
