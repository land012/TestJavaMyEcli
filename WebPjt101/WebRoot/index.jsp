<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

session.setAttribute("k1", "v1");

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <base href="<%=basePath%>" />
    
    <title>��������ҳӴ��</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="content-type" content="text/html;charset=gbk">
	
	<link rel="stylesheet" type="text/css" href="css/common.css">
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>

	<style type="text/css">
    	.left_td {
    		
    	}
    	.tbl1 {
    		color:#F5F5F5; text-align:center;
    	}
    	ul {
    		height:100%; overflow:hidden;
    	}
    	ul li {
    		width:200px; float:left; margin:5px 0px;
    	}
    	dt, dd {
    		display: block;
    	}
    </style>
    
     <script type="text/javascript">
    	function showwidth() {
    		alert($(".left_td").width());
    	}
    </script>
  </head>
  
  <body>
  	<dl>
  		<dt>JS</dt>
  		<dd><ul>
  			<li><a href="pages/js/jstest.jsp#abc" target="_blank">jstest</a></li>
  			<li><a href="pages/js/modal_window.jsp" target="_blank">modal_window</a></li>
  			<li><a href="pages/js/opener1.jsp" target="_blank">window.opener</a></li>
  			<li><a href="pages/js/jsprototype.jsp" target="_blank">prototype</a></li>
  			<li><a href="pages/js/des1.jsp" target="_blank">DES/ECB����1</a></li>
  			<li><a href="pages/js/des3.jsp" target="_blank">DES/ECB�÷�2</a></li>
  			<li><a href="pages/js/des4.jsp" target="_blank">DES/ECB�ӽ��ܡ�</a></li>
  			<li><a href="pages/js/des5.jsp" target="_blank">DES/CBC����</a></li>
  			<li><a href="pages/js/regexp.jsp" target="_blank">RegExp</a></li>
  			<li><a href="pages/js/date.jsp" target="_blank">JS���ڴ���</a></li>
  			<li><a href="pages/js/vartest.jsp" target="_blank">����</a></li>
  			<li><a href="pages/js/json.jsp" target="_blank">JSON</a></li>
  			<li><a href="pages/js/encode.jsp" target="_blank">����</a></li>
  		</ul></dd>
  		
  		<dt>jQuery</dt>
  		<dd><ul>
  			<li><a href="pages/jquery/jquery_test.jsp" target="_blank">jquery test</a></li>
  			<li><a href="pages/jquery/jquery_valid.jsp" target="_blank">jquery validation ���</a></li>
  			
  			<li><a href="js/jquery-ui-1.10.3/demos" target="_blank">jquery-ui-demo</a></li>
  			<li><a href="pages/jquery/jquery_dialog.jsp" target="_blank">jquery-ui-dialog</a></li>
  			<li><a href="pages/jquery/jquery_tabs.jsp" target="_blank">jquery-ui-tabs</a></li>
  			<li><a href="pages/jquery/ui-datepicker.jsp" target="_blank">jquery-ui-datepicker</a></li>
  			<li><a href="pages/jquery/ajax.jsp" target="_blank">Ajax</a></li>
  		</ul></dd>
  		
  		<dt>Prototype</dt>
  		<dd><ul>
  			<li><a href="pages/protype/prototype1.jsp" target="_blank">prototype1</a></li>
  		</ul></dd>
  		
  		<dt>JSP</dt>
  		<dd><ul>
  			<li><a href="pages/jsp/request.jsp?k1=v1&k2=v2#anchor1" target="_blank">request</a></li>
  			<li><a href="pages/jsp/button_ajax.jsp" target="_blank">button_ajax</a></li>
  			<li><a href="pages/jsp/encoding1.jsp" target="_blank">��������</a></li>
  			<li><a href="pages/jsp/verifycode.jsp" target="_blank">��֤��</a></li>
  			<li><a href="pages/iframe.jsp" target="_blank">iframe.jsp</a></li>
  			<li><a href="pages/jsp/html.jsp" target="_blank">html.jsp</a></li>
  			<li><a href="pages/jsp/dom.jsp" target="_blank">dom.jsp</a></li>
  			
  		</ul></dd>
  		
  		<dt>Servlet</dt>
  		<dd><ul>
  			<li><a href="wait/w?k1=v1" target="_blank">WaitServlet</a></li>
  		</ul></dd>
  		
  		<dt>JSTL</dt>
  		<dd><ul>
  			<li><a href="pages/jstl/coretag.jsp" target="_blank">JSTL����</a></li>
  		</ul></dd>
  		
  		<dt>Struts2</dt>
  		<dd><ul>
  			<li><a href="test1_index.do" target="_blank">��ҳ</a></li>
  			<li><a href="test1_index.do" target="_blank">·������ test1_index</a></li>
  			<li><a href="test/test1_index.do" target="_blank">·������ test1_index(action����·��)</a></li>
  			<li><a href="testx/test1_index.do" target="_blank">·������ test1_index(��/·��)</a></li>
  			<li><a href="test2/test2_index.do" target="_blank">·������ test2_index(��pkg-namespace)</a></li>
  			<li><a href="testx/test2_index.do" target="_blank">·������ test2_index(��/)</a></li>
  			<li><a href="test1_test3.do" target="_blank">�������</a></li>
  			<li><a href="test1_fn11.do" target="_blank">fn11.do</a></li>
  			<li><a href="pages/struts2/chkbox.jsp" target="_blank">struts2����checkbox</a></li>
  			<li><a href="pages/struts2/upload.jsp" target="_blank">�ļ��ϴ�</a></li>
  		</ul></dd>
  		
  		<dt>CSS</dt>
  		<dd><ul>
  			<li><a href="pages/css/zindex.jsp" target="_blank">z-index</a></li>
  		</ul></dd>
  		
  		<dt>��ȫ</dt>
  		<dd><ul>
  			<li><a href="pages/secure/xss1.jsp" target="_blank">��վ��ű�����</a></li>
  		</ul></dd>
  		
  	</dl>
  	
  	<hr>
  	
    <table width="80%" class="tbl_std tbl1">
    	<tr>
    		<td width="20" class="left_td" style="background-color: #FF0000"></td>
    		<td style="background-color: #008800">12</td>
    		<td width="50" style="background-color: #0000FF">50</td>
    	</tr>
    	<tr>
    		<td colspan="3" style="background-color: #888800">80%</td>
    	</tr>
    </table>
    <br/>
    <input type="button" onclick="showwidth();" value="��ɫ����Ŀ��" />
    
    <hr>
    
    disabled:text �ύ<br/>
    <form action="test1_fn1.action" method="post">
    	<input type="text" name="username" />
    	<input type="text" name="password" disabled="disabled" />
    	<input type="submit" />
    </form>
    
    <hr>
    
    Struts2 �ļ��ϴ�<br/>
    <form name="struts2Upload" action="test1_fn1.action" method="post" enctype="multipart/form-data">
    	<input type="file" name="filefirst" />
    	<input type="submit" value="�ϴ�" />
    </form>
    
    <hr>
    
    <a href="/test1_fn2down.action">Struts2 ����</a>
    
    <hr>
    
    Apache Commons FileUpload �ļ��ϴ�<br/>
    <form name="commonsUpload" action="/UploadServlet" method="post" enctype="multipart/form-data">
    	�ļ���<input type="text" name="filesecondName">
    	<br>
    	�ļ���<input type="file" name="filesecond" />
    	<input type="submit" value="�ϴ�" />
    </form>
    
    <hr>
    
    
    
    <div style="height:300px;"></div>
  </body>
</html>