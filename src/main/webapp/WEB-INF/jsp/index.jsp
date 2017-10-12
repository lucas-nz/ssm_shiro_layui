<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@include file="common/tag.jsp"%>
<%
  String path = request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>esys</title>
<link rel="shortcut icon" href="<%=path%>/resources/images/favicon.ico">
<link rel="stylesheet" href="<%=path%>/resources/index/css/index.css"
	charset="UTF-8" />
<link rel="stylesheet"
	href="<%=path%>/resources/font-awesome/css/font-awesome.css" />
<link rel="stylesheet" href="<%=path%>/resources/layui/css/layui.css" />
<script type="text/javascript"
	src="<%=path%>/resources/jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="<%=path%>/resources/layui/layui.js"
	charset="UTF-8"></script>

<style type="text/css">
</style>
</head>
<body>
	<div class="header">
		<div class="main">
			<a href="#" class="logo"><img
				src="<%=path%>/resources/images/tattoo67.png" /><i
				class="layui-icon">&#xe756;</i> </a>

			<div class="nav">
				<a href="./esysdoc"> <i class="layui-icon">&#xe705;</i> <font>文档</font>
				</a> <a href="./esysvadio"> <i class="layui-icon">&#xe6ed;</i> <font>教学视频</font>
				</a> <a href="./esystest"> <i class="layui-icon">&#xe6b2;</i> <font>检验</font>
				</a>

			</div>
			<div class="nav-user">
				<div class="nav-guest">
					<shiro:guest>
						<span> 
						<a href="#"> <span><i
									class="fa fa-user-circle-o fa-5x"></i></span></a> <a href="./toLogin">登录</a>
							<a href="#">注册</a>

						</span>
						<a href="#"> <i class="fa fa-qq" style="font-size: 20px;"></i>
						</a>
						<a href="#"> <i class="fa fa-wechat" style="font-size: 20px;"></i></a>
					</shiro:guest>

				</div>
				<shiro:user>
					<ul class="layui-nav" style="margin-top: -15px">
						<li class="layui-nav-item">
						<a> <img
								src="<%=path%>/resources/images/handsome.jpg"
								style="border-radius: 100%;" /> <span><shiro:principal></shiro:principal></span>
						</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;">修改信息</a>
								</dd>
								<dd>
									<a href="./user/album">个人相册</a>
								</dd>								
								<dd>
									<a href="javascript:;">安全管理</a>
								</dd>
								<dd>
									<a href="./logout">退了</a>
								</dd>
							</dl></li>
					</ul>
				</shiro:user>

			</div>
		</div>
	</div>
	<div class="main-body">
		<div class="content">
			<!-- es-tab start -->
			<div class="es-tab">
				<div class="layui-tab layui-tab-brief" lay-filter="index-tab-filter">
					<ul class="layui-tab-title" style="height: 50px;">
						<li class="layui-this">全部帖子</li>
						<li>全部题目</li>
						<li>权限分配</li>
						<li>商品管理</li>
						<li>订单管理</li>
					</ul>
					<div class="es-search">
						<a href="#"><i class="layui-icon" style="font-size: 30px;">&#xe615;</i></a>
					</div>
					<div class="layui-tab-content es-panel es-list"
						style="min-height: 400px;">
						<div class="layui-tab-item layui-show">内容1</div>
						<div class="layui-tab-item" id="subjectList">


							<li>
								<h2>测试测试测试测试测试测试</h2>
							</li>
							<li>
								<h2>测试测试测试测试测试测试</h2>
							</li>
						</div>
						<div class="layui-tab-item">内容3</div>
						<div class="layui-tab-item">内容4</div>
						<div class="layui-tab-item">内容5</div>
					</div>
					<div id="tabPage" class="es-page page-panel"></div>
				</div>
			</div>
			<!-- es-tab end -->



		</div>
		<div>${resultSet }</div>
		<div id="indexPage" class="es-page"></div>
	</div>
	<input id="subTotal" type="hidden" value="${total }">
	<input id="pageUrl" type="hidden" value="">
	<script type="text/javascript"
		src="<%=path%>/resources/index/js/index.js"></script>
</body>

</html>