package com.sist.user;
import java.util.*;
import com.sist.manager.*;
import com.sist.vo.*;
public class UserMain {

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in); // new는 메모리를 생성 
		GenieManager mgr=new GenieManager(); 
		while(true) {
			System.out.println("================메뉴=================");
			System.out.println("1. 목록");
			System.out.println("2. 검색");
			System.out.println("3. 상세보기");
			System.out.println("4. 종료");
			System.out.println("===================================");
			System.out.print("메뉴 선택:");
			int menu=scan.nextInt();
			if(menu==1) {
				int total=mgr.genieTotalPage();
				System.out.print("1~"+total+"사이의 페이지 입력:");
				int page=scan.nextInt();
				//데이터를 읽어오라고 요청
				Genie[] genie=mgr.genieListData(page);
				for(Genie m:genie) {
					System.out.println(m.getRank()+"."+m.getTitle());
				}
			}
			else if(menu==2) {
				System.out.print("검색어 입력:");
				String title=scan.next();
				Genie[] genie=mgr.genieFindData(title);
				for(Genie m:genie) {
					System.out.println(m.getRank()+"."+m.getTitle());
				}
			}
			else if(menu==3) {
				System.out.print("상세보기 할 번호 입력:");
				int mno=scan.nextInt();
				Genie mmm=mgr.genieDetailDate(mno);
				System.out.println("순위."+mmm.getRank());
				System.out.println("곡명:"+mmm.getTitle());
				System.out.println("가수명:"+mmm.getArtist());

			}
			else if(menu==4) {
				System.out.println("프로그램 종료");
				break;
			}
			else {
				System.out.println("없는 메뉴입니다!!");
			}			
		}
	}
}
