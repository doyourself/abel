<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String bpn = request.getRequestURL()+"";
String[] indexlength = bpn.split("/");
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<base href="<%=basePath%>">
<div id="templatemo_menu_wrapper">
	<div id="templatemo_menu">
        <ul>
        	<li class="menu"><a href="<%=basePath %>" <% if(indexlength.length == 4){out.print("class='current'");} %> >首页</a></li>
			<li class="menu"><a href="<%=basePath %>blogindex.jsp">博客</a></li>
			<li class="menu"><a href="">小组</a></li>
			<li class="menu"><a href="">问答</a></li>
			<li class="menu" id="index"><a href="<%=basePath %>bug_list.action">BUG</a></li>
			<li class="menu"><a href="<%=basePath %>notepad_list.action" <% if(bpn.indexOf("notepad")!=-1){out.print("class='current'");} %> >日志</a></li>
        </ul> 
    </div>
</div>
