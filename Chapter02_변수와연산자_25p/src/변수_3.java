/*
 * 		국어 영어 수학 => 총점 / 평균 / 학점 (ABCDF) // 변수 6개
 *         정수              실수    char
 *      
 */
public class 변수_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int kor=90;
		int eng=80;
		int math=75;
		int total=kor+eng+math;
		double avg=total/3.0;
		//정수/정수=정수 = 실수가 아니라 정수로 나옴 따라서 3.0으로 나누어야 함 
		System.out.println("국어 점수:"+kor);
		System.out.println("영어점수:"+eng);
		System.out.println("수학 점수:"+math);
		System.out.println("평균:"+avg);
		System.out.printf("평균:%.2f",avg); //%.2f는 소수점 두자리 반올림/ , 찍어야함 + 말고 /printf
		//printf는 소수점 위치 출력할 때 사용 
	}

}
