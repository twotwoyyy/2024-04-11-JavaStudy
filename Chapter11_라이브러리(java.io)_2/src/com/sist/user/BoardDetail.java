package com.sist.user;
import java.awt.Font;

// detail.jsp
import javax.swing.*;
public class BoardDetail extends JPanel{
     JLabel titleLa,nameLa,noLa,subLa,dayLa,hitLa;
     JLabel name,no,sub,day,hit;
     JTextArea ta;
     JButton b1,b2,b3; // 수정 / 삭제 / 목록 
     // nextJs , MSA , DevOps , CI/CD , Docker , 쿠바네티스 , 잰킨스 
     // JavaScript => TypeScript
     public  BoardDetail()
     {
    	 titleLa=new JLabel("게시판",JLabel.CENTER);// <table>
     	 titleLa.setFont(new Font("맑은 고딕",Font.BOLD,30)); //<h3></h3>
     	 setLayout(null);
    	 titleLa.setBounds(10, 15, 620, 50);
    	 add(titleLa);
    	 
    	 noLa=new JLabel("번호",JLabel.CENTER);
    	 noLa.setBounds(10, 75 , 80, 30);
    	 no=new JLabel("",JLabel.CENTER);
    	 no.setBounds(95, 75, 120, 30);
    	 add(noLa);add(no);
    	 
    	 dayLa=new JLabel("작성일",JLabel.CENTER);
    	 dayLa.setBounds(220, 75 , 80, 30);
    	 day=new JLabel("",JLabel.CENTER);
    	 day.setBounds(305, 75, 200, 30);
    	 add(dayLa);add(day);
    	 
    	 nameLa=new JLabel("이름",JLabel.CENTER);
    	 nameLa.setBounds(10, 110 , 80, 30);
    	 name=new JLabel("",JLabel.CENTER);
    	 name.setBounds(95, 110, 120, 30);
    	 add(nameLa);add(name);
    	 
    	 hitLa=new JLabel("조회수",JLabel.CENTER);
    	 hitLa.setBounds(220, 110 , 80, 30);
    	 hit=new JLabel("",JLabel.CENTER);
    	 hit.setBounds(305, 110, 200, 30);
    	 add(hitLa);add(hit);
    	 
    	 subLa=new JLabel("제목",JLabel.CENTER);
    	 subLa.setBounds(10, 145 , 80, 30);
    	 sub=new JLabel("");
    	 sub.setBounds(95, 145, 400, 30);
    	 add(subLa);add(sub);
    	 
    	 ta=new JTextArea();
    	 ta.setEditable(false); // 비활성화 
    	 ta.setBounds(10, 180, 485, 250);
    	 add(ta);
    	 
    	 JPanel p=new JPanel();
    	 b1=new JButton("수정");
    	 b2=new JButton("삭제");
    	 b3=new JButton("목록");
    	 p.add(b1);p.add(b2);p.add(b3);
    	 p.setBounds(10, 440, 485, 35);
    	 add(p);
     }
}