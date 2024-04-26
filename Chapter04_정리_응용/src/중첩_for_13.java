// 알파벳 10개 난수 => 버블 정렬 (DESC)
// 중복 없는 알파벳 
import java.util.*;
public class 중첩_for_13 {

	public static void main(String[] args) {
		char[] alpha=new char[10];
		for(int i=0;i<alpha.length;i++) {
			alpha[i]=(char)((int)(Math.random()*26)+65);
			for(int j=0;j<i;j++) {
				if(alpha[i]==alpha[j]) {
					i--; // ++한걸 다시 --해주기에 다시 발생! 
					break;
				}
				
			}
		}
		Arrays.sort(alpha);
		System.out.println(Arrays.toString(alpha));
		for(char i=0;i<alpha.length-1;i++) {
			for(char j=0;j<alpha.length-1-i;j++) {
				// 0 1  1 2  2 3 비교
				if(alpha[j]<alpha[j+1]) { 
					char temp=alpha[j];
					alpha[j]=alpha[j+1];
					alpha[j+1]=temp;
					}
				}
			}
		System.out.println("DSEC");
		System.out.print(Arrays.toString(alpha));
		//for(int i=alpha.length-1;i>=0;i--) {
		//	System.out.print(alpha[i]+" ");
		}
	}
