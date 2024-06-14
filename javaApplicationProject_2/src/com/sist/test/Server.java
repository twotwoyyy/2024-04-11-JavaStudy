package com.sist.test;
import java.util.*;
import java.io.*;
import java.net.*;

import com.sist.commons.Function;
import com.sist.dao.*;
public class Server implements Runnable{
	private ServerSocket ss;
	// PORT 번호 => 0~65535 => 0~1023
	private final int PORT=7777;
	private MemberDAO dao;
	// 저장 공간 (접속자)
	private Vector<Client>  waitVc=new Vector<Client>();
	public Server() {
		//생성자 => 시작과 동시에 서버 구동 시켜야 하기 때문에 
		try {
			ss=new ServerSocket(PORT);
			dao=MemberDAO.newInstance(); // 객체 생성 : 데이터베이스 
			System.out.println("Server Start...");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void run() { // 접속시에 접속자 정보 저장!! => 접속자마다 따로 프로그램이 돌아가게 한다 => Thread 
		// run은 꼭 start를 거쳐 호출해야 한다 
		//접속시에 처리
		while(true) {
			try {
				Socket s=ss.accept(); //접속이 된 경우에만 호출하게 만든다 
				// s: 클라이언트 정보 => 발신자 정보 IP,PORT
				Client client=new Client(s);
				// 통신을 시작하라
				client.start();
			}catch(Exception ex) {
				
			}
		}
	}

	public static void main(String[] args) {
		Server server=new Server();
		new Thread(server).start(); //run() 호출하는 것 
	}
	/*
	 *   클래스의 종류 
	 *    = 추상 클래스
	 *    = 보완 => 인터페이스 
	 *    = 내부 클래스 
	 *      -------- 클래스 메모리 할당 없이 접근이 모든 변수/메소드 접근 가능 
	 *      1) 멤버 클래스 : 네트워크, 쓰레드 ... 
	 *         class A{
	 *           데이터
	 *           class B{
	 *             A가 가지고 있는 모든 데이터를 공유 
	 *           }
	 *         }
	 *      2) 익명의 클래스 : 스프링, 데이터 분석 
	 *         => 상속 없이 오버라이딩 가능하게 만든다 => 생성자에서 메소드 변경, 메소드 추가 
	 */
	class Client extends Thread { // 따로 통신을 하게 해준다 
		Socket s; // 클라이언트와 통신하는 통신기기 
		OutputStream out; // 클라이언트에게 전송할 수 있게 함
		BufferedReader in; // 클라이언트로부터 요청값 받기
		// 개인정보 
		String id, name, sex, pos, admin; // name제외 DB에서 가져오기
		public Client(Socket s) {
			try {
				this.s=s;
				out=s.getOutputStream();
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				// 네트워크 전송 => byte가 1byte 단위로 전송
				// 서버에서 값을 받는 경우는 2byte로 받아야 한글이 깨지지 않는다 
				// 1byte를 => 2byte로 전송(변경)해주는 클래스 : 필터스트림 
				// 필터스트림 => InputStreamReader
			}catch(Exception ex) {}
		}
		// 통신을 시작한다
		public void run() {// 클라이언트마다 따로 따로 동작
			while(true) {
				
			try {
				// 클라이언트에게 요청값 받기
				String msg=in.readLine();
				StringTokenizer st=new StringTokenizer(msg,"|");
				//100 |id| pwd
				int protocol=Integer.parseInt(st.nextToken());
				switch(protocol){
				// 로그인 요청
				case Function.LOGIN:{
					// ID를 받는 경우
					id=st.nextToken();
					// 정보 얻기
					MemberVO vo=dao.memberInfo(id);
					name=vo.getName();
					sex=vo.getSex();
					pos="대기실";
					admin=vo.getAdmin();
				
					// 이미 접속된 회원에게 현재 접속자 정보 전송
					messageAll(Function.LOGIN+"|"+
					id+"|"+name+"|"+sex+"|"+pos+"|"+admin); // 단체 
					messageAll(Function.CHAT+"|[☞ 알림]"+name+"님이 입장하셨습니다");
					// 서버에 저장 
					waitVc.add(this); // 본인 정보 저장
					// 1. 창 갱신
					messageTo(Function.MYLOG+"|"+id+"|"+name); // 개인// Login창에서 WaitRoom으로 바꾸어라 
					// 2. 현재 접속 회원의 모든 정보 받는다
					for(Client client:waitVc) {
						messageTo(Function.LOGIN+"|"
								+client.id+"|"
								+client.name+"|"
								+client.sex+"|"
								+client.pos+"|"
								+client.admin);
					}
					// 3. 개설된 방 정보 제공 
				}
				break;
				// 나가기 요청
				case Function.EXIT:{
					
				}
				break;
				// 채팅 요청 
				case Function.CHAT:{
					String message=st.nextToken();
					messageTo(Function.CHAT+"|["
							+name+"]"+message); // 채팅창 
				}
				break;
				}
			}catch(Exception ex) {}
			}
		}
		// 접속자 전체로 전송
		public synchronized void messageAll(String msg) {
			// synchronized : 동기화 (한명씩 보내기) 동시하면 오류 생길 우려 

			}
		}
		// 접속자에게만 전송 
		public synchronized void messageTo(String msg) {
			try {
			
			}catch(Exception ex) {}
		
	}
}