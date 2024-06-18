package com.sist.client;
import java.util.*;
import com.sist.dao.*;
import com.sist.commons.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class FindPanel extends JPanel implements ActionListener,MouseListener{
	  ControllPanel ctrP;
	  JTable table;
	  DefaultTableModel model;
	  JTextField tf;
	  JButton b;
	  BooksDAO dao;
	  TableColumn column;
	  public FindPanel(ControllPanel ctrP) {
		  dao=BooksDAO.newInstance();
		  this.ctrP=ctrP;
		  
		  setLayout(new BorderLayout());
		  tf=new JTextField(20);
		  b=new JButton("검색");
		  
		  JPanel p=new JPanel();
		  p.add(tf);p.add(b);
		  add("North",p);
		  
		  String[] col= {"번호","","제목","가격"};
	      Object[][] row=new Object[0][4];
	      
	      model=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				// TODO Auto-generated method stub
				return getValueAt(0,columnIndex).getClass();
			}
	    	  
	      };
	      
	      table=new JTable(model);
	      table.setRowHeight(100);
	      table.getTableHeader().setReorderingAllowed(false);
	      table.setShowVerticalLines(false);
	      JScrollPane js=new JScrollPane(table);
	      add("Center",js);
	      
	      for(int i=0; i<col.length;i++) {
	    		column=table.getColumnModel().getColumn(i);
	    		if(i==0)
	    			column.setPreferredWidth(30);
	    		else if(i==1)
	    			column.setPreferredWidth(100);
	    		else if(i==2)
	    			column.setPreferredWidth(500);
	    		else if(i==3)
	    			column.setPreferredWidth(150);
	      }
	    	tf.addActionListener(this);
	    	b.addActionListener(this);
	    	table.addMouseListener(this);
	  }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
//		if(e.getSource()==table)
//		{
//			if(e.getClickCount()==2)
//			{
//				int row=table.getSelectedRow();
//				String no=model.getValueAt(row, 0).toString();
//				ctrP.dp.print(Integer.parseInt(no));
//				ctrP.card.show(ctrP, "DETAIL");
//			}
//		}
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
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==tf || e.getSource()==b) {
			String name=tf.getText();
			if(name.length()<1) {
				JOptionPane.showMessageDialog(this, "검색어를 입력하시오");
				tf.requestFocus();
				return;
			}
			ArrayList<BooksVO> list=dao.booksFindData(name);
			if(list.size()<1) {
				JOptionPane.showMessageDialog(this, "검색된 결과가 없습니다");
			}
			else
			{
				for(int i=model.getRowCount()-1;i>=0;i--)
				{
					model.removeRow(i);
				}
				System.out.println(list.size());
				for(BooksVO vo:list) {
					try {
						URL url=new URL(vo.getImage());
						Image img=ImageChange.getImage(new ImageIcon(url),100,100);
						Object[] obj= {
								vo.getNum(),
								new ImageIcon(img),
								"<html><font size=4>"+vo.getBookname()+"</font></html>",
								vo.getPrice()
						};
						model.addRow(obj);
					}catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			}
		}
		
	}
}
