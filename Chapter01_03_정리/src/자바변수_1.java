/*
 * 	돈까스 : 8000
 *  칼국수 : 6000
 *  왕만두 : 5000
 *  ------------
 *  주문 돈까스 => 16인분 
 *      칼국수 => 8인분
 *      왕만두 => 1인분 
 *  --------------------- 총계산서를 출력하는 프로그램을 작성 
 */

public class 자바변수_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int 돈까스=8000;
		int 칼국수=6000;
		int 왕만두=5000;
		
		System.out.println("돈까스 16인분 "+돈까스*16+"\n칼국수 8인분 "+칼국수*8+"\n왕만두 1인분 "+왕만두*1);
		System.out.println("총 가격:"+(돈까스*16+칼국수*8+왕만두*1+"원"));
	}

}
