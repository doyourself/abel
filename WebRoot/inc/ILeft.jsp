<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<script type='text/javascript' src='<%=basePath %>js/jquery-1.4.2.min.js'></script>
<script type='text/javascript' src='<%=basePath %>js/taglib.js'></script>
<div id="site_title">

	<a
		href="http://demo.cssmoban.com/cssthemes/templatemo_236_glow/index.html">

		<img src="<%=basePath%>images/laji/templatemo_logo.png"
			alt="Site Title" /> <span>your tagline goes here</span> </a>

</div>

<div id="news_section">

	<h2>
		Latest Updates
	</h2>

	<div class="news_box">
		<a href="#">Nunc varius venenatis sem sed</a>
		<p>
			Mauris suscipit mauris in purus mattis placerat. Ut rhoncus imperdiet
			nibh sit amet sagittis. Aliquam erat volutpat.
		</p>
	</div>

	<div class="news_box">
		<a href="#">Donec ac aliquam neque</a>
		<p>
			Sed tellus diam, consequat nec volutpat et, cursus ac nisi. Mauris in
			risus in diam consequat suscipit non.
		</p>
	</div>

	<div class="news_box">
		<a href="#">Pellentesque habitant morbi tristique</a>
		<p>
			Aenean in erat odio, in tempor quam. Quisque sem orci, malesuada eu
			blandit et, bibendum facilisis mi.
		</p>
	</div>

</div>

<div class="cleaner_h30"></div>

<div id="request_a_quote">
	<s:if test="#session.user!=null">
		<h2>
			个人档案
		</h2>
		<p></p>
		<div
			style="background: #F0F3F8; width: 128px; height: 128px; border: 1px solid #CCD8EA;">
			<img src="<%=basePath%>images/user.png"
				style="width: 128px; height: 128px;" />
		</div>
		<lable style="padding-top:10px;">用户名:<s:property
			value="#session.user.name" />
		</lable>
		<lable>积分:<s:property value="#session.user.points" />
		</lable>
	</s:if>
	<s:else>
		<h2>
			开始记录你的人生
		</h2>
		<p>
			In ac libero urna. Suspendisse sed odio ut mi auctor blandit. Duis
			luctus nulla metus.
		</p>

		<form action="<%=basePath%>users_login.action" method="post"
			id="userLogin">
			<label>
				用户名：
			</label>
			<input name="user.name" id="topName" size="10" class="quote_input"
				title="用户名 或 邮箱" type="text" />
			<label>
				密 码：
			</label>
			<input name="user.password" id="topPassword" size="10"
				class="quote_input" title="密码" type="password" />
			<input name="Submit" value="" alt="提交" id="loginBtn" title="提交"
				type="button" />
		</form>
	</s:else>
	<div class="cleaner"></div>
</div>
<script>
$(function(){
	$("#loginBtn").live("click",function(){
		var username=$("#topName").val();
		var password=$("#topPassword").val();
		if($.trim(username)==""){
			alertT("请输入用户名！");
		}else if($.trim(password)==""){
			alertT("请输入密码！");
		}else{
			$("#userLogin").submit();
		}
	});
});
</script>	