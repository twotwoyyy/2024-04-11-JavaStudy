package com.sist.main;

public class 예외처리_02 {

	public static void main(String[] args) {
		// try ~ catch 수행 (웹에서 필수 => 네트워크와 관련) , 오라클 연동 ... 
		// 웹, 파일, 오라클 => 예외처리는 문법사항 (반드시 추가헤야 한다)
		/*
		 *	파일을 읽어서 데이터를 출력 => 코딩 테스트 => 0점 처리 
		 *  FileReader fr=new FileReader("경로명")
		 *  int i=0;
		 *  while((i=fr.read())!=-){
		 *    system.out.print((char)i);
		 *  }
		 *  fr.close()
		 *  } catch(IOException e)
		 */
		try {
			System.out.println("문장 1");
			System.out.println("문장 2");
			System.out.println("문장 3");
			int[] arr=new int[2];
			System.out.println(arr[2]);
			System.out.println(10/0); // 에러 발생 
			////// 에러 아래 문장은 처리하지 않고 건너뛴다!! 
			System.out.println("문장 4");
			System.out.println("문장 5");
		}
		catch (RuntimeException e) { // 상위클래스 예외처리를 써서 오류 처리를 한다 
			System.out.println("에러 발생 => 복구");
		}
		System.out.println("문장 6");
		System.out.println("문장 7");
		System.out.println("프로그램 종료");
	}

}
