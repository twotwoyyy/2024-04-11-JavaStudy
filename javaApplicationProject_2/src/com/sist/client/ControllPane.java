package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class ControllPane extends JPanel{
	CardLayout card=new CardLayout();
//	EmpListPanel ep=new EmpListPanel();
	HomePanel homeP;
	GoodsDetailPanel detailP;
	FindPanel findP;
	ChatPanel1 chatP=new ChatPanel1();

	
	
	public ControllPane() {
		setLayout(card);

//		add("EP",ep);
		homeP=new HomePanel(this);
		detailP=new GoodsDetailPanel(this);
		findP=new FindPanel(this);
		add("HOME",homeP);
		add("CHAT",chatP);
		add("DETAIL",detailP);
		add("FIND",findP);

	}
}
