<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
  <head>
    <base href="<%=basePath%>" />
    
    <title>���ύ����������</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	
	<meta http-equiv="content-type" content="text/html; charset=gbk" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		$(function() {
			// Ajax GET �ύ
			$("#btn_ajaxget").click(function() {
				$.ajax({
					type : "POST",
					cache : false,
					url : "test1_test1.do",
					data : { "str1" : "����Ajax����Ӵ��" },
					dataType : "html",
					success : function(data) {
						alert(data);
					}
				});
			});
		});
	</script>

  </head>
  
  <body>
  	<b>������ԣ�</b>
  	<div style="padding-left:20px;">
	  	get��ʽ�ύ��
	    <form action="pages/jsp/encoding2.jsp" method="get">
	    	<input type="text" name="str1" value="�����Ǻ���" />
	    	<input type="submit" value="�ύ" />
	    </form>
	    
	    <hr/>
	    
	    post��ʽ�ύ��
	    <form action="pages/jsp/encoding2.jsp" method="post">
	    	<input type="text" name="str1" value="�����Ǻ���" />
	    	<input type="submit" value="�ύ" />
	    </form>
	    
	    <hr />
	    
	    <input type="button" id="btn_ajaxget" value="AjaxGET�ύ" />
    </div>
    <hr>
    
  </body>
</html>
