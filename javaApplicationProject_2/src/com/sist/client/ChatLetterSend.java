package com.sist.client;
import javax.swing.*;
public class ChatLetterSend extends JFrame{
	public JLabel dear;
	public JTextField inputDear;
	public JTextArea letterContent;
	public JButton send, cancel;
		
	public ChatLetterSend() {
		setTitle("쪽지");
		
		dear=new JLabel("받는 사람");
		inputDear=new JTextField();
		letterContent=new JTextArea();
		send=new JButton("전송");
		cancel=new JButton("취소");
		
		setLayout(null);
		
		dear.setBounds(20, 20, 80, 30);
		inputDear.setBounds(90, 20, 150, 30);
		add(dear);
		add(inputDear);
		
		letterContent.setBounds(20, 60, 260, 200);
		add(letterContent);
		
		JPanel btn=new JPanel();
		btn.add(send);
		btn.add(cancel);
		btn.setBounds(20, 265, 260, 30);
		add(btn);
		
		setSize(300, 330);
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 
		
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
		}catch(Exception ex) {}
		new ChatLetterSend();
	}
}