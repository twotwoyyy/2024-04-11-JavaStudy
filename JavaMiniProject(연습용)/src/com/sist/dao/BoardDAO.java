package com.sist.dao;
import java.util.*;
import java.sql.*;
public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static BoardDAO dao;
	public BoardDAO() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void getConnection() {
		try {
			conn=DriverManager.getConnection(URL,"hr","happy");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public void disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static BoardDAO newInstance() {
		if(dao==null)
			dao=new BoardDAO();
		return dao;
	}
	
	public List<BoardVO> boardListData(int page){
		List<BoardVO> list=new ArrayList<BoardVO>();
		try {
			getConnection();
			String sql="SELECT no,subject,name,regdate,hit,num "
					  +"FROM (SELECT no,subject,name,regdate,hit,rownum as num "
					  +"FROM (SELECT no,subject,name,regdate,hit "
					  +"FROM board ORDER BY no DESC)) " 
					  +"WHERE num BETWEEN ? AND ?";
			ps=conn.prepareStatement(sql);
			int rowSize=10;
			int start=(rowSize*page)-(rowSize-1);
			int end=rowSize*page;
			ps.setInt(1, start);
			ps.setInt(2, end);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
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
			
		}finally {
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
	
	// 2. 글쓰기 기능
	public void boardInsert(BoardVO vo) {
		try {
			getConnection();
			String sql="INSERT INTO board(no,name,subject,content,pwd) "
					  +"VALUES(board_no_seq.nextval,?,?,?,?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getSubject());
			ps.setString(3, vo.getContent());
			ps.setString(4, vo.getPwd());
			ps.executeUpdate();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
	}
	// 3. 상세보기
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
	// 4. 수정 
	// 4-1. 기존 데이터 읽기
	public BoardVO boardUpdateData(int no) {
		BoardVO vo=new BoardVO();
		try {
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
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			disConnection();
		}
		return vo;
	}
	// 4-2 실제 수정 
	public boolean boardUpdate(BoardVO vo) {
		boolean bCheck=false;
		try {
			getConnection();
			String sql="SELECT pwd FROM board WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, vo.getNo());
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(vo.getPwd())) {
				bCheck=true;
				sql="UPDATE board SET "
			      + "name=?, subject=?, content=? "
				  + "WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, vo.getName());
				ps.setString(2, vo.getSubject());
				ps.setString(3, vo.getContent());
				ps.setInt(4, vo.getNo());
				ps.executeUpdate();
			}
			else {
				bCheck=false;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally{
			disConnection();
		}
		return bCheck;
	}
	
	// 5. 삭제
	public boolean boardDelete(int no, String pwd) {
		boolean bCheck=false;
		try {
			getConnection();
			String sql="SELECT pwd FORM board WHERE no=?";
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			ResultSet rs=ps.executeQuery();
			rs.next();
			String db_pwd=rs.getString(1);
			rs.close();
			
			if(db_pwd.equals(pwd)) {
				bCheck=true;
				sql="DELETE FROM board "
				   +"WHERE no=?";
				ps=conn.prepareStatement(sql);
				ps.setInt(1, no);
				ps.executeLargeUpdate();
			}
			else {
				bCheck=false;
			}
		}catch(Exception ex) {
			
		}finally {
			disConnection();
		}
		return bCheck;
	}
	
	
}
