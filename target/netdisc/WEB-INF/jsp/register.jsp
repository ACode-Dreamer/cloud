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
<title>注册云端网盘账号</title>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/register.css">
<script type="text/javascript" src="${basePath}/static/js/register.js"></script>
</head>
<body>
	<div id="register">
		<div class="registerTop">
			<div class="topContent">
				<div class="contentLeft">
					<span class="logoBg"></span> <span
						style="border-left: 1px solid #C9C9C9; margin-left: 10px; padding-left: 10px">注册云端网盘账号</span>
				</div>
				<div class="contentRight">
					<span>已有账号</span> <span class="login"> <a href="login">
							<input type="button" value="登录" />
					</a>
					</span>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div class="content">
			<div class="reContent">
				<div class="reContentLeft">
					<form action="register.do" method="post"
						onsubmit="return checkLoad()">
						<div>
							用户名称：<input type="text" id="username" name="username"
								placeholder="请输入用户名">
						</div>
						<div>
							手机号码：<input type="text" id="telephone" name="telephone"
								placeholder="用于登录或找回密码">
						</div>
						<div>
							电子邮箱：<input type="text" id="email" name="email"
								placeholder="可用于登录或找回密码">
						</div>
						<div>
							用户密码：<input type="password" id="password" name="password"
								placeholder="请输入密码">
						</div>
						<div>
							确认密码：<input type="password" id="repass" name="repass"
								placeholder="请输入密码以进行确认">
						</div>
						<div class="check">
							<input type="checkbox" id="agreement" name="agreement" />接受并阅读《<span>QST用户协议</span>》
						</div>
						<div class="regis">
							<input type="submit" value="注册">
						</div>
						<p align="center">${msg}</p>
					</form>
				</div>
				<div class="reContentRight">
					<div class="rightContent">
						<div class="phone">
							<span class="phoneBg"></span> <span>手机快速注册</span>
						</div>
						<div class="send">
							<p>请使用中国大陆手机号，编辑短信：</p>
							<p style="color: #F18300; font-size: 14px">6-14位字符（支持数字/字母/符号）</p>
						</div>
						<div class="send">
							<p>作为登录密码，发送至：</p>
							<p style="color: #F18300">1232 2312 23212</p>
							<p>即可注册成功，手机号即为登录号</p>
						</div>
					</div>
				</div>
				<div style="clear: both;"></div>
			</div>
		</div>
		<div class="reBottom">
			<img src="${basePath}/static/images/foot_pic.jpg">
		</div>
	</div>
</body>
</html>