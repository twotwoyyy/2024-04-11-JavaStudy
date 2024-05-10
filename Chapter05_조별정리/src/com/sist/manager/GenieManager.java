package com.sist.manager;
import java.io.*;
import java.util.*;
import com.sist.vo.*;
public class GenieManager {
	private static Genie[] genies=new Genie[200];
public GenieManager() {
	 // 파일에서 데이터를 읽어서 저장 => 예외처리 => 컬렉션

		try {
			// 정상적으로 수행할 경우 => 명령문 
			// => 예외처리는 모든 문장에 있다 => 생략 가능 => 파일 입출력/ 네트워크 / 데이터베이스 연동시엔 필수적으로 예외처리 
			FileReader fr=new FileReader("c:\\javaDev\\genie.txt");
			int i=0; // fr.read() => 리턴형 => int (문자의 번호를 읽어 온다)
			StringBuffer sb=new StringBuffer();// 읽어서 데이터를 누적 (속도 개선) 
			while((i=fr.read())!=-1) { // -1 파일의 끝 EOF
				sb.append((char)i);
			}
			// 읽게되면 반드시 파일을 닫아야 한다
			fr.close();

			String data=sb.toString(); // 전체 데이터를 모은다 
			String[] temp=data.split("\n"); // 한 줄씩 저장
			i=0;
			for(String s:temp) {
				String[] genie=s.split("\\|");
				// split, replaceAll=> ?, ., +, *, | 기호 자체를 가져올 때 \\를 사용해야한다 
				// \\를 사용하지 않으면 연산자로 처리되기 때문이다 
				// \" \' \\ => ",',\출력할 때 역슬래시 사용
				genies[i]=new Genie();
				genies[i].setRank(i+1);
				genies[i].setTitle(genie[1]);
				genies[i].setArtist(genie[2]);
				genies[i].setAlbum(genie[3]);
				genies[i].setPoster(genie[4]);
				genies[i].setYoutube(genie[5]);
				i++;
			}
			
		}catch(Exception ex) {}
	}

	// 목록 출력
	public Genie[] genieListData(int page) {
		int total=genieTotalPage();
		int leng=20;
		if(page==total)
			leng=18;
		// 배열의 단점 => 고정이 되어있음 => 보완 (컬렉션)
		Genie[] genie=new Genie[leng];
		
		int j=0; // 20개씩 나눠주는 변수
		int pagecnt=(20*page)-20;

		for(int i=0; i<genies.length;i++) {
			if(j<20 && i>=pagecnt) {
				genie[j]=new Genie();
				genie[j]=genies[i];
				j++;
			}
		}
		return genie;
	}
	public int genieTotalPage() {
		return (int)(Math.ceil(genies.length/20.0)); // ceil 올림함수 
	}
	//상세보기
	public Genie genieDetailDate(int mno) {
		return genies[mno-1];
	}
	//검색
	public Genie[] genieFindData(String title) {
		int count=0;
		for(Genie m:genies) {
			if(m.getTitle().contains(title)) {
				count++;
			}
		}
		// 선언 => 배열 개수 확인 => 데이터 값 채우기 => 동일하면 선언 => 동일하지 않는 경우 
		Genie[] genie=new Genie[count]; //동적 => 가변형 
		int i=0;
		for(Genie m:genies) {
			if(m.getTitle().contains(title)) {
				genie[i]=m;
				i++;
			}
		}
		
		return genie;
	}
	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		GenieManager m=new GenieManager();
		System.out.print("검색어 입력:");
		String title=scan.next();
		
		Genie[] genie=m.genieFindData(title);
		for(Genie mm:genie) {
			System.out.println(mm.getRank()+"."+mm.getTitle());
		}
		System.out.println("===========================================");
		System.out.print("상세보기 할 노래 번호:");
		int mno=scan.nextInt();
		
		Genie mmm=m.genieDetailDate(mno);
		// 메서드 (요청에 처리 => 기능)
		// 처리 기능 / 데이터만 있는 클래스
		// 파일 / 오라클 => 데이터만 있는 클래스에 값을 채워서 전송 
		System.out.println("순위."+mmm.getRank());
		System.out.println("노래명:"+mmm.getTitle());
		System.out.println("가수명:"+mmm.getArtist());
		
		// => 목록 출력 / 상세보기 / 검색 
	}

}