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
		<base href="<%=basePath%>" />

		<title>My JSP 'MyJsp.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/public2.css" />
	</head>
	<body>
		<s:include value="/inc/ITop.jsp"></s:include>
		<div id="templatemo_wrapper">
			<div id="templatemo_sidebar">
				<s:include value="/inc/ILeft.jsp"></s:include>
			</div>
			<div id="templatemo_content">
				<div class="cleaner"></div>
			</div>
			<!-- end of content -->

			<div class="cleaner"></div>
		</div>
	</body>
</html>
