package com.sist.main;
import java.sql.*;
public class MainClass {
	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url="jdbc:oracle:thin:@localhost:1521:XE";
		Connection conn=DriverManager.getConnection(url,"hr","happy");
		String sql="INSERT INTO card VALUES(2,'shim',20000)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps=conn.prepareStatement(sql);
		ps.executeUpdate();
		
		sql="INSERT INTO point VALUES(2,3,200)";
		ps=conn.prepareStatement(sql);
		ps.executeUpdate();
		ps.close();
		conn.close();
	}catch(Exception ex) {
		ex.printStackTrace();
	}
	}
}
