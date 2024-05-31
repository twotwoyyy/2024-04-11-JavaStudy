package com.sist.temp;
import java.util.*;
import java.sql.*;
public class EmpDAO {
	// 오라클 연결
	private Connection conn;
	// 오라클에 SQL 문장 전송
	private PreparedStatement ps;
	/* 
	 *  사용자 요청 ====> 자바 ====> 오라클 
	 *                            |
	 *                          SQL문장 실행
	 *     <========결과값 저장 ========
	 *   | 데이터 출력 (윈도우, 브라우저)
	 *              ------------- VO,DAO 변경이 없다 
	 */
	// 자바 12장 
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	// 싱글턴 => 한 개 객체만 사용할 수 있게 한다 => 오라클 연동할 때 싱글턴 사용 => Connection 남발 문제 때문에
	private static EmpDAO dao;
	/*
	 *   thin : 연결만 해주는 역할 => 무료 버전  
	 *   oci  : oracle client => 유료 버전 
	 *   
	 */
	// 1. 드라이버 등록 (한번만 등록) 
	public EmpDAO() { // 생성자
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Dbeaver, sqldeveloper 
		}catch(Exception ex) {}
	}
	// 2. 싱글턴 패턴 => 메모리 공간을 한 개만 사용 => static 
	 public static EmpDAO newInstance() {
	        if (dao == null) 
	            dao = new EmpDAO();
	            return dao;
	        
	}
	 // 3. 오라클 연결
	 public void getConnection() {
		 try {
			 conn=DriverManager.getConnection(URL,"hr","happy");
			 // conn hr/happy => 오라클 연결 
		 }catch(Exception ex) {}
	 }
	 // 4. 오라클 닫기
	 public void disConnection () {
		 try {
			 if(ps!=null) ps.close();
			 // 송수신 => 닫고
			 if(conn!=null) conn.close();
			 // exit
		 }catch(Exception ex) {}
	 }
	 // 5. 오라클에 요청
	 public ArrayList<EmpVO> empListData(){
		 ArrayList<EmpVO> list=new ArrayList<EmpVO>();
		 try {
			 // 1. 연결 
			 getConnection();
			 // 2. SQL문장 만들기
			 String sql="SELECT empno, ename, job, sal, deptno FROM emp";
			 // 3. 오라클로 전송
			 ps=conn.prepareStatement(sql);
			 // 4. 오라클에서 실행된 결과를 가져온다 ==> list에 첨부 
			 ResultSet rs=ps.executeQuery(); //enter
			 // 실행된 모든 데이터는 rs에 존재
			 /*         1    2                    3                        4         5
			       	 EMPNO ENAME                JOB                       SAL     DEPTNO
				---------- -------------------- ------------------ ---------- ----------
				      int  String               String                   int         int
				      7839 KING                 PRESIDENT                5000         10 : cursor => next()
				      7698 BLAKE                MANAGER                  2850         30
				      7782 CLARK                MANAGER                  2450         10
				      7566 JONES                MANAGER                  2975         20
				      7654 MARTIN               SALESMAN                 1250         30
				      7499 ALLEN                SALESMAN                 1600         30
				      7844 TURNER               SALESMAN                 1500         30
				      7900 JAMES                CLERK                     950         30
				      7521 WARD                 SALESMAN                 1250         30
				      7902 FORD                 ANALYST                  3000         20
				      7369 SMITH                CLERK                     800         20
				      7788 SCOTT                ANALYST                  3000         20
				      7876 ADAMS                CLERK                    1100         20
				      7934 MILLER               CLERK                    1300         10 : cursor => previous()
			  */
			 // ===> list에 첨부 
			 while(rs.next()) {
				 // Double => rs.getDouble (번호)
				 // Date => rs.getDate (번호)
				 EmpVO vo=new EmpVO();
				 vo.setEmpno(rs.getInt(1));
				 vo.setEname(rs.getString(2));
				 vo.setJob(rs.getString(3));
				 vo.setSal(rs.getInt(4));
				 vo.setDeptno(rs.getInt(5));
				 // 오라클은 0번이 없고 1번부터이다.
				 list.add(vo);
			 }
			 rs.close(); // 메모리 해제 
		 }catch(Exception ex) {
			 // 에러 확인
			 ex.printStackTrace();
		 }finally {
			 // 오라클 닫기
			 disConnection();
		 }
		 return list;
	 }
	 // 한명 VO, 여러개 List
	 public EmpVO empDetailData(int empno) {
		 EmpVO vo=new EmpVO();// 사원 한 명에 대한 정보를 가져오겠다는 뜻
		 try {
			 // 1. 오라클 연결
			 getConnection(); // 반복되는 부분이라 메소드를 만듦 => 반복 제거
			 /* 
			  * 메소드 : 전송
			  * ----- 브라우저/윈도우에서는 사용이 불가능 
			  * => 리턴형 / 매개변수 
			  *    ----
			  *    1. 목록 요청 => 여러 개 필요 => ArrayList
			  *    2. 맛집 1개 정보 => FoodVO => 구분자 (맛집 번호)  
			  *    3. 검색 => ArrayList 
			  *    
			  */
			// 2. SQL 문장 
			 String sql="SELECT empno, ename, job, sal, deptno FROM emp WHERE empno="+empno;
			// 3. 오라클 전송
			 ps=conn.prepareStatement(sql);
			// 4. 실행 결과 받아오기
			 ResultSet rs=ps.executeQuery();
			// 5. EmpVO에 값 채우기 
			 rs.next();
			 vo.setEmpno(rs.getInt(1));
			 vo.setEname(rs.getString(2));
			 vo.setJob(rs.getString(3));
			 vo.setSal(rs.getInt(4));
			 vo.setDeptno(rs.getInt(5));
			 rs.close();
			 
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }finally {
			 disConnection();
		 }return vo;
	 }
	 public ArrayList<EmpVO> empFind(String ename){
		 ArrayList<EmpVO> list=new ArrayList<EmpVO>();
		 try {
			 getConnection();
			 //String sql="SELECT empno, ename,job,sal,deptno FROM emp WHERE ename LIKE '%"+ename.toUpperCase()+"%'";// toUpperCase 대문자 변경 유도 
			 String sql="SELECT empno, ename,job,sal,deptno FROM emp WHERE ename LIKE ?";// toUpperCase 대문자 변경 유도 
			 // => 데이터는 대소문자를 구분한다 
			// 3. 오라클 전송
			 ps=conn.prepareStatement(sql);
			 // LIKE 절에 대소문자 구분을 없애기 위해 검색어를 대문자로 변경합니다.
			 ps.setString(1, "%" + ename.toUpperCase() + "%");
			// 4. 실행 결과 받아오기
			 ResultSet rs=ps.executeQuery();
				// 5. EmpVO에 값 채우기 
			 while (rs.next()) {
		            EmpVO vo = new EmpVO();
		            vo.setEmpno(rs.getInt("empno"));
		            vo.setEname(rs.getString("ename"));
		            vo.setJob(rs.getString("job"));
		            vo.setSal(rs.getInt("sal"));
		            vo.setDeptno(rs.getInt("deptno"));
		            list.add(vo);
		        }
		        rs.close();
		 }catch(Exception ex) {
			 ex.printStackTrace();
		 }finally {
			 disConnection();
		 }
		 return list;
	 }
	 // 문제 => 우편번호 검색 
	 /*
	  *  VO => desc 테이블명
	  *  메소드 제작
	  *  MainClass => 동을 입력 => 출력 
	  */
	 
	 // SELECT ZIPCODE, SIDO, GUGUN, DONG, BUNJI FROM ZIPCODE WHERE DONG LIKE ?
	 // ps.setString(1, "%" + DONG.toUpperCase() + "%");
	 // 
}