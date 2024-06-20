package com.sist.client;

import javax.swing.*;
import javax.swing.border.LineBorder;

import com.sist.dao.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.sist.commons.*;
import java.util.*;
import java.net.*;

public class HomePanel extends JPanel implements ActionListener,MouseListener{
	    JPanel pan=new JPanel(); // 12개 이미지 출력 
	    JButton b1,b2; // 이전 , 다음 
	    JLabel la=new JLabel("0 page / 0 pages");
	    JLabel[] imgs=new JLabel[12]; 
	    
	    int curpage=1; // 현재 페이지 
	    int totalpage=0; // 총페이지 

	    BooksDAO dao;
	    String myId;
	    ControllPanel ctrP;
	    public HomePanel(ControllPanel ctrP) {
	    	this.ctrP=ctrP;
	    	dao=BooksDAO.newInstance();
	    	pan.setLayout(new GridLayout(3,4,5,5));
	    	
	    	setLayout(new BorderLayout());
	    	add("Center",pan);
	    	b1=new JButton("이전");
	    	b2=new JButton("다음");
	    	JPanel p=new JPanel();
	    	p.add(b1);p.add(la);p.add(b2);
	    	add("South",p);
	    	print();
	    	
	    	b1.addActionListener(this);
	    	b2.addActionListener(this);
	    }
	    public void print() {
	    	totalpage=dao.booksTotalPage();
	    	ArrayList<BooksVO> list=dao.booksListData(curpage);
	    	for(int i=0;i<list.size();i++) {
	    		BooksVO vo=list.get(i);
	    		try {
	    			URL url=new URL(vo.getImage());
	    			Image img=ImageChange.getImage(new ImageIcon(url), 170, 200);
	    			imgs[i]=new JLabel(new ImageIcon(img));
	    			imgs[i].setToolTipText(vo.getBookname()+"^"+vo.getNum());
	    			pan.add(imgs[i]);
	    			imgs[i].addMouseListener(this);
	    		}catch(Exception ex) {
	    			ex.printStackTrace();
	    		}
	    	}
	    	la.setText(curpage+" page / "+totalpage+" pages");

	    }
	    public void init() {
	        	for(int i=0;i<imgs.length;i++)
	        	{
	        		imgs[i]=new JLabel("");
	        	}
	        	pan.removeAll();
	        	pan.validate();
	        }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				if(e.getClickCount()==2)
				{
					String num=imgs[i].getToolTipText();
					num=num.substring(num.lastIndexOf("^")+1);
					ctrP.detailP.print(Integer.parseInt(num));
					ctrP.card.show(ctrP, "DETAIL");
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				imgs[i].setBorder(new LineBorder(Color.orange,3));
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++)
		{
			if(e.getSource()==imgs[i])
			{
				imgs[i].setBorder(null);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			if(curpage>1)
			{
				curpage--;
				init();
				print();
			}
		}
		else if(e.getSource()==b2)
		{
			if(curpage<totalpage)
			{
				curpage++;
				init();
				print();
			}
		}
	}
}
