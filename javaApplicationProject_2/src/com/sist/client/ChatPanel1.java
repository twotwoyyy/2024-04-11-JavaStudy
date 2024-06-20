package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;
import java.util.*;
public class ChatPanel1 extends JPanel{
	JTextPane pane;
	JTextField tf;
	JComboBox<String> box1,box2;
	JTable table;
	DefaultTableModel model;
	JButton b1,b2;
	JScrollBar bar;
	
	//상담
	JLabel la;
	JTextField youTf,sendTf;
	JTextArea ta;
	JButton ob;
	JPanel pan=new JPanel();
	
	public ChatPanel1() {
		setLayout(null);
		pane=new JTextPane();
		JScrollPane js1=new JScrollPane(pane);
		js1.setBounds(10, 15, 470, 490);
		add(js1);
		bar=js1.getVerticalScrollBar();
		pane.setEditable(false);
		
		tf=new JTextField();
		tf.setBounds(10, 520, 370, 30);
		add(tf);
		
		
		box1=new JComboBox<String>();
		box1.addItem("black");
		box1.addItem("cyan");
		box1.addItem("yellow");
		box1.addItem("blue");
		box1.addItem("magenta");
		box1.addItem("green");
		box1.addItem("pink");
		box1.addItem("orange");
		
		box1.setBounds(385, 520, 100, 30);
		add(box1);
		
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
		tableJs.setBounds(495, 15, 400, 150);
		add(tableJs);
		
		box2=new JComboBox<String>();
		box2.setBounds(495, 175, 100, 30);
		box2.addItem("상담자");
		add(box2);
		
		b1=new JButton("1:1 상담");
		b1.setBounds(600, 175, 120, 30);
		add(b1);
		b2=new JButton("정보 보기");
		b2.setBounds(725, 175, 100, 30);
		add(b2);
		
		la=new JLabel("1:1 대상");
		youTf=new JTextField(10);
		youTf.setEnabled(false);
		ob=new JButton("종료");
		
		ta=new JTextArea();
		JScrollPane js3=new JScrollPane();
		ta.setEditable(false);
		
		
		sendTf=new JTextField(30);
		
		pan.setLayout(new BorderLayout());
		
		JPanel p=new JPanel();
		p.add(la);p.add(youTf);p.add(ob);
		pan.add("North",p);
		
		pan.add("Center",js3);
		pan.add("South",sendTf);
		
		pan.setBounds(495,220,400,330);
		add(pan);
		pan.setVisible(false);
	}
	public void initStyle(){
		   Style green=pane.addStyle("green", null);
		   StyleConstants.setForeground(green, Color.green);
		   
		   Style yellow=pane.addStyle("yellow", null);
		   StyleConstants.setForeground(yellow, Color.yellow);
		   
		   Style blue=pane.addStyle("blue", null);
		   StyleConstants.setForeground(blue, Color.blue);
		   
		   Style pink=pane.addStyle("pink", null);
		   StyleConstants.setForeground(pink, Color.pink);
		   
		   Style cyan=pane.addStyle("cyan", null);
		   StyleConstants.setForeground(cyan, Color.cyan);
		   
		   Style orange=pane.addStyle("orange", null);
		   StyleConstants.setForeground(orange, Color.orange);
		   
		   Style magenta=pane.addStyle("magenta", null);
		   StyleConstants.setForeground(magenta, Color.magenta);
	       
		   Style red=pane.addStyle("red", null);
		   StyleConstants.setForeground(red, Color.red); //알림
		   
		   Style gray=pane.addStyle("gray", null);
		   StyleConstants.setForeground(red, Color.gray); //귓속말
		}
	// TextPane 단점 : 문자열 결합 불가, setText() => append로 문자열 결합
	public void append(String msg,String color) {
		try {
			Document doc=pane.getDocument();
			doc.insertString(doc.getLength(), msg+"\n", pane.getStyle(color));
		}catch(Exception ex) {}
		
	}
	
}