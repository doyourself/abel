<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<base href="<%=basePath%>"/>
<s:if test="list==null">
<div class="val_res_pg">
		<div class="val_res_img_pg">
			<img src="<%=basePath%><s:property value="dynamic.users.avatar"/>"/>
		</div>
		<div class="val_res_imgpg_r">
			<div class="val_res_imgpg_t">
				<s:if test="dynamic.type==1">
					<a href=""><s:property value="dynamic.users.name"/></a>发布了<a href="">心情</font></a></a>
				</s:if>
				<s:elseif test="dynamic.type==2">
					<a href=""><s:property value="dynamic.users.name"/></a>发布了<a href="">日志</font></a></a>
				</s:elseif>
				<s:else>
				<a href=""><s:property value="dynamic.users.name"/></a>发布了日志<a href="<%=request.getContextPath()%>/blog/detail?id=<s:property value='#listArticle.id'/>">【<s:property value="#listArticle.title"/>】</a>
				</s:else>
			</div>
			<div class="">
				<s:property value="dynamic.description"/>
			</div>
			<div class="val_res_b">
				<div class="val_res_b_l"><s:date name="dynamic.createTime" format="yyyy-MM-dd HH:mm:ss"/>    <s:if test="dynamic.type!=1&&dynamic.type!=2"><a href="">来自博客</a></s:if></div>
				<div class="val_res_b_r"><a href="">转发(0)</a>  <font>|</font>  <a href="">评论(0)</a></div>
			</div>
		</div>
</div>
</s:if>
<s:else>
<s:iterator value="list" id="l">
	<div class="val_res_pg">
		<div class="val_res_img_pg">
			<img src="<%=basePath%><s:property value="users.avatar"/>"/>
		</div>
		<div class="val_res_imgpg_r">
			<div class="val_res_imgpg_t">
				<s:if test="type==1">
					<a href=""><s:property value="users.name"/></a>发布了<a href="">心情</font></a></a>
				</s:if>
				<s:elseif test="type==2">
					<a href=""><s:property value="users.name"/></a>发布了<a href="">日志</font></a></a>
				</s:elseif>
				<s:else>
				<a href=""><s:property value="users.name"/></a>发布了日志<a href="<%=request.getContextPath()%>/blog/detail?id=<s:property value='#listArticle.id'/>">【<s:property value="#listArticle.title"/>】</a>
				</s:else>
			</div>
			<div class="">
				<s:property value="description"/>
			</div>
			<div class="val_res_b">
				<div class="val_res_b_l"><s:date name="createTime" format="yyyy-MM-dd HH:mm:ss"/>    <s:if test="type!=1&&type!=2"><a href="">来自博客</a></s:if></div>
				<div class="val_res_b_r"><a href="">赞(<s:property value="clickCount"/>)</a>  <font>|</font>  <a href="">转发(0)</a>  <font>|</font>  <a href="">评论(0)</a></div>
			</div>
		</div>
	</div>
</s:iterator>
</s:else>