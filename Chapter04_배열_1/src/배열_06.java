// 배열 편리성 => 데이터 관리 (여러개를 모아서 관리 ) => 고정성 , 같은 데이터형만 모아서 사용 
import java.util.Scanner;
public class 배열_06 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com=(int)(Math.random()*3);
		Scanner scan=new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2):");
		int user=scan.nextInt();
		//             0     1    2
		String[] res={"가위","바위","보"};
		System.out.println("컴퓨터:"+res[com]);
		System.out.println("사용자:"+res[user]);
		
		//확인
		
//		if(com==0)
//			System.out.println("컴퓨터:가위");
//		else if(com==1)
//			System.out.println("컴퓨터:바위");
//		else if(com==2)
//			System.out.println("컴퓨터:보");
//		
//		if(user==0)
//			System.out.println("사용지:가위");
//		else if(user==1)
//			System.out.println("사용자:바위");
//		else if(user==2)
//			System.out.println("사용자:보");
//		else 
//			System.out.println("잘못된 입력!!");
	}

}
