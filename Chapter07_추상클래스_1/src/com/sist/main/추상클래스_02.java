package com.sist.main;
// 이미 => 처리 메소드명은 알고 있다 
abstract class Button{
	public abstract void click();
}
class Login extends Button{ // 버튼이 공통 기반 => 선언 => 구현 내용이 다르기 때문에 

	@Override
	public void click() {
	System.out.println("로그인 요청...");	
	}	
}
class Join extends Button{

	@Override
	public void click() {
	System.out.println("회원가입 요청..");
	}
}
// 결합성이 낮게 만들 수 있다 
public class 추상클래스_02 {
	public static void main(String[] args) {
	Button btn=new Login();
	btn.click();
	btn=new Join();
	btn.click();
	}
}

