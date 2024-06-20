package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class ControllPanel extends JPanel{
	CardLayout card=new CardLayout();
	HomePanel homeP;
	BookDetailPanel detailP;
	FindPanel findP;
	ChatPanel chatP=new ChatPanel();
	BoardListPanel boardP;
	BoardInsertPanel bInsertP;
	BoardDetailPanel bDtailP;
	BoardDeletePanel bDeleteP;
	BoardUpdatePanel bUpdateP;
	MyPagePanel myP;
	NewsPanel newsP;
	ClientMain cMain;


	public ControllPanel(ClientMain cMain) {
		
		this.cMain=cMain;
		setLayout(card);
		homeP=new HomePanel(this);
		detailP=new BookDetailPanel(this);
		findP=new FindPanel(this);
		myP=new MyPagePanel(this);
		
		boardP=new BoardListPanel(this);
		bInsertP=new BoardInsertPanel(this);
		bDtailP=new BoardDetailPanel(this);
		bDeleteP=new BoardDeletePanel(this);
		bUpdateP=new BoardUpdatePanel(this);
		newsP=new NewsPanel(this);
		
		   
		add("HOME",homeP);
		add("CHAT",chatP);
		add("DETAIL",detailP);
		add("FIND",findP);
		add("BOARD",boardP);
		add("INSERT",bInsertP);
		add("BDETAIL",bDtailP);
		add("DELETE",bDeleteP);
		add("UPDATE",bUpdateP);
		add("MYPAGE",myP);
		add("NEWS",newsP);

	}
}
