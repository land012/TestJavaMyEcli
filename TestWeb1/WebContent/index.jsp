<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>TestWeb1</title>
</head>
<body>
<%=request.getSession().getId() %>
<br/>
<% request.getSession().setAttribute("k1", "session-v1"); %>
<%=request.getSession().getAttribute("k1") %>
</body>
</html>