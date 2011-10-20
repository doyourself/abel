<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div id="show2_<s:property value="comment.id"/>">
	<div
		style="width: 545px; margin: 0 0 0 50px; border-top: 1px solid #ddd; padding: 10px 0; float: left; display: inline;"
		class="sortId1_<s:property value="comment.sortId"/>">
		<div style="width: 100%; float: left; display: inline;">
			<div class="v1Img"
				style="width: 50px; height: 50px; float: left; display: inline;">
				<a href=""><img
						src="<%=basePath%>/Upload/<s:property value="users.avatar"/>" />
				</a>
			</div>
			<div style="width: 460px; float: right; display: inline;">
				<div>
					<s:property value="comment.users.name" />
					<s:date name="comment.createTime" format="yyyy-MM-dd HH:mm" />
				</div>
				<div>
					<span class="CB">评论：</span><s:property value="comment.description" />
				</div>
				
				<!-- <div class="menu">
					<a href="" class="huf2" name="<s:property value="comment.id"/>">回复(0)</a>
					<a href="">支持(0)</a>
					<a href="">反对(0)</a>
					<a href="">举报(0)</a>
				</div>
				 -->
			</div>
		</div>
		<div style="width: 84%; float: right; display: none;"
			id="showList_<s:property value="comment.id"/>">
			<textarea class="srkText" style="width: 100%;"
				id="text2_<s:property value="comment.id"/>"></textarea>
			<div
				style="width: 100%; text-align: right; float: left; display: inline;">
				<button class="btn3 chf2" abc="<s:property value="comment.id"/>"
					name="<s:property value="comment.id"/>">
					提交
				</button>
				&nbsp;&nbsp;&nbsp;
				<button class="btn3">
					取消
				</button>
			</div>
		</div>
	</div>
</div>