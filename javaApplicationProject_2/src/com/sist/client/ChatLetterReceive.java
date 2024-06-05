package com.sist.client;
import javax.swing.*;
public class ChatLetterReceive extends JFrame{
	public JLabel from;
	public JTextField fromName;
	public JTextArea letterContent;
	public JButton send, cancel;
		
	public ChatLetterReceive() {
		setTitle("쪽지");
		
		from=new JLabel("보낸 사람");
		fromName=new JTextField();
		letterContent=new JTextArea();
		send=new JButton("답장");
		cancel=new JButton("취소");
		
		setLayout(null);
		
		from.setBounds(20, 20, 80, 30);
		fromName.setBounds(90, 20, 150, 30);
		add(from);
		add(fromName);
		
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
		new ChatLetterReceive();
	}
}