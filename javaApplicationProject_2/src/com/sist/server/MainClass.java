package com.sist.server;
class MyThread extends Thread {
	// Thread 사용시 run에서 동작 구현
	public void run() {
		try {
			for(int i=1;i<=10;i++) {
				System.out.println(i+":"+getName());
				Thread.sleep(200);
			}
			
		}catch(Exception ex) {}
	}
}

public class MainClass {
	
	public static void main(String[] args) {
	MyThread m1=new MyThread(); // Thread 0
	MyThread m2=new MyThread(); // Thread 1
	MyThread m3=new MyThread(); // Thread 2 프로그램 안에서 여러 개 프로그램 동시에 돌림 
	
	m1.start();
	m2.start();
	m3.start();
	
	}
}

