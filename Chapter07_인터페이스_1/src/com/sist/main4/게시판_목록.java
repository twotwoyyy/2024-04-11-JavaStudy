package com.sist.main4;
// table 생성 
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
public class 게시판_목록 extends JFrame{
	///////////////////// 포함 클래스 ////////////////////////
	JLabel titleLa=new JLabel("게시판",JLabel.CENTER); // 기본은 left정렬
	JLabel pageLa=new JLabel("0 page/0 pages");
	JButton b1,b2,b3; // 새글/이전/다음 버튼
	JTable table; // table 모양
	DefaultTableModel model; // table 데이터 관리
	// 모양 => 필요한 클래스를 포함시켜놓고 시작 => 있는 그대로 사용 (변경x)
	// 1. 초기화 , 화면 UI => 시작과 동시에 떠야 한다 => 생성자 !!!! 
	public 게시판_목록() {
		b1=new JButton("새 글");
		b2=new JButton("이전");
		b3=new JButton("다음");
		///////////////////////////////////////////////////////////////////
		String[] col= {"번호","제목","이름","작성일","조회수"}; // table 타이틀바
		String[][] row=new String[0][5]; // 뒤 개수는 앞이랑 일치 되어야 한다 
		model=new DefaultTableModel(row,col);
		table=new JTable(model);
		JScrollPane js=new JScrollPane(table); // 스크롤바
		//////////////////////////////////////////////////////////////////
		// 네트워크 / 파일 
		////////////////////////배치/////////////////////////
		setLayout(null); // null은 직접배치하겠다는 말이다 (x,y)
		titleLa.setFont(new Font("맑은 고딕",Font.BOLD,35));
		titleLa.setBounds(10,15,500,40);
		add(titleLa); // JFrame에 추가 
		
		// 버튼 배치
		b1.setBounds(10,60,100,30);
		add(b1);
		
		js.setBounds(10, 95, 520, 400);
		add(js);
		
		JPanel p=new JPanel(); // 위치가 같으면 패널로 묶는다
		p.add(b2);
		p.add(pageLa);
		p.add(b3);
		p.setBounds(10, 500, 520, 35);
		add(p);
		
		
		
		setSize(550,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	
	}
	public static void main(String[] args) {
		new 게시판_목록();
	}
}
