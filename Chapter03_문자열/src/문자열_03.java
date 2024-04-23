/*
 * 
 */
public class 문자열_03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String msg="Hello Java";
		System.out.println(msg.replace("a","b"));
		msg="홍길동 hong gil dong";
		System.out.println(msg.replaceAll("[가-힣]","")); // 한번에 지우기 
		// 한글 => [가-힣] 한글 한번에 지우기 
		// 알파벳 => [A-Z]/ [a-z] / [A-Za-z] 대소문자 전부 지우기
		// 숫자 => [0-9] => 크롤링 

	}

}
