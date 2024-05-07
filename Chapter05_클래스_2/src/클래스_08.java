// 초기화 블록 사용법 
/*
      </div>

        <ul class="common_sp_list_ul ea4" style="padding:0 0 0 8px;">
            <li class="common_sp_list_li">
                <div class="common_sp_thumb">
                    <a href="/recipe/6984517" class="common_sp_link">
                                                    <span class="common_vod_label"><img src="https://recipe1.ezmember.co.kr/img/icon_vod.png"></span>
                                                <img src="https://recipe1.ezmember.co.kr/cache/recipe/2022/07/31/d804978cda6e3c8b4e3a94a1c19696041_m.jpg">
                    </a>
                </div>
                <div class="common_sp_caption">
                    <div class="common_sp_caption_tit line2">도시락 반찬으로 최고! 스팸감자조림♡</div>
                    <div class="common_sp_caption_rv_name" style="display: inline-block; vertical-align: bottom;">
                        <a href="/profile/recipe.html?uid=47181483"><img src="https://recipe1.ezmember.co.kr/cache/rpf/2019/09/17/b488938a21561b705f5c7b3d0cc9dd641.5248f77ae96fcdeeef6d3e7c54c2fcc7">냠냠간단요리</a>
                    </div>
                    <div class="common_sp_caption_rv">
                                                    <span class="common_sp_caption_rv_star"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"><img src="https://recipe1.ezmember.co.kr/img/mobile/icon_star2_on.png"></span>
                            <span class="common_sp_caption_rv_ea">(25)</span>
                                                <span class="common_sp_caption_buyer" style="vertical-align: middle;">조회수 4.6만</span>
                    </div>
                </div>
            </li>
            <li class="common_sp_list_li">
                <div class="common_sp_thumb">
                    <a href="/recipe/7023593" class="common_sp_link">
                                                <img src="https://recipe1.ezmember.co.kr/cache/recipe/2024/04/03/3277847daf1d7a8dcbf5cd23726890011_m.jpg">
                    </a>
                </div>
                <div class="common_sp_caption">
 */

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

class Recipe2{
	String title;
	String chef;
	String hit;
	
}
class RecipeSystem{
	Recipe2[] recipes=new Recipe2[40]; // 선언만 가능 => 외부에서 읽기(x) => 구현 
	//초기화블록 => 생성자 => 외부에서 데이터를 얻어올 때 
	{
		// 배열에 데이터 초기화 
		// class => selector => CSS구분 (태그/class/id) 디자인
		try {
			Document doc=Jsoup.connect("https://www.10000recipe.com/recipe/list.html").get(); // doc안에 모든 데이터가 저장된다 
			// 문서저장 클래스 => HTML 저장
			//System.out.println(doc.toString());
			
			Elements title=doc.select("ul.common_sp_list_ul li.common_sp_list_li div.common_sp_caption_tit");
			//System.out.println(title);
			//Element=> 채그 <div> => 여러개 Elements
			Elements chef=doc.select("ul.common_sp_list_ul li.common_sp_list_li div.common_sp_caption_rv_name");
			Elements hit=doc.select("ul.common_sp_list_ul li.common_sp_list_li span.common_sp_caption_buyer");
			
			  for(int i=0;i<title.size();i++){
			    	//size=> length
			    	recipes[i]=new Recipe2();
			    	recipes[i].title=title.get(i).text();
			    	recipes[i].chef=chef.get(i).text();
			    	recipes[i].hit=hit.get(i).text();
			    }
		}catch(Exception ex) {} // 네트워크, 서버연결 , 파일 읽기 => 반드시 예외처리 
		// 네트워크 이용 (URL) => 웹 서버 연결 후 저장된 데이터 가지고 오기 => 웹 크롤링 
		// 예외처리 (8장) 
		// 초기화 블록은 JVM에 의해 자동으로 호출 
	}
}
public class 클래스_08 {

	public static void main(String[] args) {
		RecipeSystem rs=new RecipeSystem();
		int i=1;
		for(Recipe2 r:rs.recipes) {
			System.out.println("레시피번호:"+i);
			System.out.println("레시피명:"+r.title);
			System.out.println("셰프명:"+r.chef);
			System.out.println(r.hit);
			System.out.println("======================================");
			i++;
		}
	}

}
