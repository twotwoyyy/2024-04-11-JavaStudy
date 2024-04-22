
public class 자바제어문_반복문_8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char c='A';
		//for에서 설정하는 변수는 for안에서만 가능하다 
		for(int i=1;i<=5;i++)
		{
			//char c='A'; // 밖으로 빼면 증가하기 때문에 ABCDE, 안에 넣으면 AAAAA
			// for=> 1: 생성 => 2: c삭제=> c다시 생성 
			System.out.print(c+" ");
			c++;
			// c변수는 여기까지만 사용이 가능 
		} // 여기부터 c변수는 사라짐 

	}

}
