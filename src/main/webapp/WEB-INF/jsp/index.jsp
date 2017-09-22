<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>esys</title>
<link rel="shortcut icon" href="resources/images/favicon.ico">
<link rel="stylesheet" href="resources/index/css/index.css" />
<link rel="stylesheet"
	href="resources/font-awesome/css/font-awesome.css" />
<link rel="stylesheet" href="resources/layui/css/layui.css" />
<script type="text/javascript" src="resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript"
	src="resources/jquery.nicescroll-3.7.6/jquery.nicescroll.js"></script>
<script type="text/javascript" src="resources/layui/layui.js"></script>

<style type="text/css">
</style>
</head>
<body>
	<div class="header">
		<div class="main">
			<a href="#" class="logo"><img src="resources/images/tattoo67.png" /><i
				class="layui-icon">&#xe756;</i> </a>

			<div class="nav">
				<a href="#"> <i class="layui-icon">&#xe705;</i> <font>文档</font>
				</a> <a href="#"> <i class="layui-icon">&#xe6ed;</i> <font>教学视频</font>
				</a> <a href="#"> <i class="layui-icon">&#xe6b2;</i> <font>检验</font>
				</a>

			</div>
			<div class="nav-user">
				<a href="#"> <span><i class="fa fa-user-circle-o fa-5x"></i></span>
				</a> <span> <a href="#">登录</a> <a href="#">注册</a>
				</span> <a href="#"> <i class="fa fa-qq" style="font-size: 20px;"></i>
				</a> <a href="#"> <i class="fa fa-wechat" style="font-size: 20px;"></i>
				</a>

			</div>
		</div>
	</div>
	<div class="main-body">
		<div class="content">
			<!-- es-tab start -->
			<div class="es-tab">
				<div class="layui-tab layui-tab-brief">
					<ul class="layui-tab-title" style="height: 50px;">
						<li class="layui-this">网站设置</li>
						<li>用户管理</li>
						<li>权限分配</li>
						<li>商品管理</li>
						<li>订单管理</li>
					</ul>
					<div class="es-search">
						<a href="#"><i class="layui-icon" style="font-size: 30px;">&#xe615;</i></a>
					</div>
				</div>
			</div>
			<!-- es-tab end -->

			<!-- es-panel start -->
			<ul class="es-panel es-list">
				<li><a href="esys.html" class="es-avator"><img
						src="resources/images/tattoo67.png" /></a>
					<h2>
						<a href="#">测试测试测试测试测试测试</a>
					</h2></li>
				<li><a href="esys.html" class="es-avator"><img
						src="resources/images/tattoo67.png" /></a>
					<h2>测试测试测试测试测试测试</h2></li>
				<li><a href="esys.html" class="es-avator"><img
						src="resources/images/tattoo67.png" /></a>
					<h2>测试测试测试测试测试测试</h2></li>
				<li><a href="esys.html" class="es-avator"><img
						src="resources/images/tattoo67.png" /></a>
					<h2>测试测试测试测试测试测试</h2></li>
				<li><a href="esys.html" class="es-avator"><img
						src="resources/images/tattoo67.png" /></a>
					<h2>测试测试测试测试测试测试</h2></li>
				<li><a href="esys.html" class="es-avator"><img
						src="resources/images/tattoo67.png" /></a>
					<h2>测试测试测试测试测试测试</h2></li>
				<li><a href="esys.html" class="es-avator"><img
						src="resources/images/tattoo67.png" /></a>
					<h2>测试测试测试测试测试测试</h2></li>
				<li><a href="esys.html" class="es-avator"><img
						src="resources/images/tattoo67.png" /></a>
					<h2>测试测试测试测试测试测试</h2></li>
			</ul>
			<!-- es-panel end -->

		</div>
		<div id="indexPage" class="es-page"></div>
	</div>
	<input id="subTotal" type="hidden" value="${total }">
	<script type="text/javascript" src="resources/index/js/index.js"></script>
	<script type="text/javascript">
    
  </script>
</body>

</html>