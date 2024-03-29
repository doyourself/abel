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
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<script type='text/javascript'
			src='<%=basePath%>js/jquery-1.4.2.min.js'></script>
		<script type='text/javascript' src='<%=basePath%>js/jquery-ui.js'></script>
		<script type='text/javascript' src='<%=basePath%>js/bug.js'></script>
		<link media="screen" rel="stylesheet"
			href="<%=basePath%>/css/colorbox.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/public2.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/bug2.css" />
		<style>
			.blbbanner{padding: 10px 20px;}
			.bab{background:#333; border-bottom: 1px dashed #444;}
		</style>
	</head>
	<body style="background: #2F3134;">
		<s:include value="/inc/ITop.jsp"></s:include>
		<div id="templatemo_wrapper">
			<div class="templatemo_content" id="tempBanner">
				<div id="tempBB" style="padding-bottom:50px;">
					<div id="bugListBT">
						<div id="t_l">
							<a href="<%=basePath%>bug_list.action">BUG列表</a>&nbsp;&gt;
							查看BUG
						</div>
						<div id="t_r">
							<s:date format="yyyy年MM月dd日 E HH:mm" name="bug.createTime"/>
						</div>
					</div>
					<div class="blbbanner" style="text-align: center;">
						<h2><s:property value="bug.compendium"/></h2>
					</div>
					<div class="blbbanner bab">
						<font>问题：</font>
							<s:property value="bug.problem" />
					</div>
					<div class="blbbanner bab">
						<font>原因：</font>
							<s:property value="bug.reason" />
					</div>
					<div class="blbbanner bab">
						<font>答案：</font>
							<s:property value="bug.answer" />
					</div>
					<div class="cleaner"></div>
				</div>
				<div class="cleaner"></div>
			</div>
		</div>
	</body>
</html>