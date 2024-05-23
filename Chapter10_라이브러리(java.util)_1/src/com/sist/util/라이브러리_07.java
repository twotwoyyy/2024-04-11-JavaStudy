package com.sist.util;
/*
 *	java.text => 변환 (Format)
 *  = SimpleDataFormat : 날짜 변경 
 *  = DacimalFormat : 정수 변환 => 1,000
 *  = ChoiceFormat : switch
 *  = MassageFormat : SQL, 출력 형태 
 */
import java.util.*;
import java.util.Date;
import java.text.*;
public class 라이브러리_07 {

	public static void main(String[] args) {
		// 시스템의 날짜 
		Date date = new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		/*
		 *	년도 : yyyy/yy
		 *  월  : MM/M => 05/5 (월은 대문자!!!)
		 *  일  : dd/d
		 *  시간 : hh/h
		 *  분  : mm/m
		 *  
		 */
		System.out.println(sdf.format(date));
		StringTokenizer st=new StringTokenizer(sdf.format(date),"-");
		System.out.println(st.nextToken()+"년도"
				+st.nextToken()+"월"
				+st.nextToken()+"일");
		// 게시판에 날짜 출력, 예약일..
		
		sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(sdf.format(date));
	}

}
