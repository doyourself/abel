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
<script type='text/javascript' src='<%=basePath %>js/jquery-1.4.2.min.js'></script>
<script type='text/javascript' src='<%=basePath %>js/jquery-ui.js'></script>
<script type='text/javascript' src='<%=basePath %>js/bug.js'></script>
<link media="screen" rel="stylesheet" href="<%=basePath%>/css/colorbox.css" />
<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/public2.css" />
<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/bug2.css" />
</head>
<body  style="background: #2F3134;">
<s:include value="/inc/ITop.jsp"></s:include>
		<div id="templatemo_wrapper">
			<div class="templatemo_content" id="tempBanner">
				<div id="tempBB">
					<div id="bugListBT">
						<div id="t_l">
						<a href="<%=basePath %>bug_list.action">BUG列表</a>&nbsp;&gt;
						<s:if test="bug==null">
							新增BUG
						</s:if>
						<s:else>
							修改BUG
						</s:else>
						</div>
						<div id="t_r">
							<s:date format="yyyy年MM月dd日 E HH:mm" name="bug.createTime"/>
						</div>
					</div>
						<form action="<%=basePath %>bug_save.action" id="bugForm" method="post">
					<div class="bugListBanner">
						<input type="hidden" name="bug.id" value="<s:property value="bug.id"/>"/>
						<div class="blbbanner">
							<font>BUG简述：</font><input id="compendium" value="<s:property value="bug.compendium"/>" style="width:600px; height: 24px;line-height: 24px;" name="bug.compendium" maxlength="100"/>
						</div>
						<div class="blbbanner">
							<font>问题：</font><textarea name="bug.problem" style="width:99%; height:200px;"><s:property value="bug.problem" /></textarea>
						</div>
						<div class="blbbanner">
							<font>原因</font><textarea name="bug.reason" style="width:99%;height:200px;"><s:property value="bug.reason" /></textarea>
						</div>
						<div class="blbbanner">
							<font>答案</font><textarea name="bug.answer" style="width:99%; height:200px;"><s:property value="bug.answer" /></textarea>
						</div>
						<div class="blbmenu" style="text-align: center;"><button id="sub" type="button">提交</button> <button type="reset">重置</button></div>
					</div>
					<div class="cleaner"></div>
				</div>
<div class="cleaner"></div>
				</div>
			</div>
			</body>
</html>			