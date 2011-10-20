<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="comment_list_b" id="<s:property value="comment.id"/>">
	<div class="coment_l_img">
		<a href=""><img
				src="<%=basePath%>/Upload/<s:property value="users.avatar"/>" /> </a>
	</div>
	<div class="commnet_r_b">
		<div class="comment_t">
			<span class="co_t_l"><a href=""><s:property
						value="comment.users.name" />
			</a>  <s:date name="comment.createTime" format="yyyy-MM-dd HH:mm" /></span>
			<span class="co_t_r"><a href="">删除</a> </span>
		</div>
		<div class="comment_c">
			<span class="CB">评论：</span><s:property value="comment.description" />
		</div>
		<!-- <div class="son_huifu">
			<a href="" class="shfId" name="<s:property value="comment.id"/>">回复(0)</a>
			<a href="">支持(0)</a>
			<a href="">反对(0)</a>
			<a href="">举报(0)</a>
		</div>
		 -->
		<div class="con_sub_pg" style="display: none;" id="showText_<s:property value="comment.id"/>">
			<textarea id="text1_<s:property value="comment.id"/>"></textarea>
			<div class="son_sub_btn">
				<button class="btn3 chf1" abc="<s:property value="comment.id"/>" name="<s:property value="comment.id"/>">
					提交
				</button>
				&nbsp;&nbsp;&nbsp;
				<button class="btn3">
					取消
				</button>
			</div>
		</div>
	</div>
<div class="sortId1_<s:property value="comment.id"/>"></div>