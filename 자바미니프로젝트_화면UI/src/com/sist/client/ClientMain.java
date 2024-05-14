package com.sist.client;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import java.awt.*;
import java.awt.event.*;


public class ClientMain extends JFrame implements ActionListener{ // 인터페이스 (선언만된 메소드)
	public MenuPanel mp=new MenuPanel();
	public ControllerPanel cp=new ControllerPanel(); // 버튼 누르면 바뀌는 패널 
	public ClientMain() {//생성자
		//배치
		setLayout(null);
		mp.setBounds(150,15,600,30);
		add(mp);
		cp.setBounds(0, 50, 800, 530);
		add(cp);
//		add("North",mp);
//		add("Center",cp);
//맨 위쪽 North 맨 아래 South 오른쪽 배치 West 가운데 배치 Center ==> BorderLayout(JFrame)
		//윈도우 크기 
		setSize(800,600); // 크기설정
		setVisible(true);
		
		// 항상 두 가지를 가져다 써야 한다 
		setResizable(false); // 최대화 버튼을 사라지게 한다 화면을 딱 맞추게 한다 // (윈도우 크기 고정시 사용) 
		setDefaultCloseOperation(EXIT_ON_CLOSE); // x버튼 클릭시 메모리 해소가 된다 (프로그램 종료) 
		
		mp.b1.addActionListener(this); // b1버튼을 클릭하면 => actionPerformed를 호출
		mp.b2.addActionListener(this); 
		mp.b6.addActionListener(this); 
		
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		new ClientMain();
	}
	@Override // 버튼 처리할 때 쓰는 메소드 
	public void actionPerformed(ActionEvent e) { // 메뉴 처리 => 조건문 
		if(mp.b1==e.getSource()) {//b1(메뉴 1번) 버튼이 눌렸다면
			cp.card.show(cp, "HOME");
		}
		else if(mp.b2==e.getSource()) { //메뉴 2번 
			cp.card.show(cp, "FIND"); 
		}
		else if(mp.b6==e.getSource()) { //메뉴 6번 
			JOptionPane.showMessageDialog(this,"프로그램을 종료합니다"); // 팝업창 띄우기 
			System.exit(0); // 프로그램 종료 
		}
	}
}
