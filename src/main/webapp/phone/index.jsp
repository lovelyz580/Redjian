<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="ZH-cn">
	<head>
		<meta charset="utf-8">
		<title>首页</title>
		<link rel="stylesheet" href="<%=basePath%>resources/kit_admin/plugins/layui/css/layui.css" media="all">   
	<link rel="stylesheet" href="<%=basePath%>resources/kit_admin/plugins/font-awesome/css/font-awesome.min.css" media="all" />
	<link rel="stylesheet" href="<%=basePath%>resources/kit_admin/src/css/app.css" media="all" />
	<link rel="stylesheet" href="<%=basePath%>resources/kit_admin/src/css/themes/default.css" media="all" id="skin" kit-skin />
	<style>body html{ overflow:hidden}</style>
	<script src="<%=basePath%>resources/kit_admin/plugins/layui/layui.js"></script>
	<script src="<%=basePath%>resources/js/jquery-3.2.1.min.js" type="text/javascript"></script> 
	<script src="<%=basePath%>resources/js/json2.js" type="text/javascript"></script>
	<script src="<%=basePath%>resources/js/sun.js" type="text/javascript"></script>
		<meta content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user1-scalable=0" name="viewport">
		<meta content="yes" name="apple-mobile-web-app-capable">
		<!-- <meta content="black" name="apple-mobile-web-app-status-bar-style"> -->
		<meta content="telephone=no" name="format-detection">
	<!-- 	<link rel="stylesheet" type="text/css" href="../plugins/layui/css/layui.css"/>
		<link rel="stylesheet" type="text/css" href="css/main.css"/> -->
		<style type="text/css">
			.layui-form-item input{
				height: 25px;
			}
		</style>
	</head>
	<body>cc
		<div id="app" class="pos-re wid-1000 hei-1000">
			<!-- 占位 -->
			<div class=" hei-100">
				
			</div>
			<!-- 标题 -->
			<div class="txta-c">
				<p class="fsiz-20 color-f43 txta-c"><b>全国艺术特长生社会艺术水平</b></p>
				<span class="lnh-40"><b>认证查询</b></span>
			</div>
			<!-- 表单 -->
			<form class="layui-form pad-l-15 pad-r-15 layui-col-sm6 layui-col-sm-offset3" action="">
			  <div class="layui-form-item">
				  <input type="text" name="uname" required  lay-verify="required" placeholder="您的姓名" autocomplete="off" class="layui-input">
			  </div>
			  <div class="layui-form-item">
				  <input type="text" name="number" required lay-verify="required" placeholder="身份证号" autocomplete="off" class="layui-input">
			  </div>
			  <div class="layui-form-item">
				<div class="layui-input-block mar-0">
				  <button class="layui-btn wid-1000 bg-color-f43" lay-submit lay-filter="formDemo">立即提交</button>
				</div>
			  </div>
			</form>
			<!-- 底部 -->
			<div class="pos-fix bottom-0 txta-c wid-1000 color-889-hf fsiz-12 lnh-40">
				<img src="img/RQCode.png" class="wid-60" >
				<p class=" color-889">手机版</p>
				@2019&nbsp;
				<a href="" class="color-889-hf">文化部艺术发展中心</a>
				&nbsp;冀ICP备00000000号
			</div>
		</div>
		
		<script type="text/javascript">
			// document.getElementById('app').style.height = window.screen.height +'px'
			
		</script>
	</body>
</html>