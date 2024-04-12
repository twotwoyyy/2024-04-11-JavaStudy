
public class 변수_6 {

	public static void main(String[] args) {
		byte byte_value=10; //뒤에 value붙이기 //byte는 구분이 없다=> -128~127사이의 정수만 대입할 경우 
		//byteValue 언더바나 대문자 쓰기
		int intValue=20; // 컴퓨터에서는 모든 숫자를 int로 인식한다 (21억 4천)
		// 4byte 숫자 
		long longValue=30L; // 구분 => 숫자 뒤에 L,1
		// 8byte 숫자 
		float floatValue=10.5F; // float는 F붙여야 함 // 4byte => 소수점 6자리까지 계산
		double doubleValue=10.5; // 10.5D 10.5d => D나 d는 생략이 가능// 실수의 디폴트
		// 정수 => int , 실수 => double
		// 실제 프로그램에서는 int , double이 가장 많이 사용된다 
		// 변수 => 계속 상태가 변경되는 경우에 사용 // 상수 => 고정, 변경이 안 됨
		boolean booleanValue=true;
		// => 조건식 1byte => 저장은 true/false만 저장이 가능
		char charVlaue='A';
		// => 문자 1개 저장 공간 => 2byte (0~65535)
		/*
		 * 		byte = **char = int = long = double
		 * 		boolean   |
		 *              String
		 *              
		 *              된장국 끓이는 법
		 */
		char c1='된';
		char c2='장';
		char c3='국';
		char c4=' ';
		char c5='끓';
		char c6='이';
		char c7='는';
		char c8=' ';
		char c9='법';
		
		System.out.println(c1+""+c2+c3+c4+c5+c6+c7+c8+c9); //""라는 문자를 꼭 넣어야 함 , 문자를 빼면 더하면 숫자로 계산됨 , 중간에 문자를 꼭 붙여야 함 
		
		String s="된장국 끓이는 법";
		System.out.println(s); //char이 번거롭기 때문에 요즘은 String만 쓴다
		
	}

}
