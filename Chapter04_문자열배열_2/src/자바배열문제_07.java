/*
 * 7. 임의의 문자 5개를 저장하고 정렬해서 출력하시오 
    A C D H J
    A C D H J
    J H D C A
 */
import java.util.Arrays;
public class 자바배열문제_07 {

	public static void main(String[] args) {
		char[] alpha=new char[5];
		for(int i=0;i<alpha.length;i++){
			alpha[i]=(char)((Math.random()*26)+65); // 정수를 char로 변환해야하기때문에 괄호 
		}
		System.out.println("변경전:");
		System.out.println(Arrays.toString(alpha));
		System.out.println("변경후(오름차순):");
		Arrays.sort(alpha); // ASC=>올림차순 
		System.out.println(Arrays.toString(alpha));
		System.out.println("거꾸로 출력(내림차순):");
		for(int i=alpha.length-1;i>=0;i--) //DSC=>내림차순
		{
			System.out.print(alpha[i]+" ");
		}
	
	}

}
