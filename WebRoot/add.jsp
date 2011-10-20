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
<link rel="stylesheet" type="text/css" href="<%=basePath %>ckeditor/_samples/sample.css"/>
<script src="<%=basePath %>ckeditor/ckeditor.js" type="text/javascript"></script>
<script src="<%=basePath %>ckeditor/_samples/sample.js" type="text/javascript"></script>
</head>
<style>
.labAdd{width: 300px;}
</style>
<body>
<s:include value="/inc/top.jsp"></s:include>
<div id="center">
<div id="left">
<h1>申请创建小组</h1>
<table cellpadding="0" cellspacing="0" style="width: 100%;">
	<tr>
		<td style="width: 70px" class="group_l">小组名称：</td>
		<td><input type="text" class="input" /></td>
	</tr>
	<tr>
		<td class="group_l" style="vertical-align: top; padding:10px 0;" >小组介绍：</td>
		<td style="padding:10px 0;">
			<textarea style="width: 100%;" id="textarea" name="editor2">
			</textarea>
			<script type="text/javascript">
			var editor = CKEDITOR.replace( 'textarea',
				{
					extraPlugins : 'uicolor',
					toolbar : [ 
					[ 'Source', '-', 'TextColor', '-','Bold', 'Italic', 'Underline', 'Strike','-','UIColor' ],
					[ 'NewPage','-','Undo','Redo'],
			['Find','Replace','-','SelectAll','RemoveFormat'],
			['FontSize'],
			['NumberedList','BulletedList','-','Blockquote'],
			['Link', 'Unlink'],
			[ 'Smiley','SpecialChar', ],['Maximize']]
				});
	</script>
			</td>
	</tr>
	<tr>
		<td class="group_l">标签：</td>
		<td><input type="text" class="input"  /></td>
	</tr>
	<tr>
		<td class="group_l" style="vertical-align: top">加入方式：</td>
		<td>
			<input type="radio" name="ra" id="ra" /><label for="ra" class="labAdd">需要小组管理员批准后才能加入小组</label><br>
			<input type="radio" name="ra" id="rb" /><label for="rb" class="labAdd">只有接受组员邀请才能加入小组</label><br>
			<input type="radio" name="ra" id="rc" /><label for="rc" class="labAdd">允许任何人加入小组</label>
		</td>
	</tr>
	<tr>
		<td class="group_l"></td>
		<td><input type="checkbox" id="checkbox" /><label for="checkbox">我已认真阅读并同意<a href="">《免责声明》</a></label></td>
	</tr>
</table>
</div>
	<s:include value="/inc/right.jsp"></s:include>
</div>
<div id="i_b_b"></div>
</body>
</html>