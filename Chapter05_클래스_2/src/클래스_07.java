// 맛집 데이터형을 만들어서 => 값 대입 후에 출력
class FoodHouse{
	String name;
	String loc;
	String menu;
	int hit;
	double score;
}
public class 클래스_07 {

	public static void main(String[] args) {
		FoodHouse f1=new FoodHouse();
		f1.name="새벽집 청담동점";
		f1.score=4.0;
		f1.loc="청담동";
		f1.menu= "꽃등심(150g) , 양념갈비(260g), 생고기(150g),불고기(200g),샤브샤브(160g),육회(200g)";
		String[] menus=f1.menu.split(","); // 문자열 배열
		
		System.out.println("업체명:"+f1.name);
		System.out.println("평점:"+f1.score);
		System.out.println("지역:"+f1.loc);
		System.out.println("====메뉴====");
		
		for(String m:menus) {
			System.out.println("○ "+m.trim());
		}
		// 많이 있다 => FoodHouse[] 배열잡기 
	}

}
