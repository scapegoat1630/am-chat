<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>AM聊天</title>
	<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/lbt.js"></script>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/login.css" type="text/css" media="all" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/BeatPicker.min.css"/>
	<script src="${pageContext.request.contextPath}/resources/js/BeatPicker.min.js"></script>

	<script type="text/javascript">

	$(function(){
		$('#create').click(function(){
			$.post(
				 '${pageContext.request.contextPath }/user/register',
				$('.register-form').serialize(),
				function(data){
					var response = eval(data);
					console.log(response);
					if(response.success == true){
						alert("创建成功");
						$('form').animate({height: "toggle", opacity: "toggle"}, "slow");
					}
				}
			);
		});
		$('.message a').click(function(){
			$('form').animate({height: "toggle", opacity: "toggle"}, "slow");
		});

	});

</script>

</head>
<body>
<!--头部开始-->
<div class="header">
	<h1>AM聊天室系统</h1>
</div>
<!--头部end-->
<!--登陆区域开始-->
<div class="login-page">
	<div class="form">
		<form class="register-form"  onSubmit = "return false;">
			<input type="text" name="name" placeholder="用户名"/>
			<input type="password" name="password"  placeholder="密码"/>
			<input type="text"  name="nickname" placeholder="昵称"/>
			<input type="text" name="age"  placeholder="年龄"/>
			<input type="text" placeholder="生日" data-beatpicker="true" name="birthday" data-beatpicker-module="today,clear" data-beatpicker-module="icon" data-beatpicker-position="['*','*']">
			<input type="text" name="email"  placeholder="email address"/>
			<button id="create">创建用户</button>
			<p class="message">已经注册? <a href="#">登录</a></p>
		</form>
		<form class="login-form" action="${pageContext.request.contextPath }/user/login"  method="post">
			<input type="text" placeholder="name" name="name"/>
			<input type="password" placeholder="password" name="password"/>
			<button>登录</button>
			<p class="message">没有注册? <a href="#">注册</a></p>
		</form>
	</div>
</div>
<!--登陆区域结束-->


</body>
</html>