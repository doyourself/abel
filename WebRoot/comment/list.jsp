<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<div class="comment_list_b" style="background: none;"></div>
<s:iterator value="#request.pageListData.dataList" id="v">
	<div class="comment_list_b" id="<s:property value="comment.id"/>">
		<div class="coment_l_img">
			<a href=""><img
					src="<%=basePath%>/Upload/<s:property value="comment.users.avatar"/>" />
			</a>
		</div>
		<div class="commnet_r_b">
			<div class="comment_t">
				<span class="co_t_l"><a href=""><s:property
							value="comment.users.name" /> </a> <s:date name="comment.createTime"
						format="yyyy-MM-dd HH:mm" /> </span>
				<span class="co_t_r"><!-- <a href="">删除</a>  --></span>
			</div>
			<div class="comment_c">
				<span class="CB">评论：</span><s:property value="comment.description" />
			</div>
			<div class="son_huifu" cid="<s:property value="comment.id"/>" id="shf_<s:property value="comment.id"/>">
				<a href="<s:property value="#v.commentVo.size" />" class="huifu" name="<s:property value="comment.id"/>">回复(<s:property
						value="#v.commentVo==null?0:#v.commentVo.size" />)</a>
				<a href="<s:property value="comment.support" />" class="sor" name="support">支持(<s:property value="comment.support" />)</a>
				<a href="<s:property value="comment.opposition" />" class="sor" name="opposition">反对(<s:property value="comment.opposition" />)</a>
				<a href="<s:property value="comment.report" />" class="sor" name="report">举报(<s:property value="comment.report" />)</a>
			</div>
			<div class="con_sub_pg" style="display: none;"
				id="showComment_<s:property value="comment.id"/>">
				<textarea id="text1_<s:property value="comment.id"/>"></textarea>
				<div class="son_sub_btn">
					<button class="btn3 chf1" abc="<s:property value="comment.id"/>"
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
		<div id="v1Append_<s:property value="comment.id"/>">
		</div>
		<div class="sortId1_<s:property value="comment.id"/>"></div>
		<s:iterator value="#v.commentVo" id="svo1">
			<s:if test="#svo1.comment.level ==1">
				<div id="show2_<s:property value="#svo1.comment.id"/>">
					<div
						style="width: 565px; margin: 0 0 0 70px; border-top: 1px solid #ddd; padding: 10px 0; float: left; display: inline;">
						<div style="width: 100%; float: left; display: inline;">
							<div class="v1Img"
								style="width: 50px; height: 50px; float: left; display: inline;">
								<a href=""><img
										src="<%=basePath%>/Upload/<s:property value="#svo1.commentVo.users.avatar"/>" />
								</a>
							</div>
							<div style="width: 500px; float: right; display: inline;">
								<div>
									<s:property value="#svo1.comment.users.name" />
									<s:date name="#svo1.comment.createTime"
										format="yyyy-MM-dd HH:mm" />
								</div>
								<div>
									<span class="CB">评论：</span><s:property value="#svo1.comment.description" />
								</div>
								<div class="menu" cid="<s:property value="#svo1.comment.id"/>">
									<a href="<s:property value="#svo1.comment.id" />" class="huf2"
										name="<s:property value="#svo1.comment.id"/>">回复</a>
									<a href="<s:property value="#svo1.comment.support" />" class="sor" name="support">支持(<s:property value="#svo1.comment.support" />)</a>
									<a href="<s:property value="#svo1.comment.opposition" />" class="sor" name="opposition">反对(<s:property value="#svo1.comment.opposition" />)</a>
									<a href="<s:property value="#svo1.comment.report" />" class="sor" name="report">举报(<s:property value="#svo1.comment.report" />)</a>
								</div>
							</div>
						</div>
						<div style="width: 84%; float: right; display: none;"
							id="showList_<s:property value="#svo1.comment.id"/>">
							<textarea class="srkText" style="width: 100%;"
								id="text2_<s:property value="#svo1.comment.id"/>"></textarea>
							<div
								style="width: 100%; text-align: right; float: left; display: inline;">
								<button class="btn3 chf2"
									abc="<s:property value="#v.comment.id"/>"
									name="<s:property value="#svo1.comment.id"/>">
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
			</s:if>
			<s:iterator value="#v.commentVo" id="sort2">
				<s:if test="#sort2.comment.sortId == #svo1.comment.id">
					<div id="show2_<s:property value="#sort2.comment.id"/>">
						<div
							style="width: 565px; margin: 0 0 0 70px; border-top: 1px solid #ddd; padding: 10px 0; float: left; display: inline;">
							<div style="width: 100%; float: left; display: inline;">
								<div class="v1Img"
									style="width: 50px; height: 50px; float: left; display: inline;">
									<a href=""><img
											src="<%=basePath%>/Upload/<s:property value="#svo1.commentVo.users.avatar"/>" />
									</a>
								</div>
								<div style="width: 490px; float: right; display: inline;">
									<div>
										<s:property value="#sort2.comment.id" />
										<s:property value="#sort2.comment.users.name" />
										<s:date name="#sort2.comment.createTime"
											format="yyyy-MM-dd HH:mm" />
									</div>
									<div
										style="width: 100%; float: left; display: inline; background: #ddd;">
										<table class="yy" cellpadding="0" cellspacing="0" width="100%">
											<tr class="yyTitle">
												<td align="left">
													<s:property value="#svo1.comment.users.name" />
													<s:date name="#svo1.comment.createTime"
														format="yyyy-MM-dd HH:mm" />
												</td>
												<td align="right">
													引用内容
												</td>
											</tr>
											<tr>
												<td colspan="2">
													<s:property value="#svo1.comment.description" />
												</td>
											</tr>
										</table>
									</div>
									<div>
										<span class="CB">评论：</span><s:property value="#sort2.comment.description" />
									</div>
									<div class="menu" cid="<s:property value="#sort2.comment.id"/>">
										<a href="" class="huf2"
											name="<s:property value="#sort2.comment.id"/>">回复</a>
										<a href="<s:property value="#sort2.comment.support" />" class="sor" name="support">支持(<s:property value="#sort2.comment.support" />)</a>
									<a href="<s:property value="#sort2.comment.opposition" />" class="sor" name="opposition">反对(<s:property value="#sort2.comment.opposition" />)</a>
									<a href="<s:property value="#sort2.comment.report" />" class="sor" name="report">举报(<s:property value="#sort2.comment.report" />)</a>
									</div>
								</div>
							</div>
							<div class="srk" style="width: 84%; float: right; display: none;"
								id="showList_<s:property value="#sort2.comment.id"/>">
								<textarea class="srkText" style="width: 100%;"
									id="text2_<s:property value="#sort2.comment.id"/>"></textarea>
								<div
									style="width: 100%; text-align: right; float: left; display: inline;">
									<button class="btn3 chf2"
										abc="<s:property value="#v.comment.id"/>"
										name="<s:property value="#sort2.comment.id"/>">
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
				</s:if>
			</s:iterator>
		</s:iterator>
	</div>
</s:iterator>
<style>
.v1Img {
	border: 1px solid #ddd;
	border-radius: 4px;
}
.yy td{padding: 5px 5px; text-indent: 10px;}
.yyTitle td{color: #336699; padding-bottom: 0;}
</style>
<div
	style="width: 100%; text-align: center; float: left; display: none;">
	<s:property value="#request.pageListData.footer" escape="false" />
</div>
