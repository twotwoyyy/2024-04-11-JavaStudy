package com.sist.dao;
import java.util.*;
import java.sql.*;

public class BooksDAO {
	 // 오라클 연결 
     private Connection conn;
     private PreparedStatement ps;
     private final String URL="jdbc:oracle:thin:@192.168.10.124:1521:XE";
     private static BooksDAO dao;
     public BooksDAO(){
    	 try {
    		 Class.forName("oracle.jdbc.driver.OracleDriver");
    	 }catch(Exception ex) {
    		 ex.printStackTrace();
    	 }
     }
     public void getConnection() {
    	 try {
    		 conn=DriverManager.getConnection(URL,"hr2","happy");
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
     public static BooksDAO newInstance() {
    	 if(dao==null)
    		 dao=new BooksDAO();
    	 return dao;
     }
     
     public int booksTotalPage() {
    	 int total=0;
    	 try {
    		 getConnection();
    		 String sql="SELECT CEIL(COUNT(*)/12.0) FROM wiki";
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
     public ArrayList<BooksVO> booksListData(int page){
    	 ArrayList<BooksVO> list=new ArrayList<BooksVO>();
  
     try {
    	 getConnection();
			String sql = "SELECT NUM, ISBN, BOOKNAME, WRITER, TRANSLATOR, PAGE, PRICE, PUBDATE, SERIES, IMAGE, DETAIL, rnum "
					+ "FROM(SELECT NUM, ISBN, BOOKNAME, WRITER, TRANSLATOR, PAGE, PRICE, PUBDATE, SERIES, IMAGE, DETAIL, rownum as rnum "
					 + "FROM(SELECT NUM, ISBN, BOOKNAME, WRITER, TRANSLATOR, PAGE, PRICE, PUBDATE, SERIES, IMAGE, DETAIL "
					 + "FROM wiki ORDER BY NUM ASC)) "
					 + "WHERE rnum BETWEEN ? AND ?";
    	 int rowSize=12;
    	 int start=(rowSize*page)-(rowSize-1);
    	 int end=rowSize*page;
    	 ps=conn.prepareStatement(sql);
    	 ps.setInt(1, start);
    	 ps.setInt(2, end);
    	 
    	 ResultSet rs=ps.executeQuery();
    	 while(rs.next()) {
    		 BooksVO vo=new BooksVO();
				vo.setNum(rs.getInt(1));
				vo.setIsbn(rs.getLong(2));
				vo.setBookname(rs.getString(3));
				vo.setWriter(rs.getString(4));
				vo.setTranslator(rs.getString(5));
				vo.setPage(rs.getInt(6));
				vo.setPrice(rs.getInt(7));
				vo.setPubdate(rs.getDate(8));
				vo.setSeries(rs.getString(9));
				vo.setImage(rs.getString(10));
				vo.setDetail(rs.getString(11));
								
				list.add(vo);
    	 }
    	 rs.close();
     }catch(Exception ex) {
    	 ex.printStackTrace();
     }finally {
    	 
     }
     return list;
     }
     
     public BooksVO booksDetailData(int num) {
    	 BooksVO vo=new BooksVO();
    	 try {
    		 getConnection();
    		 String sql="UPDATE wiki SET "
    				 +"hit=hit+1 "
    				 +"WHERE num=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, num);
    		 ps.executeUpdate();
    		 
    		 sql="SELECT num, isbn, bookname, writer, translator, page, price, pubdate, series, image, detail, hit "
    				 +"FROM wiki "
    				 +"WHERE num=?";
    		 
    		 ps=conn.prepareStatement(sql);
    		 ps.setInt(1, num);
    		 
    		 ResultSet rs=ps.executeQuery();
    		 rs.next();
    		 vo.setNum(rs.getInt(1));
    		 vo.setIsbn(rs.getLong(2));
    		 vo.setBookname(rs.getString(3));
    		 vo.setWriter(rs.getString(4));
    		 vo.setTranslator(rs.getString(5));
    		 vo.setPage(rs.getInt(6));
    		 vo.setPrice(rs.getInt(7));
    		 vo.setPubdate(rs.getDate(8));
    		 vo.setSeries(rs.getString(9));
    		 vo.setImage(rs.getString(10));
    		 vo.setDetail(rs.getString(11));
    		 vo.setHit(rs.getInt(12));
    		 rs.close();
    		 
    	 }catch(Exception ex) {
    		 ex.printStackTrace();
    	 }finally {
    		 disConnection();
    	 }
    	 return vo;
     }
     
     public ArrayList<BooksVO> booksFindData(String name){
    	 ArrayList<BooksVO> list=new ArrayList<BooksVO>();
    	 try {
    		 getConnection();
    		 String sql="SELECT num,bookname, image, price "
    				 +"FROM wiki "
    				 +"WHERE bookname LIKE '%' ||?|| '%' "
    				 +"ORDER BY num ASC";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, name);
    		 
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next()) {
    			 BooksVO vo=new BooksVO();
    			 vo.setNum(rs.getInt(1));
    			 vo.setBookname(rs.getString(2));
    			 vo.setImage(rs.getString(3));
    			 vo.setPrice(rs.getInt(4));
    			 
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
     public void cartInsert(BookCartVO vo) {
    	 try {
    		 getConnection();
    		 String sql="INSERT INTO bookcart(bno,id,bnum,account,price) "
    				   +"VALUES(bookcart_bno_seq.nextval,?,?,?,?)";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, vo.getId());
    		 ps.setInt(2, vo.getBnum());
    		 ps.setInt(3, vo.getAcoount());
    		 ps.setInt(4, vo.getPrice());
    		 ps.executeUpdate();
    	 }catch(Exception ex) {
    		 ex.printStackTrace();
    	 }finally {
    		 disConnection();
    	 }
     }
     
     public void cartCancel(int bno) {
    	 try {
    		 getConnection();
    		 String sql="DELETE FROM bookcart "
    				   +"WHERE bno="+bno;
    		 ps=conn.prepareStatement(sql);
    		 ps.executeUpdate();
    	 }catch(Exception ex) {
    		 ex.printStackTrace();
    	 }finally {
    		 disConnection();
    	 }
     }

     public List<BookCartVO> cartSelect(String id){
    	 List<BookCartVO> list=new ArrayList<BookCartVO>();
    	 try {
    		 getConnection();
    		 String sql="SELECT bno,price,account,"
    				 +"(SELECT image FROM wiki WHERE num=bookcart.bno),"
    				 +"(SELECT bookname FROM wiki WHERE num=bookcart.bno),"
    				 +"(SELECT price FROM wiki WHERE num=bookcart.bno) "
    				 +"FROM bookcart WHERE id=?";
    		 ps=conn.prepareStatement(sql);
    		 ps.setString(1, id);
    		 ResultSet rs=ps.executeQuery();
    		 while(rs.next()) {
    			 BookCartVO vo=new BookCartVO();
    			 vo.setBno(rs.getInt(1));
    			 vo.setPrice(rs.getInt(2));
    			 vo.setAcoount(rs.getInt(3));
    			 vo.getBvo().setImage(rs.getString(4));
    			 vo.getBvo().setBookname(rs.getString(5));
    			 vo.getBvo().setPrice(rs.getInt(6));
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
