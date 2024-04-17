/*
 * 	단일 조건문 
 *	----------단점
 *	if(조건문)
 *	{
 *	}
 *	-------------
 **	if(조건문)
 *	{
 *	}
 *	-------------
 *	if(조건문)
 *	{
 *	}
 *	------------- 단일 조건문은 모두 독립문장 => 속도가 느리다 => 다중조건문으로 해결
 *
 *	=>***선택 조건문 => true/false => 나눠서 처리
 *	형식) 
 *		if(조건문)
 *		{
 *			조건이 true일 때 처리
 *		}
 *		else
 *		{		
 			조건이 false일 때 처리
 *		}
 *
 *		if(조건문)
 *		{
 *		{
 *		---------------단독
 *		if(조건문)
 *		{
 *		}
 *		else
 *		{
 *		}
 *		---------else는 바로 위 if 문장만 처리 
 *		
 */
//		1. 짝수=> num%2==0 / 홀수 => num%2!=0
/*
 * 		if
 * 		=> 정상 수행
 * 		else
 * 		=> 오류 => 입력 문제 
 * 		----------------
 * 		오류 발생
 * 		1) 프로그래머의 실수 => 어렵다 => 예외처리
 * 		2) 사용자 입력 => if~else 
 */
public class 제어문_조건문_3 {

	public static void main(String[] args) {
		int num=(int)(Math.random()*100)+1;
		System.out.println("num="+num);
		if(num%2==0)
		{ // true일 때 처리
			System.out.println(num+"은(는) 짝수입니다");
		}
		else
		{// false일 때 처리 
			System.out.println(num+"은(는) 홀수입니다");
		}
	}

}
