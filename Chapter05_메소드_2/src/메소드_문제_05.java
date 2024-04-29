//5.문자열의 소문자를 대문자로 바꾸는 메소드를 구현하시오.

import java.util.Scanner;

public class 메소드_문제_05 {
	static String munje_5(String str) {
		String res="";
		for(int i=0; i<str.length();i++){
			char c=str.charAt(i);
			if(c>='A' && c<='Z') {
				res+=c;
			}
			else if(c>='a' && c<='z') {
				res+=(char)(c-32);
			}
			else {
				res+=c;
			}
		}
		return res;
		//return str.toUpperCase(); // .toUpperCase (대문자 변경) 문자열 
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.println("문자열 입력:");
		String str=scan.next();
		String res=munje_5(str);
		System.out.println(res);
	}

}
