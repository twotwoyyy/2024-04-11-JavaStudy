package com.sist.server;
import java.util.*;
import java.io.*;
import java.net.*;
import com.sist.dao.*;
public class Server implements Runnable{
	private ServerSocket ss;
	private final int PORT=7777;
	private Vector<Client> waitVc=new Vector<Client>();
	public Server() {
		try {
			ss=new ServerSocket(PORT);
			System.out.println("서버를 시작합니다..");
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	public void run() {
		try {
			while(true) {
				Socket s=ss.accept();
				System.out.println("접속 IP:"+s.getInetAddress().getHostAddress());
				System.out.println("포트번호:"+s.getPort());
				OutputStream out=s.getOutputStream();
				out.write("서버에 접속되었습니다^.^~!!\n".getBytes());
				Client client=new Client(s);
				waitVc.add(client);
				client.start();
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		Server server=new Server();
		new Thread(server).start();
	}
	class Client extends Thread{
		String id;
		Socket s;
		OutputStream out; // 클라이언트 전송
		BufferedReader in; // 클라이언트 요청 받기 
		public Client(Socket s) {
			try {
				this.s=s;
				out=s.getOutputStream();
						in=new BufferedReader(new InputStreamReader(s.getInputStream()));
			}catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		// 통신 역할 
		public void run() {
			try {
				while(true) {
					//1.클라이언트 요청을 받는다
					String msg=in.readLine(); //채팅 문자열을 보내면
					System.out.println("Client=>"+msg);
					//2.서버에서 응답
	
					for(Client client:waitVc) { //모든 접속자가 받음
						client.out.write((msg+"\n").getBytes());
					}
				}
			}catch(Exception ex){}
		}
	}
}