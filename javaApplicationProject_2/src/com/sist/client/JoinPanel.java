package com.sist.client;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JoinPanel extends JPanel implements ActionListener{
	JLabel title, id, pw, pw2, name, gender, birth, post, addr1, addr2, phone, phoneD1, phoneD2, email, emailAt, content;
	JTextField idF, pwF, pw2F, nameF, birthF, postF, addr1F, addr2F, phoneF1, phoneF2, phoneF3, emailF;
	JRadioButton genderM, genderW;
	JComboBox emailCombo;
	JTextArea conT;
	JButton idCheck, postFind, join, cancel;
	String[] emailList= {"naver.com", "gmail.com", "daum.com"};
	//UtilDateModel model = new UtilDateModel();
	//JDatePanelImpl datePanel = new JDatePanelImpl(model);
	//JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
    private CardLayout cardLayout;
    private MenuPanel menup; // MenuPanel 객체 선언
    private ControlPanel cp; // ControlPanel 객체 선언
	public JoinPanel() {
		setLayout(null);
		
		title=new JLabel("회원가입",JLabel.CENTER);
		title.setFont(new Font("맑은 고딕",Font.BOLD,30));
		title.setBounds(10, 40, 940, 40);
		add(title);
		
		id=new JLabel("아이디");
		idF=new JTextField();
		idCheck=new JButton("아이디 중복체크");
		idF.setEditable(false);
		id.setBounds(230, 110, 80, 30);
		idF.setBounds(320, 110, 180, 30);
		idCheck.setBounds(520, 110, 120, 30);
		add(id);
		add(idF);
		add(idCheck);
		
		
		pw=new JLabel("비밀번호");
		pwF=new JTextField();
		pw.setBounds(230, 150, 80, 30);
		pwF.setBounds(320, 150, 180, 30);
		add(pw);
		add(pwF);
		pw2=new JLabel("비밀번호 확인");
		pw2F=new JTextField();
		pw2.setBounds(230, 190, 80, 30);
		pw2F.setBounds(320, 190, 180, 30);
		add(pw2);
		add(pw2F);
		
		name=new JLabel("이름");
		nameF=new JTextField();
		name.setBounds(230, 230, 80, 30);
		nameF.setBounds(320, 230, 180, 30);
		add(name);
		add(nameF);
		
		gender=new JLabel("성별");
		genderM=new JRadioButton("남자");
		genderW=new JRadioButton("여자");
		gender.setBounds(230, 270, 80, 30);
		genderM.setBounds(320, 270, 60, 30);
		genderW.setBounds(400, 270, 60, 30);
		add(gender);
		add(genderM);
		add(genderW);
		
		birth=new JLabel("생년월일");
		birthF=new JTextField();
		birth.setBounds(230, 310, 80, 30);
		birthF.setBounds(320, 310, 180, 30);
		//datePicker.setBounds(320, 310, 200, 80);
		add(birth);
		add(birthF);
		//add(datePicker);
		
		post=new JLabel("우편번호");
		postF=new JTextField();
		postFind=new JButton("우편번호 검색");
		post.setBounds(230, 350, 80, 30);
		postF.setBounds(320, 350, 180, 30);
		postFind.setBounds(510, 350, 100, 30);
		add(post);
		add(postF);
		add(postFind);
		
		addr1=new JLabel("주소");
		addr1F=new JTextField();
		addr1.setBounds(230, 390, 80, 30);
		addr1F.setBounds(320, 390, 400, 30);
		add(addr1);
		add(addr1F);
		addr2=new JLabel("상세주소");
		addr2F=new JTextField();
		addr2.setBounds(230, 430, 80, 30);
		addr2F.setBounds(320, 430, 400, 30);
		add(addr2);
		add(addr2F);
		
		phone=new JLabel("전화번호");
		phoneD1=new JLabel("-");
		phoneD2=new JLabel("-");
		phoneF1=new JTextField();
		phoneF2=new JTextField();
		phoneF3=new JTextField();
		phone.setBounds(230, 470, 80, 30);
		phoneF1.setBounds(320, 470, 80, 30);
		phoneD1.setBounds(408, 470, 5, 30);
		phoneF2.setBounds(420, 470, 80, 30);
		phoneD2.setBounds(508, 470, 5, 30);
		phoneF3.setBounds(520, 470, 80, 30);
		add(phone);
		add(phoneF1);
		add(phoneD1);
		add(phoneF2);
		add(phoneD2);
		add(phoneF3);
		
		email=new JLabel("이메일");
		emailF=new JTextField();
		emailAt=new JLabel("@");
		emailCombo=new JComboBox(emailList);
		email.setBounds(230, 510, 80, 30);
		emailF.setBounds(320, 510, 80, 30);
		emailAt.setBounds(403, 510, 15, 30);
		emailCombo.setBounds(420, 510, 100, 30);
		add(email);
		add(emailF);
		add(emailAt);
		add(emailCombo);
		
		content=new JLabel("회원가입 경로");
		conT=new JTextArea();
		content.setBounds(230, 550, 80, 30);
		conT.setBounds(320, 550, 400, 100);
		add(content);
		add(conT);
		
		join=new JButton("가입");
		cancel=new JButton("취소");
		JPanel btnP=new JPanel();
		btnP.add(join);
		btnP.add(cancel);
		btnP.setBounds(10, 660, 940, 35);
		add(btnP);
		cancel.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        // 이전 화면(로그인 화면)으로 돌아가기 위해 CardLayout 객체를 사용하여 로그인 화면을 보여줍니다.
		        CardLayout cardLayout = (CardLayout) getParent().getLayout();
		        cardLayout.show(getParent(), "LOGIN");
		    }
		});

    }
    public JoinPanel(CardLayout cardLayout, MenuPanel menup, ControlPanel cp) { // 생성자 수정
        this.cardLayout = cardLayout;
        this.menup = menup; // MenuPanel 객체 초기화
        this.cp = cp; // ControlPanel 객체 초기화
        setLayout(null);

        // 각종 컴포넌트들 생성 및 추가하는 코드

        // 메뉴 클릭 이벤트 처리
        // Home 메뉴 클릭 시
        menup.homeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cp, "HOME");
            }
        });

        // Find 메뉴 클릭 시
        menup.findBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cp, "FIND");
            }
        });

        // Board 메뉴 클릭 시
        menup.boardBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cp, "BOARD");
            }
        });

        // Chat 메뉴 클릭 시
        menup.chatBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cp, "CHAT");
            }
        });

        // News 메뉴 클릭 시
        menup.newsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cp, "NEWS");
            }
        });

        // Exit 메뉴 클릭 시
        menup.exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	JOptionPane.showMessageDialog(null, "프로그램을 종료합니다");
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // actionPerformed 메서드 내용
    }
}