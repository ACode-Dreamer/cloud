<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>云端网盘登录</title>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/login.css">
<script type="text/javascript" src="${basePath}/static/js/login.js"></script>
</head>
<body>
	<div id="cloud">
		<div class="login">
			<div class="loginTop">
				<div class="topLeft">
					<span class="logo"></span> <span class="logoName">云端网盘</span>
				</div>
				<div class="topRight">
					<ul>
						<li><a href="#">云端首页</a></li>
						<li><a href="#">APP下载</a></li>
						<li><a href="#">联系我们</a></li>
					</ul>
				</div>
			</div>
			<div class="loginContent">
				<form class="content" action="login.do" method="post"
					onsubmit="return checkLoad()">
					<p style="text-align: center; font-size: 18px;">账号密码登录</p>
					<input name="username" id="username" type="text"
						placeholder="账号/邮箱/用户名" class="ip" /> <input name="password"
						id="password" type="password" placeholder="密码" class="ip" />
					<div class="remeber">
						<input type="checkbox" value="记住密码">记住密码
					</div>
					<input type="submit" class="logon"
						value="登&nbsp;&nbsp;&nbsp;&nbsp;录">
					<p align="center">${msg}</p>
					<div class="loginType">
						<ul>
							<li class="floatLi Bg1"></li>
							<li class="floatLi Bg2"></li>
							<li class="floatLi Bg3"></li>
							<li class="floatLi Bg4"></li>
							<li style="clear: both;"></li>
						</ul>
					</div>
					<div class="loginBottom">
						<ul>
							<li><input type="button" value="忘记密码？"></li>
							<li><a href="register"><input type="button"
									value="立即注册"></a></li>
						</ul>
					</div>
				</form>
			</div>
		</div>
		<div class="version">
			<ul>
				<li class="bottom versionBg1"></li>
				<li class="bottom versionBg2"></li>
				<li class="bottom versionBg3"></li>
				<li class="bottom versionBg4"></li>
				<li style="clear: both;"></li>
			</ul>
		</div>
	</div>
</body>
</html>