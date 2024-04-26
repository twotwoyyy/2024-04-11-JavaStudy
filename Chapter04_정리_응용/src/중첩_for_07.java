/*
 *	반복문 => 데이터베이스에서 데이터를 읽어 올 때 
 *		    파일 읽기 / HTML 화면 출력 
 *
 *	1) for / for-each / for 2차 
 *	   for : 반복문 => 횟수지정된 상태
 *			 형식)
 *						 | start----|false면 종료
 *                                   -------|
 *					for(초기화식;    조건식;   증가식)
 *                  {               |true   |
 *						 실행문장----- |--------
 *					}
 *					시작점 : 초기화
 *					조건식 : 범위 => 반복횟수
 *					------false가 나올 때까지 수행
 *					증가식 
 *			=> 무한루프 
 *				for(;;)
 *			=> for-each : 배열 출력, 컬렉션 출력
 *				==> 출력 전용
 *				형식) 
 *					for(배열에 저장된 데이터를 받을 변수: 배열)
 *						----------------------   --- 
 *						  |                       |
 *						  --------데이터형 일치--------
 *					=> 자바스크립트 : forEach,each,map
 *					   ---------- for-of
 *			=> 2차 for문의 형식
 *					  1     2 | false면 종료
 *				for(초기값 ; 조건식 ; 증가식) 
 *				{         | true
 *					실행문장 3
 *				 --------------------------
 *                              | false => 1차 for 증가식으로 이동 
 *					      1     2      3
 *					for(초기값 ; 조건식 ; 증가식)
 *					{           |true
 *						  실행문장 3
 *					}
 *				}
 *	2) while 
 */

// 3명의 국어 영어 수학 점수를 입력 받아서 총점 , 평균 , 학점 , 등수 비교 (2차 for)
import java.util.Scanner;
public class 중첩_for_07 {

	public static void main(String[] args) {
		String[] name=new String[3];
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		// 사용자 입력
		
		// 처리 결과값	
		int[] total=new int[3];
		double[] avg=new double[3];
		char[] score=new char[3];
		int[] rank=new int[3];
		// 용도별로 나눠서 저장
		// 1. 프로그램에 필요한 변수/배열 선언
		// 2. 사용자 입력 요청 
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<kor.length;i++) {
			System.out.println("이름 입력: ");
			name[i]=scan.next();
			System.out.print((i+1)+"번째 국어");
			kor[i]=scan.nextInt();
			System.out.print((i+1)+"번째 영어");
			eng[i]=scan.nextInt();
			System.out.print((i+1)+"번째 수학");
			math[i]=scan.nextInt();
			
			total[i]=kor[i]+eng[i]+math[i];
			avg[i]=total[i]/(double)kor.length;
			
			switch(total[i]/30) {
			case 10:
			case 9:
				score[i]='A';
				break;
			case 8:
				score[i]='B';
				break;
			case 7:
				score[i]='C';
				break;
			case 6:
				score[i]='D';
				break;
			default:
				score[i]='F';
			}
		}
		// 순위 결정 
		for(int i=0;i<kor.length;i++) {
			rank[i]=1;
			for(int j=0;j<kor.length;j++) {
				if(total[i]<total[j]) {
					rank[i]++;
				}
			}
		}
		// 3. 입력된 데이터를 처리 => 요청 처리 
		// 4. 처리된 데이터를 화면 출력 (사용자)
		for(int i=0;i<kor.length;i++) {
			System.out.printf("%-7s%-5d%-5d%-5d%-5d%-7.2f%-3c%-3d\n",
					name[i],kor[i],eng[i],math[i],total[i],avg[i],score[i],rank[i]);
		}
		/*
		 *  00000 00000 00000 00000 0000000 000
		 *
		 */
		// => 변수 선언 ==> 프로그램의 85%
	}

}
