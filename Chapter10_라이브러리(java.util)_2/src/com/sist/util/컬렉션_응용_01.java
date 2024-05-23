package com.sist.util;

import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

class Sawon{
	private int sabun;
	private String name;
	private String dept;
	private String job;
	private long pay;
	public int getSabun() {
		return sabun;
	}
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}

	public long getPay() {
		return pay;
	}
	public void setPay(long pay) {
		this.pay = pay;
	}
	public Sawon(int sabun, String name, String dept, String job, long pay) {
		super();
		this.sabun = sabun;
		this.name = name;
		this.dept = dept;
		this.job = job;
		this.pay = pay;
	}
	public Sawon() {
		
	}
	
}
class SawonSystem{
	// Sawon[] sawon ...
	static ArrayList<Sawon> list=new ArrayList<Sawon>(); //static이어야 추가된다 
	public SawonSystem() {
		list.add(new Sawon(1,"홍길동","개발부","대리",4000));
		list.add(new Sawon(2,"이순신","영업부","부장",6000));
		list.add(new Sawon(3,"박문수","자재부","사원",3200));
		list.add(new Sawon(4,"심청이","총무부","과장",4500));
		list.add(new Sawon(5,"김두한","기획부","사원",3200));
	}
	public void insertSawon(Sawon sa) {
		list.add(sa);
	}
	public void updateSawon(int sabun,Sawon sa) {
		for(int i=0;i<list.size();i++) {
			Sawon s=list.get(i);
			if(s.getSabun()==sabun) {
				list.set(i, sa);
				break;
			}
		}
	}
	public void deleteSawon(int sabun) {
		for(Sawon s:list) {
			if(s.getSabun()==sabun) {
				list.remove(s);
				break;
			}
		}
	}
	// 값을 갖고온다 
	public ArrayList<Sawon> sawonListdata(){
		return list;
	}
	public ArrayList<Sawon> sawonFind(String name){
		ArrayList<Sawon> arr=new ArrayList<Sawon>();
		for(Sawon s:list) {
			if(s.getName().contains(name)) {
				arr.add(s);
			}
		}
		return arr;
	}
}
public class 컬렉션_응용_01 extends JFrame implements ActionListener{
	JButton up,in,del,exit;
	JTable table;
	DefaultTableModel model;
	SawonSystem ss=new SawonSystem();
	public 컬렉션_응용_01() {
		up=new JButton("수정");
		in=new JButton("추가");
		del=new JButton("삭제");
		exit=new JButton("종료");
		JPanel p=new JPanel();
		p.add(in);p.add(up);p.add(del);p.add(exit);
		
		String[] col= {"사번","이름","부서","직위","연봉"};
		String[][] row=new String[0][5]; // 0은 1줄
		model=new DefaultTableModel(row,col);
		table=new JTable(model);
		JScrollPane js=new JScrollPane(table);
		
		add("Center",js);
		
		add("North",p);
		SawonList();
		setSize(600,400);
		setVisible(true);
		
		up.addActionListener(this);
		in.addActionListener(this);
		del.addActionListener(this);
		exit.addActionListener(this);
	}
	// 테이블 지워주기
	public void SawonList() {
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		
		//SawonSystem ss=new SawonSystem();
		ArrayList<Sawon> list=ss.sawonListdata();
		
		for(Sawon s:list) {
			String[] temp= {String.valueOf(s.getSabun()),s.getName(),
					s.getDept(),s.getJob(),String.valueOf(s.getPay())};
			model.addRow(temp);
		}
	}
	public static void main(String[] args) {
		new 컬렉션_응용_01();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==in) {
			//SawonSystem ss=new SawonSystem();
			Sawon s=new Sawon(6,"을지문덕","영업부","대리",4000);
			ss.insertSawon(s);
			SawonList();
		}
		else if(e.getSource()==up) {
			Sawon s=new Sawon(6,"정세현","영업부","대리",4000);
			ss.updateSawon(6,s);
			SawonList();
		}
		else if(e.getSource()==del) {
			ss.deleteSawon(4);
			SawonList();
		}
		else {
			JOptionPane.showMessageDialog(this,"프로그램을 종료합니다"); // 팝업창 띄우기 
			System.exit(0); // 프로그램 종료 
		}
	}
}
