import java.util.Arrays;

public class 실무_중복없는_난수 {

	public static void main(String[] args) {
		int[] lotto=new int[6];
		int su=0; // 난수 받는 변수
		boolean bCheck=false; // 중복여부 확인 변수 => 중복이 되면 true / 중복아니면 false
		for(int i=0;i<lotto.length;i++) {
			bCheck=true;
			while(bCheck) {// 중복이면 다시 수행, 중복이 아니면 종료 => lotto에 저장
				//난수
				su=(int)(Math.random()*45)+1;
				bCheck=false;
				//중복 여부 비교 (중복이 있는 숫자가 저장되었는지)
				for(int j=0;j<i;j++) {
					if(lotto[j]==su) {
						bCheck=true;
						break;
					}
				}
			}
			lotto[i]=su;
		}
		System.out.println(Arrays.toString(lotto));
	}

}
