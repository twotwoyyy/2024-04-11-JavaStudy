import java.util.*;
public class 중첩_for_09 {

	public static void main(String[] args) {
		int[] lotto=new int[6];
		// 중복 없는 난수 발생 => 6
		for(int i=0;i<lotto.length;i++) {
			lotto[i]=(int)(Math.random()*45)+1;
			// 중복이 될 수 있음 => 이중 for사용 
			for(int j=0;j<i;j++) {
				if(lotto[j]==lotto[i]) {
					i--;
					break;
				}
			}
		}
		System.out.println(Arrays.toString(lotto));
		// 로또 번호는 정렬해서 출력 => 정렬 알고리즘 필요 
		for(int i=0;i<lotto.length-1;i++) {
			for(int j=i+1;j<lotto.length;j++) {
				if(lotto[i]>lotto[j]) {
					int temp=lotto[i];
					lotto[i]=lotto[j];
					lotto[j]=temp;
				}
			}
		}
		System.out.println("====== 오늘의 로또 번호 ======");
		//출력
		for(int i:lotto) {
			System.out.print(i+" ");
			try {
				Thread.sleep(2000);
			}catch(Exception ex) {}
		}
	}

}
