package com.sist.client;

import javax.swing.*;

public class Login extends JFrame{
	public JLabel la1,la2;
	public JTextField tf;
	public JPasswordField pf;
	public JButton b1,b2;
public Login() {
		
		setTitle("로그인"); // 타이틀 바
		
		//초기화
		la1=new JLabel("아이디");
		la2=new JLabel("비밀번호");
		
		tf=new JTextField();
		pf=new JPasswordField();
		
		b1=new JButton("로그인");
		b2=new JButton("취소");
		
		//배치
		setLayout(null); // default=> BorderLayout // 직접 배치하는 것이 편함
		//아이디 배치
		la1.setBounds(30, 15, 80, 30);
		tf.setBounds(100, 15, 200, 30); //윈도우에 추가 => 90에서 여백 5 띄기 
		add(la1);
		add(tf);
		//비밀번호 배치
		la2.setBounds(30, 50, 80, 30);
		pf.setBounds(100, 50, 200, 30);
		add(la2);
		add(pf);
		// 아래 버튼 
		JPanel p=new JPanel();
		p.add(b1);p.add(b2); // 가운데 정렬
		p.setBounds(10, 90, 290, 35); // 2+4 = 값 +40
		add(p);
		
		
		setSize(350, 170); // 윈도우 크기 결정 
		setVisible(true); // 출력여부 true
	}
public static void main(String[] args) {
	// 생성자 호출

	new Login();
}
}
