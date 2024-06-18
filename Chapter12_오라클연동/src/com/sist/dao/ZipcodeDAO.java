package com.sist.dao;
// => 기능 : 오라클 연결 => 사용자 요청에 맞는 데이터 찾아오기 
import java.util.*; // ArrayList
import java.sql.*; // 오라클 연결 라이브러리
public class ZipcodeDAO {
	// 오라클 연결 클래스 
	private Connection conn;
	// SQL 전송하는 클래스 (결과값 받기)
	private PreparedStatement ps; // SQL 전송 => 결과값 읽기
	/*
	 *	localhost => 본인 컴퓨터 / 외부 : IP이용
	 *  PORT: 1521(오라클) 1433(MS-SQL), 3306(MySQL,MariaDB)
	 *  XE : table 저장된 데이터베이스 => ORCL / ORA
	 */
	// 오라클 연결 => URL (오라클 주소)         thin : 연결만 하는 드라이버
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	// 1. 드라이버 등록 => 한번만 등록 => 생성자 
	public ZipcodeDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {}
	}
	// 2. 오라클 연결
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy"); // conn hr/happy
		}catch(Exception ex) {}
	}
	// 3. 오라클 연결 해제
	public void disConnection() {
		try {
			if(ps!=null) ps.close(); // 통신중단
			if(conn!=null) conn.close(); // conn(전화기) 닫기
		}catch(Exception ex) {}
	}
	// 4. 기능 설정
	// => 우편 검색 / 주민번호 검색 개수
	public ArrayList<ZipcodeVO> postFind(String dong){
		ArrayList<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
		try {
			//오라클 연결 => 값을 읽기
			//1. 오라클 연결
			getConnection();
			//2. SQL 문장 
			String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
					+ "FROM zipcode "
					+ "WHERE dong LIKE '%'||?||'%'";
			       // WHERE dong LIKE CONCAT('%',?,'%') => MySQL/MariaDB
			       // NVL => ISNULL
			ps=conn.prepareStatement(sql); // 미리 SQL 문장을 전송하고 나중에 값을 채워준다
			//                                                   ------- ? 
			ps.setString(1, dong); // ?의 값을 채워 실행 요청
			// 오라클에 실행 요청 => 결과값 메모리에 저장 => ResultSet
			ResultSet rs=ps.executeQuery(); // 쿼리 문장을 rs에 넣어달라
			// 메모리 => 커서의 위치가 마지막에 존재 => 첫 쨰줄에 이동 => next() 
			while(rs.next()) { // 첫번째부터 읽기(커서위치 맨위)
				ZipcodeVO vo=new ZipcodeVO();
				vo.setZipcode(rs.getString(1));
				vo.setSido(rs.getString(2));
				vo.setGugun(rs.getString(3));
				vo.setDong(rs.getString(4));
				vo.setBunji(rs.getString(5));
				list.add(vo);
			}
			rs.close(); // 메모리 닫기
		}catch(Exception ex) {
			ex.printStackTrace(); // 에러 확인
		}finally {
			//닫기
			disConnection();
		}
		return list;
	}
	

}
