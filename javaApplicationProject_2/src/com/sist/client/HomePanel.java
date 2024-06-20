package com.sist.client;
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.sist.dao.*;
import com.sist.commons.*;
import java.util.*;
import java.net.*;
public class HomePanel  extends JPanel implements ActionListener,MouseListener{
	JPanel pan=new JPanel(); // 12개 이미지 출력 
	JButton b1,b2; // 이전, 다음
	JLabel la=new JLabel("0 page / 0 pages");
	
	JLabel[] imgs=new JLabel[12]; // 라벨 하나에 이미지 1개씩 들어간다
	
	int curpage=1; // 현재 페이지
	int totalpage=0; // 총페이지
	// 데이터베이스 연결
	GoodsDAO dao;
	String myId;
	// 초기화
	ControllPanel ctrP;
	public HomePanel(ControllPanel ctrP) {
		this.ctrP=ctrP;
		dao=GoodsDAO.newInstance(); // 객체 생성
		pan.setLayout(new GridLayout(3,4,5,5)); // 한 줄에 4개, 3줄 
		
		setLayout(new BorderLayout());
		add("Center",pan);
		b1=new JButton("이전");
		b2=new JButton("다음");
		JPanel p=new JPanel();
		p.add(b1); p.add(la);p.add(b2);
		add("South",p);
		print();
		
		b1.addActionListener(this);
		b2.addActionListener(this);
	}
	public void print() {
		totalpage=dao.goodsTotalPage();
		ArrayList<GoodsVO> list=dao.goodsListData(curpage);
		for(int i=0;i<list.size();i++) {
			GoodsVO vo=list.get(i);
			try {
				URL url=new URL(vo.getGoods_poster());
				Image img=imageChange.getImage(new ImageIcon(url), 240, 200);
				// 이미지 크기 조절 (축소)
				imgs[i]=new JLabel(new ImageIcon(img));
				imgs[i].setToolTipText(vo.getGoods_name()+"^"+vo.getNo()); // 풍선
				pan.add(imgs[i]);
				imgs[i].addMouseListener(this);
			}catch(Exception ex) {
				ex.printStackTrace();
			}
			la.setText(curpage+" page / "+totalpage+" pages");
		}
	}
	public void init() {
		for(int i=0; i<imgs.length;i++) {
			imgs[i]=new JLabel(""); // 그전의 라벨 지우기
		}
		pan.removeAll();
		pan.validate(); // 패널 지우고 다시 생성 
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			if(curpage>1) {
				curpage--;
				init();
				print();
			}
		}
		else if(e.getSource()==b2){
			if(curpage<totalpage) {
				curpage++;
				init();
				print();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i=0;i<imgs.length;i++) {
			if(e.getSource()==imgs[i]) {
				if(e.getClickCount()==2) {
					String no=imgs[i].getToolTipText();
					no=no.substring(no.lastIndexOf("^")+1);
					ctrP.detailP.print(Integer.parseInt(no),myId);
					ctrP.card.show(ctrP, "DETAIL");
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {

		}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0;i<imgs.length;i++) {
			if(e.getSource()==imgs[i]) {
				imgs[i].setBorder(new LineBorder(Color.red,3));
				}
			}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		for(int i=0;i<imgs.length;i++) {
			if(e.getSource()==imgs[i]) {
				imgs[i].setBorder(null);
				}
			}
		
	}
}
