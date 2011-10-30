<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<form action="<%=basePath %>notepad_save.action" id="notepadForm" method="post">
<table id="categoryList" cellpadding="0" cellspacing="0">
  <tr>
    <th width="20%">简述</th>
    <th align="left">
    <input type="hidden" name="notepad.id"  value="<s:property value="notepad.id"/>"/>
	<input name="notepad.title" id="compendium" maxlength="100" style="width:59%; height:99%;" value="<s:property value="notepad.title"/>"/>
	</th>
  </tr>
  <tr class="quesTr">
	  <td>问题：</td>
	  <td>
	  <textarea name="notepad.description" style="width:99%; height:99%;"><s:property value="notepad.description"/></textarea>
	  </td>
  </tr>
  <tr>
  	<td colspan="2"><button id="sub" type="button">修改</button> <button type="reset">重置</button> <button type="button" id="delnotepad" name="<s:property value="notepad.id"/>">删除</button> </td>
  </tr>
</table>
</form>
<style>
	#compendium{width: 100%; height: 100%; border: 0px;}
	.quesTr td{height: 200px;}
	#categoryList textarea{font-size: 12px; border: 0px;}
	#categoryList{width: 900px; border-top:1px solid #ccc; border-right: 1px solid #ccc;}
	#categoryList td{ line-height:24px; padding:5px 0; border-bottom:1px solid #ccc; border-left: 1px solid #ccc;}
	#categoryList th{ line-height:24px; padding:5px 0;border-bottom:1px solid #ccc; border-left: 1px solid #ccc;}
</style>