package com.sist.client;

import java.awt.CardLayout;

import javax.swing.*;

public class ControllerPanel extends JPanel{
	public CardLayout card=new CardLayout();
	public HomePanel hp=new HomePanel();
	public FindPanel fp=new FindPanel();
	public NewsPanel np=new NewsPanel();
	public ReviewPanel rp=new ReviewPanel();
	public ChatPanel chp=new ChatPanel();
	public ControllerPanel() {
		setLayout(card);
		add("HOME",hp);	
		add("FIND",fp);
		add("NEWS",np);
		add("REVIEW",rp);
		add("CHAT",chp);
		
	}
	
}
