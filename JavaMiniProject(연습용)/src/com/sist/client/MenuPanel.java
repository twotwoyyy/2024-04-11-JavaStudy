package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MenuPanel extends JPanel{
	JButton homeBtn,findBtn, boardBtn, chatBtn, newsBtn, myBtn, exitBtn;
	public MenuPanel() {
		setLayout(new GridLayout(1,6,5,5));
	//  setLayout(new GridLayout(6,1,5,5)); 옆 메뉴 출력
		homeBtn=new JButton("홈");
		findBtn=new JButton("도서 검색");
		newsBtn=new JButton("뉴스");
		boardBtn=new JButton("게시판");
		chatBtn=new JButton("채팅");
    	myBtn=new JButton("마이페이지");
		exitBtn=new JButton("나가기");
		
		// add는 추가되는 순서대로 버튼이 나타난다
		add(homeBtn);
		add(findBtn);
		add(newsBtn);
		add(boardBtn);
		add(chatBtn);
		add(myBtn);
		add(exitBtn);
	}
}
