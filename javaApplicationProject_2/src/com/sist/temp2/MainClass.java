package com.sist.temp2;
import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		ZIPCODEDAO zipcode=ZIPCODEDAO.newInstance();
		System.out.println("=============================");
		Scanner scan=new Scanner(System.in);
		System.out.print("검색어 입력:");
		String DONG=scan.next();
		ArrayList<ZIPCODEVO> list=zipcode.zipFind(DONG);
		for(ZIPCODEVO vo:list) {
			System.out.println(vo.getZIPCODE()+" "
					+vo.getSIDO()+" "
					+vo.getGUGUN()+" "
					+vo.getDONG()+" "
					+vo.getBUNJI()+" ");
		}
	}
}
