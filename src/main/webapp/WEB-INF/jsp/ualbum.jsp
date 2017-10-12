<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
+ path + "/";
%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%@include file="common/tag.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>album</title>
<base href="<%=basePath%>">
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
			<a id="toIndex" href="index" class="logo"><img
				src="<%=path%>/resources/images/tattoo67.png" /><i
				class="layui-icon">&#xe756;</i> </a>

			<div class="nav">
				<a href="esysdoc"> <i class="layui-icon">&#xe705;</i> <font>文档</font>
				</a> <a href="esysvadio"> <i class="layui-icon">&#xe6ed;</i> <font>教学视频</font>
				</a> <a href="esystest"> <i class="layui-icon">&#xe6b2;</i> <font>检验</font>
				</a>

			</div>
			<div class="nav-user">
				<shiro:user>
					<ul class="layui-nav" style="margin-top: -15px">
						<li class="layui-nav-item"><a> <img
								src="<%=path%>/resources/images/handsome.jpg"
								style="border-radius: 100%;" /> <span id="username"><shiro:principal></shiro:principal></span>
						</a>
							<dl class="layui-nav-child">
								<dd>
									<a href="javascript:;">修改信息</a>
								</dd>
								<dd>
									<a href="user/album">个人相册</a>
								</dd>									
								<dd>
									<a href="javascript:;">安全管理</a>
								</dd>
								<dd>
									<a href="logout">退了</a>
								</dd>
							</dl></li>
					</ul>
				</shiro:user>


			</div>
		</div>
	</div>
	<div class="main-body layui-clear">
		<div class="wrap">
			<div class="login-content">
				<div class="es-panel">

					<div class="layui-row" style="height: 100%;">
						<div class="layui-col-md2">
							<div class="layui-upload-drag" id="albupl" style="margin-top: 20px;">
								<i class="layui-icon">&#xe67c;</i>拖拽上传图片
							</div>
						</div>
						<div class="layui-col-md10">
							<ul id="imgDiv" class="flow-default">
								
							</ul>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>

	<jsp:include page="common/footer.jsp"></jsp:include>


	<script type="text/javascript"
		src="<%=path%>/resources/index/js/index.js"></script>
	<script type="text/javascript"
		src="<%=path%>/resources/define/ualbum.js"></script>
	<script type="text/javascript">
    
  </script>
</body>

</html>