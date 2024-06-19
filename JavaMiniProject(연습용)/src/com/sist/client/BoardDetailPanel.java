package com.sist.client;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import com.sist.dao.*;
public class BoardDetailPanel extends JPanel implements ActionListener{
	JLabel titleLa,nameLa,noLa,subLa,dayLa,hitLa;
    JLabel name,no,sub,day,hit;
    JTextArea ta;
    JButton upP,delP,listP; // 수정 / 삭제 / 목록 
    ControllPanel ctrP;
    BoardDAO dao;

    public  BoardDetailPanel(ControllPanel ctrP)
    {
    	this.ctrP=ctrP;
    	dao=BoardDAO.newInstance();

    	titleLa=new JLabel("게시판",JLabel.CENTER);// <table>
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
    	setLayout(null);
    	titleLa.setBounds(120, 15, 620, 50);
    	add(titleLa);

    	noLa=new JLabel("번호",JLabel.CENTER);
    	noLa.setOpaque(true);
    	noLa.setBackground(new Color(255,212,230));
    	noLa.setBounds(120, 75 , 80, 30);
    	no=new JLabel("",JLabel.CENTER);
    	no.setBounds(205, 75, 120, 30);
    	add(noLa);add(no);

    	dayLa=new JLabel("작성일",JLabel.CENTER);
    	dayLa.setOpaque(true);
    	dayLa.setBackground(new Color(255,212,230));
    	dayLa.setBounds(330, 75 , 80, 30);
    	day=new JLabel("",JLabel.CENTER);
    	day.setBounds(415, 75, 200, 30);
    	add(dayLa);add(day);

    	nameLa=new JLabel("이름",JLabel.CENTER);
    	nameLa.setOpaque(true);
    	nameLa.setBackground(new Color(255,212,230));
    	nameLa.setBounds(120, 110 , 80, 30);
    	name=new JLabel("",JLabel.CENTER);
    	name.setBounds(205, 110, 120, 30);
    	add(nameLa);add(name);

    	hitLa=new JLabel("조회수",JLabel.CENTER);
    	hitLa.setOpaque(true);
    	hitLa.setBackground(new Color(255,212,230));
    	hitLa.setBounds(330, 110 , 80, 30);
    	hit=new JLabel("",JLabel.CENTER);
    	hit.setBounds(415, 110, 200, 30);
    	add(hitLa);add(hit);

    	subLa=new JLabel("제목",JLabel.CENTER);
    	subLa.setOpaque(true);
    	subLa.setBackground(new Color(255,212,230));
    	subLa.setBounds(120, 145 , 80, 30);
    	sub=new JLabel("");
    	sub.setBounds(205, 145, 400, 30);
    	add(subLa);add(sub);

    	ta=new JTextArea();
    	ta.setOpaque(true);
    	ta.setBackground(new Color(237,237,237));
    	ta.setEditable(false); // 비활성화 
    	ta.setBounds(120, 180, 485, 250);
    	add(ta);

    	JPanel p=new JPanel();
    	upP=new JButton("수정");
    	delP=new JButton("삭제");
    	listP=new JButton("목록");
    	p.add(upP);p.add(delP);p.add(listP);
    	p.setBounds(120, 440, 485, 35);
    	add(p);

    	upP.addActionListener(this); //수정
    	delP.addActionListener(this); //삭제
    	listP.addActionListener(this); //목록
    }
    
    public void print(int no) {
    	BoardVO vo=dao.boardDetailData(no);
    	this.no.setText(String.valueOf(vo.getNo()));
    	name.setText(vo.getName());
    	sub.setText(vo.getSubject());
    	hit.setText(String.valueOf(vo.getHit()));
    	day.setText(vo.getRegdate().toString());
    	ta.setText(vo.getContent());
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==listP) // 목록
		{
			ctrP.card.show(ctrP,"BOARD");// <input type=button value="목록" onclick="javascript:history.back()">
		}
		else if(e.getSource()==delP) //삭제
		{
			ctrP.bDeleteP.pf.setText("");
			ctrP.bDeleteP.no=Integer.parseInt(no.getText());// <input type=hidden value="10">
			ctrP.card.show(ctrP, "DELETE");
		}
		else if(e.getSource()==upP) // 수정 
		{
			BoardVO vo=dao.boardUpdateData(Integer.parseInt(no.getText()));
			ctrP.bUpdateP.no=vo.getNo();
			ctrP.bUpdateP.nameTf.setText(vo.getName());
			ctrP.bUpdateP.subTf.setText(vo.getSubject());
			ctrP.bUpdateP.ta.setText(vo.getContent());
			ctrP.card.show(ctrP, "UPDATE");
		}
	}

}
