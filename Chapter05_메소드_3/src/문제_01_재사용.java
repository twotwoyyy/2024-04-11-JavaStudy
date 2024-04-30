
public class 문제_01_재사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num=메소드_문제_01.input();
		//num=>  이진법 제작 메소드로 전송
		int[] binary=메소드_문제_01.binaryCheck(num);
		// binary[]를 넘겨준다 => 출력 요청
		메소드_문제_01.print(binary);
	}

}
