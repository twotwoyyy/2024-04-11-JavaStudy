package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
public class BoardDeletePanel extends JPanel implements ActionListener{
	JLabel titleLa,pwdLa;
	JPasswordField pf;
	JButton delP,cencleP;
	ControllPanel ctrP;
	BoardDAO dao;
	int no=0;

	public BoardDeletePanel(ControllPanel ctrP) {
		this.ctrP=ctrP;
		dao=BoardDAO.newInstance();
		titleLa=new JLabel("삭제하기",JLabel.CENTER);// <table>
		titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
		setLayout(null);
		titleLa.setBounds(120, 15, 620, 50);
		add(titleLa);

		pwdLa=new JLabel("비밀번호",JLabel.CENTER);
		pwdLa.setBounds(300, 75, 80, 30);
		add(pwdLa);

		pf=new JPasswordField();
		pf.setBounds(385, 75, 120, 30);
		add(pf);

		delP=new JButton("삭제");
		cencleP=new JButton("취소");

		JPanel p=new JPanel();
		p.add(delP); p.add(cencleP);
		p.setBounds(300, 120, 205, 35);
		add(p);

		delP.addActionListener(this); //삭제
		cencleP.addActionListener(this); //취소   
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==cencleP) {
			ctrP.card.show(ctrP, "BDETAIL");
		}
		else if(e.getSource()==delP) {
			String pwd=String.copyValueOf(pf.getPassword());
			if(pwd.length()<1) {
				pf.requestFocus();
				return;
			}
			boolean bCheck=dao.boardDelete(no, pwd);
			if(bCheck==true) {
				JOptionPane.showMessageDialog(this, "게시물이 삭제되었습니다!!");
				// 이동
				ctrP.card.show(ctrP, "BOARD");
			}
			else {
				JOptionPane.showMessageDialog(this, "비밀번호가 틀렸습니다\n 다시 입력하세요");
				pf.setText("");
				pf.requestFocus();
			}
		}
	}

}
