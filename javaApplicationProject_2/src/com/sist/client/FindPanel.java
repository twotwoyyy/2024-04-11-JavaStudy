package com.sist.client;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class FindPanel extends JPanel{
    JTable table;
    DefaultTableModel find;
	JButton search, entire, add, edit, del;
	JTextField searchT;
	JTextArea list;
	
   public FindPanel()
   {
	   searchT=new JTextField(40);
	   search=new JButton("검색");
	   
	   setLayout(null); 
	   
	   JPanel p=new JPanel();
	   searchT.setBounds(30, 50, 400, 30);
   	   add(searchT);
   	   search.setBounds(450, 50, 100, 30);
   	   add(search);

	   String[] col= {"책 제목","저자","출판사","발행일"};
   	   String[][] row=new String[0][4];
	   find=new DefaultTableModel(row,col);
   	   table=new JTable(find);
   	   JScrollPane js=new JScrollPane(table);
   	   
	   js.setBounds(30, 110, 800, 450);
	   add(js);
	   
	   entire=new JButton("전체보기");
	   add=new JButton("추가");
	   del=new JButton("수정");
	   edit=new JButton("삭제");
	   
	   JPanel p1=new JPanel();
	   p1.add(entire);
	   p1.add(add);
	   p1.add(del);
	   p1.add(edit);
	   p1.setBounds(20, 600, 250, 60);
	   add(p1);
	   
   }
}