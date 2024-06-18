package com.sist.main;
import java.util.*;
import com.sist.dao.*;
public class MainClass {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("동/읍/면 입력: ");
		String dong=scan.next();
		ZipcodeDAO dao=new ZipcodeDAO();
		ArrayList<ZipcodeVO> list=dao.postFind(dong);
		
		// 출력
		for(ZipcodeVO vo:list) {
			System.out.println(vo.getZipcode()+" "
					+vo.getAddress()); // Address에 이미 리턴 받아놓아서 호출만
		}
	}
}
