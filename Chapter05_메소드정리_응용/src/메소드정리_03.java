
public class 메소드정리_03 {
	static void swap(int[] arr) {
		// 메모리 주소 자체를 넘겨준다 => 같은 메모리를 제어 / Call By Reference 원본 자체 변경 
		System.out.println("변경전:arr[0]"+arr[0]+",arr[1]="+arr[1]);
		int temp=arr[0];
		arr[0]=arr[1];
		arr[1]=temp; // 값교환
		System.out.println("변경후:arr[0]"+arr[0]+",arr[1]="+arr[1]);
	}
	public static void main(String[] args) {
		// Call By Reference 방식 => 메모리 주소 자체를 변경 
		// 주소는 배열, 클래스만 가지고 있다 
		int[] temp= {100,200};
		swap(temp);
		System.out.println("main=>temp값:temp[0]:"+temp[0]+",temp[1]:"+temp[1]); // 원본 값이 변경됨 
	}

}
