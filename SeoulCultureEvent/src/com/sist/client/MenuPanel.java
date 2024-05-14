package com.sist.client;
import java.awt.GridLayout;
import javax.swing.*;
public class MenuPanel extends JPanel{
	public JButton b1,b2,b3,b4,b5,b6;
	
	public MenuPanel() {
		setLayout(new GridLayout(1,5,6,6)); // Grid => 같은 크기의 버튼 생성 
		//                           --- 메뉴마다의 간격 띄기 
		b1=new JButton("홈"); // 목록, 상세보기 
		b2=new JButton("검색"); // 검색, 상세보기 
		b3=new JButton("뉴스");// 채팅, 쪽지보내기 
		b4=new JButton("행사 후기"); // 목록, 상세보기, 수정, 추가, 삭제 
		b5=new JButton("채팅"); // 뉴스 검색창
		b6=new JButton("나가기");
		// 메뉴 배치 추가
		add(b1);add(b2);add(b3);add(b4);add(b5);add(b6); // 추가 순서대로 배치
	}
}
