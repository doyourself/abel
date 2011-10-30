<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<form action="<%=basePath %>bug_save.action" id="bugForm" method="post">
<table id="categoryList" cellpadding="0" cellspacing="0">
  <tr>
    <th width="20%">BUG简述</th>
    <th align="left">
		<input id="compendium" name="bug.compendium" maxlength="100"/>
	</th>
  </tr>
  <tr class="quesTr">
	  <td>问题：</td>
	  <td align="left">
	  <textarea name="bug.problem" style="width:99%; height:99%;"></textarea>
	  </td>
  </tr>
  <tr class="quesTr">
	  <td>原因</td>
	  <td align="left"><textarea name="bug.reason" style="width:99%; height:99%;"></textarea></td>
  </tr>
  <tr class="quesTr">
	  <td>答案</td>
	  <td align="left"><textarea name="bug.answer" style="width:99%; height:99%;"></textarea></td>
  </tr>
  <tr>
  	<td colspan="2"><button id="sub" type="button">提交</button> <button type="reset">重置</button> </td>
  </tr>
</table>
</form>
<style>
	#compendium{width: 100%; height: 100%; border: 0px;}
	.quesTr td{text-align:center; height: 200px;}
	#categoryList textarea{font-size: 12px; border: 0px;}
	#categoryList{width: 900px; border-top:1px solid #ccc; border-right: 1px solid #ccc;}
	#categoryList td{ line-height:24px; padding:5px 0; border-bottom:1px solid #ccc; border-left: 1px solid #ccc;}
	#categoryList th{ line-height:24px; padding:5px 0;border-bottom:1px solid #ccc; border-left: 1px solid #ccc;}
</style>