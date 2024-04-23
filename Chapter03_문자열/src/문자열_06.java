
public class 문자열_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String alpha="ABCDEFGHIJ";
		//            0123456789
		// 1. => C~J까지 출력
		System.out.println(alpha.substring(2));
		// 2. => EFG 출력
		System.out.println(alpha.substring(4,7));
		
		String id=" admin ";
		System.out.println(id+"의 문자 갯수:"+id.length());
		// 공백도 문자로 취급 " " => space 문자 
		id=id.trim(); // 좌우 공백 지우기
		System.out.println(id+"의 문자 갯수:"+id.length());
		// trim()=> 좌우 공백 지우기 /검색, 입력 
		
		String msg="Hello Java";
		//          0123456789
		System.out.println(msg.indexOf("a")); //indexOf는 가장 첫번째 나타나는 a값의 순서 
		System.out.println(msg.lastIndexOf("a")); //lastIndexOf는 뒤에서 첫번째 나타나는 a값의 순서
		
		String ext="He.llo.java";
		System.out.println(ext.substring(ext.lastIndexOf(".")+1)); // .제외 다음문자부터 출력 
		
		/*
		 * 	데이터형
		 * 		정수: 정수만 저장 => int/long
		 * 		실수: 실수만 저장 => double
		 * 		문자: 문자 1개 저장 => char
		 * 		논리: true/false => boolean
		 * 		문자열: 문자 여러개를 동시에 저장 => String , 기능을 가지고 있다
		 * 								   -----------------------
		 * 								   | 문자열을 제어하는 기능을 제공 
		 * 
		 */
		int a=Integer.parseInt("100"); // 문자열을 (int)로 형변환 x 따라서 이렇게 해야 한다 
	}

}
