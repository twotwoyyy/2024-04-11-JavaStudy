//88page
/*
 * 	1. 배열
 * 	   기능별로 묶는다
 * 	   ----------
 * 	 예) 3명의 학생 국,영,수,총점,평균 
 *               3 3 3  3   3
 *            배열  
 *       int kor1,kor2, kor3
 *       int[] kor
 *       int[] eng
 *       itn[] math
 *       int[[ total
 *       int[] total
 *       double[] avg
 *       ------------
 *       => int[3][5] socer
 */
import java.util.Scanner;
public class 배열_04 {

	public static void main(String[] args) {	
		// TODO Auto-generated method stub



		Scanner scan=new Scanner(System.in);
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		int[] total=new int[3];
		double[] avg=new double[3];
		char[] score=new char[3];
		
		for(int i=0;i<3;i++)
		{
			System.out.println((i+1)+"번째 국어 점수 입력:");
			kor[i]=scan.nextInt();
			System.out.println((i+1)+"번째 영어 점수 입력:");
			eng[i]=scan.nextInt();
			System.out.println((i+1)+"번째 수학 점수 입력:");
			math[i]=scan.nextInt();
			
			total[i]=kor[i]+eng[i]+math[i];
			avg[i]=total[i]/3.0;
			
			switch(total[i]/30)
			{
			case 10: case 9:
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
		for(int i=0;i<3;i++)
		{
			System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c\n",
					kor[i],eng[i],math[i],total[i],avg[i],score[i]);
		}

	}
}