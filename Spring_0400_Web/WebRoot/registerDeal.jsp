<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.xyz.model.*, com.xyz.service.*"
%>
<%
String username = request.getParameter("username");
String password = request.getParameter("password");
String password2 = request.getParameter("password2");
User u = new User();
u.setUsername(username);
u.setPassword(password);
UserManager um = new UserManager();
if(um.add(u)) {
	response.sendRedirect("registerSuccess.jsp");
	return;
}
response.sendRedirect("registerFail.jsp");
return;
%>