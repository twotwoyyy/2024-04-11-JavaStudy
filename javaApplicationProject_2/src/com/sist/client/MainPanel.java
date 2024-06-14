package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class MainPanel extends JPanel{
	MenuPanel menuP=new MenuPanel();
	ControlPanel ctrP=new ControlPanel();
	//EmpListPanel ep=new EmpListPanel();
	public MainPanel() {
		setLayout(new BorderLayout());
		add("North",menuP);
		add("Center",ctrP);
		
	}
}
