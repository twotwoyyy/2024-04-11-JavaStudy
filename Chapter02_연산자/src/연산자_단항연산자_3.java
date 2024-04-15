/*
 * 		형변환 연산자
 * 		-----------(데이터형) => boolean은 제외
 *           |
 *        Upcasting => 데이터형을 크게 만든다
 *        Downcasting => 데이터형을 낮게 만든다
 *        
 *        ====================> Upcasting
 *        byte < char < int < long < float < double
 *        <==================== Downcasting
 *        
 *        예) 
 *        	'A' => char
 *          (int)'A' => int => 65
 *         ===> Upcasting 
 *         
 *          10.5 => double
 *          (int)10.5 => int => 10
 *         ===> Downcasting
 *         
 */
public class 연산자_단항연산자_3 {

	public static void main(String[] args) {
		// 형변환 (데이터형) => (int), (double), (char) ...
		System.out.println('A');
		System.out.println((int)'A');
		
		System.out.println(98);
		System.out.println((char)98);
		
		System.out.println(10.5);
		System.out.println((int)10.5);
		
		/*
		 * 	10.5+10.5 ==> 21.0
		 *  (int)(10.5+10.5) => 21
		 *  (int)10.5+(int)10.5 => 20
		 *  
		 *  double d=123456.78
		 *  int i=123456
		 *  (int)((d-i)*100) => 77 
		 *  *왜냐하면 77.999999에서 반올림해서 78로 한 것이기 때문
		 *  bit가 달라서..
		 *  
		 *  float d=123456.78F
		 *  int i=123456
		 *  system.out.println((int))((d-1))*100)); = 78 bit가 맞기 떄문
		 *  0.0 and less than 1.0 => 0.99
		 */
		int rand=(int)(Math.random()*100)+1;
	//                ------------
    //                    0.0~0.99 => 난수 1
    //                           0.0~99.0 => *100
	//           0~99 => int변환
    //                                   1~100 => +1
		System.out.println("rand="+rand);
		

	}

}
