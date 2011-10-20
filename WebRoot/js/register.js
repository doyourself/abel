var usernameV = false;
var emailV = false;
var passwordV = false;
var passwordV2 = false;
var time_clear;
$(function(){
	$("#username").click(function(){
		clearInterval(time_clear);
		$('#usernamespan').html('');
		$('#usernamespan').css('color','red');
	});
	$("#password").click(function(){
		clearInterval(time_clear);
		$('#passwordspan').html('');
		$('#password2span').html('');
		$('#passwordspan').css('color','red');
	});
	$("#password2").click(function(){
		clearInterval(time_clear);
		$('#password2span').html('');
		$('#password2span').css('color','red');
	});
	$("#email").click(function(){
		clearInterval(time_clear);
		$('#emailspan').html('');
		$('#emailspan').css('color','red');
	});
	$("#qq").click(function(){
		clearInterval(time_clear);
		$("#qqspan").html("");
		$('#qqspan').css('color','red');
	});
	
	$("#username").blur(function(){
		name();
	});
	$("#password").blur(function(){
		textPwd();
	});
	$("#password2").blur(function(){
		textPwd2();
	});
	$("#email").blur(function(){
		textEmail();
	});
	
	$('#phone').keydown(function(event){
		if(event.keyCode==13){
			register_sub();
		}
	});
	$('#btn_sub').click(function(e){
		e.preventDefault();
		register_sub();
	});
});
function register_sub(){
	if(!usernameV)name();
	if(!emailV)textEmail();
	if(!passwordV)textPwd();
	if(!passwordV2)textPwd2();
	time_clear = setInterval(function(){
		if(usernameV && passwordV && emailV && passwordV2){
			$("#registerBanner span").remove();
			clearInterval(time_clear);
			$(this).attr('disabled',true);
			$("#registerForm").submit();
		}
	}, 500);
}
function name() {
	$('#usernamespan').css('color','red');
	usernameV = false;
	var re = "^(?!_)(?!.?_$)[a-zA-Z0-9_]+$";
	var name_val = $('#username').val();
	var data = $.trim(name_val);
	$('#usernamespan').html('');
	var reg = new RegExp(re);
	if(data.length < 1){
		$('#usernamespan').html("用户名不能为空！");
	}else if(name_val.length != data.length){
		$('#usernamespan').html("用户名不能含有空格！");
	}else if(data.length > 20 || data.length < 4){
		$('#usernamespan').html("用户名输入长度有误！");
	}else if(!reg.test(data)){
		$('#usernamespan').html("用户名不能含有特殊字符！");
	}else if(reg.test(data)){
		$('#usernamespan').html("正在验证用户名！");
		$.ajax({
			url :"/Abel/users_nameOremail.action",type :"post", data:"value=" + data+"&type=username",timeout :20000,
			error : function(msg) {
				alert("服务器响应时间过长！请重新验证！");
			},
			success :function(msg){
				if(msg == 1){
					usernameV=true;
					$('#usernamespan').html("用户名验证成功！");
					$('#usernamespan').css('color','green');
				}else if(msg == 0){
					$('#usernamespan').html("用户名验证失败！已存在此用户！");
				}else{
					$('#usernamespan').html("");
					alert("非法操作！");
				}
			}
		});
	}
}
function textPwd(){
	passwordV=false;
	var data = $.trim($('#password').val());
	var data1= $('#password').val();
	$('#passwordspan').html('');
	$('#password2span').html('');
	if(data1.length < 4 || data1.length>20){
		$('#passwordspan').html(
			"输入的密码长度应为6—20位！"
		);
		$('#passwordspan').css('color','red');
	}else if(data.length != data1.length){
		$('#passwordspan').html("密码中不能含有空格！");
		$('#passwordspan').css('color','red');
	}else{
		passwordV = true;
		$('#passwordspan').html("密码输入正确！");
		$('#passwordspan').css('color','green');
	}
}
function textPwd2(){
	passwordV2=false;
	var pwd2=$('#password2').val();
	var pwd = $('#password').val();
	$('#password2span').html('');
	if(pwd==""){
		$('#password2span').html("请输入密码！");
		$('#password2span').css('color','red');
	}else if(pwd2 == ""){
		$('#password2span').html("请输入确认密码！");
		$('#password2span').css('color','red');
	}else if(pwd2 != pwd){
		$('#password2span').html("密码和确认密码不一致！");
		$('#password2span').css('color','red');
	}else{
		$('#password2span').html("密码和确认密码一致！");
		$('#password2span').css('color','green');
		passwordV2=true;
	}
}
function textEmail() {
	$('#emailspan').css('color','red');
	emailV = false;
	var data = $.trim($('#email').val());
	var reg = /^[a-zA-Z0-9]([a-zA-Z0-9]*[-_.]?[a-zA-Z0-9]+)+@([\w-]+\.)+[a-zA-Z]{2,}$/;
	$('#emailspan').html('');
	if(data.length > 50){
		$('#emailspan').html("邮箱字符超过50位！");
	}else if (!reg.test(data)) {
		$('#emailspan').html("邮箱格式输入不正确！");
	}else{
		$('#emailspan').html("正在验证邮箱！");
		$.ajax({ 
			url :"/Abel/users_nameOremail.action", type :"post", data:"value=" + data+"&type=email",timeout :20000,
			error : function(msg) {
				alert("服务器响应时间过长！请重新验证！");
			}, 
			success :function(msg){
				if(msg == 1){
					emailV = true;
					$('#emailspan').css('color','green');
					$('#emailspan').html("邮箱验证成功！可以使用！");
				}else if(msg == 0){
					$('#emailspan').html("邮箱验证失败！已存在此邮箱！");
				}else{
				$('#emailspan').html("");
					alert("非法操作！");
				}
			}
		});
	}
}

