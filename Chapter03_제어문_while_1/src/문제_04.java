/*
 * 4.	1에서 50까지의 합을 더하는 while 문이다. 빈칸에 적절한 코드를 삽입하라.
 */
// continue => 제외하고 다시 수행 (반복문에서만 사용)
// break => 종료 (반복문/선택문에서 사용)
// 
public class 문제_04 {


		public static void main(String[] args) {
			int sum=0,i=1;
			while (true) {
			    if(i>50) break;
			    sum+=i;
			    i++;  
			} 
			System.out.println("1에서 50까지의 합:"+sum);
		}

	}

