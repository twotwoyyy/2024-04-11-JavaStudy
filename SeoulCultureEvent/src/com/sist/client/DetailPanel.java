package com.sist.client;
import javax.swing.*;
import java.awt.*;
public class DetailPanel extends JFrame{
	JLabel la1,la2,la3,la4,la5,la6;
	JButton b1,b2,b3;
	JTextArea ta;
	JPasswordField pf;
	
	public DetailPanel() {
		la1=new JLabel("내용보기",JLabel.CENTER);
		la2=new JLabel("번호");
		la3=new JLabel("작성일");
		la4=new JLabel("이름");
		la5=new JLabel("조회수");
		la6=new JLabel("제목");

		b1=new JButton("수정");
		b2=new JButton("삭제");
		b3=new JButton("목록");
		

		ta=new JTextArea();
		JScrollPane js=new JScrollPane(ta);
		pf=new JPasswordField();
		
		// 게시판 제목 배치
		setLayout(null);
		setLayout(null); // null은 직접배치하겠다는 말이다 (x,y)
		la1.setFont(new Font("맑은 고딕",Font.BOLD,35));
		la1.setBounds(110,15,500,40);
		add(la1); // JFrame에 추가 
		
		
		JPanel p=new JPanel();
		p.add(b1);
		p.add(b2);
		p.add(b3);

		la2.setBounds(100, 75,80, 30);
		add(la2);
		la3.setBounds(400, 75,80, 30);
		add(la3);
		la4.setBounds(100, 115,80, 30);
		add(la4);
		la5.setBounds(400, 115,80, 30);
		add(la5);
		la6.setBounds(100, 155,80, 30);
		add(la6);

		pf.setBounds(100, 190, 520, 200);
		add(pf);
		
		p.setBounds(210,400,300,35);
		add(p);
		
		setSize(800,550);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new DetailPanel();
	}

}
