package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import java.util.*;


public class ChatPanel extends JPanel{
	ControllPanel ctrP;
	JLabel chatTitle;
	JTextPane chatTextArea;
	JTextField chatWrite;
	JButton chatSubmit, chatLetter, chatInfo;
	JTable chatPeople;
	DefaultTableModel chatPeopleData;
	JScrollBar bar;
	JComboBox<String> box;
		public ChatPanel() {
			//title
			chatTitle=new JLabel("실시간 채팅", JLabel.CENTER);
			chatTitle.setFont(new Font("맑은 고딕",Font.BOLD,20));
			chatTitle.setBounds(0, 15, 800, 20);
			add(chatTitle);
			
			//textarea
			chatTextArea=new JTextPane();
			chatWrite=new JTextField();
			chatSubmit=new JButton("입력");
			JScrollPane js=new JScrollPane(chatTextArea);
			chatTextArea.setEditable(false);
			
			setLayout(null);
			
			chatTextArea.setBounds(20, 55, 500, 410);
			add(chatTextArea);
			
			chatWrite.setBounds(20, 470, 400, 30);
			add(chatWrite);

			
			//table
			String[] col={"아이디","이름","성별"};
			String[][] row=new String[0][3];
			chatPeopleData=new DefaultTableModel(row, col) {

				@Override
				public boolean isCellEditable(int row, int column) {
					// TODO Auto-generated method stub
					return false;
				}
				
			};
			chatPeople=new JTable(chatPeopleData);
			JScrollPane chatTable=new JScrollPane(chatPeople);
			chatTable.setBounds(550, 55, 220, 410);
			add(chatTable);
			bar=chatTable.getVerticalScrollBar();
			
			box=new JComboBox<String>();
			box.addItem("black");
			box.addItem("cyan");
			box.addItem("yellow");
			box.addItem("blue");
			box.addItem("magenta");
			box.addItem("green");
			box.addItem("pink");
			box.addItem("orange");
			
			box.setBounds(420, 470, 100, 30);
			add(box);
			
			
			//table button
			chatLetter=new JButton("1:1 채팅");
			chatInfo=new JButton("정보 보기");
			JPanel chatTableBtn=new JPanel();
			chatTableBtn.add(chatLetter);
			chatTableBtn.add(chatInfo);
			chatTableBtn.setBounds(550, 470, 220, 40);
			add(chatTableBtn);
			
		}
		public void initStyle() {
			   Style green=chatTextArea.addStyle("green", null);
			   StyleConstants.setForeground(green, Color.green);
			   
			   Style yellow=chatTextArea.addStyle("yellow", null);
			   StyleConstants.setForeground(yellow, Color.yellow);
			   
			   Style blue=chatTextArea.addStyle("blue", null);
			   StyleConstants.setForeground(blue, Color.blue);
			   
			   Style pink=chatTextArea.addStyle("pink", null);
			   StyleConstants.setForeground(pink, Color.pink);
			   
			   Style cyan=chatTextArea.addStyle("cyan", null);
			   StyleConstants.setForeground(cyan, Color.cyan);
			   
			   Style orange=chatTextArea.addStyle("orange", null);
			   StyleConstants.setForeground(orange, Color.orange);
			   
			   Style magenta=chatTextArea.addStyle("magenta", null);
			   StyleConstants.setForeground(magenta, Color.magenta);
		       
			   Style red=chatTextArea.addStyle("red", null);
			   StyleConstants.setForeground(red, Color.red); //알림
			   
			   Style gray=chatTextArea.addStyle("gray", null);
			   StyleConstants.setForeground(red, Color.gray); //귓속말
		}
		public void append(String msg,String color) {
			try {
				Document doc=chatTextArea.getDocument();
				doc.insertString(doc.getLength(), msg+"\n", chatTextArea.getStyle(color));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		public static void main(String[] args) {
			new ChatPanel();
		}
	}
