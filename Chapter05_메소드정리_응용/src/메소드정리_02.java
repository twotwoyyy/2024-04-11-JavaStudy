
public class 메소드정리_02 {
	// 매개변수 전송법 => 메소드 안에서만 변경 => Call By Value (값만 변경)
	static void swap(int a,int b) {
		System.out.println("변경전:a="+a+",b="+b);
		int temp=a;
		a=b;
		b=temp;
		System.out.println("변경후:a="+a+",b="+b);
	}
	public static void main(String[] args) {
		int a=100;
		int b=200; // 원본
		swap(a,b);
		System.out.println("main=>원본값:a="+a+",b="+b);
		// 원본이 저장된 메모리와 => 전송받은 메모리가 따로 생성된다 => 영향이 없다 
		// => 기본형, String 
		

	}

}
