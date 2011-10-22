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
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/list.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath %>css/blog.css"/>
<script src="<%=basePath %>js/jquery-1.4.2.min.js" type="text/javascript"></script>
<script src="<%=basePath %>js/comment.js" type="text/javascript"></script>
</head>
<body>
<s:include value="/inc/top.jsp"></s:include>
<div id="center">
	<div id="left">
		<h1>我的博文</h1>
		<s:if test="list.size==0">
			<h1 style="text-align: center;"><a href="<%=basePath %>blog_add.action" style="font-size:20px;">您还未发布博文！点击发布！</a></h1>
		</s:if>
		<s:else>
		<h2 style="text-align: right;"><a href="<%=basePath %>blog_add.action">发表博文！</a></h2>
		</s:else>
		<s:iterator value="list" status="sta">
		<div class="ht_pg" id="list_<s:property value="id"/>" >
			<div class="cla_title">
				<span class="clatl">
					<a href="<%=basePath %>blog_findById.action?blog.id=<s:property value="id"/>"><s:property value="title"/></a>
					<font>(<s:property value="category.name"/>)</font>
					<span class="listMenu">
					<s:if test="users.id == #session.user.id">
					<a href="<%=basePath %>blog_edit.action?blog.id=<s:property value="id"/>">修改</a> | <a class="del" id="<s:property value="id"/>" href="<%=basePath %>blog_delete.action?blog.id=<s:property value="id"/>">删除</a>
					</s:if>
					</span>
				</span>
				<span class="clatr">
					<s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/>
				</span>
			</div>
			<div class="cla_content">
				<s:property value="content" escape="false"/>
			</div>
		</div>
		</s:iterator>
		<input type="hidden" id="type" value="1" />
	</div>
	<s:include value="/inc/right.jsp"></s:include>
</div>
<s:include value="/inc/bottom.jsp"></s:include>
<script>
$(function(){
	$(".clatl").mouseover(function(){
		  $(this).css("background","#FFCCCC");
		  $(this).find(".listMenu").show();
	});
	 $(".clatl").mouseout(function(){  
        $(this).css("background","");
        $(".listMenu").hide();
     }); 
});
</script>
</body>
</html>