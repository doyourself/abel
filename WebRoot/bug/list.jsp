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
<link media="screen" rel="stylesheet" href="<%=basePath%>/css/templatemo_style.css" />
<script src="<%=basePath%>/js/jquery.colorbox.js"></script>
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
			<s:iterator value="list" id="l">
				{
					title: '<s:property value="compendium"/>',
					start: new Date(<s:date format="yyyy" name="createTime"/>, <s:date format="M" name="createTime"/>, <s:date format="d" name="createTime"/>,<s:date format="H" name="createTime"/>,<s:date format="m" name="createTime"/>,<s:date format="s" name="createTime"/>),
					url: '<%=basePath%>bug_findById.action?bug.id=<s:property value="id"/>',
					allDay: false
				},
				</s:iterator>
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
</style>
<script>
$(function(){
	$("#addBug").click(function(e){
		e.preventDefault();
		$.fn.colorbox({href:"/Abel/bug/add.jsp"});	
	});
	$(".fc-event").click(function(e){
		e.preventDefault();
		var varHref = $(this).attr("href");
		$.fn.colorbox({href:varHref});	
	});
	$(".ui-widget-content").click(function(){
		var cla = $(this).attr("class");
		var fcom = cla.indexOf("fc-other-month");
		if(fcom == -1){
			var fcdn = $(this).find(".fc-day-number").html();
			var time = $(".fc-header-title h2").html();
			var time = time+" "+fcdn;
		}
	});
});
</script>
</head>
<body style="100%; margin:0; padding:0; background: #ccc;">
<s:include value="/inc/ITop.jsp"></s:include>
<div style="height: auto; padding:5px 0; background:green; position: fixed; z-index: 100000000; bottom: 0px; right: 0pt; overflow: hidden; width: 60px;">
	<a href="<%=basePath%>/bug_updateType.action" id="type" style="color: #fff;">切换模式</a>
</div>
<div style="height: auto; padding:5px 0; background:green; position: fixed; z-index: 100000000; top: 150px; right: 0pt; overflow: hidden; width: 20px;">
	<a href="" id="addBug" style="color: #fff;">添加B<br/>U<br/>G</a>
</div>
<div id="center">
<div id='calendar'></div>
</div>
</body>
</html>
