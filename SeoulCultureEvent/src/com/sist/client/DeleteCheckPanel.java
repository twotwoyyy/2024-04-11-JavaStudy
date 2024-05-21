package com.sist.client;
import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DeleteCheckPanel extends JFrame{
	JLabel la1,la2;
	JButton b1,b2;
	JTextField tf;
	JPasswordField pf;
	
	public DeleteCheckPanel() {
		la1=new JLabel("삭제하기",JLabel.CENTER);
		la2=new JLabel("비밀번호");
		
		b1=new JButton("삭제");
		b2=new JButton("취소");
		
		tf=new JTextField();
		JScrollPane js=new JScrollPane(tf);
		pf=new JPasswordField();
		
		setLayout(null);
		setLayout(null); 
		la1.setFont(new Font("맑은 고딕",Font.BOLD,35));
		la1.setBounds(110,30,500,40);
		add(la1); 
		
		JPanel p=new JPanel();
		p.add(b1);
		p.add(b2);

		la2.setBounds(160, 105,80, 30);
		tf.setBounds(250, 105, 200, 30);
		add(tf);
		add(la2);
		
		
		p.setBounds(210,150,300,35);
		add(p);
		
		
		setSize(800,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public static void main(String[] args) {
		new DeleteCheckPanel();
		

	}

}
