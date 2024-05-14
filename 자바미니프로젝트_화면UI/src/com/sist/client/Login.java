package com.sist.client;
/*
 *	윈도우 (컨테이너)
 *   |
 *  = JFrame : 기본 윈도우 => 최소화/최대화/닫기
 *  = JWindow : 타이틀바가 없다 
 *  = JPanel => 단독 수행이 불가능 => JFrame, JWindow => 화면 변경 // 버튼 클릭하면 일부분만 화면 바꾼다 
 *  = JDialog => 검색어를 입력하세요 ..  (팝업창)
 *  컴포넌트
 *    |
 *   버튼
 *    => 메뉴 JMeny <ul>
 *    => 버튼 JButton, 라디오 버튼 : JRadio, 체크박스 : JCheckBox
 *       <input type=button>
 *       <input type=radio>
 *       <input type=checkbox>
 *       
 *   입력창
 *    => 한 줄 입력 : JTextField , JPasswordField
 *       <input type=text> <input type=password>
 *    => 여러 줄 입력 : JtextArea
 *                  <Jrextarea>
 *   라벨 => JLabel <label>
 *   테이블 => JTable <table>
 *   트리 => JTree
 *   
 *   배치
 *    = BorderLayout // 5군데 배치 
 *    = FlowLayout // 일자 배치 
 *    = GridLayout // 크기동일한 배치 
 *    = CardLayout
 *    = 사용자 정의 => 직접 배치 
 *    
 *    -----------------------------
 *    화면 만드는 법
 *    
 *    1. JFrame 상속
 *    2. 필요한 컴포넌트를 포함 
 *    3. 생성자
 *        초가화 => 배치
 *   //  McWinLookAndFeel  
 *   
 *   => 라벨 2개 
 *   => JTextField
 *   => JPasswordField
 *   => JButton 2
 */
import javax.swing.*; //윈도우 관련 // javafx
public class Login extends JFrame{
// 포함클래스로 멤버변수를 잡아준다
	/*
	 *	모든 멤버변수는 private가 아니다 => 라이브러리는 public으로 설정한다 
	 */
	public JLabel la1,la2;
	public JTextField tf;
	public JPasswordField pf;
	public JButton b1,b2;
	
	// 초기화 => 화면 배치 => 생성자 사용
	//                   ----- 다른 클래스와 연결 public
	
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
