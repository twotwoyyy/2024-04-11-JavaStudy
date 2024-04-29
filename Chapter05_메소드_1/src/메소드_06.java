// => 3개의 중복이 없는 난수 발생 
// => 출력 

import java.util.Arrays;
	// 나중에 필요 => 묶어서 사용 => 사용자 정의 라이브러리 
public class 메소드_06 {
	static void rand(int num) {
		int[] com=new int[num];
		for(int i=0;i<com.length;i++) {
			com[i]=(int)(Math.random()*100)+1;
			for(int j=0;j<i;j++) {
				if(com[i]==com[j]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(com));
	}
	public static void main(String[] args) {
		rand(6); // 매개변수를 받아 처리=> 필요한 개수만큼 넣으면 된다 
	}

}
