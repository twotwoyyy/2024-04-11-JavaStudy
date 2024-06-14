package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
import com.sist.dao.*;
/*
 *    Server 
 *      1. 접속을 받는 클래스 => 접속을 받아서 클라이언트 정보 저장 
 *                                    ------------- IP, PORT (연결)
 *                                    ----------------------------
 *                                       IP: 전화번호, PORT: 전화선 
 *                                    ---------------------------- 전화기 => 소켓 
 *      2. 접속된 클라이언트마다 통신 담당 클래스 
 *         --------------- 따로 제작 => 한번에 제작 여러 개가 동시에 수행 => 쓰레드 
 *      => 자바 : 두 개 쓰레드 => 시분할 (시간을 나눠서 처리) 
 *               main / gc 
 */
public class Server implements Runnable{ 
	// 접속 담당 => 교환 소켓
	/*
	 * 1. ServerSokcet을 생성 
	 *    ------------
	 *     bind ==> 연결 => 전화기 개통 
	 *                    --------- 전화 / 전화선 매칭 => 유심 
	 *                    bind(IP, port) 
	 *     listen => 대기 상태
	 * 2. 대기 중에 클라이언트 접속 
	 *    ------------------
	 *    accept() => 이 메소드가 호출되면 사용자 정보 수집 => 메모리에 저장 
	 *                               -------- 
	 *                               | Thread 매칭 후에 통신 
	 * 3. 종료 요청시에는 Tread 종료 
	 */
	/*
	 * 결정 : 서버 컴퓨터, 연결선 (숫자 지정) => 0~65535 중에 사용(0~1023은 이미 사용중) 
	 *                                  21 : FTP 파일 전송 프로토콜
	 *                                  23 : TELNET 
	 *                                  25 : SMTP 메일 전송 
	 *                                  80 : 웹 (브라우저 연결)
	 *                                  8080 : 프록시 서버
	 *                                  1521 : 오라클 서버 
	 *                                  1433 : MSSQL
	 *                                  4000 : 머드 서버 
	 *                                  3306 : MYSQL / MariaDB
	 */
	private ServerSocket ss; // 접속을 받는 클래스
	private final int PORT=7777;
	// 클라이언트의 정보 저장 => IP, PORT, id, name, sex
	//                              --- => 나머지는 오라클에서 정보 가져온다 
	// 동기화 Vector 이용해야 한다
	private Vector<Client> waitVc=new Vector<Client>(); // 저장하는 공간 
	public Server() {
		try {
			ss=new ServerSocket(PORT); // 개통 (PORT,숫자) < 숫자만큼 접속 가능하게 늘릴 수 있다 
			System.out.println("Server start ...");
			// 클라이언트 접속을 대기 ... 
			// 50명까지만 접속이 가능 
			// TomCat => Web Server (50명)
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 접속 시에 클라이언트 정보 확인 => 정보 저장 
	// Thread가 동작하는 메소드 => run 메소드 
	public void run() {
		try {
			while(true) {
				// 접속이 된 경우
				Socket s=ss.accept(); // 접속이 되면 접속자의 IP를 받아서 저장
				// Socket (전화기 역할) => 클라이언트 정보가 들어가 있다 (IP,PORT)
				/*
				 * 서버 : ServerSocket => PORT : 고정 
				 * 클라이언트 : Socket => PORT : 자동 설정 (자동 세팅) 
				 * 
				 */
//				System.out.println("접속 IP :"+s.getInetAddress().getHostAddress());
//				System.out.println("포트번호 "+s.getPort());
//				OutputStream out=s.getOutputStream(); // 클라이언트에게 값을 보내겠다
//				// s : 클라이언트 
//				out.write("서버에 접속되었습니다!!^0^\n".getBytes());
				Client client=new Client(s);
				waitVc.add(client); // 정보 저장
				client.start(); // 클라이언트와 통신을 시작하라 ...
			}
		}catch(Exception ex){

		}
	}
	public static void main(String[] args) {
		Server server=new Server();
		new Thread(server).start();
		
	}
	// 통신 담당 
	// 프로그램 안에서 여러 개의 프로그램을 동시 수행 => 프로세스 => 여러 개 쓰레드가 동시에 수행 
	// 내부 클래스 (클래스 안 클래스) => Server가 가지고 있는 모든 데이터, 메소드, 변수 마음대로 사용 가능 
	// => 한 개의 컴퓨터에서 Server는 1개만 동작이 가능 
	// => Server 프로그램은 고정 IP를 가지고 있어야 한다 
	class Client extends Thread{
		String id;
		Socket s;
		OutputStream out; // 클라이언트 전송 (받아서 전송) 
		BufferedReader in; // 클라이언트 요청 받기
		public Client(Socket s) {
			try {
				this.s=s;
				out=s.getOutputStream(); // 클라이언트에게 보내겠다 클라이언트 s
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			}catch(Exception ex) {}
		}
		// 총신 역할
		public void run() {
			try {
				while(true) {
					// 1. 클라이언트 요청을 받아온다
					String msg=in.readLine();
					System.out.println("Client=>"+msg);
					// 2. 서버에서 응답 
					for(Client client:waitVc) {//접속한 모든 사람에게 보낸걸 다시 보내라 
						client.out.write((msg+"\n").getBytes()); // 문자열을 다시 전체적으로 한번 더 보내준다 
//						out.write((msg+"\n").getBytes()); // 나에게만 
					}
				}
			}catch(Exception ex) {}
		}
	}
}
