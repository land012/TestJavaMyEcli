<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>jquery_validation 举例</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript" src="js/jquery.validate.min.js"></script>
	<script type="text/javascript" src="js/jquery.metadata.js"></script>
	
	<style type="text/css">
		label.error {
			color:#FF0000;
		}
	</style>
	
	<script type="text/javascript">
		$(function() {
			$("form[name=form1]").validate({
				meta : "jvalidate",
				//errorClass : "jverror", // 指定错误的 label 的 class属性值
				rules : {
					text3 : {
						required: true,
						number : true
					},
					radio1 : {
						required : true
					},
					checkbox1 : {
						required: true,
						minlength: 2,
						maxlength: 3
					},
					select1 : {
						required : true
					}
				},
				messages : {
					text3 : {
						required: "不能为空！",
						number: "必须是数字！"
					},
					radio1 : {
						required : "必须选择一个 radiio1"
					},
					checkbox1 : {
						required : "checkbox1 不能为空",
						minlength : "不能少于 2 个",
						maxlength : "不能多于 3 个"
					},
					select1 : {
						required : "请选择一个 select1"
					}
				}
			});
		});
		
	</script>
  </head>
  
  <body>
    <div>
  		jquery.validation 前端表单验证
  	</div>
    <form action="" name="form1">
    	text1 <input type="text" class="required" name="text1" />
    	<label for="text1" class="error">这个字段必填！</label>
    	<br/>
    	<!-- 这种写法似乎不管用了！↓ -->
    	text2 <input type="text" class="{jvalidate : {required: true, messages: { required: '不能为空！'}}}" name="text2" />
    	<br/>
    	
    	text3 <input type="text" name="text3" />
    	<br>
    	radio1
    	<input type="radio" name="radio1" value="1" /> 1
    	<input type="radio" name="radio1" value="2" /> 2
    	<label for="radio1" class="error"></label>
    	<br>
    	checkbox1
    	<input type="checkbox" name="checkbox1" value="A" /> A
    	<input type="checkbox" name="checkbox1" value="B" /> B
    	<input type="checkbox" name="checkbox1" value="C" /> C
    	<input type="checkbox" name="checkbox1" value="D" /> D
    	<input type="checkbox" name="checkbox1" value="E" /> E
    	<label for="checkbox1" class="error"></label>
    	<br>
    	select1
    	<select name="select1">
    		<option value="">请选择</option>
    		<option value="1">1</option>
    		<option value="2">2</option>
    		<option value="3">3</option>
    	</select>
    	<label for="select1" class="error"></label>
    	<br>
    	<input type="submit" value="提交" />
    </form>
    
    <hr/>
  </body>
</html>
