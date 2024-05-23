package com.sist.util;
import java.text.*;
import java.util.*;
//ChoiceFormat
public class 라이브러리_09 {

	public static void main(String[] args) {
		double[] limit= {59,60,70,80,90};
		String[] grade= {"F","D","C","B","A"};
		
		int[] score=new int[10];
		Random r=new Random();
		for(int i=0;i<score.length;i++) {
			score[i]=r.nextInt(101);
		}
		System.out.println(Arrays.toString(score));
		ChoiceFormat cf=new ChoiceFormat(limit,grade);
		
		for(int i:score) {
			System.out.println(i+":"+cf.format(i));
		}
	}
}
