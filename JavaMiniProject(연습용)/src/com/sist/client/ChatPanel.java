package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import java.util.*;


public class ChatPanel extends JPanel{
	JTextPane chatpane;
    JTextField chatInput;
    JComboBox<String> colorBox, userBox;
    JTable table;
    DefaultTableModel model;
    JButton oneBtn, infoBtn;
    JScrollBar chatBar;
	 public ChatPanel() {
         setLayout(null);
         chatpane=new JTextPane();
         JScrollPane js1=new JScrollPane(chatpane);
         js1.setBounds(10, 45, 630, 570);
         add(js1);
         chatBar=js1.getVerticalScrollBar();
         chatpane.setEditable(false);
         
         chatInput=new JTextField();
         chatInput.setBounds(10, 620, 525, 30);
         add(chatInput);
         
         colorBox=new JComboBox<String>();
         colorBox.addItem("black");
         colorBox.addItem("cyan");
         colorBox.addItem("yellow");
         colorBox.addItem("blue");
         colorBox.addItem("magenta");
         colorBox.addItem("green");
         colorBox.addItem("pink");
         colorBox.addItem("orange");
         
         colorBox.setBounds(540, 620, 100, 30);
         add(colorBox);
         
         String[] col={"ID", "이름", "성별"};
         String[][] row=new String[0][3];
         model=new DefaultTableModel(row, col) {
            @Override
            public boolean isCellEditable(int row, int column) {
               // TODO Auto-generated method stub
               return false;
            }
         };
         table=new JTable(model);
         JScrollPane tableJs=new JScrollPane(table);
         tableJs.setBounds(650, 45, 250, 570);
         add(tableJs);
         
         userBox=new JComboBox<String>();
         userBox.setBounds(650, 620, 80, 30);
         add(userBox);
         
         oneBtn=new JButton("1:1상담");
         oneBtn.setBounds(735, 620, 80, 30);
         add(oneBtn);
         infoBtn=new JButton("정보보기");
         infoBtn.setBounds(820, 620, 80, 30);
         add(infoBtn);
      }
		public void initStyle() {
			   Style green=chatpane.addStyle("green", null);
			   StyleConstants.setForeground(green, Color.green);
			   
			   Style yellow=chatpane.addStyle("yellow", null);
			   StyleConstants.setForeground(yellow, Color.yellow);
			   
			   Style blue=chatpane.addStyle("blue", null);
			   StyleConstants.setForeground(blue, Color.blue);
			   
			   Style pink=chatpane.addStyle("pink", null);
			   StyleConstants.setForeground(pink, Color.pink);
			   
			   Style cyan=chatpane.addStyle("cyan", null);
			   StyleConstants.setForeground(cyan, Color.cyan);
			   
			   Style orange=chatpane.addStyle("orange", null);
			   StyleConstants.setForeground(orange, Color.orange);
			   
			   Style magenta=chatpane.addStyle("magenta", null);
			   StyleConstants.setForeground(magenta, Color.magenta);
		       
			   Style red=chatpane.addStyle("red", null);
			   StyleConstants.setForeground(red, Color.red); //알림
			   
			   Style gray=chatpane.addStyle("gray", null);
			   StyleConstants.setForeground(red, Color.gray); //귓속말
		}
		public void append(String msg,String color) {
			try {
				Document doc=chatpane.getDocument();
				doc.insertString(doc.getLength(), msg+"\n",chatpane.getStyle(color));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		public static void main(String[] args) {
			new ChatPanel();
		}
	}
