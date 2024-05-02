// 매개변수의 전송 
// => 메소드 안의 변수는 메소드가 종료가 되면 => 자동으로 사라진다 => 다른 메소드로 값을 전송 
import java.util.*;
/*
 *	메소드의 연결
 *	---------
 *	숫자 야구 게임 => 분리 (5개의 기능)
 *	1) 3개의 중복없는 난수 발생 
 *	2) 사용자로부터 3개 정수 입력 받음 
 *	3) 난수와 사용자 입력값 비교 
 *	4) 힌트 제공 
 *	5) 종료 여부 확인 ==> 다시 게임을 할지 물어본다
 */
public class 메소드정리_04 {

	public static void main(String[] args) {
		// 절차적 언어 => '다시 게임을 할지 물어본다' 불가능 => 재사용이 안된다 
		// 3개의 중복없는 난수 발생
		int[] com=new int[3];
		for(int i=0; i<com.length; i++) {
			com[i]=(int)(Math.random()*9)+1; // 1~9 사이 정수 => 중복 없이
			// 중복 체크
			for(int j=0; j<i ; j++) {
				if(com[i]==com[j]) {
					i--; // 다시 발생 (원상복귀) => 감소했다 증가하니까 재위치
					break;
				}
			}
		}
		//System.out.println(Arrays.toString(com));
		//사용자 입력 => 정답 입력이 되는 상태까지 => while
		//사용자 입력값 저장 
		int[] user=new int[3];
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.print("세 자리 정수 입력:");
			int input=scan.nextInt();
			//오류 처리
			if(input<100 || input>999) {
				// || => 범위 벗어난 경우
				System.out.println("세 자리 정수만 입력할 수 있습니다!!");
				//처음상태로 돌아간다
				continue;
			}
			user[0]=input/100; // 첫 번째 자리수
			user[1]=(input%100)/10; // 두 번째 자리수
			user[2]=input%10; // 세 번째 자리수
			// 오류 처리
			if(user[0]==user[1] || user[1]==user[2] || user[0]==user[2]) {
				System.out.println("같은 수는 사용할 수 없습니다!!");
				continue;
			}
			if(user[0]==0 ||user[1]==0 || user[2]==0) {
				System.out.println("0은 사용할 수 없습니다!!");
				continue;
			}
			
			//비교
			int s=0, b=0; // 같은 자리 s, 다른 자리 b
			for(int i=0;i<com.length;i++) {
				for(int j=0; j<user.length; j++) {
					// i=0 => j=0,1,2
					// i=1 => j=0,1,2
					// i=2 => j=0,1,2
					if(com[i]==user[j]) { // 같은 수가 있는지
						if(i==j) // 같은 자리냐
							s++;
						else
							b++; //같은 수는 있지만 다른 자리
					}
				}
			}
			//힌트
			System.out.printf("Input Number:%d,Result:%dS-%dB\n",
					input,s,b);
			//종료 여부 확인
			if(s==3) {
				System.out.println("Game over!!");
				break;
			}
		}
	}

}
