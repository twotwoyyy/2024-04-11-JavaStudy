package com.sist.main;
import javax.swing.*;
public class 생성자활용 {
	//JFrame frame=new JFrame();
	//public 생성자활용() { // 리턴형이 없다 
		//frame.setSize(800,600);
		//frame.setVisible(true);
	//}
	JFrame frame;
	public 생성자활용(String title) { // 생성자는 매개변수 넣을 수도 있다 
		frame=new JFrame(title);
		frame.setSize(800,600);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new 생성자활용("music");
	}

}
