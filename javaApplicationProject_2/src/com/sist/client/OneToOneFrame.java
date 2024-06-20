package com.sist.client;
import java.awt.*;
import javax.swing.*;
public class OneToOneFrame extends JFrame{
    JLabel la;
    JButton b;
    JTextArea ta;
    JTextField tf1,tf2;
    
    public OneToOneFrame()
    {
    	la=new JLabel("대화 상대");
    	b=new JButton("종료");
    	ta=new JTextArea();
    	ta.setEditable(false);
    	JScrollPane js=new JScrollPane(ta);
    	tf1=new JTextField(15);
    	tf1.setEnabled(false);
    	tf2=new JTextField(25);
    	
    	JPanel p1=new JPanel();
    	p1.add(la);p1.add(tf1);p1.add(b);
    	add("North",p1);
    	
    	add("Center",js);
    	
    	add("South",tf2);
    	
    	setSize(450, 350);
    }
    
}