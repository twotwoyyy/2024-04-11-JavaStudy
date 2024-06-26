package com.sist.main;
import java.sql.*;
/*
 *   INSERT / UPDATE / DELETE가 여러 개 동시에 수행 되는 경우 
 *   ======================== 일괄처리 (정상 수행시 처리, 한 개라도 비정상 수행시 전체 취소) => 트랜잭션
 *   
 */
public class MainClass_2 {

    public static void main(String[] args) {
        Connection conn = null; // Connection 객체 초기화
        PreparedStatement ps = null; // PreparedStatement 객체 초기화
        String url = "jdbc:oracle:thin:@localhost:1521:XE"; // Oracle 데이터베이스 접속 URL

        try {
            // 1. Oracle JDBC 드라이버를 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. Oracle 데이터베이스에 연결
            conn = DriverManager.getConnection(url, "hr", "happy");
            
            // 3. 자동 커밋 기능을 해제하여 수동으로 트랜잭션을 관리
            conn.setAutoCommit(false);

            // 4. SQL 작업을 수행하는 PreparedStatement를 생성하고 실행하는 코드가 필요
    		String sql="INSERT INTO card VALUES(3,'park',20000)";
    		ps=conn.prepareStatement(sql);
    		ps=conn.prepareStatement(sql);
    		ps.executeUpdate();
    		
    		sql="INSERT INTO point VALUES(3,4,200)";
    		ps=conn.prepareStatement(sql);
    		ps.executeUpdate();
            // 5. SQL 작업이 성공적으로 수행되었다고 가정하고, 트랜잭션을 커밋
            conn.commit();

        } catch (Exception ex) {
            try {
                // 6. 예외가 발생하면 트랜잭션을 롤백합니다.
                if (conn != null)
                    conn.rollback();
            } catch (Exception e) {}
        } finally {
            try {
                // 7. 자원 해제: PreparedStatement와 Connection 닫기
                if (ps != null)
                    ps.close();
                if (conn != null)
                    conn.close();
            } catch (Exception ex) {}
        }
    }

}

