package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.*;

public class ControllerPanel extends JPanel{ 
	public CardLayout card=new CardLayout(); // 묶어서 원하는 형식으로 보여준다 Panel들을 한번에 묶음 
	public HomePanel hp=new HomePanel();
	public FindPanel fp=new FindPanel();
	public ControllerPanel() {
		setLayout(card);
		add("HOME",hp);	
		add("FIND",fp);
	}

}
