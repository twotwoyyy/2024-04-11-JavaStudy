// if~else
import java.util.Scanner;
import javax.swing.*;
public class 자바제어문_조건문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		String id=JOptionPane.showInputDialog("ID 입력:");
		String pwd=JOptionPane.showInputDialog("비밀번호 입력:");
		final String ID="admin";
		final String PWD="1234";
		
		if(ID.equals(id) && PWD.equals(pwd))
		{
			//로그인
			JOptionPane.showMessageDialog(null, id+"님 로그인되었습니다!\n 메인으로 이동합니다.");
		}
		else
		{
			//로그인 실패
			JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 틀립니다!!\n 다시 입력하세요.");
		}
		

	}

}
