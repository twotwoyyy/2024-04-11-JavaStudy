package com.sist.lang;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;
import com.sist.music.Music;
import com.sist.music.MusicSystem;

public class 라이브러리_활용_Genie extends JFrame implements ActionListener,MouseListener{
	JTextField tf;
	JButton b,b1;
	JTable table;
	DefaultTableModel model;
	public 라이브러리_활용_Genie() {
		tf=new JTextField(20);
		b=new JButton("검색");
		b1=new JButton("목록");
		JPanel p=new JPanel(); // 패널 묶어서 배치 
		p.add(tf);p.add(b);p.add(b1);
		
		add("North",p);
		
		String[] col= {"번호","곡명","가수명"};
		String[][]row=new String[0][3]; // [줄수][데이터수]
		
		model=new DefaultTableModel(row,col) {

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // 편집을 막을 경우 사용 
			}
			// 익명의 클래스 = 상속 없이 오버라이딩 가능 
			
		}; // 오버라이딩
		table=new JTable(model);
		JScrollPane js=new JScrollPane(table);
		add("Center",js);
		
		musicData();
		setSize(500,450);
		setVisible(true);
		
		b.addActionListener(this);
		b1.addActionListener(this);
		table.addMouseListener(this);
	}
	public void musicData() {
		// 일부로 지우고 새롭게 목록 출력하도록 설정 
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		MusicSystem ms=new MusicSystem();
		Music[] music=ms.musicListData();
		
		for(Music m:music) {
			String[] data={String.valueOf(m.getMno()),m.getTitle(),m.getSinger()}; // 정수는 문자열로 변환 
			model.addRow(data);
		}
	}
	public void musicFindData(String fd) {
		for(int i=model.getRowCount()-1;i>=0;i--) {
			model.removeRow(i);
		}
		MusicSystem ms=new MusicSystem();
		Music[] music=ms.musicFindData(fd);
		
		for(Music m:music) {
			String[] data={String.valueOf(m.getMno()),m.getTitle(),m.getSinger()}; // 정수는 문자열로 변환 
			model.addRow(data);
		}
	}
	public static void main(String[] args) {
		//MusicSystem ms=new MusicSystem();
		new 라이브러리_활용_Genie();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) {
			//입력한 값 읽기
			String fd=tf.getText();
			if(fd.trim().length()<1) {
				// length<1 은 입력한 값이 없다는 뜻  // trim으로 공백 제거하지 않으면 공백도 문자처리를 해버린다 
				JOptionPane.showMessageDialog(this,"검색어를 입력하세요!!");
				//                           this는 창 위에 띄운다는 말 
				tf.requestFocus();
				return; // 메소드 종료
			}
			musicFindData(fd);
		}
		else if(e.getSource()==b1) {
			musicData();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==table) {
			if(e.getClickCount()==2) { //2 => 더블클릭
				int row=table.getSelectedRow();//몇 번째 줄이 선택됐는지 확인
				String col=model.getValueAt(row, 0).toString();
				MusicSystem ms=new MusicSystem();
				Music music=ms.MusicDetailData(Integer.parseInt(col));
				String msg="노래명:"+music.getTitle()+"\n"
						+"가수명:"+music.getSinger()+"\n"
						+"앨범명:"+music.getAlbum();
				JOptionPane.showMessageDialog(this, msg);
				try {
					Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe "
							+"http://youtube.com/embed/"+music.getKey());
				}catch(Exception ex) {}
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
