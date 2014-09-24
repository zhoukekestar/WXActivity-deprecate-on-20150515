<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="/head.jsp"%>

</head>
<body>
<h1>friend:<%=request.getParameter("id") %></h1>
id:${id }
<br>
openid:${openid }
</body>
</html>