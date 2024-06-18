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

	
	
	public ControllPanel() {
		setLayout(card);


		homeP=new HomePanel(this);
		detailP=new BookDetailPanel(this);
		findP=new FindPanel(this);
		add("HOME",homeP);
		add("CHAT",chatP);
//		add("DETAIL",detailP);
		add("FIND",findP);

	}
}
