/*
 * 	학습 ==> 반복 
 * 	=> 형식 
 * 	=> 코딩 연습 
 *     => 안 되는 지점 찾기
 *     => 에러 처리
 *  => 라이브러리
 *  => 구글링 => 관련 큰 프로그램 찾기 
 *  ----------------------------
 *  
 */
import java.util.Scanner; // *은 모든 유틸 가져오는 것 , 대신 속도가 느리다 
public class 제어문_선택문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 계절 출력 , 12 1 2 => 겨울 , 
		System.out.print("달 입력:");
		int month=scan.nextInt();
		switch(month)
		{
		case 3: case 4: case 5: // if(month==3 || month==4 || month==5) 
			                    // if(month>=3 && month<=5)
			System.out.println("봄입니다.");
			break;
		case 6: case 7: case 8:
			System.out.println("여름입니다.");
			break;
		case 9: case 10: case 11:
			System.out.println("가을입니다.");
			break;
		case 12: case 1: case 2:
			System.out.println("겨울입니다.");
			break;
		default:
			System.out.println("없는 달입니다.");
		}

	}

}
