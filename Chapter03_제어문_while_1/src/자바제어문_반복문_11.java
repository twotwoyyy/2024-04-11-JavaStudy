/*
 *	while : 선조건 => 한번도 수행 못할 수도 있다
 *	
 *	do~while => 75page
 *			후조건 => 무조건 한번은 수행
 *
 *	초기값
 *	while(조건식)
 *	{
 *		반복 수행문장
 *		증가식
 *	}
 *
 *	int i=10;
 *	while(i<=5) => 시작과 동시에 false => 종료 
 *	{
 *	}
 *	-------------while은 조건이 맞지 않아 수행을 못한다
 *	int i=10; ---------1
 *	do
 *	{
 *		반복 수행 문장-----2
 *		증가식-----------3
 *	} while(i<=5) ------4 ==> 나중에 조건 검색 => 따라서 한번이상 반드시 수행
 *	
 *	while을 보완하기 위헤 do~while => c/c++에서 많이 사용
 *	=> 자바에서 사용빈도가 거의 없다 
 *
 */
public class 자바제어문_반복문_11 {

	public static void main(String[] args) {
		int i=1;
		System.out.println("=====for=====");
		for(i=1;i<=10;i++)
			System.out.print(i+" ");
		// i=11
		System.out.println("\n=====while=====");
		i=1;
		while(i<=10)
		{
			System.out.print(i+" ");
			i++;
		}
		
		System.out.println("\n=====do~while=====");
		i=1;
		do
		{
			System.out.print(i+" ");
			i++;
		}while(i<=10);
	}

}
