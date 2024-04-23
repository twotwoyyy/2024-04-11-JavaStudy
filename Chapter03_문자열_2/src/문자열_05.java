
public class 문자열_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="hello";
		String s2="HELLO";
		
		if(s1.equalsIgnoreCase(s2)) //같은 경우 true 다른 경우 false
		{
			System.out.println("s1과 s2는 같다");
		}
		else
		{
			System.out.println("s1과 s2는 같지 않다");
		} // equals : 대소문자를 구분한다  // equalsIgnoreCase :대소문자 구별하지 않는다 
		  //        비밀번호                    아이디, 검색기
		
		String msg="Hello Java";
		for(int i=msg.length()-1;i>=0;i--) // 거꾸로 출력 
		{
			System.out.print(msg.charAt(i));
		} 
		System.out.println();
		for(int i=0;i<msg.length();i++) // length가 더 길기때문에 <=하면 안되고 <로 처리 
		{
			System.out.print(msg.charAt(i));
		} 
		// length() 문자갯수 => index=0부터 시작, length는 1부터 시작 => 그래서 -1을 해야한다 
	}

}
