
public class 문자열_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="ABCDEFG"; // 0부터 시작한다 
		System.out.println(msg.substring(2,6));
		System.out.println(msg); // 원본자체는 유지된다 // 재저장하면 유지되지 않고 변경된다 
		
		int a=10;
		int b=20;
		String s1=String.valueOf(a); // 모든데이터형을 문자형으로 변경 
		String s2=String.valueOf(b); // 정수 => 문자열로 변경
		// 윈도우, 웹 => 정수,실수,논리 => 데이터형이 없다 => 문자열 
		// 자바 => 원래 상태로 복귀 => 처리 

	}

}
