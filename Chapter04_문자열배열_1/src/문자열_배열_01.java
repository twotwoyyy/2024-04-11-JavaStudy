/*
 *	String: 문자열을 저장하는 데이터형
 *	String => 일반 문자열 데이터형 / 클래스형 
 *							 --------- 기능:문자열을 제어하는 기능
 *									   -------------------- 메소드
 *	*Sting 사용법
 *	String name="ASSS"; // 제한이 없다 => char[]을 클래스화 
 *	-------------------
 *  ------------------- 데이터형을 제어하는 클래스 : Wrapper
 *	int    =====> Integer (클래스)
 *	long   =====> Long
 *	byte   =====> Byte
 *	double =====> Double
 *	boolean ====> Boolean
 *  --------------------
 *  1. 기능 
 *   비교
 *    = equals()
 *    = contains()
 *    = startsWith()
 *    = endsWith()
 *   변경
 *    = replace()
 *    = replaceAll()
 *    = split()
 *    = concat() => 문자열 결합 (+) 
 *   제어
 *    = substring()
 *    = indexOf()
 *    = lastIndexOf()
 *   기타
 *    = toUpperCase()
 *    = toLowerCase()
 *    = valueOf()
 *    = trim()
 *   -------------------- 웹 : int / double / String
 *   					  오라클 : Number,Varchar2
 *   					  다운로드/업로드 : byte
 *   배열
 *   String[] 배열명={} => 데이터를 고정
 *   String[] 배열명=new String[10]; 값초기화/값변경
 */
import java.util.*;
public class 문자열_배열_01 {

	public static void main(String[] args) {
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
		String[] singer={
			  "이수 (엠씨더맥스)",
			  "장덕철",
			  "허각",
			  "양다일",
			  "미란이 (Mirani) & 먼치맨 & Khundi Panda & 머쉬베놈 (MUSHVENOM)",
			  "방탄소년단",
			  "경서",
			  "정준일",
			  "방탄소년단",
			  "임영웅",
			  "비",
			  "장범준",
			  "태연 (TAEYEON)",
			  "릴보이 (lIlBOI)",
			  "임영웅",
			  "황인욱",
			  "임창정",
			  "이하이",
			   "Jawsh 685 & Jason Derulo & 방탄소년단",
			   "산들",
			   "임영웅",
			   "BLACKPINK",
			   "나얼",
			   "이승기",
			   "릴보이 (lIlBOI)",
			   "방탄소년단",
			   "이승기",
			   "릴보이 (lIlBOI)",
			   "임영웅",
			   "김호중",
			   "스윙스 (Swings)",
			   "벤",
			   "장범준",
			   "마크툽 (Maktub)",
			   "Standing Egg (스탠딩 에그)",
			   "김호중",
			   "이예준","김호중","10CM","폴킴","임영웅","규현 (KYUHYUN)","잔나비","임영웅",
			   "Khundi Panda","아이유 (IU)","김호중","노을","미란이 (Mirani)","아이유 (IU)"
			};
		String[] album={
			  "Your Lights (바이크 원정대 OST Part.1)","겨울잠","Hello","요즘",
			  "쇼미더머니 9 Episode 1","Dynamite (DayTime Ver.)","밤하늘의 별을 (2020)",
			  "첫사랑","BE","내일은 미스터트롯 우승자 특전곡","나로 바꾸자","잠이 오질 않네요",
			  "What Do I Call You - The 4th Mini Album","쇼미더머니 9 Final",
			  "사랑의 콜센타 Part19","한잔이면 지워질까","힘든 건 사랑이 아니다",
			  "For You","Savage Love (Laxed - Siren Beat) (BTS Remix)",
			  "취기를 빌려 (취향저격 그녀 X 산들)","HERO","THE ALBUM",
			  "서로를 위한 것","뻔한남자","쇼미더머니 9 Episode 3","MAP OF THE SOUL : PERSONA",
			  "The Project","쇼미더머니 9 Final","내일은 미스터트롯 트롯 에이드 베스트",
			  "우리家","쇼미더머니 9 Semi Final","혼술하고 싶은 밤","멜로가 체질 OST Part 3 (JTBC 금토 드라마)",
			  "Red Moon : To You My Light","오래된 노래","살았소","그날에 나는 맘이 편했을까",
			  "나보다 더 사랑해요","5.1",
			  "'키스 먼저 할까요?' OST Part. 3 (SBS 월화드라마)","내일은 미스터트롯 예선곡 베스트",
			  "내 마음이 움찔했던 순간 (취향저격 그녀 X 규현)","잔나비 소곡집 l","이제 나만 믿어요",
			  "쇼미더머니 9 Episode 3","에잇","The Classic Album","늦은 밤 너의 집 앞 골목길에서",
			  "쇼미더머니 9 Episode 3","Love poem"
			};
			
		String[] state={
			"유지","유지","유지","유지","유지",
			"유지","유지","유지","상승","상승",
			"하강","하강","상승","상승","상승",
			"상승","상승","상승","하강","하강",
			"상승","상승","상승","상승","상승",
			"상승","상승","상승","하강","하강",
			"상승","상승","상승","상승","상승",
			"상승","상승","상승","상승","상승",
			"하강","하강","상승","상승","상승",
			"상승","상승","상승","상승","상승",
			"상승","상승","상승","상승","상승",
			"상승","하강","하강","하강","하강",
			"상승","상승","상승","상승","상승",
			"상승","상승","상승","상승","상승",
			"하강","하강","상승","상승","하강",
			"하강","상승","상승","상승","상승",
			"하강","하강","상승","상승","상승",
			"상승","하강","하강","상승","상승",
			"상승","상승","하강","하강","상승",
			"상승","상승","상승","상승","상승"
			};
			
		int[] modify={
			0,0,0,0,0,
			0,0,0,2,2,
			1,1,7,7,2,
			2,3,3,4,4,
			26,26,20,20,8,
			8,32,32,7,7,
			20,20,23,23,23,
			23,16,16,28,28,
			12,12,30,30,30,
			30,48,48,34,34,
			12,12,18,18,14,
			14,16,16,19,19,
			39,39,7,7,27,
			27,61,61,31,31,
			21,21,26,26,21,
			21,23,23,27,27,
			25,25,5,5,44,
			44,26,26,6,6,
			9,9,28,28,38,
			38,7,7,15,15
			};
	// 노래 출력 
			System.out.println("등록된 곡 총 "+title.length+"곡 수록");
			int rank=1;
			for(String t:title) {
				System.out.println(rank+"."+t);
				rank++;
			}
	System.out.println("======================================");
	// 노래 검색 => contains => Oracle => LIKE
	Scanner scan=new Scanner(System.in);
	System.out.print("검색어 입력:");
	String fd=scan.next();
	int count=0;
	for(String t:title) {
		if(t.contains(fd)) { // 제목안에 단어가 포함됐는지 여부 => true/false
			System.out.println(t);
			count++;
		}
	}
	System.out.println("검색 결과 총"+count+"건");
	System.out.println("======================================");
	System.out.println("============== 등폭 출력 ================");
	// 보통 배열이 여러개인 경우 인덱스 번호를 이용한다 
	// 상승/하락/유지
	for(int i=0;i<title.length;i++) { // 여러개 배열을 동시에 제어 => 인덱스를 이용한다 
		String temp="";
		if(state[i].equals("상승")) {
			temp="▲ "+modify[i];
		}
		else if(state[i].equals("하강")){
			temp="▽ "+modify[i];
		}
		else{//유지 
			temp="-";
		}
		System.out.println(temp+"   "+title[i]+" "+singer[i]);
	}

	}

}
