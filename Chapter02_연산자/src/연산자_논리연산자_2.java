// 점수 >=60 <=100 -> true (60~100)

public class 연산자_논리연산자_2 {

	public static void main(String[] args) {
		int score=(int)(Math.random()*100)+1; //1~100 난수 발생
		System.out.println("난수값:"+score);
		
		boolean bCheck=(score>=60) && (score%2==0); // %2 짝수조건
		System.out.println("(score>=60) && (score%2==0) "+bCheck);
		// score가 40이상 score가 홀수면 
		// 위에 boolean으로 처리가 됐기 때문에 bCheck만 쓰면 된다 
		// 재사용시 변수만 사용
		bCheck=(score>=40) && (score%2==1); //score%2!=0 
		System.out.println("(score>=40) && (score%2==1) "+bCheck);
		
		int a=10;
		a++;
		a=100;
		a++;
		a=200;
		a++;
		a=300;
		a--;
		
		System.out.println(a);
	}

}
