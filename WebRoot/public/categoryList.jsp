<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:iterator value="list" id="ss">
	<option value="<s:property value="id"/>">
		<s:property value="name"/>
	</option>
</s:iterator>
<option>请选择</option>
