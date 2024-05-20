package com.sist.main;
// UpDown 게임 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //interface
public class 예외처리_응용 extends JFrame implements ActionListener{
	// 예외처리_응용 => 윈도우를 확장 => 상속(단일 상속 기본)
	JTextField tf;
	JButton b1,b2; // 선언 
	JLabel la=new JLabel("",JLabel.CENTER); // 명시적인 초기화
	// 클래스 => 변수 (객체) => 변수 사용 (기본형, 배열, 클래스) => 멤버 변수로 사용이 가능
	// 초기화, 화면 UI, 서버 연결 => 생성자에 주로 처리 
	
	// 전체적으로 사용하는 변수 => 메소드 2개 이상인 곳에서 사용 
	// 1. 입력값 받는 경우 2. 비교시에 사용
	int com; // 난수
	int user; // 사용자 입력값
	// 처리 => 입력 => 엔터시 => 입력값을 받는다 , 비교 => 결과값 출력 
	public 예외처리_응용() {
		tf=new JTextField();
		b1=new JButton("시작");
		b2=new JButton("종료");
		
		// 배치
	setLayout(null); // 사용자 정의  
	tf.setBounds(10, 15, 150, 30);
	tf.setEnabled(false); // 비활성화 시키기 
	// 윈도우에 추가
	add(tf);
	b1.setBounds(165, 15, 100, 30);
	add(b1);
	b2.setBounds(270,15,100,30);
	add(b2);
	la.setBounds(10, 55, 360, 30);
	add(la);
	
	//윈도우 크기
	setSize(400, 135);
	setVisible(true);
	
	//버튼 클릭 => 등록 => 메소드 자동 호출 
	b1.addActionListener(this); //actionPetformed => 어디 있는지 // 여기 있는 클래스 this => 자신이 갖고 있는 객체 
	b2.addActionListener(this);
	tf.addActionListener(this);
	
	}
	public static void main(String[] args) {
		//생성자 호출
		new 예외처리_응용();
	}
	
	
	public void getRand() {
		com=(int)(Math.random()*100)+1;
		
	}
	public void compare() {
		if(com>user) {
			la.setText("입력값보다 큰 값을 입력하시오.");
			tf.setText("");
			tf.requestFocus();
		}
		else if(com<user) {
			la.setText("입력값보다 작은 값을 입력하시오.");
			tf.setText("");
			tf.requestFocus();
		}
		else {
			int no=JOptionPane.showConfirmDialog(this,"정답입니다! \n종료할까요?","UpDownGame",
					JOptionPane.YES_NO_OPTION);
			if(no==JOptionPane.YES_OPTION) {
				System.exit(0);
			}
			else {
				tf.setText("");
				tf.setEnabled(false);
				b1.setEnabled(true);
				la.setText("");
			}
		}
	}
	// 버튼이나 텍스트 필드 처리 (엔터) => 고정 => 구현을 할 수 없어서 선언만 한다 abstract 
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2) { // b2번 버튼을 클릭했다면
			System.exit(0); // 종료
		}
		else if(e.getSource()==b1) {
			getRand(); // com에 난수 발생
			JOptionPane.showMessageDialog(this,"게임을 시작합니다!!");
			tf.setEnabled(true);
			tf.requestFocus();
			b1.setEnabled(false);
		}
		if(e.getSource()==tf) {
			String no=tf.getText(); // 입력값을 읽어온다
			//예외처리
			try {
				user=Integer.parseInt(no);
			}catch(Exception ex) {
				JOptionPane.showMessageDialog(this, "정수만 입력이 가능합니다!!");
				tf.setText("");
				tf.requestFocus();
				// 다시 처음부터 동작을 하게 만든다
				return;
			}
			// 비교
			compare();
		}
	}
}
