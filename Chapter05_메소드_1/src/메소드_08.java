import java.util.*;
public class 메소드_08 {
	static void find(String fd) {
		String[] title={
		        "Your Lights",
				"겨울잠",
				"우린 어쩌다 헤어진 걸까",
				"요즘",
				"VVS (Feat. JUSTHIS) (Prod. by GroovyRoom)",
				"Dynamite",
				"밤하늘의 별을 (2020)",
				"첫사랑 (Feat. SOLE (쏠))",
				"Life Goes On",
				"이제 나만 믿어요",
				"나로 바꾸자 (Duet With JYP)",
				"잠이 오질 않네요",
				"What Do I Call You",
				"ON AIR (Feat. 로꼬 & 박재범 & GRAY)",
				"오래된 노래",
				"한잔이면 지워질까",
				"힘든 건 사랑이 아니다",
				"For You (Feat. Crush)",
				"Savage Love (Laxed - Siren Beat) (BTS Remix)",
				"취기를 빌려 (취향저격 그녀 X 산들)",
				"HERO",
				"Lovesick Girls",
				"서로를 위한 것",
				"뻔한남자",
				"내일이 오면 (Feat. 기리보이 & BIG Naughty (서동현))",
				"작은 것들을 위한 시 (Boy With Luv) (Feat. Halsey)",
				"잘할게",
				"CREDIT (Feat. 염따 & 기리보이 & Zion.T)",
				"어느 60대 노부부이야기",
				"만개 (Prod. 신지후)",
				"악역 (Feat. 이하이 & 사이먼 도미닉) (Prod. by 코드 쿤스트)",
				"혼술하고 싶은 밤",
				"흔들리는 꽃들 속에서 네 샴푸향이 느껴진거야",
				"오늘도 빛나는 너에게 (To You My Light) (Feat.이라온)",
				"오래된 노래",
				"살았소",
				"그날에 나는 맘이 편했을까",
				"나보다 더 사랑해요",
				"입김",
				"모든 날, 모든 순간 (Every day, Every Moment)",
				"바램",
				"내 마음이 움찔했던 순간 (취향저격 그녀 X 규현)",
				"가을밤에 든 생각",
				"이제 나만 믿어요 (Piano by 조영수)",
				"뿌리 (Feat. JUSTHIS) (Prod. by GroovyRoom)",
				"에잇 (Prod. & Feat. SUGA of BTS)",
				"아무도 잠들지 마라 (Nessun Dorma)",
				"늦은 밤 너의 집 앞 골목길에서",
				"Achoo (Feat. pH-1 & HAON) (Prod. by GroovyRoom)",
				"Blueming"
				}; 
		
		for(String t:title) {
			if(t.contains(fd)) { // 검색어 포함된 것 출력
				System.out.println(t);
			}
		}
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		System.out.print("검색어 입력:");
		String fd=scan.next();
		find(fd); // void일 때 호출하는 메소드
		//   -- 입력하지 않으면 다른 메소드로 인식, 오류 
		/*
		 *  리턴형이 있는 경우
		 *  : 데이터형 변수=메소드명(데이터형에 맞는 실제값)
		 */
		double r=Math.random();//0.0~99사이 (double)이기에 int로 받을 수 없다 
		//double java.lang.Math.random() // (매개변수) x , 리턴형 double 
		       // (int)Math.random <== int로 형변환해서 사용
		System.out.println(r);
		// 라이브러리 = 원형
		// => 리턴형 매개변수 
		// boolean equals(String s)
	}

}
