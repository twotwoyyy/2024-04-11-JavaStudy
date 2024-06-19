package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.sist.dao.*;
// onclick=""
public class BoardUpdatePanel extends JPanel implements ActionListener{
	JLabel titleLa,nameLa,subLa,contLa,pwdLa;
    JTextField nameTf,subTf;
    JPasswordField pwdPf;
    JTextArea ta;
    JButton b1,b2;
    ControllPanel ctrP;
    BoardDAO dao;
    int no=0;
    public BoardUpdatePanel(ControllPanel ctrP)
    {
    	this.ctrP=ctrP;
    	dao=BoardDAO.newInstance();
    	
    	titleLa=new JLabel("수정하기",JLabel.CENTER);// <table>
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
    	setLayout(null);
    	titleLa.setBounds(120, 15, 620, 50);
    	add(titleLa);
    	
    	nameLa=new JLabel("이름",JLabel.CENTER);
    	nameTf=new JTextField();
    	nameLa.setBounds(120, 70, 80, 30);
    	nameTf.setBounds(205, 70, 150, 30);
    	add(nameLa);add(nameTf);
    	
    	subLa=new JLabel("제목",JLabel.CENTER);
    	subTf=new JTextField();
    	subLa.setBounds(120, 105, 80, 30);
    	subTf.setBounds(205, 105, 450, 30);
    	add(subLa);add(subTf);
    	
    	
    	contLa=new JLabel("내용",JLabel.CENTER);
    	ta=new JTextArea();
    	JScrollPane js=new JScrollPane(ta);
    	contLa.setBounds(120, 140, 80, 30);
    	js.setBounds(205, 140, 450, 250);
    	add(contLa);add(js);
 
    	pwdLa=new JLabel("비밀번호",JLabel.CENTER);
    	pwdPf=new JPasswordField();
    	//             Top  Right Bottom Left ==> CSS
    	pwdLa.setBounds(120, 395, 80, 30);
    	//             x  y width heigth
    	pwdPf.setBounds(205, 395, 150, 30);
    	add(pwdLa);add(pwdPf);
    	
    	b1=new JButton("수정");
    	b2=new JButton("취소");
    	
    	JPanel p=new JPanel();
    	p.add(b1);p.add(b2);
    	p.setBounds(120, 435, 535, 35);
    	add(p);
    	
    	b1.addActionListener(this);
    	b2.addActionListener(this);
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			ctrP.card.show(ctrP, "BOARD");
		}
		else if(e.getSource()==b1)
		{
			String name=nameTf.getText();
			if(name.length()<1) // NOT NULL => 강제로 입력 => 웹(유효성 검사 => 자바스크립트)
			{
				nameTf.requestFocus();
				return;
			}
			
			String subject=subTf.getText();
			if(subject.length()<1) // NOT NULL => 강제로 입력 => 웹(유효성 검사 => 자바스크립트)
			{
				subTf.requestFocus();
				return;
			}
			
			String content=ta.getText();
			if(content.length()<1) // NOT NULL => 강제로 입력 => 웹(유효성 검사 => 자바스크립트)
			{
				ta.requestFocus();
				return;
			}
			
			String pwd=String.valueOf(pwdPf.getPassword());
			//    char[] => String으로 변환 
			if(pwd.length()<1)
			{
				pwdPf.requestFocus();
				return;
			}
			
			// 데이터를 모아서 DAO로 전송 
			BoardVO vo=new BoardVO();
			vo.setName(name);
			vo.setSubject(subject);
			vo.setContent(content);
			vo.setPwd(pwd);
			vo.setNo(no);
			
			// 데이터베이스 연동 
			boolean bCheck=dao.boardUpdate(vo);
			// 이동 
			if(bCheck==true)
			{
				JOptionPane.showMessageDialog(this, "수정이 완료되었습니다");
				ctrP.boardDtailP.print(no);
				ctrP.card.show(ctrP, "BOARD");
			}
			else
			{
				JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다\n다시 입력하세요");
				pwdPf.setText("");
				pwdPf.requestFocus();
			}
			// => response.sendRedirect("detail.jsp");
			
		}
	}
    	
}