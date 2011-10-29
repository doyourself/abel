<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<base href="<%=basePath%>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/public.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
<script src="<%=basePath%>js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=basePath%>js/index.js" type="text/javascript"></script>
</head>
<body>
<s:include value="/inc/top.jsp"></s:include>
<div id="center">
	<div id="left">
		<div id="huati">
			<textarea id="textarea" rows="" cols=""></textarea>
			<div id="ila_btn">
				<span>发送至
					<select id="selectType" style="vertical-align: middle;">
						<option value="1">心情</option>
						<option value="2">日志</option>
					</select>
				</span>
				<div id="sendType">
					
				</div>
				<button class="btn7" id="send">发 布</button>
			</div>
		</div>
		<div id="ilb_pg">
			<div id="ilb_tl">
				<img src="<%=basePath%>images/buttom/s.jpg" title="刷新最新动态" />
			最新动态 — —</div>
			<div id="ilb_tr"><a href="">设置</a></div>
		</div>
		<div class="val_res_pg" style="background: none;">
		</div>
	</div>
	<s:include value="/inc/right.jsp"></s:include>
</div>
<div id="i_b_b">
</div>
</body>
</html>