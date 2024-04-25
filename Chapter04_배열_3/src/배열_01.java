/*
 *	배열 : 같은 데이터형 여러개 데이터를 모아서 저장
 *		  ---------- 용도가 같은 데이터
 *		  => 단점: 고정적
 *		  => 장점: 여러 개의 데이터를 한 개의 이름으로 제어 할 수 있다 
 *							    -------- 인덱스 => 0번부터 시작 
 *		1) 선언
 *		데이터형[] 배열명;
 *		데이터형 배열명[];
 *		예) int[] arr;
 *		   double[] arr;
 *			.
 *			.
 *		2) 초기화
 *		=> 실제값을 초기화
 *		int[] arr;
 *		arr=new int[]{1,2,3} // 값지정o
 *		=> 기본값을 초기화 
 *		int[] arr=new int[5]; // 값지정x, 자동으로 0으로 초기화 
 *		                                ---------------
 *		= int[]=>0
 *		= double[]=>0.0
 *		= char[]=>'\0' => 공백
 *		= boolean[]=>false
 *		= String[]=> null(주소가 없는 상태) // 모든 클래스에 저장 (참조할 수 있는 주소)
 *		= long[]=>0L
 *		
 *		** new연산자 => malloc() => 자주 사용 => 연산자로 승격
 *		  --------- => 넘겨주는 값 (주소값=>int)
 *		  --------- 동적 메모리 할당 (생성)
 *					--- 실행시마다 메모리를 확보 (메모리 따로 생성)
 *					--- 메모리 주소가 다르다 => 클래스에서 저장
 *					int[] arr=new int[5];
 *					arr=[I@6f2b958e => 메모리 주소
 *									   연속적인 메모리를 가지고 있다
 *							   인덱스번호* arr[0]  arr[1]  arr[2]  arr[3]  arr[4]
 *					arr------------> -----------------------------------------
 *									  |   0   |   0   |   0   |   0   |   0   |
 *									|--------------------------------- 같은 크기의 메모리가 5개 생성
 *								[I@6f2b958e
 *								=> 주소를 이용해서 원하는 데이터에 접근하는 변수 => 참조변수
 *								  배열/클래스 
 *								=> 변수/배열/클래스 => 변수
 *							       한 개만 저장 / 같은 데이터형 여러 개 / 다른 데이터형 여러 개 저장 
 *								=> 예)
 *									학생 1명에 대한 정보 
 *									---------------
 *									1. 이름
 *								    2. 성별
 *									3. 학번
 *									4. 학년 
 *									5. 주소
 *									6. 전화
 *									7. 나이
 *									------
 *									변수 => String name1,name2,name3;
 *										   Stirng[] name=new String[3];
 *										   String sex;
 *										   int hakbun;
 *										   int year;
 *										   String address;
 *										   String phone;
 *										   int age;
 *								 => 클래스
 *								class Student
 *								{
 *								  String name,sex,address,phone;
 *								  int hakbun,year,age
 *								}
 *								: 메모리를 원하는 만큼 확보할 수 있다 
 *		3) 값 변경
 *		   int[] arr={10,20,30,40,50}
 *		   Stack(주소)                   Heap(실제 데이터가 저장되는 영역)
 *		   arr -------------->         
 *							  ----------------------------------
 *                              10  |  20  |  30  |  40  |  50 
 *                            |---------------------------------
 *                            0x100  0x104  0x108  0x112  0x116
 *                     배열 변수는 시작 주소값만 가지고 있다
 *                     arr=0x100
 *                     arr[0] => 0x100주소 첫 번째 값
 *                     arr[1] => 0x100주소로부터 두 번째 값
 *                     ..
 *                     ..
 *               세 번째 값 변경 => arr[2]=100 => 30(x) => 100으로 변경 
 *               마지막 번째 값 변경 => arr[4]=500 => 50(x) => 500으로 변경
 *               배열의 값을 변경할 때 => 배열명[인덱스 번호]
 *                                      ---------- 0번부터
 *                                      -------개수 => length
 *               => 배열 복사
 *                 얕은 복사 : 공유 
 *                 깊은 복사 : 새로운 배열을 생성 
 *		4) 출력 => for-each
 */
public class 배열_01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] arr=new int[5];
//		System.out.println(arr);
//		int[] arr1=new int[5];
//		System.out.println(arr1); //실제 주소값 출력
//		// new를 사용할 때마다 새로운 주소값 부여
		
		//얕은 복사-> 바뀌면 원본주소도 바뀐다, 같은 영역 제어
		System.out.println("====얕은 복사====");
		int[] arr= {10,20,30,40,50};
		int[] temp=arr;
		temp[0]=100;
		temp[1]=200;
		System.out.println("temp[0]="+temp[0]);
		System.out.println("temp[1]="+temp[1]);
		System.out.println("arr[0]="+arr[0]);
		System.out.println("arr[1]="+arr[1]);
		
		//깊은 복사-> 설정된 그대로 복사, 새로운 배열을 생성 .clone(); 
		System.out.println("====깊은 복사====");
		int[] arr1= {10,20,30,40,50};
		int[] temp1=arr1.clone();
		int[] temp2=arr1;// 얕은 복사시
		System.out.println("arr1="+arr1);
		System.out.println("temp1="+temp1);
		System.out.println("temp2="+temp2); //주소가 같아진다 
		
		//배열은 메모리 주소를 그대로 이용한다 => 주소를 대입시 => 별칭 => 같은 메모리를 제어 
		temp1[0]=100;
		temp1[1]=200;
		System.out.println("temp1[0]="+temp1[0]);
		System.out.println("temp1[1]="+temp1[1]);
		System.out.println("arr1[0]="+arr1[0]);
		System.out.println("arr1[1]="+arr1[1]);
		//배열은 메모리 주소
		// => 원본이 변경될 수 있다 / 변경되지 않게 하려면 깊은 복사를 해야 한다 
		// 주소값은 대입이 가능 
	}

}
