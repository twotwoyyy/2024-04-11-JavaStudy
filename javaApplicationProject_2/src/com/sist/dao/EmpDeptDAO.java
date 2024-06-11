package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDeptDAO {
	   private Connection conn;
	   private PreparedStatement ps;
	   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	   private static EmpDeptDAO dao; // 싱글턴 
	   
	   // 1. 드라이버 등록 
	   public EmpDeptDAO()
	   {
		   try
		   {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }catch(Exception ex) {}
	   }
	   // 2. 오라클 연결 
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,"hr","happy");
			   // conn hr/happy
		   }catch(Exception ex) {}
	   }
	   // 3. 오라클 해제 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   // 4. 싱글턴 => 한사람당 한개의 DAO만 사용할수 있게 만든다 => 메모리 누수현상을 제거 
	   public static EmpDeptDAO newInstance()
	   {
		   if(dao==null)
			   dao=new EmpDeptDAO();
		   return dao;// null이 아니면 기존에 저장된 dao를 전송 
	   }
	   // 기능 설정 
	   // 1. emp,dept 데이터 출력 (웹 , 윈도우) => DAO 변경이 없다 => React / Vue / Ajax 
	   // 2. DAO / VO는 변경 사항이 없다 
	   // SQL은 검색언어 => SELECT 
	   // 1. 오라클을 배우는 목적 => 자바에서 사용이 가능 => 2주 
	   public ArrayList<EmpVO> empListData()
	   {
		   ArrayList<EmpVO> list=new ArrayList<EmpVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT  "
					     +"FROM emp,dept "
					     +"WHERE emp.deptno=dept.deptno";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   EmpVO vo=new EmpVO();
				   vo.setEmpno(rs.getInt(1));
				   vo.setEname(rs.getString(2));
				   vo.setJob(rs.getString(3));
				   vo.setHiredate(rs.getDate(4));
				   vo.getDvo().setDname(rs.getString(5));
				   vo.getDvo().setLoc(rs.getString(6));
				   
				   list.add(vo);
			   }
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
}