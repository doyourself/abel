<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/public.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/index.css">
<script src="<%=basePath%>js/jquery-1.4.2.min.js" type="text/javascript"></script>
</head>
<body>
<s:include value="/inc/top.jsp"></s:include>
<div id="center">
	<div id="left">
		<div id="huati">
			<textarea id="textarea" rows="" cols=""></textarea>
			<div id="ila_btn">
				<span>发送至
					<select style="vertical-align: middle;">
						<option>博文</option>
						<option>心情</option>
						<option>日志</option>
						<option>bug</option>
					</select>
				</span>
				<div id="sendType">
					
				</div>
				<button>发 布</button>
			</div>
		</div>
		<div id="ilb_pg">
			<div id="ilb_tl">
				<img src="images/bottom/s.jpg" title="刷新最新动态" />
			最新动态 — —</div>
			<div id="ilb_tr"><a href="">设置</a></div>
		</div>
		<div class="val_res_pg">
				<div class="val_res_img_pg">
					<img src=""/>
				</div>
				<div class="val_res_imgpg_r">
					<div class="val_res_imgpg_t">
						<a href="">啊是的发生地方</a>发布了一篇博客<a href="<%=request.getContextPath()%>/blog/detail?id=<s:property value='#listArticle.id'/>">【<s:property value="#listArticle.title"/>】</a>
					</div>
					<div class="val_res_b">
						<div class="val_res_b_l"><s:date name="#listArticle.createTime" format="yyyy-MM-dd HH:mm:ss"/>    <a href="">来自博客</a></div>
						<div class="val_res_b_r"><a href="">转发(23)</a>  <font>|</font>  <a href="">评论(56)</a></div>
					</div>
				</div>
		</div>
		<div class="val_res_pg">
				<div class="val_res_img_pg">
					<img src=""/>
				</div>
				<div class="val_res_imgpg_r">
					<div class="val_res_imgpg_t">
						<a href=""><s:property value="#listArticle.userName"/></a>发布了一篇博客<a href="<%=request.getContextPath()%>/blog/detail?id=<s:property value='#listArticle.id'/>">【<s:property value="#listArticle.title"/>】</a>
					</div>
					<div class="val_res_b">
						<div class="val_res_b_l"><s:date name="#listArticle.createTime" format="yyyy-MM-dd HH:mm:ss"/>    <a href="">来自博客</a></div>
						<div class="val_res_b_r"><a href="">转发(23)</a>  <font>|</font>  <a href="">评论(56)</a></div>
					</div>
				</div>
		</div>
	</div>
	<s:include value="/inc/right.jsp"></s:include>
</div>
<div id="i_b_b">
</div>
</body>
</html>