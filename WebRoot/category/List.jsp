<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<table id="categoryList" cellpadding="0" cellspacing="0">
  <tr>
    <th width="80%">分类名称</th>
    <th>操作</th>
  </tr>
  <s:iterator value="list" id="ss">
  <tr>
    <td align="center"><input id="text_<s:property value="id"/>" style="width:90%; border: 1px solid #ccc; height: 20px; line-height: 20px; color: #333; " type="text" name="" value="<s:property value="name"/>"/></td>
    <td align="center"><a class="editUpdate" href="<s:property value="id"/>">修改</a>　<a class="delCategory" href="<s:property value="id"/>">删除</a></td>
  </tr>
  </s:iterator>
</table>
<style>
	#categoryList{width: 500px; border-top:1px solid #ccc; border-right: 1px solid #ccc;}
	#categoryList td{ line-height:24px; padding:5px 0; border-bottom:1px solid #ccc; border-left: 1px solid #ccc;}
	#categoryList th{ line-height:24px; padding:5px 0;border-bottom:1px solid #ccc; border-left: 1px solid #ccc;}
</style>