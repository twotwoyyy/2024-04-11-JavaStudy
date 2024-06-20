package com.sist.client;

import javax.swing.*;
import java.net.*;
import com.sist.dao.*;
import com.sist.commons.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;

//ISBN, BOOKNAME, WRITER, TRANSLATOR, PAGE, PRICE, PUBDATE, SERIES, IMAGE
public class BookDetailPanel extends JPanel implements ActionListener,ItemListener{
	JLabel imageLa,booknameLa,writerLa,transLa,pageLa,priceLa,pubdateLa,seriesLa;
	JButton cartBtn,listBtn;
	JComboBox<Integer> box;
	JLabel numLa,totalpriceLa, noteLa;
	ControllPanel ctrP;// 화면 이동
	BooksDAO dao;
	int bnum=0;
	String myId;
	public BookDetailPanel(ControllPanel ctrP)
	{
		dao=BooksDAO.newInstance();
		this.ctrP = ctrP;
		setLayout(null);
		imageLa = new JLabel();
		imageLa.setBounds(10,15,450,550);
		add(imageLa);
		
		booknameLa = new JLabel();
		booknameLa.setBounds(470, 15, 400, 100);
		add(booknameLa);
	
		writerLa = new JLabel();
		writerLa.setBounds(470,120,400,30);
		add(writerLa);
		
		transLa = new JLabel();
		transLa.setBounds(470, 155, 400, 30);
		add(transLa);
				
		pageLa = new JLabel();
		pageLa.setBounds(470, 190, 200, 30);
		add(pageLa);
				
		priceLa = new JLabel();
		priceLa.setBounds(470, 225, 400, 30);
		add(priceLa);
				
		pubdateLa = new JLabel();
		pubdateLa.setBounds(470, 260, 400, 30);
		add(pubdateLa);
				
		seriesLa = new JLabel();
		seriesLa.setBounds(470, 295, 300, 30);
		add(seriesLa);
				
		numLa = new JLabel("수량: ");
		numLa.setBounds(470, 330, 40, 30);
		add(numLa);
		
		box=new JComboBox<Integer>();
		box.addItem(1);
		box.addItem(2);
		box.addItem(3);
		box.addItem(4);
		box.addItem(5);
		box.addItem(6);
		box.addItem(7);
		box.setBounds(510, 330, 200, 30);
		add(box);
		
		noteLa = new JLabel("최대 7개까지 구매하실 수 있습니다."); 
		noteLa.setBounds(470, 365, 200, 30);
		add(noteLa);
		
		totalpriceLa = new JLabel();
		totalpriceLa.setBounds(470, 405, 380, 40);
		add(totalpriceLa);
		
		cartBtn = new JButton("장바구니");
		listBtn = new JButton("목록");
		JPanel p=new JPanel();
		p.add(cartBtn);p.add(listBtn);
		p.setBounds(470, 460, 450, 55);
		add(p);

		listBtn.addActionListener(this);
		box.addItemListener(this);
		cartBtn.addActionListener(this);
	}

	public void print(int NUM)
	{
		bnum=NUM;
		// 1. 오라클에서 값을 받는다 
		BooksVO vo=dao.booksDetailData(NUM);
		try
		{
			URL url=new URL(vo.getImage());
			Image img=ImageChange.getImage(new ImageIcon(url), 400, 500);
			imageLa.setIcon(new ImageIcon(img));
		}catch(Exception ex) {}
		booknameLa.setText("<html><font size= 5>"+vo.getBookname()+"</font></html>");
		writerLa.setText("지은이: "+ vo.getWriter());
		transLa.setText("옮긴이: "+vo.getTranslator());
		pageLa.setText("페이지: "+vo.getPage());
		priceLa.setText("가격: "+vo.getPrice()+"원");
		pubdateLa.setText("발행일: "+vo.getPubdate());
		seriesLa.setText("시리즈: "+vo.getSeries());
	}  
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==box)
		{
			String price=priceLa.getText();
			price=price.substring(price.indexOf(":")+1);
			price=price.replaceAll("[^0-9]", ""); // 숫자를 제외한 나머지는 공백으로 바꿔준다

			int account=box.getSelectedIndex()+1;
			int total=Integer.parseInt(price)*account;

			DecimalFormat df=new DecimalFormat("##,###,###");
			String s=df.format(total);
			totalpriceLa.setText("구매 총 가격:"+s+"원");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==listBtn)
		{
			ctrP.card.show(ctrP, "HOME");
		}else if(e.getSource()==cartBtn)
		{
			BookCartVO vo=new BookCartVO();
			vo.setBnum(bnum);
			
			String id=ctrP.cMain.myId;
			
			vo.setId(id);
			
			int account=box.getSelectedIndex()+1;
			vo.setAcoount(account);
			String price=totalpriceLa.getText();
			price=price.replaceAll("[^0-9]", "");
			vo.setPrice(Integer.parseInt(price));
			
			dao.cartInsert(vo);
			JOptionPane.showMessageDialog(this, "장바구니에 추가되었습니다\n마이페이지에서 확인하세요");
			// 이동 => 마이페이지 이동 
			//cp.card.show(cp, price);
		}
	
	}

}
