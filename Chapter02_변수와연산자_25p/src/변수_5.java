/*
 * 		byte , char , int, long , float , double 
 *      기타 : boolean
 *      
 *      1. 데이터형의 크기 
 *         byte < char < int < long < float < double
 *         //정수보다 실수가 더 크다 / 실수형이 정수형보다 크다 
 *         => 크기의 기준 : 수 표현의 갯수 / byte크기 기준이 아님
 *         
 *         int a=10L ==> X
 *         ---- ---
 *          4    8
 *        //왼쪽이 숫자가 같거나 더 커야 함 
 *        
 *        long  a=10; ==> O
 *        ---- ------
 *       8byte  4byte
 *       
 *       *크기를 알고 있을 것
 *       
 *    int a='A' => o
 *           65로 계산하고 들어감
 *           
 */
public class 변수_5 {

	public static void main(String[] args) {
		// 자동형변환!! 데이터는 언제나 자동형변환이 가능하다, 강제 형변환도 가능 ex) (int)'A' 괄호치고 데이터만 쓰면 됨
		//업캐스팅, 다운캐스팅이 있음 크기 기준으로 
		int a='A'; //char가 정수int로 바뀜 , 대입연산자 = 가 들어갔기 때문에 수로 바뀜 
		System.out.println(a);
		char c=65; // A로 들어간 것 
		double d='A'; //char가 double보다 작기 때문에 들어갈 수 있음, double은 가장 커서 다 받아들일 수 있음
		System.out.println(d);
		System.out.println(c);
		
		
		byte b1=10;
		byte b2=110;
		byte b3=(byte)(b1+b2); //byte b3=b1+b2; 왜 계산 오류일까? byte로 변경하지 않았기 때문
		//byte + byte = int
		//char + char = int //결과값이 더 큰 데이터 쪽으로 나온다 
		
		//형변환 : 데이터 변환 
	}

}
