package com.sist.client;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class ChatPanel extends JPanel{
	public ChatPanel() {
		JLabel chatTitle;
		JTextArea chatTextArea;
		JTextField chatWrite;
		JButton chatSubmit, chatLetter, chatInfo;
		JTable chatPeople;
		DefaultTableModel chatPeopleData;

		//title
		chatTitle=new JLabel("실시간 채팅", JLabel.CENTER);
		chatTitle.setFont(new Font("맑은 고딕",Font.BOLD,20));
		chatTitle.setBounds(0, 15, 800, 20);
		add(chatTitle);
		
		//textarea
		chatTextArea=new JTextArea();
		chatWrite=new JTextField();
		chatSubmit=new JButton("입력");
		
		setLayout(null);
		
		chatTextArea.setBounds(20, 55, 500, 410);
		add(chatTextArea);
		
		chatWrite.setBounds(20, 470, 450, 30);
		add(chatWrite);
		
		chatSubmit.setBounds(480, 470, 50, 30);
		add(chatSubmit);
		
		//table
		String[] col={"아이디","이름"};
		String[][] row=new String[0][2];
		chatPeopleData=new DefaultTableModel(row, col);
		chatPeople=new JTable(chatPeopleData);
		JScrollPane chatTable=new JScrollPane(chatPeople);
		chatTable.setBounds(550, 55, 220, 410);
		add(chatTable);
		
		//table button
		chatLetter=new JButton("쪽지보내기");
		chatInfo=new JButton("정보보기");
		JPanel chatTableBtn=new JPanel();
		chatTableBtn.add(chatLetter);
		chatTableBtn.add(chatInfo);
		chatTableBtn.setBounds(550, 470, 220, 30);
		add(chatTableBtn);
	}
}