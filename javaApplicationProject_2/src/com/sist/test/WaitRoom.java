package com.sist.test;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
public class WaitRoom extends JPanel{
	JButton b1,b2,b3,b4,b5,b6;
	JTextArea ta;
	JTextField tf;
	JTable table1,table2;
	DefaultTableModel model1,model2;
	JScrollBar bar;
	
	public WaitRoom() {
		String[] col1= {"방이름","상담사","상태","인원"};
		String [][] row1=new String[0][4];
		model1=new DefaultTableModel(row1,col1) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			} // 테이블안의 데이터 관리

		};
		table1=new JTable(model1); // 모양만 잡아준다 => MV
		// Model => 데이터 관리 (Model=> Java,JavaScript) => MVC / Vue / React
		// View => 윈도우 / HTML 
		JScrollPane js1=new JScrollPane(table1);
		
		
		String[] col2= {"ID","이름","성별","위치","구분"}; // 방 접속자 
		String [][] row2=new String[0][5]; // col=> 데이터 개수 
		model2=new DefaultTableModel(row2,col2); // 테이블안의 데이터 관리 
		table2=new JTable(model2); // 모양만 잡아준다 => MV
		// Model => 데이터 관리 (Model=> Java,JavaScript) => MVC / Vue / React
		// View => 윈도우 / HTML 
		JScrollPane js2=new JScrollPane(table2);
		
		ta=new JTextArea();
		JScrollPane js3=new JScrollPane(ta);
		bar=js3.getVerticalScrollBar(); // 스크롤바 밑으로 내림 
		ta.setEditable(false); // 건들지 못하게 (서버에서 보내는 값 출력 위치/ 채팅창)
		
		tf=new JTextField(); // 채팅 보내는 창
		
		b1=new JButton("방만들기");
		b2=new JButton("방들어가기");
		b3=new JButton("1:1 채팅");
		b4=new JButton("정보보기");
		b5=new JButton("쪽지보내기");
		b6=new JButton("나가기");
		
		// 배치
		setLayout(null); // 수동 배치 null
		
		js1.setBounds(10, 15, 370, 320); // 상담사 명단
		add(js1);
		js3.setBounds(385, 15, 390, 285); // 채팅창
		add(js3);
		tf.setBounds(385, 305, 390, 30); // 채팅보내기 창
		add(tf);
		
		js2.setBounds(10, 340, 370, 200); // js2 접속대기명단
		add(js2);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(3,2,5,5));
		p.add(b1);p.add(b2);
		p.add(b3);p.add(b4);
		p.add(b5);p.add(b6);
		
		p.setBounds(385, 345, 390, 195);
		add(p);
		
		
	}
}
