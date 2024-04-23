import java.io.*;
import java.util.Scanner;
public class 제어문_선택문_3 {
/*	C:\Windows\System32\notepad.exe
 * 	C:\Program Files\WindowsApps\Microsoft.Paint_11.2402.32.0_x64__8wekyb3d8bbwe\PaintApp
 * 	C:\Program Files\Google\Chrome\Application
 * 
 */

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("메모장,그림판,크롬 >>");
		// 결과 출력
		switch(scan.next()) // 문자, 문자열, 정수 
		{
		case "메모장":
			Runtime.getRuntime().exec("C:\\Windows\\System32\\notepad.exe");
			break;
		case "그림판":
			Runtime.getRuntime().exec("C:\\Program Files\\WindowsApps\\Microsoft.Paint_11.2402.32.0_x64__8wekyb3d8bbwe\\PaintApp\\mspaint.exe");
			break;
		case "크롬":
			Runtime.getRuntime().exec("C:\\Program Files\\Google\\Chrome\\Application\\Chrome.exe");
			break;
		default:
			System.out.println("잘못된 입력입니다!!");
		}
		
	}

}
