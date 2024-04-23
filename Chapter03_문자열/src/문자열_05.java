//모과:quince
public class 문자열_05 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String f="모과:quince";
		System.out.println("모과의 영어는?");
		System.out.println("영어는 "+f.substring(f.indexOf(":")+1));//클론위치다음부터니까 +1
		
		/*
		 * substring : 문자열을 자르는 경우에 사용
		 * Hello Java
		 * 0123456789
		 * substring(6) => Java
		 * substring(3,8) => lo ja
		 * substring(int startIndex)
		 * substring(int startIndex,int endIndex)
		 * 							=> endIndex-1 // 따라서 1개가 더 많아야 함 
		 *  
		 */
		String msg="Hello Java";
		System.out.println(msg.substring(3,8)+"...");// 3~7까지 가져오고 싶으면 endIndex에서 +1 해야함 
	}

}
