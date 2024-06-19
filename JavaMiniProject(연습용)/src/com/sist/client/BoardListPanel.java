package com.sist.client;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import com.sist.dao.*;
public class BoardListPanel extends JPanel implements ActionListener,MouseListener{
	JLabel titleLa,pageLa;
	JButton newBtn,postBtn,nextBtn;
	JTable table;
	DefaultTableModel model;
	TableColumn column;
	BoardDAO dao;
	ControllPanel ctrP;
	int curpage=1;
	int totalpage=0;
	public BoardListPanel(ControllPanel ctrP) {
		this.ctrP=ctrP;
		dao=BoardDAO.newInstance();
		
		newBtn=new JButton("새글");
		postBtn=new JButton("이전");
		nextBtn=new JButton("다음");
    	pageLa=new JLabel("0 page / 0 pages"); //<label>0 page / 0 pages</label>
    	titleLa=new JLabel("게시판",JLabel.CENTER);// <table>
    	titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
    	String[] col={"번호","제목","이름","작성일","조회수"};//<tr><th></th>....</tr>
    	String[][] row=new String[0][5];
    	model=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
    	};
    	table=new JTable(model);
    	JScrollPane js=new JScrollPane(table);
    	for(int i=0;i<col.length;i++) {
    		column=table.getColumnModel().getColumn(i);
    		if(i==0)
    		{
    			column.setPreferredWidth(50);
    		}
    		else if(i==1)
    		{
    			column.setPreferredWidth(350);
    		}
    		else if(i==2)
    		{
    			column.setPreferredWidth(100);
    		}
    		else if(i==3)
    		{
    			column.setPreferredWidth(150);
    		}
    		else if(i==4)
    		{
    			column.setPreferredWidth(50);
    		}
    	}
    	table.getTableHeader().setReorderingAllowed(false);
    	table.setShowVerticalLines(false);
    	table.setRowHeight(30);
    	table.getTableHeader().setBackground(Color.pink);
    	
    	setLayout(null);
    	titleLa.setBounds(120, 15, 620, 50);
    	add(titleLa);
    	newBtn.setBounds(120, 70, 100, 30);
    	add(newBtn);
    	js.setBounds(120, 110, 620, 330);
    	add(js);
    	
    	JPanel p=new JPanel();
    	p.add(postBtn);
    	p.add(pageLa);
    	p.add(nextBtn);
    	
    	p.setBounds(120, 450, 620, 35);
    	add(p);
    	print();
    	
    	newBtn.addActionListener(this);
    	postBtn.addActionListener(this);
    	nextBtn.addActionListener(this);
    	table.addMouseListener(this);
	}
	public void print() {
		for(int i=model.getRowCount()-1;i>0;i--) {
			model.removeRow(i);
		}
		
    	List<BoardVO> list=dao.boardListData(curpage);
    	totalpage=dao.boardTotalPage();
    	
    	for(BoardVO vo:list)
    	{
    		String[] data={
    			String.valueOf(vo.getNo()),
    			vo.getSubject(),
    			vo.getName(),
    			vo.getRegdate().toString(),
    			String.valueOf(vo.getHit())
    		};
    		model.addRow(data);
    		
    		pageLa.setText(curpage+" page / "+totalpage+" pages");
    	}
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==postBtn) {
			if(curpage>1) {
				curpage--;
				print();
			}
		}
		else if(e.getSource()==nextBtn) {
			if(curpage<totalpage) {
				curpage++;
				print();
			}
		}
		else if(e.getSource()==newBtn) {
			ctrP.bInsertP.nameTf.setText("");
			ctrP.bInsertP.subTf.setText("");
			ctrP.bInsertP.ta.setText("");
			ctrP.bInsertP.pwdPf.setText("");
			ctrP.card.show(ctrP, "INSERT");
			ctrP.bInsertP.nameTf.requestFocus();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource()==table)
		{
			if(e.getClickCount()==2)
			{
				int row=table.getSelectedRow();
				String no=model.getValueAt(row, 0).toString();
				
				// 데이터를 출력 
				ctrP.bDtailP.print(Integer.parseInt(no));
				// 이동 
				ctrP.card.show(ctrP, "BDETAIL");
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
}
