<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel='stylesheet' type='text/css' href='<%=basePath %>/css/fullcalendar/theme.css' />
<link rel='stylesheet' type='text/css' href='<%=basePath %>/css/fullcalendar/fullcalendar.css' />
<link rel='stylesheet' type='text/css' href='<%=basePath %>/css/fullcalendar/fullcalendar.print.css' media='print' />
<script type='text/javascript' src='<%=basePath %>js/jquery-1.4.2.min.js'></script>
<script type='text/javascript' src='<%=basePath %>js/jquery-ui.js'></script>
<script type='text/javascript' src='<%=basePath %>js/bug.js'></script>
<script type='text/javascript' src='<%=basePath %>js/fullcalendar.min.js'></script>
<link media="screen" rel="stylesheet" href="<%=basePath%>/css/colorbox.css" />
<script src="<%=basePath%>/js/jquery.colorbox.js"></script>
<style type='text/css'>
	body {
		text-align: center;
		font-size: 13px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		}

	#calendar {
		width: 900px;
		margin: 0 auto;
		}
	.menu{width:149px; height:45px; cursor:pointer; text-align:center; line-height:45px; float: left; display: inline;}
	.menu a{width:149px; height:45px; text-decoration:none; color:#CCCCCC; font-weight:bold; float: left; display: inline;}
	.menu a:hover{background: url(<%=basePath%>/images/hr/templatemo_menu_hover.jpg) no-repeat; float: left; display: inline;}
	#index{background: url(<%=basePath%>/images/hr/templatemo_menu_hover.jpg) no-repeat;}
</style>
</head>
<body style="100%; margin:0; padding:0; background: #ccc;">
<div id="top" style="width:100%; height:47px; padding-bottom:10px; text-align:center; background: url(<%=basePath%>/images/hr/templatemo_menu.jpg) repeat-x;">
<div style="100%; height:47px;">
	<div style="width:920px; margin:0 auto;">
		<span class="menu"><a href="<%=basePath %>">首页</a></span>
		<span class="menu"><a href="<%=basePath %>blog_list.action">博文</a></span>
		<span class="menu"><a href="">小组</a></span>
		<span class="menu"><a href="">问答</a></span>
		<span class="menu" id="index"><a href="">BUG</a></span>
		<span class="menu"><a href="">日志</a></span>
	</div>
</div>
</div>
<div style="height: auto; padding:5px 0; background:green; position: fixed; z-index: 100000000; top: 150px; right: 0pt; overflow: hidden; width: 20px;">
	<a href="" id="addBug" style="color: #fff;">添加B<br/>U<br/>G</a>
</div>
<div id='calendar'></div>
</body>
</html>
