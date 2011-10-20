<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<base href="<%=basePath%>">
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/public.css" />
		<link rel="stylesheet" type="text/css"
			href="<%=basePath%>css/register.css">
		<script src="<%=basePath%>js/jquery-1.4.2.min.js"
			type="text/javascript"></script>
			<script src="<%=basePath%>js/register.js"
			type="text/javascript"></script>
	</head>
	<body>
		<s:include value="/inc/top.jsp"></s:include>
		<div id="center">
			<div id="left">
				<h3>注册用户</h3>
				<s:if test="actionErrors[0]!=null">
					<script>
						alert("<s:property value='actionErrors[0]'/>"); 
					</script>
				</s:if>
				<form action="<%=basePath%>/users_save.action" id="registerForm"  enctype="multipart/form-data" method="post" >
					<table id="registerBanner" cellpadding="0" cellspacing="0">
						<tr>
							<td class="group_l" width="72px;">
								用户名：
							</td>
							<td style="width: 320px">
								<input type="text" id="username" value="<s:property value='user.name'/>" name="user.name" class="input" />
							</td>
							<td>
							<span id="usernamespan"></span>
							</td>
						</tr>
						<tr>
							<td class="group_l" width="72px;">
								Email：
							</td>
							<td style="width: 320px">
								<input type="text" id="email" value="<s:property value='user.email'/>" name="user.email" class="input" />
							</td>
							<td>
							<span id="emailspan"></span>
							</td>
						</tr>
						<tr>
							<td class="group_l">
								密码：
							</td>
							<td>
								<input type="text" id="password" class="input" value="<s:property value='user.password'/>" name="user.password"/>
							</td>
							<td>
								<span id="passwordspan"></span>
							</td>
						</tr>
						<tr>
							<td class="group_l">
								确认密码：
							</td>
							<td>
								<input type="text" id="password2" class="input" name="password2"  value="<s:property value='password2'/>"/>
							</td>
							<td><span id="password2span"></span></td>
						</tr>
						<tr>
							<td class="group_l">
								QQ：
							</td>
							<td>
								<input type="text" id="qq" class="input" name="user.qq"  value="<s:property value='user.qq'/>"/>
							</td>
							<td><span id="qqspan"></span></td>
						</tr>
						<tr>
							<td class="group_l">
								性别：
							</td>
							<td>
								<select name="user.sex">
									<option value=0 <s:if test="user.sex==0">selected="selected"</s:if>>
										清选择
									</option>
									<option value=1 <s:if test="user.sex==1">selected="selected"</s:if>>
										男
									</option>
									<option value=2 <s:if test="user.sex==2">selected="selected"</s:if>>
										女
									</option>
								</select>
							</td>
							<td></td>
						</tr>
						<tr>
							<td class="group_l">
								头像：
							</td>
							<td>
								<input id="fileInput" name="upload" type="file" class="input" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td class="group_l">
								现居地址：
							</td>
							<td>
								<input type="text" name="user.address" value="<s:property value='user.address'/>" class="input" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td class="group_l">
								职业：
							</td>
							<td>
								<input type="text" name="user.work" value="<s:property value='user.work'/>" class="input" />
							</td>
							<td></td>
						</tr>
						<tr>
							<td class="group_l">
								验证码：
							</td>
							<td>
								<input name="piccode" type="text" style="width: 60px" maxlength="4" class="input" />
								<img src="<%=basePath%>/piccode"/>
							</td>
							<td></td>
						</tr>
						<tr>
							<td class="group_l"></td>
							<td>
								<input name="checkbox" checked="checked" type="checkbox" id="checkbox" />
								<label for="checkbox">
									我已认真阅读并同意
									<a href="">《免责声明》</a>
								</label>
							</td>
							<td></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<button class="btn" id="btn_sub" type="submit">
									提交
								</button>
								<button class="btn" type="reset">
									重置
								</button>
							</td>
							<td></td>
						</tr>
					</table>
				</form>
			</div>
			<s:include value="/inc/right.jsp"></s:include>
		</div>
		<s:include value="/inc/bottom.jsp"></s:include>
	</body>
</html>