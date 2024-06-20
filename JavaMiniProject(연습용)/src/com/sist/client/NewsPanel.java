package com.sist.client;
import java.awt.*;
import javax.swing.*;

import com.sist.manager.NaverNewsManager;
import com.sist.manager.NewsVO;

import java.awt.event.*;
import java.util.List;
import java.util.*;
public class NewsPanel extends JPanel implements ActionListener,MouseListener{
   NewsCard[] cards=new NewsCard[10];
   JTextField tf;
   JButton b;
   JPanel pan;
   JScrollPane pane;
   ControllPanel cp;
   List<NewsVO> list=new ArrayList<NewsVO>();
   public NewsPanel(ControllPanel cp)
   {
	   // 초기화 
	   this.cp=cp;
	   tf=new JTextField();
	   b=new JButton("검색");
	   for(int i=0;i<cards.length;i++)
	   {
		   cards[i]=new NewsCard();
		   cards[i].addMouseListener(this);
	   }
	   pan=new JPanel();
	   pan.setLayout(new GridLayout(10,1,5,5));
	   setLayout(null);
	   // 배치
	   
	   //pane.setViewportView(pan);
	   tf.setBounds(10, 15, 250, 30);
	   b.setBounds(265, 15, 100, 30);
	   pan.setPreferredSize(new Dimension(850,950));
	   pane=new JScrollPane(pan);
	   pane.setPreferredSize(new Dimension(850,650));
	   pane.setBounds(10, 55, 850, 500);
	   
	   add(tf);
	   add(b);
	   add(pane);
	   //add(pan);
	   
	   // 등록 
	   tf.addActionListener(this);
	   b.addActionListener(this);
	   
	   newsPrint("뮤직");
	   
   }
    public void newsPrint(String fd)
    {
    	list=NaverNewsManager.newsSearchData(fd);
		pan.setLayout(new GridLayout(10,1,5,5));
		int i=0;
		for(NewsVO vo:list)
		{
			cards[i].titleLa.setText("<html><b><font color=blue>"+vo.getTitle()+"</font></b></html>");
			cards[i].contentTa.setText(vo.getContent());
			cards[i].dateLa.setText(vo.getDate());
			pan.add(cards[i]);
			i++;
		}
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==tf || e.getSource()==b)
		{
			String fd=tf.getText();
			// 웹 => 유효성 검사 
			if(fd.length()<1)
			{
				JOptionPane.showMessageDialog(this, "검색어 입력");
				tf.requestFocus();
				return;
			}
			newsPrint(fd);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<list.size();i++)
		{
			if(e.getSource()==cards[i])
			{
				try
				{
					Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "+list.get(i).getLink() );
				}catch(Exception ex) {}
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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}