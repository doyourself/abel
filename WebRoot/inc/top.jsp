<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<base href="<%=basePath%>">
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/public.css">
<style>
#i_t_b table{color:#fff; font-size:12px;}
</style>
<script>
$(function(){
	$("#loginBtn").click(function(){
		var username=$("#topName").val();
		var password=$("#topPassword").val();
		if($.trim(username)==""){
			alert("请输入用户名！");
		}else if($.trim(password)==""){
			alert("请输入密码！");
		}else{
			$("#userLogin").submit();
		}
	});
});
</script>
<div id="i_t_b">
<form action="<%=basePath%>users_login.action" method="post" id="userLogin">
<table width="100%" height="100%" cellpadding="0" cellspacing="0">
<tr>
	<td width="45%" align="left">　<a href="<%=basePath%>">欢迎进入Abel首页</td>
	<td align="right" id="loginbanner" style="vertical-align: middle;">
	<s:if test="#session.user==null">
	用户名：<input type="text" id="topName" name="user.name"/>　密码：<input id="topPassword" type="password" name="user.password"/>　<button id="loginBtn" type="button">登录</button>　
	<button>忘记密码</button>　<a href="<%=basePath%>/user/register.jsp">注册</a>
	</s:if>
	<s:else>
	<s:property value="#session.user.name"/>&nbsp;<a href="#" title="你当前的积分<s:property value="#session.user.points"/>分" style="color: red;">[<s:property value="#session.user.points"/>]</a>
	<a href="">[设置]</a>&nbsp;
	<a href="<%=basePath%>/users_quit.action">[退出]</a>
	</s:else>　
	</td>
</tr>
</table>
</form>
</div>
<div id="itop">
<table width="100%" height="100%" cellpadding="0" cellspacing="0">
<tr>
<td width="20%" ><img class="png extra-img" src="images/logo.jpg"/></td>
<td width="80%" align="right">
	<div id="tab">
	<ul>
		<li><a href="<%=basePath%>blogindex.jsp">首页</a></li>
		<li><a href="<%=basePath%>blog_list.action">博文</a></li>
		<li><a href="">相册</a></li>
		<li><a href="">分享</a></li>
		<li><a href="<%=basePath%>bug/bug_list.action">音乐</a></li>
	</ul>
	</div>
</td>
</tr>
</table>
</div>