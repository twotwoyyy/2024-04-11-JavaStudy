//2. 1~10까지 합을 구하는 메소드를 구현하시오.
// 리턴형(o) , 매개변수 (x)
public class 메소드_문제_02 {
	static int munje_2() {
		int sum=0;
		for(int i=1; i<=10;i++) {
			sum+=i;
		}
		return sum; //값 = 리턴형에 사용되는 데이터형이 동일
		// 특별한 경우에는 return값이 작을 수 있다 
	}
	public static void main(String[] args) {
		for(int i=1; i<=10;i++) {
		}
		System.out.print("1~10까지의 합:"); 
		//리턴형이 있는 경우 => 결과값을 받는다
		int sum=munje_2(); // 메소드 호출 
		System.out.println(sum);
	}

}
