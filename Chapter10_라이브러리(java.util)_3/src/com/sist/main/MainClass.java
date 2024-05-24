package com.sist.main;
import java.util.*;
public class MainClass {
	public static void main(String[] args) {
		Set_05 music=new Set_05();
		
		Set<String> genie=music.genieDate();
		System.out.println("================== 지니 뮤직 ==================");
		for(String title:genie) {
			System.out.println(title);
		}
		
		System.out.println("================== 멜론 뮤직 ==================");
		Set<String> melon=music.melonDate();
		for(String title:melon) {
			System.out.println(title);
		}
		System.out.println("============ 지니 뮤직에만 있는 곡 ================");
		Set<String> gTemp=new HashSet<String>();
		gTemp.addAll(genie);
		gTemp.removeAll(melon);
		for(String title:gTemp) {
			System.out.println(title);
		}
		System.out.println("============ 멜론 뮤직에만 있는 곡 ================");
		// 지니는 변경이 된 상태 => 세 곡만 있는 상태 => 따라서 템포
		Set<String> mTemp=new HashSet<String>();
		mTemp.addAll(melon);
		mTemp.removeAll(genie);
		for(String title:mTemp) {
			System.out.println(title);
		}
		System.out.println("============ 지니 뮤직 + 멜론 뮤직 ================");
		// UNION / UNIONALL
		// 중복 허용 ArrayList 
		ArrayList<String> list=new ArrayList<String>();
		list.addAll(genie);
		list.addAll(melon);
		for(String title:list) {
			System.out.println(title);
		}
		System.out.println("========= 지니 뮤직 + 멜론 뮤직 (중복없음)============");
		Set<String> list2=new HashSet<String>();
		list2.addAll(genie);
		list2.addAll(melon);
		
		for(String title:list2) {
			System.out.println(title);
		}
	}
}
