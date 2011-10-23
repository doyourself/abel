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
<script src="<%=basePath %>js/blog.js" type="text/javascript"></script>
<script src="<%=basePath %>ckeditor/_samples/sample.js" type="text/javascript"></script>
</head>
<style>
.labAdd{width: 300px;}
#addBlog td{padding: 5px 0;}
</style>
<body>
<s:include value="/inc/top.jsp"></s:include>
<div id="center">
<div id="left">
<h1>修改博文</h1>
<form action="<%=basePath %>blog_saveOrUpdate.action" method="post" id="categoryForm">
<table id="addBlog" cellpadding="0" cellspacing="0" style="width: 100%;">
	<tr>
		<td style="width: 100px" align="right" class="group_l">博文名称：</td>
		<td>
		<input type="hidden" name="blog.id" value="<s:property value="blog.id"/>"/>
		<input type="text" id="Title" class="input" name="blog.title" value="<s:property value="blog.title"/>"/></td>
	</tr>
	<tr>
		<td class="group_l" align="right" style="vertical-align: top; padding:10px 0;" >博文描述：</td>
		<td style="padding:10px 0;">
			<textarea style="width: 100%;" id="textarea" name="blog.content">
			<s:property value="blog.content"/>
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
		<td class="group_l" align="right" style="text-align: top;">标签：</td>
		<td><input type="text" id="Tag" class="input" name="tag" value="<s:property value="tag"/>" /><br>标签之间以空格隔开，如Java Net,标签便于搜索到你的博文！</td>
	</tr>
	<tr>
		<td class="group_l" align="right" style="vertical-align: top">分类：</td>
		<td>
			<div style="float: left; display: inline;">
			<select name="blog.category.id" id="category_name">
				<option value="0">请选择</option>
				<s:iterator value="categoryList" id="sb">
					<option value="<s:property value="id"/>"<s:if test="blog.category.id == #sb.id"> selected="selected"</s:if> ><s:property value="name"/></option>
				</s:iterator>
			</select>
			<a id="addcategory" href="">添加分类</a>
			<a id="editCategory" href="">修改分类</a>
			</div>
			<div id="addcateb" style="float:left; display:none;">
				&nbsp;&nbsp;<input type="text" class="input2" maxlength="13" name="checkName" onmouseout="if(value=='请输入分类名称'){this.style.color='#BDBDBD'}" onmouseover="this.style.color='#333'" id="category_value" value="请输入分类名称" onfocus="if(value=='请输入分类名称'){value=''}" onblur="if(value==''){value='请输入分类名称'}" style="color: rgb(189, 189, 189);" />
				<button type="button" id="add_category_blog" class="btn3">添加</button>
				<button type="button" id="qx_category_blog" class="btn3">取消</button>
			</div>
		</td>
	</tr>
	<tr>
		<td class="group_l">是否允许评论：</td>
		<td>
			<input type="radio"  <s:if test="blog.isAllowedComment==null">checked="checked"</s:if> <s:if test="blog.isAllowedComment==1">checked="checked"</s:if> name="blog.isAllowedComment" value="1"/>是
			<input type="radio" <s:if test="blog.isAllowedComment==0">checked="checked"</s:if>  name="blog.isAllowedComment" value="0" />否
		</td>
	</tr>
	<tr>
		<td class="group_l">是否允许转载：</td>
		<td>
			<input type="radio" <s:if test="blog.isReprinted==null">checked="checked"</s:if> <s:if test="blog.isReprinted==1">checked="checked"</s:if> name="blog.isReprinted" value="1"/>是
			<input type="radio" <s:if test="blog.isReprinted==0">checked="checked"</s:if> name="blog.isReprinted" value="0" />否
		</td>
	</tr>
	
	<tr>
		<td class="group_l"></td>
		<td>
			<button type="button" id="blog_sub" class="btn2">提交</button>
			<button type="reset" class="btn2">重置</button>
		</td>
	</tr>
	<input type="hidden" value="1" id="type" />
</table>
</form>
</div>
	<s:include value="/inc/right.jsp"></s:include>
</div>
<div id="i_b_b"></div>
</body>
</html>