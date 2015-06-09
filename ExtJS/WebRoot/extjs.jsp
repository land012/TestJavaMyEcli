<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>ExtJS 测试</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="js/jquery.1.7.1.min.js"></script>
	
	<link rel="stylesheet" type="text/css" href="extjs/resources/css/ext-all.css" />
	<script type="text/javascript" src="extjs/adapter/ext/ext-base.js"></script>
	<script type="text/javascript" src="extjs/ext-all.js"></script>
	
	<script type="text/javascript">
		Ext.onReady(function() {
			
			var addPanel = function(btn, event) {
				var n;
				n = tabPanel.getComponent(btn.id);
				if(n) {
					tabPanel.setActiveTab(n);
					return;
				}
				n = tabPanel.add({
					id: btn.id,
					title: btn.id,
					html: btn.id,
					//autoLoad:,
					closable: true
				});
				tabPanel.setActiveTab(n);
			};
			
			var item1 = new Ext.Panel({
				title: 'item1',
				cls: "empty",
				items: [
					new Ext.Button({
						id: "btn1",
						text: "btn1",
						width: "100%",
						listeners: {
							click: addPanel
						}
					})
				]
			});
			
			var item2 = new Ext.Panel({
				title: "item2",
				html: "&lt;empty panel&gt;",
				cls: "empty"
			});
			
			var accordion = new Ext.Panel({
				id: 'accordion1',
				layout: 'accordion',
				region: 'west',
				split:true,
				margins: '2 0 5 5',
				width: 275,
				items: [item1, item2]
			});
			
			var tabPanel = new Ext.TabPanel({
				id: 'tabpanel1',
				region: 'center',
				enableTabScroll: true,
				deferredRender: false,
				activeTab: 0,
				items: [
					{
						title: 'idnex',
						autoLoad: 'index.jsp', // autoLoad 会覆盖 html，与顺序无关
						html: 'aaaa'
					}
				]
			});
			
			var viewport = new Ext.Viewport({
				layout: 'border',
				title: 'Ext Layout Browser',
				items:[
					accordion,
					tabPanel
				]
			});
		});
	</script>

  </head>
  
  <body></body>
</html>
