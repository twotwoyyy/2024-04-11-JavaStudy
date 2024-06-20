package com.sist.client;
import java.util.*;
import java.awt.*;
import javax.swing.*;
public class NewsCard extends JPanel{
     JLabel titleLa;
     JTextPane contentTa;
     JLabel dateLa;
     public NewsCard()
     {
    	 setLayout(null);
    	 titleLa=new JLabel("");
    	 contentTa=new JTextPane();// 자동 줄바꿈 
    	 contentTa.setEditable(false);
    	 JScrollPane js=new JScrollPane(contentTa);
    	 dateLa=new JLabel("");
    	 
    	 // 배치 
    	 titleLa.setBounds(10, 10, 450, 35);
    	 js.setBounds(10, 50, 800, 150);
    	 dateLa.setBounds(470, 10, 200, 35);
    	 
    	 // 추가 
    	 add(titleLa);
    	 add(js);
    	 add(dateLa);
     }
}