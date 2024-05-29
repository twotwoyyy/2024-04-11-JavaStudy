package com.sist.sql;

import java.sql.*;

public class 라이브러리_01 {
	public static void main(String[] args) {
		try {
			// 1. 오라클 연결을 위한 드라이버 설치
			Class.forName("oracle.jdbc.driver.OracleDriver"); // 메모리 할당 => 리플렉션 => new 줄이기
			// 2. 오라클 연결
			String url="jdbc:oracle:thin:@localhost:1521:XE"; // localhost => IP
			// XE => 폴더 (데이터베이스) => 파일 저장 
			//           TABLE
			// 3. SQL 문장 전송
			Connection conn=DriverManager.getConnection(url,"hr","happy");
			// conn hr/happy, conn system/happy 
			String sql="SELECT empno,ename,job,sal FROM emp"; // 자동추가 
			PreparedStatement ps=conn.prepareStatement(sql);
			// 4. 실행 결과값 받기
			ResultSet rs=ps.executeQuery(); // 실행한 결과값을 가지고 온다
			while(rs.next()) { // next : 데이터가 없을때까지 밑으로 내려가서 읽어와라.
				System.out.println(rs.getInt(1)+" "
						+rs.getString(2)+" "
						+rs.getString(3)+" "
						+rs.getInt(4));
				
			}
			// 5. 브라우저 전송 => 도스에 출력 
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
