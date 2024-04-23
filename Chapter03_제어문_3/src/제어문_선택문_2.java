
public class 제어문_선택문_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com=(int)(Math.random()*3); // 0 1 2 고정할 경우 default 걸 필요가 없음
		// 정수 => 상수 
		// 순서는 상관없다 ==> 분석, 추가 => 순차적으로 서술한다 
		switch(com) // 정수
		{
		case 0:
			System.out.println("가위");
			break;
		case 1:
			System.out.println("바위");
			break;
		case 2:
			System.out.println("보");
		// default 생략 가능, 다른 숫자가 나올 일이 없기 때문에
		}
	}

}
