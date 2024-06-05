package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	public CardLayout card=new CardLayout();
	public HomePanel hp=new HomePanel();
	public FindPanel fp=new FindPanel();
	public BoardPanel bp=new BoardPanel();
	public ChatPanel chp=new ChatPanel();
	public NewsPanel np=new NewsPanel();
	public ControlPanel() {
		setLayout(card);
		add("HOME",hp);	
		add("FIND",fp);
		add("BOARD",bp);
		add("CHAT",chp);
		add("NEWS",np);
		
	}
}
