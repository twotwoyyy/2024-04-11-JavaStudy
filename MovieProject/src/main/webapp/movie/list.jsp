<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="com.sist.manager.*,com.sist.vo.*"%>  
<%
   String strPage=request.getParameter("page");
   if(strPage==null)
	   strPage="1";
   int curpage=Integer.parseInt(strPage);
   int totalpage=MovieManager.movieTotalPage();
   Movie[] movie=MovieManager.getMovieData(curpage);
%>
<!DOCTYPE html>
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <style type="text/css">
    .container{
       margin-top: 50px;
    }
    .row{
       margin: 0px auto;
       width: 960px
    }
    h2{
       text-align: center;
    }
  </style>
</head>
<body>

<div class="container">
  <h2>영화 목록</h2>
  <div class="row">
  <%
     for(Movie m:movie)
     {
  %>
    <div class="col-md-3">
      <div class="thumbnail">
        <a href="#" target="_blank">
          <img src="<%=m.getPoster() %>" alt="Lights" style="width:240px;height: 250px">
          <div class="caption">
            <p><%=m.getTitle() %></p>
          </div>
        </a>
      </div>
    </div>
 <%
     }
 %>
  </div>
  <div class="row">
   <div class="text-center">
     <a href="list.jsp?page=<%=curpage>1?curpage-1:curpage %>" class="btn btn-sm btn-danger">이전</a>
      <%= curpage %> page / <%=totalpage %> pages
     <a href="list.jsp?page=<%=curpage<totalpage?curpage+1:curpage %>" class="btn btn-sm btn-info">다음</a>
   </div>
  </div>
</div>

</body>
</html>