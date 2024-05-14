package com.sist.client;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*;

public class ClientMain extends JFrame implements ActionListener{
	public MenuPanel mp=new MenuPanel();
	public ControllerPanel cp=new ControllerPanel();
	public ClientMain() {
		setLayout(null);
		mp.setBounds(150,15,600,30);
		add(mp);
		cp.setBounds(0, 50, 800, 530);
		add(cp);
		setSize(800,600); 
		setVisible(true);
		setResizable(false); // 최대화 버튼을 사라지게 한다 화면을 딱 맞추게 한다 // (윈도우 크기 고정시 사용) 
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼 클릭시 메모리 해소가 된다 (프로그램 종료) 
		
		mp.b1.addActionListener(this); // b1버튼을 클릭하면 => actionPerformed를 호출
		mp.b2.addActionListener(this); 
		mp.b3.addActionListener(this); 
		mp.b4.addActionListener(this); 
		mp.b5.addActionListener(this); 
		mp.b6.addActionListener(this); 
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		new ClientMain();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(mp.b1==e.getSource()) {//b1(메뉴 1번) 버튼이 눌렸다면
			cp.card.show(cp, "HOME");
		}
		else if(mp.b2==e.getSource()) { //메뉴 2번 
			cp.card.show(cp, "FIND"); 
		}
		else if(mp.b3==e.getSource()) { //메뉴 2번 
			cp.card.show(cp, "NEWS"); 
		}
		else if(mp.b4==e.getSource()) { //메뉴 2번 
			cp.card.show(cp, "REVIEW"); 
		}
		else if(mp.b5==e.getSource()) { //메뉴 2번 
			cp.card.show(cp, "CHAT"); 
		}
		else if(mp.b6==e.getSource()) { //메뉴 6번 
			JOptionPane.showMessageDialog(this,"프로그램을 종료합니다"); // 팝업창 띄우기 
			System.exit(0); // 프로그램 종료 
		}
	}
}
