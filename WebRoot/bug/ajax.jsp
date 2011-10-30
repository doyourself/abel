<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:iterator value="list" id="l">
	<div class="bugListBanner">
		<div class="blbt">
			<a
				href="<%=basePath%>bug_findById.action?bug.id=<s:property value="id"/>"><s:property
					value="compendium" /> </a>
		</div>
		<div class="blbtime">
			<s:date format="yyyy年MM月dd日 E HH:mm" name="createTime" />
		</div>
		<div class="blbbanner">
			<font>问题：</font>
			<s:property value="problem" />
		</div>
		<div class="blbbanner">
			<font>原因：</font>
			<s:property value="reason" />
		</div>
		<div class="blbbanner">
			<font>解决方法：</font>
			<s:property value="answer" />
		</div>
		<div class="blbmenu">
			<!-- <a href="">类别：默认分类</a> |  -->
			<a
				href="<%=basePath%>bug_findUpdate.action?bug.id=<s:property value="id"/>">编辑</a>
			|
			<a
				href="<%=basePath%>bug_deleteList.action?bug.id=<s:property value="id"/>">删除</a>
			|
			<a href="">评论(0)</a> |
			<a href="">浏览(90)</a>
		</div>
	</div>
</s:iterator>