/*
 *	int i=1
 *	while(i<=5)
 *	{
 *		System.out.println(i);
 *	i++;
 *	}
 *
 *	i=1 => i<=5 => 1=> i++
 *	i=2 => i<=5 => 2=> i++
 *	i=3 => i<=5 => 3=> i++
 *	i=4 => i<=5 => 4=> i++
 *	i=5 => i<=5 => 5=> i++
 *	i=6 => i<=5(false) => while 종료 
 *----------------------------------
 *						조건 검색 후에 증가
 *
 *
 *	int i=1;
 *  do
 *  {
 *  	System.out.println(i);
 *  	i++;
 *  } while(i<=5)
 *  
 *  i=1 => i => i++(2) => i<=5
 *             --------------false로 종료
 *             증가 후에 조건검색
 *  i=2 => i => i++(3) => i<=5
 *  i=3 => i => i++(4) => i<=5
 *  i=4 => i => i++(5) => i<=5
 *  i=5 => i => i++(6) => i<=5 
 *             ---------------false로 종료
 *             
 *
 */
public class 자바제어문_반복문_12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
