//=> 리턴형 x, 매개변수 o
//   ------- 메소드 자체에서 출력
// 단 입력을 받아서 해당 단을 출력
import java.util.*;
public class 메소드_04 {
	// void 결과값이 없다는 뜻 
	static void gugudan(int dan) {
		for(int i=1;i<=9;i++) {
			System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		}
	}
	public static void main(String[] args) {
//		gugudan(2); // 반복 제어 => 구조적 프로그램 (단락 나누기) 
//		System.out.println("===========");
//		gugudan(3);
//		System.out.println("===========");
//		gugudan(4);
//		System.out.println("===========");
//		gugudan(5);
//		System.out.println("===========");
		for(int i=2;i<=9;i++) {
			gugudan(i); // 항상 호출시에 처음부터 수행 
			System.out.println("===========");
		}
	}

}
