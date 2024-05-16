package com.sist.main3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/*
 * abstract class A
 * abstract class B
 * abstract class C
 * class D extends A,B,C => 오류
 * 
 * abstract class A
 * abstract class B extends A
 * abstract class C extends B
 * class D extends C // 하나씩 받아서 와야한다 다중상속이 안되기 때문에,
 * => 따라서 인터페이스 (다중 상속이 가능한 클래스) 이용한다 
 * 
 * 
 */
public class MainClass2 extends JFrame implements MovieListner,KeyListener,Runnable{
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
