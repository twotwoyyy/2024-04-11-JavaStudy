
import java.awt.geom.GeneralPath;
import java.io.*;
import java.net.URLEncoder;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.print.Doc;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class Music1{
	String rank;
	String title;
	String singer;
	String album;
	String poster;
	String key;
}
class Melon
{
	static Music1[] musics=new Music1[100]; // 클래스 블록은 선언하는 위치 
	/*
	 *    <td class="info">
                 <a href="#" class="title
	 */
	{
		try
		{
		  int k=1;
		  for(int i=1;i<=100;i+=50)
		  {//wrap t_center
			  Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			  Elements title=doc.select("tr.lst"+i+"div.wrap sib.rank01 a");
			  Elements singer=doc.select("table.list-wrap td.info a.artist");
			  Elements album=doc.select("table.list-wrap td.info a.albumtitle");
			  Elements poster=doc.select("table.list-wrap a.cover img");
			  for(int j=0;j<title.size();j++)
			  {
				  System.out.println("순위:"+k++);
				  System.out.println("노래명:"+title.get(j).text());
				  System.out.println("가수명:"+singer.get(j).text());
				  System.out.println("앨범:"+album.get(j).text());
				  System.out.println("이미지:"+poster.get(j).attr("src"));
				  //System.out.println("동영상 키:"+youtubeData(title.get(j).text()));
				  System.out.println("===================================================");
				  FileWriter fw=
						  new FileWriter("c:\\javaDev\\genie.txt",true); //append // 크롤링 및 저장방법 
				  String data=k+"|"+title.get(j).text()+"|"
						  +singer.get(j).text()+"|"
						  +album.get(j).text()+"|"
						  +poster.get(j).attr("src")+"|"
						  +youtubeData(title.get(j).text())+"\r\n";
				  fw.write(data);
				  fw.close();
				  k++;
			  }
		  }
			

		}catch(Exception ex){}
	}
	static void musicList() {
		System.out.println("===============Music List=============");
		int i=1;
		for(Music1 s:musics) {
			System.out.println(i+"."+s.title);
			i++;
		}
	}
	static void musicDetail(int rank) {
		try {
			Music1 m=musics[rank-1];
			String url="http://youtube.com.embed/"+m.key;
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		}catch(Exception ex) {}
	}
	static void misicTitleFind(String title) {
		int count=0;
		for(Music1 m:musics) {
			if(m.title.contains(title)) {
				System.out.println(m.title);
				count++;
			}
		}
		System.out.println("검색결과 총 "+count+"건");
	}
	static void misicSingerFind(String singer) {
		int count=0;
		for(Music1 m:musics) {
			if(m.singer.contains(singer)) {
				System.out.println(m.title+"["+m.singer+"]");
				count++;
			}
		}
		System.out.println("검색결과 총 "+count+"건");
	}
	
	static void misicAlbumFind(String album) {
		int count=0;
		for(Music1 m:musics) {
			if(m.singer.contains(album)) {
				System.out.println(m.title+"["+m.album+"]");
				count++;
			}
		}
		System.out.println("검색결과 총 "+count+"건");
	}
	
	static String youtubeData(String title) throws Exception
	{
		String result="";
		String url="https://www.youtube.com/results?search_query="
				  +URLEncoder.encode(title, "UTF-8");
		Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
		Document doc=Jsoup.connect(url).get();
		Matcher m=p.matcher(doc.toString());
		while(m.find())
		{
			String temp=m.group();
			System.out.println(temp);
			temp=temp.substring(temp.indexOf("=")+1,temp.indexOf("\""));
			result=temp;
			break;
		}
		return result;
	}
}
/*
 *	프로그램
 *		=> 데이터 수정
 *		=> 데이터를 메모리 저장
 *		   ---------------- 모든 메소드에서 사용이 가능 => 전역변수 / 멤버변수
 *		=> 사용 요청하는 모든 내용 => 메소드 (수정,추가) => 재사용
 */
public class Melon_Music {
	   public static void main(String[] args) {
		GenieMusic gm=new GenieMusic();
		gm.musicList();
		System.out.println("=============================================");
		Scanner scan=new Scanner(System.in);
		//System.out.print("1~200사이의 번호 선택:");
		//int no=scan.nextInt();
		//gm.musicDetail(no);
		System.out.print("제목 검색어 입력:");
		String title=scan.next();
		gm.misicTitleFind(title);
		
		System.out.print("가수 입력:");
		String singer=scan.next();
		gm.misicSingerFind(singer);
		
		System.out.print("앨범명 입력:");
		String album=scan.next();
		gm.misicAlbumFind(album);
	}

}
