import java.util.*;
public class 배열_08 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 년 월 일 입력 => 결과값 무슨 요일
		System.out.print("년도 입력:");
		int year=scan.nextInt();
		System.out.println("월 입력:");
		int month=scan.nextInt();
		System.out.println("일 입력:");
		int day=scan.nextInt();
		
		System.out.println("===== API 이용 =====");
		Calendar cal=Calendar.getInstance();
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, day);
		
		String[] strWeek={"","일","월","화","수","목","금","토"}; //cal.set은 week가 1부터 시작되기때문에 공백을 준다 
		int week=cal.get(Calendar.DAY_OF_WEEK);
		//System.out.println(week);
		System.out.println(year+"년도 "+month+"월 "+day+"일은 "+strWeek[week]+"요일입니다");
	}

}
