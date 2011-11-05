<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<script type='text/javascript' src='<%=basePath %>js/jquery-1.4.2.min.js'></script>
<script type='text/javascript' src='<%=basePath %>js/bug.js'></script>
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/public2.css" />
<link rel="stylesheet" type="text/css" href="<%=basePath%>css/bug2.css" />
</head>
<body style="background: #2F3134;">
<!-- style="width: 100%; height: 1000px; overflow-y:auto; overflow-x:hidden;" -->
<div id="ibody" >
<s:include value="/inc/ITop.jsp"></s:include>
		<div id="templatemo_wrapper">
			<div class="templatemo_content" id="tempBanner">
				<div id="tempBB">
					<div id="bugListBT">
						<div id="t_l">BUG列表</div>
						<div id="t_r"><input type="text"/>&nbsp;<button class="btn3" style="vertical-align: middle;">搜索</button></div>
					</div>
					<s:iterator value="list" id="l" status="ll">
					<div class="bugListBanner" id="<s:property value="start"/>">
						<div class="blbt"><a href="<%=basePath%>bug_findById.action?bug.id=<s:property value="id"/>"><s:property value="compendium"/></a>
						</div>
						<div class="blbtime">
							<s:date format="yyyy年MM月dd日 E HH:mm" name="createTime"/>
						</div>
						<div class="blbbanner">
							<font>问题：</font><s:property value="problem"/>
						</div>
						<div class="blbbanner">
							<font>原因：</font><s:property value="reason"/>
						</div>
						<div class="blbbanner">
							<font>解决方法：</font><s:property value="answer"/>
						</div>
						<div class="blbmenu"><!-- <a href="">类别：默认分类</a> |  --><a href="<%=basePath%>bug_findUpdate.action?bug.id=<s:property value="id"/>">编辑</a> | <a href="<%=basePath%>bug_deleteList.action?bug.id=<s:property value="id"/>">删除</a> | <a href="">评论(0)</a> | <a href="">浏览(<s:property value="count==null?0:count"/>)</a> </div>
					</div>
					</s:iterator>
					<div id="ajax" class="" style="display:none;">
						<img src="<%=basePath%>images/loading.gif"/>正在加载！请稍等！
					</div>
					<div id="cleaner"></div>
				</div>
			</div>
			<!-- end of content -->

			<div class="cleaner"></div>
		</div>
<div style="height: auto; padding:5px 0; text-align:center; background:green; position: fixed; z-index: 100000000; bottom: 0px; right: 0pt; overflow: hidden; width: 60px;">
	<a href="<%=basePath%>/bug_updateType.action" id="type" style="color: #fff;">切换模式</a>
</div>
<div style="height: auto; padding:5px 0; text-align:center; background:green; position: fixed; z-index: 100000000; top: 150px; right: 0pt; overflow: hidden; width: 20px;">
	<a href="<%=basePath%>/bug/add2.jsp" id="addBug" style="color: #fff;">添加B<br/>U<br/>G</a>
</div>
<style>
.bugListBanner{width:940px; padding:10px; border-bottom:1px solid #fff; float: left; display: inline;}
.blbt{width: 100%;line-height: 22px;  float: left; display: inline; }
.blbt a{font-size:16px; font-weight:bold; color:#959595; text-decoration: none;}
.blbt a:hover{color: #C99E63; text-decoration: underline;}
.blbtime{width: 100%;line-height: 18px; padding-bottom:10px; font-size:10px; color:#959595; float: left; display: inline; }
.blbtl{float: left; display: inline;}
.blbtr{float: right; display: inline;}
.blbbanner{width: 100%; line-height: 22px; padding-bottom:10px; color: #959595; float: left; display: inline;}
.blbbanner font{font-weight: bold; color:#999; }
.blbmenu{width: 100%; color: #C99E63; float: left; display: inline;}
.blbmenu a{color: #C99E63; text-decoration: none;}
.blbmenu a:hover{color: #C99E63; text-decoration: underline;}
</style>
</div>
 <script type="text/javascript">
       //页面加载事件
	  $(document).ready(function(){
			//窗体的滚动事件
			var hei;
			$(window).scroll(function(e){
				e.preventDefault();	
				//如果当前文档的高度减去当前窗口大小等于滚动条的高度
				if  ($(window).scrollTop() == $(document).height() - $(window).height()){
				   //继续加载
				   if($(document).height() !=hei){
					    hei = $(document).height();
					   $('#ajax').show();
						var start = $(".bugListBanner:last").attr("id");
						//这里用$.ajax动态获取内容
						$.post("<%=basePath %>bug_ajaxList.action",{"start":start},function(data){
							$('#ajax').before(data);
						});
				   }
				}
			}); 
			
	   });
    </script>
	</body>
</html>
