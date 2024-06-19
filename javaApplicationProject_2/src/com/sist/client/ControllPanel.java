package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControllPanel extends JPanel{
   CardLayout card=new CardLayout();
   //EmpListPanel ep=new EmpListPanel();
   HomePanel homeP;
   GoodsDetailPanel detailP;
   FindPanel findP;
   BoardListPanel boardP;
   BoardInsertPanel boardInP;
   BoardDetailPanel boardDtailP;
   BoardDeletePanel bDeleteP;
   BoardUpdatePanel bUpdateP;
   
   ChatPanel1 chatP=new ChatPanel1();
   public ControllPanel()
   {
	   setLayout(card);
	   //add("EP",ep);
	   homeP=new HomePanel(this);
	   detailP=new GoodsDetailPanel(this);
	   findP=new FindPanel(this);
	   boardP=new BoardListPanel(this);
	   boardInP=new BoardInsertPanel(this);
	   boardDtailP=new BoardDetailPanel(this);
	   bDeleteP=new BoardDeletePanel(this);
	   bUpdateP=new BoardUpdatePanel(this);
	   
	   
	   add("HP",homeP);
	   add("CHAT",chatP);
	   add("DETAIL",detailP);
	   add("FIND",findP);
	   add("BOARD",boardP);
	   add("INSERT",boardInP);
	   add("BDETAIL",boardDtailP);
	   add("DELETE",bDeleteP);
	   add("UPDATE",bUpdateP);
	   
	   
	  
   }
}