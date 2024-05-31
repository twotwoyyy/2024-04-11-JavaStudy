package com.sist.temp2;
import java.util.*;
import java.sql.*;

public class ZIPCODEDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static ZIPCODEDAO zipcode;

	public ZIPCODEDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
		}catch(Exception ex) {}
	}
	
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {}
	}
	
	public void disConnection () {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {}
	}

	public static ZIPCODEDAO newInstance() {
		if (zipcode == null) 
			zipcode = new ZIPCODEDAO();
		return zipcode;
	}


	public ArrayList<ZIPCODEVO> zipFind(String DONG){
		ArrayList<ZIPCODEVO> list=new ArrayList<ZIPCODEVO>();
		try {
			getConnection();
			String sql="SELECT ZIPCODE, SIDO, GUGUN, DONG, NVL(BUNJI,' ') FROM ZIPCODE WHERE DONG LIKE '%'||?||'%'";// toUpperCase 대문자 변경 유도 
			ps=conn.prepareStatement(sql);
			ps.setString(1, DONG);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				ZIPCODEVO vo = new ZIPCODEVO();
				vo.setZIPCODE(rs.getString(1));
				vo.setSIDO(rs.getString(2));
				vo.setGUGUN(rs.getString(3));
				vo.setDONG(rs.getString(4));
				vo.setBUNJI(rs.getString(5));
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


}
