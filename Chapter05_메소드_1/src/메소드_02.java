// 리턴형(o) , 매개변수(o)
import java.util.*;
public class 메소드_02 {
	// 큰 데이터형으로 선언이 가능 
	static boolean isLogin(String id,String pwd) {
		//매개변수 여러 개 사용이 가능, 리턴형 1개만 사용
		//매개변수가 많은 경우 => 클래스, 배열 3개 이상 
		final String ID="admin";
		final String PWD="1234";
		/*
		 * 메소드 안에 선언된 변수, 상수 => 메소드 안에서만 사용 가능 
		 * ----------------------- 매개변수도 메소드 안에서만 사용 가능 
		 */
		boolean bCheck=false;
		if(id.equals(ID) && pwd.equals(PWD)) {
			bCheck=true;
		}
		else {
			bCheck=false;
		}
		
		return bCheck; // 사용자 요청에 대한 결과값 
	//  return에 사용하는 데이터형과 실제 전송하는 값이 일치해야 한다 
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("아이디 입력:");
		String id=scan.next();
		System.out.print("비밀번호 입력:");
		String pwd=scan.next();
		// 기능 요청
		// 메소드에서 넘겨주는 결과값을 받는다 
		boolean bCheck=isLogin(id,pwd);
		// 숫자인 경우에는 큰 데이터형을 받을 수 있다, 대부분은 일치해야한다 
		// 예) int(리턴형) => long / double로 받을 수 있다
		// 기능 처리 => 윈도우, 브라우저에서 출력 
		if(bCheck) {
			System.out.println(id+"님 로그인 되었습니다.");
		}
		else {
			System.out.println("아이디나 비밀번호가 틀립니다!!");
		}
	}

}
