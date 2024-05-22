package com.sist.lang;

import com.sist.melon.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.table.*;

public class 라이브러리_활용_Melon extends JFrame implements ActionListener,MouseListener{
    JTextField tf;
    JButton b,b1;
    JTable table;
    DefaultTableModel model;
    TableColumn column;
    JComboBox<String> box;
    MusicSystem ms=new MusicSystem();
    public 라이브러리_활용_Melon()
    {
    	tf=new JTextField(20);
    	b=new JButton("검색");
    	b1=new JButton("목록");
    	box=new JComboBox<String>();
    	box.addItem("노래명");
    	box.addItem("가수명");
    	box.addItem("앨범명");
        JPanel p=new JPanel();
        p.add(box);p.add(tf);p.add(b);p.add(b1);
        
        add("North",p);
        
        String[] col={"번호","노래명","가수명"};
        String[][] row=new String[0][3];
        model=new DefaultTableModel(row,col)
        {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
        	// 익명의 클래스 => 상속없이 오버라이딩이 가능 
        	
        };
        table=new JTable(model);
        table.getTableHeader().setBackground(Color.orange);
        table.setShowVerticalLines(false);
        table.setRowHeight(35);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        JScrollPane js=new JScrollPane(table);
        add("Center",js);
        
        musicData();
        setSize(500, 450);
        setVisible(true);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        table.addMouseListener(this);
        tf.addActionListener(this);
        for(int i=0;i<3;i++)
        {
        	column=table.getColumnModel().getColumn(i);
        	if(i==0)
        		column.setPreferredWidth(40);
        	else if(i==1)
        		column.setPreferredWidth(250);
        	else if(i==2)
        		column.setPreferredWidth(200);
        }
    }
    public void musicData()
    {
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	
    	
    	Music[] music=ms.musicListData();
    	// String s=1
    	for(Music m:music)
    	{
    		String[] data={String.valueOf(m.getMno()),m.getTitle(),m.getSinger()};
    		model.addRow(data);
    	}
    }
    public void musicFindData(int type,String fd)
    {
    	for(int i=model.getRowCount()-1;i>=0;i--)
    	{
    		model.removeRow(i);
    	}
    	
    	Music[] music=ms.musicFindData(type,fd);
    	
    	for(Music m:music)
    	{
    		String[] data={String.valueOf(m.getMno()),m.getTitle(),m.getSinger()};
    		model.addRow(data);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		}catch(Exception ex) {}
        new 라이브러리_활용_Melon();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b || e.getSource()==tf)
		{
			// 입력한 값 읽기 
			String fd=tf.getText();
			if(fd.trim().length()<1) // 입력이 안된 경우 
			{
				JOptionPane.showMessageDialog(this, "검색어를 입력하세요");
				tf.requestFocus();
				return; // 메소드 종료 
			}
			int type=box.getSelectedIndex();
			musicFindData(type,fd.trim());
		}
		else if(e.getSource()==b1)
		{
			musicData();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e){
		// TODO Auto-generated method stub
		if(e.getSource()==table)
		{
			if(e.getClickCount()==2)//더블 클릭
			{
				int row=table.getSelectedRow();
				String col=model.getValueAt(row, 0).toString();
				Music music=ms.musicDetailData(Integer.parseInt(col));
				String msg="노래명:"+music.getTitle()+"\n"
						  +"가수명:"+music.getSinger()+"\n"
						  +"앨범명:"+music.getAlbum();
				JOptionPane.showMessageDialog(this, msg);
				          
				/*try 
				{
					Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "
							+"http://youtube.com/embed/"+music.getKey());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
				
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