package com.sist.main4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//1. 윈도우 상속 2. 인터페이스 상속
/*
 *	인터페이스
 *  ------- 이벤트와 관련 
 *  1) JButton, JRadioButton, JMenu, JTextField
 *     출력                           엔터 
 *    ------------------------------------------
 *     처리해 주는 인터페이스 => ActionListener : actionPerformed()
 *  2) MoseListener
 *      mouseClicked / mousePressed / MuseReleased / mouseExited / mouseEntered
 *  3) KeyListener
 *      KeyTyped / keyPressed / KeyReleased
 */
public class 퍼즐게임 extends JFrame implements ActionListener{
/*
 *	1. 기본초기화
 *     int=0; double => 0.0; boolean=false
 *     모든 클래스에서는 null
 *  2. 명시적인 초가화 => 중심 (고려)
 *
 */
	
	JButton[] btns=new JButton[9];
	JLabel la=new JLabel("퍼즐 게임",JLabel.CENTER); // 명시적인 초기화
	JButton b1,b2;
	// 초기화 
	
	public 퍼즐게임() { // 생성자
		//초기화와 동시에 화면 UI
	b1=new JButton("시작");
	b2=new JButton("종료");
	
	JPanel pan=new JPanel();
	pan.setLayout(new GridLayout(3,3,5,5)); // 같은 크기의 버튼... 
	//                           위 아래, 좌우 
	for(int i=0;i<btns.length;i++) {
		btns[i]=new JButton(String.valueOf(i+1));// 윈도우, 네트워크,웹은 데이터가 없다 => String 
		// 정수를 문자열로 변환 String.valueOf()
		pan.add(btns[i]);
	}
	JPanel p=new JPanel();
	p.add(b1);
	p.add(b2); // 일자 배치 JPanel =일자 배열 (FlowLayout)
	
	setLayout(null);
	
	la.setFont(new Font("맑은 고딕", Font.BOLD,38));
	la.setBounds(10,15,450,60); // 사용자정의 배치 => 직접배치
	add(la); // 윈도우에 첨부
	
	pan.setBounds(10,70,450,330);
	add(pan);
	
	p.setBounds(10,400,450,35);
	add(p);
	
	setSize(500,500);
	setVisible(true);
	}
	public static void main(String[] args) {
		new 퍼즐게임();
	}

	//버튼처리/메뉴처리/엔터처리
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
