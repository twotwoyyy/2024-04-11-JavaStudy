/*
 * 13.정수를 10개 저장하는 배열을 만들고 1에서 10까지 범위의 정수를 랜덤하게 생성하여 
배열에 저장하라. 그리고 배열에 든 숫자들과 평균을 출력하라.
예) 랜덤한 정수들 : 3 6 3 6 1 3 8 9 6 9 
평균은 5.4
[Hint] 1에서 10까지 범위의 정수를 랜덤하게 생성할 때는 다음 코드를 이용하라.
int i  = (int)(Math.random()*10)+1;

 */
public class 문제_13 {

	public static void main(String[] args) {
		int sum=0;
        for(int i=1;i<=10;i++)
        {
        	int num=(int)(Math.random()*10)+1;
        	sum+=num;
        	System.out.print(num+" ");
        }
        System.out.println();
        System.out.printf("평균:%.2f",sum/10.0);

//		int sum=0;
//		int j=1;
//		while(j<=10)
//		{
//			///반복 문장=> 난수 발생 => 0,1 확인
//			int i = (int)(Math.random()*10)+1;
//			System.out.print(i+" ");
//			j++;;
//			sum+=i;
//		}
//		System.out.println();
//		System.out.print("평균:"+(sum)/10.0);

	}

}
