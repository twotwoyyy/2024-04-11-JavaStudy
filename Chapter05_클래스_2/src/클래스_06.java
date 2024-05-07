// 벤치마킹 => 프로그램에 맞는 데이터만 설정 => 메소드 설정 
/*
 *	프로젝트 
 *	=> 모방 CGV
 *	=> 불편한 부분 / 추가되는 내용
 *               | 카페/술집/맛집
 *  --------------------------
 */
class Recipe{
	// 멤버변수 
	String title;
	String chef;
	String star;
	int hit;
	//변수는 배열 / 클래스
	int[] reserve= {13,14,15,20,25};
	
}
// 레시피가 많은 경우
//Recipe[] recipes=new Recipe[200]; => 데이터형이라 배열 사용이 가능하다 
//사용자정의 데이터형 => 배열 / 형변환 => 일반 변수와 동일하게 취급 
public class 클래스_06 {

	public static void main(String[] args) {
		Recipe r1=new Recipe();
		r1.title="돼지고기 김치찌개 맛내는 비법";
		r1.chef="완소연홍";
		r1.star="★★★★★";
		r1.hit=46000;
		System.out.println("레시피명:"+r1.title);
		System.out.println("셰프명:"+r1.chef);
		System.out.println("별점:"+r1.star);
		System.out.println("조회수:"+r1.hit);
		System.out.println("예약 가능한 날");
		for(int i:r1.reserve) {
			System.out.print(i+" ");
			
		}
	}

}
