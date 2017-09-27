<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="shortcut icon" href="resources/images/favicon.ico">
<link rel="stylesheet" href="resources/index/css/index.css"
	charset="UTF-8" />
<link rel="stylesheet"
	href="resources/font-awesome/css/font-awesome.css" />
<link rel="stylesheet" href="resources/layui/css/layui.css" />
<script type="text/javascript" src="resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="resources/layui/layui.js"
	charset="UTF-8"></script>
<style type="text/css">
</style>
</head>
<body>
	<div class="header">
		<div class="main">
			<a id="toIndex" href="./index" class="logo"><img src="resources/images/tattoo67.png" /><i
				class="layui-icon">&#xe756;</i> </a>

			<div class="nav">
				<a href="./esysdoc"> <i class="layui-icon">&#xe705;</i> <font>文档</font>
				</a> <a href="./esysvadio"> <i class="layui-icon">&#xe6ed;</i> <font>教学视频</font>
				</a> <a href="./esystest"> <i class="layui-icon">&#xe6b2;</i> <font>检验</font>
				</a>

			</div>
			<div class="nav-user">
				<a href="#"> <span><i class="fa fa-user-circle-o fa-5x"></i></span></a>
				<span> <shiro:guest>
						<a href="./toLogin">登录</a>
						<a href="#">注册</a>
					</shiro:guest>
				</span> <a href="#"> <i class="fa fa-qq" style="font-size: 20px;"></i>
				</a> <a href="#"> <i class="fa fa-wechat" style="font-size: 20px;"></i>
				</a>

			</div>
		</div>
	</div>
		<div class="main-body layui-clear">
			<div class="wrap">
				<div class="login-content">
					<div class="es-panel">
						<div class="layui-tab layui-tab-brief">
							<ul class="layui-tab-title" style="height: 50px;">
								<li class="layui-this">
									<a href="login.html">登录</a>
								</li>
								<li>
									<a href="register.html">注册</a>
								</li>
							</ul>
						</div>
						<div  id="loginDiv" class="layui-form layui-form-pane" style="margin-top: 20px;">

							<div class="layui-form-item">
								<label class="layui-form-label">用户名</label>
								<div class="layui-input-inline">
									<input type="text" name="username" autoFocus="true" 
										lay-verify="username" placeholder="请输入用户名" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">密码</label>
								<div class="layui-input-inline">
									<input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<label class="layui-form-label">人类验证</label>
								<div class="layui-input-inline">
									<input type="text" name="vcode" lay-verify="required" placeholder="" autocomplete="off" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item">
								<button id="loginBtn" class="layui-btn" lay-submit lay-filter="loginForm">立即登录</button>
								<span style="margin-left: 20px;"><a href="#">忘记密码</a></span>
							</div>
						</div>
						</div>
					</div>

				</div>

			</div>
			<script type="text/javascript" src="resources/index/js/index.js"></script>
			<script type="text/javascript" src="resources/index/js/login.js"></script>
	<script type="text/javascript">
    
  </script>
</body>

</html>