package com.sist.dao;
import java.util.*;
import java.sql.*;
public class MemberDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   private static MemberDAO dao; // 싱글턴 
   
   // 1. 드라이버 등록 
   public MemberDAO()
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
   public static MemberDAO newInstance()
   {
	   if(dao==null)
		   dao=new MemberDAO();
	   return dao;// null이 아니면 기존에 저장된 dao를 전송 
   }
   ////////////////////////////// 모든 DAO에 공통 사항 
   // 기능 
   // 1. 로그인 처리 
   /*
    *   리턴형 => 경우의 수 
    *   = 사번이 없는 경우  => 0 => NOSABUN 
    *   = 사번은 존재 이름이 틀린경우 => 1 NONAME
    *   = 사번은 존재 , 이름도 동일 => 2 OK
    *   ------------------------ String / int 
    */
   public String memberLogin(String id,String pwd)
   {
	   String result="";
	   try
	   {
		   // 1. 연결 
		   getConnection();
		   // 2. SQL문장 
		   String sql="SELECT COUNT(*) FROM member "
				     +"WHERE id=?"; // 사번이 존재하는지 확인 => 0/1
		   // 3. 오라클로 SQL문장 전송 
		   ps=conn.prepareStatement(sql);
		   // ?에 값을 채운다 
		   ps.setString(1, id);
		   // 4. 결과값을 받는다 
		   ResultSet rs=ps.executeQuery();
		   rs.next();
		   int count=rs.getInt(1); // 0,1
		   rs.close();
		   if(count==0) // ID가 없는 경우 
		   {
			   result="NOID";
		   }
		   else // ID가 있는 경우 
		   {
			   sql="SELECT pwd FROM member "
				  +"WHERE id=?";
			   // 오라클로 전송 
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, id);
			   // 결과값 받기 
			   rs=ps.executeQuery();
			   rs.next();
			   String db_pwd=rs.getString(1);
			   rs.close();
			   
			   if(db_pwd.equals(pwd))// 로그인 
			   {
				   result="OK";
			   }
			   else // 이름이 없는 상태 
			   {
				   result="NOPWD";
			   }
		   }
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();// 오류 확인 => null , SQL문장 
	   }
	   finally
	   {
		   // 오라클 해제 
		   disConnection();
	   }
	   return result;
   }
   // 2. 회원가입 => 아이디 중복 체크 / 우편번호 검색 
   // 3. 회원수정
   // 4. 회원탈퇴 
   // => SQL문장 제작 => 웹도 가능 => DAO변경이 없다 
   // 5. 우편번호 검색 
   public ArrayList<ZipcodeVO> postFindData(String dong){
	   ArrayList<ZipcodeVO> list=new ArrayList<ZipcodeVO>();
	   try {
		   getConnection();
		   String sql="SELECT zipcode,sido,gugun,dong,NVL(bunji,' ') "
				   + "FROM zipcode "
				   + "WHERE dong LIKE '%'||?||'%'";
		   ps=conn.prepareStatement(sql);
		   ps.setString(1, dong);
		   ResultSet rs=ps.executeQuery();
		   while(rs.next()) {
			   ZipcodeVO vo=new ZipcodeVO();
			   vo.setZipcode(rs.getString(1));
			   vo.setSido(rs.getString(2));
			   vo.setGugun(rs.getString(3));
			   vo.setDong(rs.getString(4));
			   vo.setBunji(rs.getString(5));
			   list.add(vo);
		   }
		   rs.close();
	   }catch(Exception ex) {
		   
	   }finally {
		   disConnection();
	   }
	   return list;
   }
   
}