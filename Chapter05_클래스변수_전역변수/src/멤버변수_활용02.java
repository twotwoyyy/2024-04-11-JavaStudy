/*
 *	달력 만들기
 *	1. 년도/월 year/month
 *	2. 요일 year/month/week
 *	3. 출력 year/month/week
 *	
 */ 
// 멤버 변수 없이 메소드만 가지고 처리 => 리턴형/매개변수 많이 필요할 것 
import java.util.Calendar;
import java.util.Scanner;
public class 멤버변수_활용02 {
	//입력
	static int year,month,day,week;
	static int input(String msg) {
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		return scan.nextInt();
	}
	static int getWeek() {
		Calendar cal= Calendar.getInstance();
		cal.set(Calendar.YEAR,year);
		cal.set(Calendar.YEAR,month-1);
		cal.set(Calendar.DATE,day);
		
		int week=cal.get(Calendar.DAY_OF_WEEK);
		return week; // 지역변수는 return값을 넘겨주어야 한다 
	}

	static void print() {
		String[] strWeek= {"","일","월","화","수","목","금","토"};
		System.out.printf("%d년도 %d월 %d일 %s요일입니다\n",
				year,month,day,strWeek[week-1]);
	}
	
	public static void main(String[] args) {
		year=input("년도");
		month=input("월");
		day=input("일");
		week=getWeek();
		print();
	}
}
