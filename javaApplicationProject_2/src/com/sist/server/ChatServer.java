package com.sist.server;
import java.util.*;
import java.io.*;
import java.lang.module.FindException;
import java.net.*;
import com.sist.commons.*;
import com.sist.dao.*;
public class ChatServer implements Runnable{
    /*
     *   1. 회원 관련 => Chatting 
     *   2. 나머지는 => Client에서 => Database
     */
	// 서버 가동 
	private ServerSocket ss;
	private final int PORT=7777;
	// 접속한 클라이언트 정보 
	private Vector<Client> waitVc=new Vector<Client>();
	// 데이터베이스 연동 
	private MemberDAO dao;
	// 서버가동은 시작과 동시에 처리 
	public ChatServer()
	{
		try
		{
			dao=MemberDAO.newInstance();
			ss=new ServerSocket(PORT);
			// 같은 컴퓨터에서는 서버는 한번만 실행해야 된다 ..
			System.out.println("Server Start...");
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	// 접속시에 처리 
	public void run()
	{
		try
		{
			while(true)
			{
			  Socket s=ss.accept(); // Socket은 클라이언트의 정보 => ip,port
			  System.out.println("client 접속");
			  Client client=new Client(s);// 정보 => 
			  client.start(); // 정보에 해당되는 클라이언트와 통신을 해라..
			}
		}catch(Exception ex){}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ChatServer server=new ChatServer();
        new Thread(server).start();
	}
	// 통신 담당 => 클라이언트 1개당 한개씩 연결 => 동시에 프로그램이 작동 => 프로그램안에서 여러개의 프로그램을 동시 작업 => 쓰레드 
	// 같은 작업을 한다 => 통신 => 모든 클라이언트가 다르게 동작이 가능하다 => 웹 / 모바일 (웹 서버) 
	/*
	 *   웹 서버 : 송수신 
	 *     => 요청 / 응답 
	 *        --------- JSP 
	 */
	class Client extends Thread
	{
		// 한명하고 통신 
		// => IP를 받아서 연결 
		Socket s;
		// 전송 위치 
		OutputStream out; //out.write() => 클라이언트로 응답
		// 수신 위치 
		BufferedReader in; // in.readLine() => 클라이언트 요청을 받는다 
		// 기타 => 개인 정보 
		String id,name,sex,admin; // 관리자 / 일반사용자 => y/n
		
		// 초기화 
		public Client(Socket s)
		{
			try
			{
				this.s=s;
				in=new BufferedReader(new InputStreamReader(s.getInputStream()));
				out=s.getOutputStream();
				System.out.println("생성자 Call..");
			}catch(Exception ex){}
		}
		
		// 통신 
		public void run()
		{
			try
			{
				while(true)
				{
					String msg=in.readLine();// 요청값을 받는다 
					System.out.println("Client => "+msg);
					// 구분 => 요청? => Function
					// 구분자 전송 => Function.LOGIN => 문자열 => 보안 
					StringTokenizer st=new StringTokenizer(msg,"|");
					int delimit=Integer.parseInt(st.nextToken());
					// Function.LOGIN|id|pwd...
					switch(delimit)
					{
					   case Function.LOGIN:
					   {
						   // id => 데이터베이스 (정보읽기)
						   id=st.nextToken();
						   System.out.println("id="+id);
						   MemberVO vo=dao.memberInfo(id);
						   name=vo.getName();
						   sex=vo.getSex();
						   admin=vo.getAdmin();
						   System.out.println("name="+name);
						   // 1. 접속된 모든 회원에게 정보 전송 
						   messageAll(Function.LOGIN+"|"+id+"|"+name+"|"
								    +sex+"|"+admin);
						   // 2. 입장 메세지 전송 
						   messageAll(Function.CHAT+"|[알림 ▶]"+name+"님 입장하셨습니다!!|red");
						   // 3. 현재 접속자에게 => 이전에 접속한 회원의 정보를 전송 
						   
						   // 저장 
						   waitVc.add(this);
						   
						   // Login=>Home으로 변경 (창) 
						   messageTo(Function.MYLOG+"|"+id+"|"+name);
						   // 접속자 정보를 전송 
						   for(Client client:waitVc)
						   {
							   messageTo(Function.LOGIN+"|"+client.id+"|"+client.name+"|"
									    +client.sex+"|"+client.admin);
						   }
						   
					   }
					   break;
					   case Function.CHAT:
					   {
						   String message=st.nextToken();
						   String color=st.nextToken();
						   messageAll(Function.CHAT+"|["+name+"]"+message+"|"+color);
						   
						   
					   }
					   break;
					   case Function.INFO:
					   {
						   
					   }
					   break;
					   case Function.EXIT:
					   {
						   messageAll(Function.EXIT+"|"+id);
						   messageAll(Function.CHAT+"|[알림☞]"+name+"님 퇴장하셨습니다!|red");
						   // 남아 있는 회원 처리
						   // 실제 나가는 회원 처리
						   for(Client client : waitVc) {
							   // => Vector에서 제거
							   if(client.id.equals(id)) {
								   waitVc.remove(client);
								   // => 나가라는 메세지 전송
								   messageTo(Function.MYEXIT+"|");
								   // => in/out 종료
								   in.close();
								   out.close();
								   
								   break;
							   }
						   }
					   }
					}
				}
			}catch(Exception ex) {}
		}
		
		// 전체 메세지 (접근자 전체)
		public synchronized void messageAll(String msg)
		{
			try
			{
				for(Client client:waitVc)
				{
					client.messageTo(msg);
				}
			}catch(Exception ex) {}
		}
		// 접근자 한명에게 전송
		public synchronized void messageTo(String msg)
		{
			try
			{
				out.write((msg+"\n").getBytes());
			}catch(Exception ex) {}
		}
	}

}