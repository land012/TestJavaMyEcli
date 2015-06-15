<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<title>Main Page</title>
</head>
<body>
	This is Main.jsp！
	<br/>
	<s:property value="username" default="用户名" escape="false"/>
	<hr>
	<s:set var="admin" value="password" />
	<s:set id="admin1" value="password" />
	<s:set name="admin2" value="password" />
	<br/>
	(request):<s:property value="#request.admin"/>
	(ActionContext):<s:property value="#admin" />
	<br/>
	id_admin1:<s:property value="#admin1"/>
	<br/>
	name_admin2:<s:property value="#admin2"/>

	<hr>

	set<s:set var="v1" value="admin" scope="session" />
	<br/>
	admin(session):<s:property value="#session.v1"/>
	
	<hr>

	<s:bean name="com.xu.vo.User" var="u1">
		<s:param name="name" value="'tom'"></s:param>
		<s:param name="age" value="'20'"></s:param>
	</s:bean>
	User:<s:property value="#u1"/>
	<br>
	<s:property value="#u1.name"/>
	<hr/>
	<s:if test="u != null">
		User:<s:property value="u" />
	</s:if>
	<s:debug></s:debug>
</body>
</html>