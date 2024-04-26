// 중복이 없는 난수
// 1~10 => 10개의 난수 발생 => 중복없이 
public class 중첩_for_05 {

	public static void main(String[] args) {
		//용도가 같은 정수 10개 저장(배열)
		int[] arr=new int[10]; // => 변수 이름을 1개로 통일 => 구분은 인덱스로 [0]부터 시작
		// length-1까지 사용 가능 (인덱스)
		// 제어하기가 편리하다 (읽기/쓰기가 편리) => 반복문을 사용하기 때문에 소스코딩을 줄인다 
		// int a=random() => 500 
		// 클래스도 한 개의 이름으로 통일 => 인터페이스 
		for(int i=0;i<arr.length;i++){
			arr[i]=(int)(Math.random()*10)+1;
			for(int j=0;j<i;j++) {
				if(arr[i]==arr[j]) {
					i--; // 같은게 있으면 다시 난수 발생(+,-같은위치)
					break; // 2차 for문만 제어 
				}
			}
		}
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
	}
		

}
