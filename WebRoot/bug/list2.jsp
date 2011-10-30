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
<script type='text/javascript' src='http://ajax.googleapis.com/ajax/libs/jquery/1.6.4/jquery.min.js'></script>
<script type='text/javascript' src='<%=basePath %>js/jquery-ui.js'></script>
<script type='text/javascript' src='<%=basePath %>js/bug.js'></script>
<link media="screen" rel="stylesheet" href="<%=basePath%>/css/colorbox.css" />
<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/public2.css" />
<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/bug2.css" />
<script src="<%=basePath%>/js/jquery.colorbox.js"></script>
<script>
$(function(){
	$(".fc-event").click(function(e){
		e.preventDefault();
		var varHref = $(this).attr("href");
		$.fn.colorbox({href:varHref});	
	});
	$(".ui-widget-content").click(function(){
		var cla = $(this).attr("class");
		var fcom = cla.indexOf("fc-other-month");
		if(fcom == -1){
			var fcdn = $(this).find(".fc-day-number").html();
			var time = $(".fc-header-title h2").html();
			var time = time+" "+fcdn;
		}
	});
});
</script>
</head>
<body style="background: #2F3134; overflow:hidden; ">
<div id="ibody" style="width: 100%; height: 1000px; overflow-y:auto; overflow-x:hidden;">
<s:include value="/inc/ITop.jsp"></s:include>
		<div id="templatemo_wrapper">
			<div class="templatemo_content" id="tempBanner">
				<div id="tempBB">
					<div id="bugListBT">
						<div id="t_l">BUG列表</div>
						<div id="t_r"><input type="text"/>&nbsp;<button class="btn3" style="vertical-align: middle;">搜索</button></div>
					</div>
					<s:iterator value="list" id="l">
					<div class="bugListBanner">
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
						<div class="blbmenu"><!-- <a href="">类别：默认分类</a> |  --><a href="<%=basePath%>bug_findUpdate.action?bug.id=<s:property value="id"/>">编辑</a> | <a href="<%=basePath%>bug_deleteList.action?bug.id=<s:property value="id"/>">删除</a> | <a href="">评论(0)</a> | <a href="">浏览(90)</a> </div>
					</div>
					</s:iterator>
					<div id="ajax" class="">
						<img src="<%=basePath%>images/loading.gif"/>正在加载！请稍等！
					</div>
					<div class="cleaner"></div>
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
<script language="javascript">
    $(document).ready(function (){
    var h = scrollHeight = document.body.offsetHeight + document.body.scrollTop;
      var nScrollHight = 0; //滚动距离总长(注意不是滚动条的长度)
      var nScrollTop = 0;   //滚动到的当前位置
      var nDivHight = $("#ibody").height();
      $("#ibody").scroll(function(){
        nScrollHight = $(this)[0].scrollHeight;
        nScrollTop = $(this)[0].scrollTop;
        if(nScrollTop + nDivHight >= nScrollHight)
        	$.post("<%=basePath%>bug_ajaxList.action",{"start":5,"end":14},function(data){
        		$("#ajax").before(data);
        	});
        });
    });
    </script>
</body>
</html>
