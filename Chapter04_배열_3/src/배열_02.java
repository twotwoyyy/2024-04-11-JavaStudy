/*
 *	문자 10개 저장
 *	=> 출력
 *		HELLO
 *	=> 반대 출력
 *		OLLEH
 *	=> sort => 이차 for => 정렬 
 */
public class 배열_02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] alpha=new char[10];
		for(int i=0;i<alpha.length;i++)
		{
			alpha[i]=(char)((Math.random()*26)+65); // 정수를 char로 변환해야하기때문에 괄호 
		}
		// 출력 => for-each : 출력 중심 => 웹 => 배열 / (컬렉션=12장)
		/*
		 *	for(데이터형 변수:배열명)
		 *		-----     ---- 둘의 데이터형이 일치해야 한다 / 혹은 데이터형 변수가 데이터형이 더 클 수 있음 
		 *	** for-each는 인덱스를 이용하는 것이 아니라 실제 배열에 저장된 값을 읽어온다 
		 *  * 단점 : 관련된 다른 배열의 값을 출력할 수 없다, 뒤에서부터 출력도 안된다 (index번호 이용해야 하기때문)
		 *
		 *  String[] name={"","","","",""}
		 *  String[] sexs={"","","","",""}
		 *  
		 *   이름(성별)
		 *   for(String name:names) > 두개 동시에 제어할 수 없음 => 일반 for 이용해야 한다
		 *   
		 */
		for(char c:alpha)
		{
			System.out.print(c+" ");
		}
		System.out.println("\n---------반대로 출력(인덱스 번호 이용)");
		for(int i=alpha.length-1;i>=0;i--)
		{
			System.out.print(alpha[i]+" ");
		}
	}

}
