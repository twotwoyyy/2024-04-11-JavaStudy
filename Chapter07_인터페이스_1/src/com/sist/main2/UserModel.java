package com.sist.main2;
import java.util.*;
public class UserModel implements Model {
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("게시판(1),맛집(2),레시피(3),여행(4),공지사항(5):");
		int menu=scan.nextInt();
		Container c=new Container();
		Model model=c.getModel(menu);
		model.execute();
//		if(menu==1) {
//			BoardModel model=new BoardModel();
//			model.execute();
//		}
//		if(menu==2) {
//			FoodModel model=new FoodModel();
//			model.execute();
//		}
//		if(menu==3) {
//			BoardModel model=new BoardModel();
//			model.execute();
//		}
//		if(menu==4) {
//			BoardModel model=new BoardModel();
//			model.execute();
//		}
//		if(menu==5) {
//			BoardModel model=new BoardModel();
//			model.execute();
//		}
//	}
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
	}
}
