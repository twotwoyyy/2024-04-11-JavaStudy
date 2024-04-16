/*
 * 	변수 / 연산자 / 제어문 => 데이터베이스 => 웹사이트
 * -----------------------------------------
 *          |
 *        재사용(게시판) => 메소드 
 *                        |
 *                      목록 출력
 *                      글쓰기
 *                      상세보기
 *                      수정하기
 *                      삭제하기
 *                      검색
 *                      댓글
 *                      
 *		char => 대문자 / 소문자 / 알파벳이 아니다
 * 
 */
import java.util.Scanner;
public class 제어문_단일조건문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("문자 입력:");
		char c=scan.next().charAt(0);
		
		// 출력 => 결과값
		// 대문자 => c>='A' && c<='Z'
		// 소문자 => c>='a' && c<='z'
		// 알파벳이 아닌 경우 !((c>='A' && c<='Z')||(c>='a' && c<='z'))
		
		System.out.println("====결과====");
		if(c>='A' && c<='Z')
		{
			System.out.println(c+"은(는) 대문자입니다");
		}
		if(c>='a' && c<='z')
		{
			System.out.println(c+"은(는) 소문자입니다");
		}
		if(!((c>='A' && c<='Z')||(c>='a' && c<='z')))
		{
			System.out.println(c+"은(는) 알파벳이 아닙니다");
		}
		}
}