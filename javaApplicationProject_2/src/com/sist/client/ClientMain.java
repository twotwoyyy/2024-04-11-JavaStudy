package com.sist.client;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class ClientMain extends JFrame implements ActionListener{
	CardLayout card=new CardLayout();
	LoginPanel loginp=new LoginPanel();
	MenuPanel mainp=new MenuPanel();
	ControlPanel contp=new ControlPanel();
	public ClientMain() {
		setLayout(card);
		add("MAIN",mainp);
		add("LOGIN",loginp);
		setLayout(null);
		mainp.setBounds(170, 15, 600, 30);
		add(mainp);
		contp.setBounds(5, 60, 875, 585);
		add(contp);
	
		
		setSize(900,700);
		setVisible(true);
		
		setResizable(false); // 최대화 버튼을 사라지게 한다 화면을 딱 맞추게 한다 // (윈도우 크기 고정시 사용) 
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼 클릭시 메모리 해소가 된다 (프로그램 종료) 
		
		mainp.homeBtn.addActionListener(this);
		mainp.findBtn.addActionListener(this);
		mainp.boardBtn.addActionListener(this);
		mainp.chatBtn.addActionListener(this);
		mainp.newsBtn.addActionListener(this);
		mainp.exitBtn.addActionListener(this);
	}
	public static void main(String[] args) {
		new ClientMain();
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(mainp.homeBtn==e.getSource()) { 
			contp.card.show(contp, "HOME");
		}else if(mainp.findBtn==e.getSource()) { 
			contp.card.show(contp, "FIND");
		}else if(mainp.boardBtn==e.getSource()) {
			contp.card.show(contp, "BOARD");
		}else if(mainp.chatBtn==e.getSource()) {
			contp.card.show(contp, "CHAT");
		}else if(mainp.newsBtn==e.getSource()) {
			contp.card.show(contp, "NEWS");
		}else if(mainp.exitBtn==e.getSource()) {
			JOptionPane.showMessageDialog(this, "프로그램을 종료합니다"); 
			System.exit(0);			
		}
	}

}