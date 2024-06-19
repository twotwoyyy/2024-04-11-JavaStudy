package com.sist.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.util.*;

import com.sist.client.*;
import com.sist.commons.*;
import com.sist.dao.*;
public class ClientMain extends JFrame implements ActionListener,MouseListener, Runnable{
	CardLayout card=new CardLayout();
	LoginPanel loginP=new LoginPanel();
	JoinPanel joinP=new JoinPanel();
	PostFindFrame post=new PostFindFrame();
	IdCheckFrame idFrm=new IdCheckFrame();
	MenuPanel menuP=new MenuPanel();
	ControllPanel ctrP=new ControllPanel();

	
	Socket s;
	OutputStream out;
	BufferedReader in;
	String myId;
	int selRow=-1;

	public ClientMain() {
		setLayout(null);
		
		menuP.setBounds(280, 25, 650, 35);
		add(menuP);
		ctrP.setBounds(10, 60, 930, 680);
		add(ctrP);
		
		setSize(960,790);
		setResizable(false);
		
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		
		

		menuP.homeBtn.addActionListener(this);
		menuP.findBtn.addActionListener(this);
		menuP.newsBtn.addActionListener(this);
		menuP.chatBtn.addActionListener(this);
		menuP.exitBtn.addActionListener(this);
		menuP.boardBtn.addActionListener(this);
		
		loginP.loginBtn.addActionListener(this);
		loginP.joinBtn.addActionListener(this);
		loginP.cancelBtn.addActionListener(this);
		
		joinP.cancel.addActionListener(this);
		joinP.postFind.addActionListener(this); //우편번호검색
		joinP.idCheck.addActionListener(this); //아이디중복체크
		joinP.join.addActionListener(this); //가입
		
		idFrm.idFind.addActionListener(this); //아이디체크
		idFrm.ok.addActionListener(this); //확인
		
		post.find.addActionListener(this); //우편번호 검색
		post.cancel.addActionListener(this); //우편번호 취소
		post.postTf.addActionListener(this); //우편번호 입력
		post.table.addMouseListener(this); //우편번호 더블클릭
		
		ctrP.chatP.chatInput.addActionListener(this);
		ctrP.chatP.table.addMouseListener(this); // 
		ctrP.chatP.infoBtn.addActionListener(this); // 정보보기

		
		
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		new ClientMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginP.cancelBtn) {
			dispose();
			System.exit(0);
		}
		else if(e.getSource()==loginP.loginBtn) {
			try {
				String id=loginP.idField.getText();
				if(id.length()<1) {
					JOptionPane.showMessageDialog(this, "아이디를 입력하세요");
					loginP.idField.requestFocus();
					return;
				}
				String pwd=String.valueOf(loginP.pwField.getPassword());
				if(pwd.length()<1) {
					JOptionPane.showMessageDialog(this, "비밀 번호를 입력하세요");
					loginP.pwField.requestFocus();
					return;
				}
				
				MemberDAO dao=MemberDAO.newInstance();
				String result=dao.memberLogin(id, pwd);
				if(result.equals("NOID")) {
					JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
					loginP.idField.setText("");
					loginP.pwField.setText("");
					loginP.idField.requestFocus();
				}
				else if(result.equals("NOPWD")) {
					JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
					loginP.pwField.setText("");
					loginP.pwField.requestFocus();
				}
				else {
					try {
//						s=new Socket("192.168.0.126",7777);
						s=new Socket("localhost",7777);
						out=s.getOutputStream();
						in=new BufferedReader(new InputStreamReader(s.getInputStream()));
						out.write((Function.LOGIN+"|"+id+"\n").getBytes());
						
					}catch(Exception ex) {
						ex.printStackTrace();
					}
					new Thread(this).start();
				}
			}catch(Exception ex) {
				ex.printStackTrace();
				JOptionPane.showMessageDialog(this, "잘못된 입력입니다");
				return;
			}
		}else if(e.getSource()==loginP.joinBtn) {
			loginP.setVisible(false);
			joinP.setVisible(true);
		}else if(e.getSource()==joinP.cancel) {
			loginP.setVisible(true);
			joinP.setVisible(false);
		}else if(e.getSource()==menuP.homeBtn) {
			ctrP.card.show(ctrP, "HOME");
		}else if(e.getSource()==menuP.findBtn) {
			ctrP.card.show(ctrP, "FIND");
		}else if(e.getSource()==menuP.boardBtn) {
			ctrP.card.show(ctrP, "BOARD");
		}else if(e.getSource()==menuP.chatBtn) {
			ctrP.card.show(ctrP, "CHAT");
		}else if(e.getSource()==menuP.exitBtn) {
			try {
				out.write((Function.EXIT+"|\n").getBytes());
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(e.getSource()==joinP.idCheck) {
			idFrm.idTf.setText(""); //메모리 초기화
			idFrm.ok.setVisible(false);
			idFrm.alert.setText("");
			idFrm.setVisible(true);
		}else if(e.getSource()==idFrm.idFind) {
			String id=idFrm.idTf.getText();
			if(id.length()<1) {
				JOptionPane.showMessageDialog(this, "아이디를 입력하세요"); // alert()
				idFrm.idFind.requestFocus(); //idTf.focus()
				return;
			}
			//아이디 입력된 상태
			//오라클 연결
			MemberDAO dao=MemberDAO.newInstance();
			int count=dao.memberIdCheck(id);
			if(count==0) {
				idFrm.alert.setText(id+"는(은) 사용 가능한 아이디입니다");
				idFrm.ok.setVisible(true);
			}else {
				idFrm.alert.setText(id+"는(은) 이미 사용중인 아이디입니다");
				idFrm.ok.setVisible(false);
				idFrm.idTf.setText("");
				idFrm.idTf.requestFocus();
			}
		}else if(e.getSource()==idFrm.ok) {
			String id=idFrm.idTf.getText();
			joinP.idF.setText(id);
			idFrm.setVisible(false);
		}else if(e.getSource()==joinP.postFind) {//--------우편번호검색
			for(int i=post.model.getRowCount()-1;i>=0;i--) {
				post.model.removeRow(i); //열릴때마다 리스트 리셋, 지우기
			}
			post.postTf.setText("");
			post.setVisible(true);
		}else if(e.getSource()==post.cancel) {
			post.setVisible(false);
		}else if(e.getSource()==post.find || e.getSource()==post.postTf) {
			String dong=post.postTf.getText();
			if(dong.length()<1) {
				JOptionPane.showMessageDialog(this, "동/읍/면을 입력하세요");
				post.postTf.requestFocus();
				return;
			}
			MemberDAO dao=MemberDAO.newInstance();
			ArrayList<ZipcodeVO> list=dao.postFindData(dong);
			if(list.size()==0) {
				JOptionPane.showMessageDialog(this, "검색된 결과가 없습니다");
				post.postTf.setText("");
				post.postTf.requestFocus();
			}else {
				for(int i=post.model.getRowCount()-1;i>=0;i--) {
					post.model.removeRow(i); //열릴때마다 리스트 리셋, 지우기
				}
				for(ZipcodeVO vo:list) {
					String[] data= {vo.getZipcode(), vo.getAddress()};
					post.model.addRow(data);
				}
			}
		}else if(e.getSource()==joinP.join) {
			String id=joinP.idF.getText();
			if(id.length()<1) {
				joinP.idF.requestFocus();
				return;
			}
			String pwd=String.valueOf(joinP.pwF.getPassword());
			if(pwd.length()<1) {
				joinP.pwF.requestFocus();
				return;
			}
			String pwd2=String.valueOf(joinP.pw2F.getPassword());
			if(pwd.length()<1) {
				joinP.pw2F.requestFocus();
				return;
			}
			if(!pwd.equals(pwd2)) {
				joinP.pw2F.requestFocus();
				return;
			}
			String name=joinP.nameF.getText();
			if(name.length()<1) {
				joinP.nameF.requestFocus();
				return;
			}
			String sex="";
			if(joinP.genderM.isSelected()) {
				sex="남자";
			}else {
				sex="여자";
			}
			String birthday=joinP.birthF.getText();
			if(birthday.length()<1) {
				joinP.birthF.requestFocus();
				return;
			}
			String post=joinP.postF.getText();
			if(post.length()<1) {
				joinP.birthF.requestFocus();
				return;
			}
			String addr1=joinP.addr1F.getText();
			if(addr1.length()<1) {
				joinP.addr1F.requestFocus();
				return;
			}
			String phone1=joinP.phoneF1.getText();
			String phone2=joinP.phoneF2.getText();
			String phone3=joinP.phoneF3.getText();
			if(phone1.length()<1) {
				joinP.phoneF1.requestFocus();
				return;
			}
			String phone=phone1+"-"+phone2+"-"+phone3;
			
			String emailId=joinP.emailF.getText();
			String emailSite=joinP.emailCombo.getSelectedItem().toString();
			if(emailId.length()<1) {
				joinP.emailF.requestFocus();
				return;
			}
			String email=emailId+"@"+emailSite;
			
			String addr2=joinP.addr2F.getText();
			String content=joinP.conT.getText();
			MemberVO vo=new MemberVO();
			vo.setId(id);
			vo.setPwd(pwd);
			vo.setName(name);
			vo.setSex(sex);
			vo.setBirthday(birthday);
			vo.setPost(post);
			vo.setAddr1(addr1);
			vo.setAddr2(addr2);
			vo.setEmail(email);
			vo.setPhone(phone);
			vo.setContent(content);
			
			MemberDAO dao=MemberDAO.newInstance();
			String res=dao.memberInsert(vo);
			
			if(res.equals("yes")) {
				JOptionPane.showMessageDialog(this, "회원 가입 축하합니다");
				card.show(getContentPane(), "LOGIN");
			}else {				
				JOptionPane.showMessageDialog(this, "회원 가입에 실패하셨습니다\n"+res);
			}	
			
		}else if(e.getSource()==ctrP.chatP. chatInput) {
			
			String msg=ctrP.chatP. chatInput.getText();
			if(msg.length()<1) {
				return;
			}
			String color=ctrP.chatP.colorBox.getSelectedItem().toString();
			try {
				out.write((Function.CHAT+"|"+msg+"|"+color+"\n").getBytes());
			}catch(Exception ex) {}
			ctrP.chatP. chatInput.setText("");
			ctrP.chatP. chatInput.requestFocus();
		}else if(e.getSource()==ctrP.chatP.infoBtn) {
			if(selRow==-1) {
				JOptionPane.showMessageDialog(this, "정보를 볼 회원을 선택하세요");
				return;
			}
			String yid=ctrP.chatP.model.getValueAt(selRow, 0).toString();
			try {
				out.write((Function.INFO+"|"+yid+"\n").getBytes());
			}catch(Exception ex) {}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==post.table) {
			if(e.getClickCount()==2) {
				int row=post.table.getSelectedRow();
				String zip=post.model.getValueAt(row, 0).toString();
				String addr=post.model.getValueAt(row, 1).toString();
				
				joinP.postF.setText(zip);
				joinP.addr1F.setText(addr);
				
				post.setVisible(false);
			}
		}
	    else if (e.getSource() == ctrP.chatP.table) {
	        if (e.getClickCount() == 2) {
	            int row = ctrP.chatP.table.getSelectedRow();
	            selRow = row;
				String id=ctrP.chatP.model.getValueAt(row, 0).toString();
				if(id.equals(myId))
				{
					ctrP.chatP.infoBtn.setEnabled(false);
					ctrP.chatP.oneBtn.setEnabled(false);
				}
				else
				{
					ctrP.chatP.infoBtn.setEnabled(true);
					ctrP.chatP.oneBtn.setEnabled(true);
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
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				while(true) {
					String msg=in.readLine(); //서버 응답값
					StringTokenizer st=new StringTokenizer(msg, "|");
					int delimit=Integer.parseInt(st.nextToken());
					switch(delimit) {
						case Function.LOGIN:{
							String[] data={
									st.nextToken(),
									st.nextToken(),
									st.nextToken()
							};
							ctrP.chatP.model.addRow(data);
							String admin=st.nextToken();
						}
						break;
						case Function.MYLOG:{
							myId=st.nextToken();
							String name=st.nextToken();
							setTitle(name+"님의 채팅창");
							loginP.setVisible(false);
							setVisible(true);
						}
						break;
						case Function.CHAT:{
							String message=st.nextToken();
							String color=st.nextToken();
							ctrP.chatP.initStyle();
							ctrP.chatP.append(message, color);
							ctrP.chatP.chatBar.setValue(ctrP.chatP.chatBar.getMaximum());
						}
						break;
						case Function.MYEXIT:{
							System.exit(0); //윈도우창 종료
						}
						break;
						case Function.INFO:{
							String info="이름: "+st.nextToken()+"\n"
									+"성별: "+st.nextToken()+"\n"
									+"주소: "+st.nextToken()+"\n"
									+"이메일: "+st.nextToken()+"\n"
									+"전화: "+st.nextToken()+"\n"
									+"소개: "+st.nextToken();
							JOptionPane.showMessageDialog(this, info);
							selRow=-1;
						}
						break;
						case Function.EXIT:{
							String yid=st.nextToken();
							for(int i=0;i<ctrP.chatP.model.getRowCount();i++) {
								String s=ctrP.chatP.model.getValueAt(i, 0).toString(); //테이블에 등록된 아이디 읽기
								if(s.equals(yid)) {
									ctrP.chatP.model.removeRow(i);
									break;
								}
							}
						}

						break;
					}
				}
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}

	}