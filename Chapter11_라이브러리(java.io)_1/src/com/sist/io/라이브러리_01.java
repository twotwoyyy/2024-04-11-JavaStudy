package com.sist.io;
/*
 *   355page
 *   -------
 *   1. java.io : CheckedExceprtion을 가지고 있다 => 예외처리 반드시 해야한다
 *    = io : 입출력
 *     (inputStream / outputStream)
 *           |             |
 *         read()        write()
 *         읽기           쓰기
 *    = Stream : 데이터가 이동하는 통로
 *      FIFO => 먼저 들어간 값이 먼저 나오는 방식 => Queue
 *      
 *   2. File 
 *   3. FileInputStream / FileOutputStream
 *   4. FileReader / FileWriter
 *   5. BufferedReader / BufferdWriter
 *   6. BufferedInputStream / BufferOutputStream
 *   7. ObjectInputStream / ObjectOutputStream
 *   ---------------------------------------------
 *    InputStream / OutputStream : 읽기 / 쓰기 => 1byte씩 읽기를 한다 => 한글이 깨진다는 단점 
 *      => 업로드 / 다운로드
 *      => 바이트 스트림
 *    Reader / Writer : 읽기 / 쓰기 => 2byte씩 읽기 / 쓰기를 한다 => 한글이 정상적 작동
 *      => 파일 읽기 / 쓰기 (한글 포함)
 *      => 문자 스트림 
 *       ex) FileReader  
 *       
 *    1) 메모리에 저장 => 프로그램이 종료가 되면 모든 데이터가 사라진다 
 *       --------- 속도는 빠르다
 *       | 영구적으로 저장하는 장치? File 
 *        File => 1. 데이터 노출 2. 잊어버릴 가능성(삭제) 3. 관련된 데이터를 따로 저장해 처리 어려움 
                  4. 구분자가 없다 **** => 배열에 저장, ArrayList에 저장해서 사용 
                  --------------------------------------------------------------
                  => 이를 보완 : RDBMS (관계형 데이터베이스) => 오라클 
                     1. 노출 x 2. 지워지지 않음 3. 구분자 사용 등...
                     다만, 업로드/다운로드 불가
                     추천 => 카페/블로그에서 읽은 데이터를 파일에 저장한 후에 분석, 분석된 데이터를 오라클로 전송 
                     따라서 파일은 임시 저장 용도로 자주 쓰인다 
     2) 파일의 정보 => 376page => 파일 입출력 / 378page에 나오는 메소드 잘 보기 !! 
        --------
 *      File : 파일, 폴더 정보를 가지고 있다
 *      ----------------------------
 *      File 정보와 관련된 메소드 
 *      File 생성자
 *      ---------
 *       File file=new File("경로명/파일명") => 파일에 대한 정보를 가지고 온다
 *       File dir=new File("경로명") => 폴더에 대한 정보를 가지고 온다 
 *       01) 파일명 읽기 *** => getName():String(리턴형)
 *       02) 경로명 읽기 => getParent():String
 *       03) 파일명+경로명 *** => getPath():String
 *       04) 파일 크기 *** => length():long
 *       05) 숨긴 파일 여부 => isHidden():boolean
 *       06) 읽기 기능 여부 => canRead():boolean
 *       07) 쓰기 기능 여부 => canWrite():boolean
 *       08) 수정일 => lastModified():long
 *       09) 파일 정보를 한번에 읽기 (폴더) *** => listFiles():File[]
 *       10) 파일 여부 확인 => isFile():boolean
 *       11) 폴더 여부 확인 => isDirectory():boolean
 *       
 *      File 제어하는 메소드 *** 
 *       01) 폴더 생성 : mkdir()
 *       02) 파일 생성 : creatNewFile()
 *       03) 파일 삭제 : delete()
 *       04) 파일 존재 여부 : exists() 
 *      ---------------------- 파일 입출력 / 파일 복사 / 속도의 최적화 
 *
 *       
 */
import java.io.*;
import java.text.*;
import java.util.*;
public class 라이브러리_01 {

	public static void main(String[] args) {
		File file=new File("C:\\javaDev\\melon.txt");
		System.out.println("파일명:"+file.getName());
		System.out.println("경로명:"+file.getParentFile());
		System.out.println("파일+경로명:"+file.getPath());
		System.out.println("숨긴 파일:"+file.isHidden());
		System.out.println("읽기 전용:"+file.canRead());
		System.out.println("쓰기 전용:"+file.canWrite());
		System.out.println("파일 여부:"+file.isFile());
		//long형이라서 수정, new SimpleDateFormat!! 
		System.out.println("수정일:"+new SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
				                      .format(new Date(file.lastModified()))); 
		System.out.println("파일 크기:"+file.length());
	}

}
