package com.sist.client;

import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;

public class ControlPanel extends JPanel{
	public CardLayout card=new CardLayout();
	EmpListPanel ep=new EmpListPanel();

	public ControlPanel() {
		setLayout(card);
		add("EP",ep);
	}
}
