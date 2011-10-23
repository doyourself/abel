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
<script type='text/javascript' src='<%=basePath %>js/fullcalendar.min.js'></script>
<script type='text/javascript'>
	$(document).ready(function() {
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		$('#calendar').fullCalendar({
			theme: true,
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			editable: true,
			events: [
				{
					title: 'All Day Event',
					start: new Date(y, m, 1)
				},
				{
					title: 'Long Event',
					start: new Date(y, m, 3)
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: new Date(y, m, d-3, 16, 0),
					allDay: false
				},
				{
					id: 999,
					title: 'Repeating Event',
					start: new Date(y, m, d+4, 16, 0),
					allDay: false
				},
				{
					title: 'Meeting',
					start: new Date(y, m, d, 10, 30),
					allDay: false
				},
				{
					title: 'Lunasdfasdfch',
					start: new Date(y, m, d),
					allDay: false
				},
				{
					title: 'Birthday Party',
					start: new Date(y, m, d+1, 19, 0),
					allDay: false
				},
				{
					title: 'Click for Google',
					start: new Date(y, m, 28),
					url: 'http://google.com/'
				}
			]
		});
		
	});

</script>
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
	.menu a:hover{background: url(../images/hr/templatemo_menu_hover.jpg) no-repeat; float: left; display: inline;}
	#index{background: url(../images/hr/templatemo_menu_hover.jpg) no-repeat;}
</style>
</head>
<body style="margin:0; padding:0; background: #2F3134;">
<div id="top" style="width:100%; height:47px; padding-bottom:10px; text-align:center; background: url(../images/hr/templatemo_menu.jpg) repeat-x;">
<div style="900px; height:47px; margin: 0 auto;">
	<div style="margin:0 0 0 250px; float: left; display: inline;">
		<span class="menu" id="index"><a href="">首页</a></span>
		<span class="menu"><a href="">博文</a></span>
		<span class="menu"><a href="">小组</a></span>
		<span class="menu"><a href="">问答</a></span>
		<span class="menu"><a href="">BUG</a></span>
	</div>
</div>
</div>
<div id='calendar'></div>
</body>
</html>
