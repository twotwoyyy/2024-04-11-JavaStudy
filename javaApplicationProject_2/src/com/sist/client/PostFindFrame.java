package com.sist.client;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class PostFindFrame extends JFrame{
	JTextField postTf;
	JButton find,cancel;
	JTable table;
	DefaultTableModel model;
	public PostFindFrame() {
		setLayout(new BorderLayout());
		postTf=new JTextField(15);
		find=new JButton("검색");
		cancel=new JButton("취소");
		JPanel p=new JPanel();
		p.add(postTf);p.add(find);p.add(cancel);
		add("North",p);
		
		String[] col= {"우편번호","주소"};
		String[][] row=new String[0][2];
		model=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			// 익명의 클래스, 생성자 안에서 오버라이딩 
		};
		table=new JTable(model);
		JScrollPane js=new JScrollPane(table);
		add("Center",js);
		setSize(450,300);
		// 버튼을 눌렀을 때 띄워야 하기 때문에 setvisible xxxx 

	}
}
