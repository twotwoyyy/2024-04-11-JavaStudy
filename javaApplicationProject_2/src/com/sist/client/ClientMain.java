package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Array;
import java.lang.reflect.Member;
import java.util.ArrayList;

import com.sist.dao.*;
public class ClientMain extends JFrame implements ActionListener, MouseListener{
	CardLayout card=new CardLayout();
	LoginPanel loginP=new LoginPanel();
	MainPanel mainP=new MainPanel();
	JoinPanel joinP=new JoinPanel();
	PostFindFrame post=new PostFindFrame(); //우편번호 검색창
	IdCheckFrame idFrm=new IdCheckFrame();
	public ClientMain() {
		setLayout(card);
		add("LOGIN",loginP);
		add("JOIN", joinP);
		add("MAIN", mainP);
		
		setSize(960, 750);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); //윈도우 창 우측상단 X버튼으로 종료금지
	
		mainP.menuP.homeBtn.addActionListener(this); //홈
		mainP.menuP.findBtn.addActionListener(this); //검색
		mainP.menuP.newsBtn.addActionListener(this); //뉴스
		mainP.menuP.boardBtn.addActionListener(this); //게시판
		mainP.menuP.chatBtn.addActionListener(this); //채팅
		mainP.menuP.exitBtn.addActionListener(this); //종료
		
		loginP.loginBtn.addActionListener(this); //로그인
		loginP.joinBtn.addActionListener(this); //회원가입
		loginP.cancelBtn.addActionListener(this); //종료
		
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
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		new ClientMain();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==loginP.cancelBtn) {
			dispose(); //window 메모리 해제
			System.exit(0); //프로그램종료
		}else if(e.getSource()==loginP.loginBtn) {
			//1.입력한 사번, 이름 가지고 오기
			try {
				//유효성 검사
				String id=loginP.idField.getText();
				if(id.length()<1) {
					JOptionPane.showMessageDialog(this, "아이디을 입력하세요");
					loginP.idField.requestFocus();
					return;
				}
				String pwd=String.valueOf(loginP.pwField.getPassword()); //비밀번호 값 가지고 오기 char배열이라 String으로 변환
				if(pwd.length()<1) {
					JOptionPane.showMessageDialog(this, "비밀번호을 입력하세요");
					loginP.pwField.requestFocus();
					return;
				}
				
				//오라클 연결
				MemberDAO dao=MemberDAO.newInstance();
				String result=dao.memberLogin(id, pwd);
				//웹에서는 자바스크립트 처리
				if(result.equals("NOID")) {
					//없는 아이디
					JOptionPane.showMessageDialog(this, "아이디가 존재하지 않습니다");
					loginP.idField.setText("");
					loginP.pwField.setText("");
					loginP.idField.requestFocus();
				}else if(result.equals("NOPWD")) {
					//비밀번호 불일치
					JOptionPane.showMessageDialog(this, "비밀번호가 틀립니다");
					loginP.pwField.setText("");
					loginP.pwField.requestFocus();
				}else {
					//로그인
					card.show(getContentPane(),"MAIN");
				}
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "잘못된 입력입니다");
				return; //메소드 종료
			}
		}else if(e.getSource()==loginP.joinBtn) {
			card.show(getContentPane(),"JOIN");
		}else if(e.getSource()==joinP.cancel) {
			card.show(getContentPane(),"LOGIN");
		}else if(e.getSource()==mainP.menuP.homeBtn){
			mainP.ctrP.card.show(mainP.ctrP,"BOOKLIST");
		}else if(e.getSource()==mainP.menuP.findBtn){
			mainP.ctrP.card.show(mainP.ctrP,"FIND");
		}else if(e.getSource()==joinP.idCheck) {//-------아이디중복체크
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
