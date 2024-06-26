package com.sist.dao;
import java.sql.*;
import java.util.*;
import oracle.jdbc.*;
public class StudentDAO {
   private Connection conn;
   private CallableStatement cs;
   /*
    *   CallableStatement : 프로시저 호출시에 사용 
    *     = SELECT , INSERT , UPDATE , DELETE => executeQuery()만 사용 
    *   PreparedStatement : 일반 SQL문장 전송 사용
    *     = executeQuery() => SELECT문장으로 실행 결과값을 가지고 올때 사용 
    *     = executeUpdate() => 오라클에 있는 데이터 변경 (INSERT,UPDATE,DELETE)
    *   
    */
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   private static StudentDAO dao; // 싱글턴 => 한개 메모리에 생성된 객체 => 재사용 목적 => 메모리 누수 방지 
   // 드라이버 등록 
   public StudentDAO()
   {
	   try
	   {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) {}
   }
   // 오라클 연결 
   public void getConnection()
   {
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {}
   }
   // 오라클 닫기 
   public void disConnection()
   {
	   try
	   {
		   if(cs!=null) cs.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   // 싱글턴
   public static StudentDAO newInstance()
   {
	   if(dao==null)
		   dao=new StudentDAO();
	   return dao;
   }
   // 기능 수행
   /*
    *   CREATE OR REPLACE  PROCEDURE studentAllData(
            pResult OUT SYS_REFCURSOR
        )
        IS
        BEGIN
          OPEN pResult FOR
          SELECT * FROM student;
        END;
        /

    */
   public List<StudentVO> studentAllData()
   {
	   List<StudentVO> list=new ArrayList<StudentVO>();
	   try
	   {
		   getConnection();
		   String sql="{CALL studentAllData(?)}";
		   cs=conn.prepareCall(sql);
		   // ?에 값을 채운다 => IN변수는 기존 동일 , OUT는 저장하는 공간을 지정 
		   cs.registerOutParameter(1, OracleTypes.CURSOR);
		   // 실행 요청 
		   cs.executeQuery();
		   // 결과값 받기
		   ResultSet rs=(ResultSet)cs.getObject(1);
		   while(rs.next())
		   {
			   StudentVO vo=new StudentVO();
			   vo.setHakbun(rs.getInt(1));
			   vo.setName(rs.getString(2));
			   vo.setKor(rs.getInt(3));
			   vo.setEng(rs.getInt(4));
			   vo.setMath(rs.getInt(5));
			   list.add(vo);
		   }
		   rs.close();
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
   // 삭제
   /*
    *   CREATE OR REPLACE PROCEDURE studentDelete(vHakbun student.hakbun%TYPE)
		IS
		BEGIN
		   DELETE FROM student 
		   WHERE hakbun=vHakbun;
		   COMMIT;
		END;
		/

    */
   public void studentDelete(int hakbun)
   {
	   try
	   {
		   getConnection();
		   String sql="{CALL studentDelete(?)}";
		   cs=conn.prepareCall(sql);
		   // ?에 값을 채운다 
		   cs.setInt(1, hakbun);
		   // 실행 요청 
		   cs.executeQuery();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 추가 
   /*
    *   CREATE OR REPLACE PROCEDURE studentInsert(
		   vName student.name%TYPE,
		   vKor student.kor%TYPE,
		   vEng student.eng%TYPE,
		   vMath student.math%TYPE
		)
		IS
		BEGIN
		   INSERT INTO student VALUES(std_hak_seq.nextval,vName,vKor,vEng,vMath);
		   COMMIT;
		END;
		/

    */
   // 프로시저는 DBA가 보통 제작 => 웹프로그래머는 자바로 프로시저 호출이 가능
   // 프로시저 => 댓글 
   // JDBC = DBCP = MyBatis = JPA
   //               -------------- 데이터베이스 연동 라이브러리 
   //               ------- 주력 
   /*
    *   최신 : JSP를 사용하지 않는다
    *         --- ThymeLeaf (HTML 자체 처리) =>  제어문 사용 
    *         
    *         Spring FrameWork (사라진다) 
    *         String-Boot (서버)  ========  클라이언트 (Vue,React)
    *           STS                           VsCode
    *   GIT 원격 => 무시하는 파일 작성 
    */
   public void studentInsert(StudentVO vo)
   {
	   try
	   {
		   getConnection();
		   String sql="{CALL studentInsert(?,?,?,?)}";
		   cs=conn.prepareCall(sql);
		   // ?에 값울 채운다 => 실행 요청 
		   cs.setString(1, vo.getName());
		   cs.setInt(2, vo.getKor());
		   cs.setInt(3, vo.getEng());
		   cs.setInt(4, vo.getMath());
		   
		   cs.executeQuery();
	   }catch(Exception ex)
	   {
		   ex.printStackTrace();
	   }
	   finally
	   {
		   disConnection();
	   }
   }
   // 수정 
   /*
    *   CREATE OR REPLACE PROCEDURE studentUpdate(
		   vHak student.hakbun%TYPE,
		   vName student.name%TYPE,
		   vKor student.kor%TYPE,
		   vEng student.eng%TYPE,
		   vMath student.math%TYPE)
		IS
		BEGIN
		   UPDATE student SET 
		   name=vName,
		   kor=vKor,
		   eng=vEng,
		   math=vMath
		   WHERE hakbun=vHak;
		   COMMIT;
		END;
		/

    */
    public void studentUpdate(StudentVO vo)
    {
    	try
    	{
    		getConnection();
    		String sql="{CALL studentUpdate(?,?,?,?,?)}";
    		cs=conn.prepareCall(sql);
    		// ?에 값을 채운다 
    		cs.setInt(1, vo.getHakbun());
    		cs.setString(2, vo.getName());
 		    cs.setInt(3, vo.getKor());
 		    cs.setInt(4, vo.getEng());
 		    cs.setInt(5, vo.getMath());
    		// 실행 
 		    cs.executeQuery();
    	}catch(Exception ex)
    	{
    		ex.printStackTrace();
    	}
    	finally
    	{
    		disConnection();
    	}
    }
   
}