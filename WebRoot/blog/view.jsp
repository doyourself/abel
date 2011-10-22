<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/public.css"/>
<script src="<%=basePath %>js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/comment.js" type="text/javascript"></script>
<link rel="stylesheet" type="text/css" href="<%=basePath %>ckeditor/_samples/sample.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/view.css"/>
</head>
<style>
.labAdd{width: 300px;}
</style>
<body>
<s:include value="/inc/top.jsp"></s:include>
<div id="center">
<div id="left">
<h1>查看博文</h1>
<div class="title">
			<s:property value="blog.title"/>
		</div>
		<div class="title_tag_b">
			<span>标签：</span>
			<s:iterator value="listTag" id="lt">
			 <a href=""><s:property value="description"/></a>
			 </s:iterator>
			 &nbsp;&nbsp;发表于
			 <s:date name="blog.createTime" format="yyyy年MM月dd日 HH时mm分"/>
		</div>
		<div id="tv_pg"><s:property value="blog.content" escape="false"/></div>
		<div id="tvpg">
			<s:if test="blog.users.id!=#session.user.id">
				<a href="">分享</a>　<a href="">转载</a>
			</s:if>
		</div>
		<div id="text_pg">
			<div id="t_comm">评论:</div>
			<div id="t_comm_r">
				<textarea id="tcommr_text"></textarea>
				<div id="b_pg">
					<div style="float: right; display: inline;">
						<div class="btn7" id="commentBtn">评论</div>
					</div>
				</div>
			</div>
		</div>
		<input type="hidden" id="blogId" value="<s:property value="blog.id"/>"/>
		<input type="hidden" id="type" value="1"/>
		<div id="commentBanner" style="width: 100%;">
			<div id="cB" style="width: 100%; text-align: center;">
				<img src="<%=basePath %>/images/loading.gif" style="width: 50px; height: 50px; vertical-align: middle; "/>　正在加载评论。。。
			</div>
		</div>
</div>
	<s:include value="/inc/right.jsp"></s:include>
</div>
<div id="i_b_b"></div>
</body>
</html>