<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Model model;
		int num = Integer.parseInt(request.getAttribute("num").toString());
		if (num == 1) {
			%>안녕하세요! <%
		} else if (num == 2) {
			%>반갑습니다! <%
		}
	%>
</body>
</html>