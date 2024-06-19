package com.sist.dao;
/*
 * DQL / DML 수행 => DDL/DCL/TCL 은 오라클에서 작업 
 *                         ----- 오라클 명령어로 사용하는 것이 아니다 => 메소드 commit(), rollback() 
 *                         | 설정이 없으면 Autocommit () 
 *   => 프로그램 : 데이터 관리 CRUD (SELECT / INSERT / UPDATE / DELETE) => 핵심 : 게시판 
 *   
 *   1. DQL : 데이터 검색 (SELECT) 
 *      자바 =======> 오라클 
 *           SQL문장 
 *           ------> 오라클 문법에 맞춘다 
 *      SELECT 
 *      ------
 *       형식) SELECT * | column1, column2.. 
 *            FROM table_name | view_name | ( SELECT ~ )
 *                                           ----------
 *                                          1. 페이지 나누기 
 *                                          2. 인기 순위 
 *                                          ------------- rownum (가상컬럼 => INSERT마다 번호를 자동지정)
 *                                                        => 1번부터 => 인라인뷰 
 *           [ 
 *             WHERE 조건문 (연산자) => 컬럼(함수) 연산자 값 
 *                                               -- 직접대입, 사용자 입력값, (SELECT ~)<=뷰
 *             GROUP BY 그룹컬럼(함수) => 관리자 계정 => 통계..(지정된 그룹별로 따로) 
 *             HAVING 그룹 조건 => 반드시 GROUP BY를 동반 
 *                    ------ 
 *                    집합함수 (COUNT, AVG, SUM..)
 *             ORDER BY 컬럼(함수) ASC | DESC => 처리하는 속도가 느림 => INDEX로 대처 
 *           ]
 *       => 형식 : 화면 설계 2. 연산자 (조건에 맞는 데이터 추출) 3. 내장함수 4. 정렬 => 최신 데이터를 먼저 출력 => DESC
 *   2. DML : 데이터 조작 언어
 *     INSERT : 데이터 저장 
 *      => 형식) 
 *          1) 컬럼 전체에 값을 저장
 *             INSERT INTO table_name VALUES(값..)
 *                                          ------
 *                                          숫자 : 10,20,30..
 *                                          문자 : ''
 *                                          날짜 : SYSDATE(현재), 'YY/MM/DD'
 *          2) 원하는 컬럼에만 값 저장
 *             INSERT INTO tabla_name(컬럼명,컬럼명..) VALUES (값...)
 *             => 컬럼에 NULL값 허용 / DEFAULT가 있는 경우  
 *     UPDATE : 데이터 수정
 *      => 형식)
 *            UPDATE table_name SET
 *            컬럼명=값, 컬렴명=값 ...
 *            [WHERE 조건문]
 *     DELETE : 데이터 삭제
 *      => 형식)
 *            DELETE FROM table_name
 *            [WHERE 조건문]
 *     
 *     = 주의점
 *       문자열 => " " 
 *       ----------- 1. 공백 2. ' ' 3. ;를 사용하면 오류 
 *       ----------- AutoCommit() 잘못된 데이터가 저장 => 복구할 수 없다 
 *     
 */
// 1. 목록 출력 : 번호 / 제목 / 이름 / 작성일 / 조회수 
/*
 *   게시판 ==> 흐름 (웹 : 로직 x), 데이터베이스 연동 => 이동 
 *                 목록                          상세보기
 *                  |                             |
 *          ----------------             -------------------    
 *          |              |             |        |        |
 *         글쓰기         상세보기 =>이동    수정하기    삭제하기   목록이동 => 목록 이동
 *          |                            |        |   
 *        완료 => 목록                  완료 => 상세  완료 => 목록
 */
import java.util.*;

import javax.imageio.plugins.tiff.GeoTIFFTagSet;

import java.sql.*;
public class BoardDAO {
	// 오라클 연결 객체
	private Connection conn; // Socket 
	// 오라클 송수신 => Socket / OutputStream, BufferedReader => Network
	private PreparedStatement ps;
	// 오라클 주소 => 상수형 
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE"; // xe=> 테이블이 저장된 데이터베이스(폴더)
	// 객체 한번만 생성 => 싱글턴 => 반드시 static
	private static BoardDAO dao;
	// 드라이버 등록 = 오라클 연결 = SQL 문장 전송 = 결과값 읽기 = 데이터 모아서 윈도우로 전송 
	public BoardDAO() {
		// 시작과 동시에 수행 문장, 멤버변수 초기화 ...
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 오라클 연결 
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
			// 오라클로 명령 => conn hr/happy 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	/*
	 *  Connection 
	 *  PreparedStatement
	 *  ResultSet
	 *  
	 *  여는 순서랑 반대로 닫는다
	 *  ResultSet.close
	 *  PreparedStatement
	 *  Connection
	 */
	// 오라클 해제
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	// 싱글턴 
	public static BoardDAO newInstance() {
		if(dao==null)
			dao=new BoardDAO();
		return dao;
	}
	////////////////////// 공통 기반 => 웹 (클래스 => jar) => 라이브러리화 
	// 기능 => 리턴형 (어떤 데이터를 보내줄지), 매개변수 (사용자로부터 어떤 값을 받을지)
	// 1. 목록 출력 => 페이지 나누기 (인라인뷰) 
	// VO => 한 개의 게시물 정보 => 묶는다 => 컬렉션, 배열을 이용해서 여러 개를 묶어 전송 
			/*
			 *   Collection 
			 *                Collection 
			 *                    |
			 *       ------------------------------
			 *       |             |              |
			 *      List          Set            Map
			 *       |             |              |
			 *    ArrayList      HashSet        HashMap
			 *    ---------     ---------      ---------
			 *    데이터 모아 저장   웹 실시간 채팅     클래스/sql문장 관리
			 *    순서 존재 (인덱스) 순서x/중복x      키,값 : 동시에 저장
			 *    비동기 방식                     키 중복 x 값 중복 o
			 *    순서 order by써야함
			 */
	public List<BoardVO> boardListData(int page){
		// 리턴형 => return
		List<BoardVO> list=new ArrayList<BoardVO>(); // vo(게시물 1개) => VO 여러 개를 보내준다
		try {
			// 1. 연결 
			getConnection();
			// 2. 오라클로 보낼 SQL 문장
			String sql="SELECT no,subject,name,regdate,hit,num "
					+"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					+"FROM (SELECT no,subject,name,regdate,hit "
					+"FROM board ORDER BY no DESC)) "
					+"WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql); // 먼저 전송
			// 실행 요청전 ?에 값 채우기
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			// 실행
			ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   BoardVO vo=new BoardVO();
				   vo.setNo(rs.getInt(1));
				   vo.setSubject(rs.getString(2));
				   vo.setName(rs.getString(3));
				   vo.setRegdate(rs.getDate(4));
				   vo.setHit(rs.getInt(5));
				   list.add(vo);
			   }
			   rs.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			// 닫기
			disConnection();
		}
		return list;
	}
	// 1-1 총페이지 구하기 
	public int boardTotalPage() {
		int total=0;
		try {
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/10.0) FROM board";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return total;
	}
	// SELECT외는 오라클 자체에서 처리 => 결과값이 없다 
	// 2. 글쓰기 기능 => 시퀀스 사용법 (결과값 없으니 void) 
	// 매개변수는 특별한 경우 외에는 3개이상 추과시 반드시 배열, 클래스 객체 이용  
	public void boardInsert(BoardVO vo) {
		try {
			// 1. 연결
			getConnection();
			// 2. sql
			String sql="INSERT INTO board(no,name,subject,content,pwd) "
					  +"VALUES(board_no_seq.nextval,?,?,?,?)";
			// 3. 전송
			ps=conn.prepareStatement(sql);
			// 4. 실행 요청
			// ?에 값을 채운다 
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			
			ps.executeUpdate();
			/*
			 *  executeQuery() => 결과값이 있다 => SELECT 
			 *  executeUpdate() => 결과값이 없다 => commit() => INSERT/UPDATE/DELETE
			 */
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
	   // 3. 상세보기 => WHERE => 조회수 증가 / 데이터 읽기 
	   public BoardVO boardDetailData(int no)
	   {
		   // 한개의 게시물에 대한 구분자 => no
		   BoardVO vo=new BoardVO();
		   try
		   {
			   getConnection();
			   String sql="UPDATE board SET "
					     +"hit=hit+1 "
					     +"WHERE no=?"; // 조회수 증가 
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ps.executeUpdate();
			   
			   // 데이터 읽기 
			   sql="SELECT no,name,subject,content,regdate,hit "
				  +"FROM board "
				  +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setContent(rs.getString(4));
			   vo.setRegdate(rs.getDate(5));
			   vo.setHit(rs.getInt(6));
			   rs.close();
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return vo;
	   }
	   // 4. 수정 => 비밀번호 체크 => 비밀번호 체크 / 실제 수정  => 묻고답하기 : SQL(5)
	   // 4-1 기존의 데이터 읽기 
	   public BoardVO boardUpdateData(int no)
	   {
		   // 한개의 게시물에 대한 구분자 => no
		   BoardVO vo=new BoardVO();
		   try
		   {
			   getConnection();
			   String sql="SELECT no,name,subject,content "
				  +"FROM board "
				  +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   vo.setNo(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setSubject(rs.getString(3));
			   vo.setContent(rs.getString(4));
			   rs.close();
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return vo;
	   }
	   // 체크 => boolean => pwd,no 
	   // 목록 => List => page
	   // 상세보기 => VO => primary key
	   // 찾기 => List => 검색어 
	   // 추가 => void => VO
	   // 4-2 실제 수정 
	   // SQL문장 사용법 
	   public boolean boardUpdate(BoardVO vo)
	   {
		   boolean bCheck=false;
		   try
		   {
			   getConnection();
			   //1. 비밀번호 체크 
			   String sql="SELECT pwd FROM board "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, vo.getNo());
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   rs.close();
			   
			   // 확인 
			   if(db_pwd.equals(vo.getPwd()))
			   {
				   bCheck=true;
				   // 데이터베이스 수정 
				   sql="UPDATE board SET "
				      +"name=? , subject=? , content=? "
					  +"WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   // ?에 값을 채운다 => 실행 => commit() 자동 실행된다 
				   ps.setString(1, vo.getName());
				   ps.setString(2, vo.getSubject());
				   ps.setString(3, vo.getContent());
				   ps.setInt(4, vo.getNo());
				   
				   ps.executeUpdate();
			   }
			   else
			   {
				   bCheck=false;
			   }
			   
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return bCheck;
	   }
	   // 5. 삭제 => 비밀번호 체크 => 비밀번호 체크 / 실제 삭제  => 묻고답하기 : SQL(7)
	   public boolean boardDelete(int no, String pwd)
	   {
		   boolean bCheck=false;
		   try
		   {
			   getConnection();
			   String sql="SELECT pwd FROM board "
					     +"WHERE no=?";
			   ps=conn.prepareStatement(sql);
			   ps.setInt(1, no);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   rs.close();
			   
			   if(db_pwd.equals(pwd))
			   {
				   bCheck=true;
				   // 실제 삭제
				   sql="DELETE FROM board "
					  +"WHERE no=?";
				   ps=conn.prepareStatement(sql);
				   ps.setInt(1, no);
				   ps.executeUpdate();
			   }
			   else
			   {
				   bCheck=false;
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return bCheck;
	   }
	   // 기능 수행을 위해서는  SQL문장이 1개가 아닐 수 있다 => 여러개의 SQL문장을 사용할 수 있다 
	}

