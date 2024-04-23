//continue => for문에서 주로 사용 => 제외
public class 자바제어문_02 {

	public static void main(String[] args) {
		for(int i=1;i<=5;i++)
		{
			if(i==3) continue; //3을 제외하고 나머지 출력
			System.out.println("i="+i); // 다시 위로 올라가서 조건 검색 후 출력 
		}
		System.out.println("==== while-continue:무한루프=====");
		int i=1;
		while(i<=5)
		{
			if(i==3) continue;
			System.out.println("i="+1); // 증가하지 못하고 => 조건식으로 이동 (무한루프)
			i++;
		}
		// continue,break 문장은 자신의 반복문에서만 제어 
		/*
		 * 	for(int i=1;i<=3;i++)
		 * 	{
		 * 		for(int j=1;j>=3;j++)
		 * 		{
		 * 			if(j==2) break; => j가 있는 for문만 종료 
		 * 		}
		 * 	}
		 */
	}

}
