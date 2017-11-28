<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="cn.easybuy.entity.*" %>
<%@ page import="cn.easybuy.service.news.*" %>
<%@ page import="cn.easybuy.param.*" %>
<%@ page import="cn.easybuy.utils.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'news.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%
    	NewsService dao = new NewsServiceImpl();
		NewsParams params = new NewsParams();
		Pager pager = new Pager(5, 5, 1);
		try {
			List<News> ulist = dao.queryNewsList(params);
			for (News news : ulist) {
				out.println(news.getTitle()+"<br/>");
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
     %>
  </body>
</html>
