// char 리턴 ==> 알파벳을 전송 => 대문자 => 소문자 , 소문자 => 대문자 
public class 메소드_07 {
	static char upper(char c) {
		return (char)(c-32); // 'a' => 'A'
		//                      97      65 => '32'차이 
	}
	static char lower(char c) {
		return (char)(c+32); // 결과값 1개 
		// 따로따로 처리 
	}
	static char upperLower(char c) {
		char res=' '; // 결과값이 여러 개 있는 경우 => 변수 선언 하고 시작 
		if(c>='A' && c<='Z')
			res=(char)(c+32);
		else
			res=(char)(c-32);
		return res;
		// 통합 처리 
	}
	public static void main(String[] args) {
//		char c=upper('m');
//		System.out.println(c);
//		c=lower('M');
//		System.out.println(c);
		char c=upperLower('A');
		System.out.println(c);
		c=upperLower('a');
		System.out.println(c);
		// 메소드명 => 기능
		// 매개변수 => 리턴형
	}

}
