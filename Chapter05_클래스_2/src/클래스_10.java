/*
 * 	static / instance 변수의 차이점!!
 *  ------   --------
 *           | new 사용시마다 메모리 공간이 따로 생성
 *  | 메모리 공간은 1개 생성 => 모든 객체가 종료
 */
class Member{
	 String name;
	 String address;
}
class MemberSystem{
	// 공유
	// 데이터가 공통으로 사용이 될 때 => 크롤링, 파일 읽은 데이터 => 오라클에 저장된 데이터는 기본적으로 static 
	static Member[] members=new Member[3]; // 배열은 객체 생성하는 부분이 아니라 저장할 공간만 만들어준다 
	/*
	 * static Member[] members=new Member[3]; => null,null,null/ 메모리 주소가 없는 상태
	 * int[] arr=new int[3] => 0,0,0
	 * 
	 * 각각 저장하는 변수 => 멤버변수 (인스턴스) => new 개수만큼 만들어진다
	 *     => 학생 정보, 영화 정보, 맛집 정보  
	 * 공유 (한 개만 저장) => 정적변수 (공유변수) => static : 메모리 공간이 한 개만 만들어진다
	 *     => 데이터집합 , 게시판 , 회원가입 ...  
	 */
	int index=0;
}
public class 클래스_10 {

	public static void main(String[] args) {
		MemberSystem ms1=new MemberSystem();
		ms1.members[ms1.index]=new Member();
		ms1.members[ms1.index].name="홍길동";
		ms1.members[ms1.index].address="서울";
		ms1.index++;
		ms1.members[ms1.index]=new Member();
		ms1.members[ms1.index].name="심청이";
		ms1.members[ms1.index].address="경기";
		ms1.index++;
		ms1.members[ms1.index]=new Member();
		ms1.members[ms1.index].name="박문수";
		ms1.members[ms1.index].address="인천";
		
		for(Member m:ms1.members) {
			System.out.println(m.name+","+m.address);
		}
		MemberSystem ms2=new MemberSystem();
		for(Member m:ms2.members) {
			System.out.println(m.name+","+m.address);
		}
	}

}
