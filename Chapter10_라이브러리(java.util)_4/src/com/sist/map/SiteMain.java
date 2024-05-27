package com.sist.map;
import java.util.*;
public class SiteMain {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("1.로그인 2.회원가입 3.공지사항 4.게시판 5.맛집 >> 메뉴 번호 입력: ");
		int menu=scan.nextInt();
		if(menu==1) {
			LoginModel model=new LoginModel();
			model.execute();
		}
		else if(menu==2) {
			JoinModel model=new JoinModel();
			model.execute();
		}
		else if(menu==3) {
			NoticeModel model=new NoticeModel();
			model.execute();
		}
		else if(menu==4) {
			BoadModel model=new BoadModel();
			model.execute();
		}
		else if(menu==5) {
			FoodModel model=new FoodModel();
			model.execute();
		}
		else {
			System.out.println("존재하지 않는 메뉴입니다!!");
		}
		// 이를 간단히 코딩 => 인터페이스 
	}
}
