package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class IdCheckFrame extends JFrame{
	JLabel idTitle, idLabel, alert;
	JButton idFind, ok, b2;
	JTextField idTf;
	
	public IdCheckFrame() {
		setLayout(null);
		idTitle=new JLabel("아이디 중복체크",JLabel.CENTER);
		idTitle.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		idTitle.setBounds(10, 15, 250, 35);
		add(idTitle);
		
		idLabel=new JLabel("ID");
		idLabel.setBounds(10, 55, 30, 30);
		add(idLabel);
		
		idTf=new JTextField();
		idTf.setBounds(45, 55, 150, 30);
		add(idTf);
		
		idFind=new JButton("검색");
		idFind.setBounds(200, 55, 60, 30);
		add(idFind);
		
		alert=new JLabel("사용 가능한 아이디입니다",JLabel.CENTER);
		alert.setForeground(Color.red);
		alert.setBounds(10, 95, 250, 30);
		add(alert);
		
		ok=new JButton("확인");
		ok.setVisible(false);
		JPanel p=new JPanel();
		p.add(ok);
		p.setBounds(10, 135, 250, 35);
		add(p);
		
		setSize(290, 220);
		//setVisible(true);
	}
	/*
	public static void main(String[] args) {
		new IdCheckFrame();
	}
	*/
}