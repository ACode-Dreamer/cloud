<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="UTF-8">
<title>云端网盘</title>
<link rel="stylesheet" type="text/css" href="./css/index.css">
<script type="text/javascript" src="./js/index.js"></script>
<script type="text/javascript" src="./js/jquery/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				function show() {
					var timestamp = new Date().valueOf();
					$.get("ajax.do?type=up&t=" + timestamp, function(data,
							status) {
						var dl = jQuery.parseJSON(data);
						var cit = $("#uploadlist");
						if (cit.size() > 0) {
							cit.find("tr:not(:first)").remove();
						}
						//alert(data);
						var dl = jQuery.parseJSON(data);
						for (i = 0; i < dl.length; i++) {
							var status = dl[i].udProcess == '100.0%' ? '上传完成'
									: '正在上传';
							$("#uploadlist").append(
									"<tr>" + "<td>" + dl[i].udName + "</td>"
											+ "<td>" + dl[i].udPath + "</td>"
											+ "<td>" + dl[i].udSize + "</td>"
											+ "<td>" + dl[i].udProcess
											+ "</td>" + "<td>" + status
											+ "</td>" + "</tr>");
						}
					});
				}
				window.setInterval(show, 1000); // websocket

			});
</script>
</head>
<body>
	<div id="index">
		<div class="cloud">
			<div class="banner">
				<div class="bannerLeft">
					<span class="logoBg"></span> <span
						style="font-size: 22px; font-weight: bold">云端网盘</span>
				</div>
				<div class="bannerCenter">
					<ul>
						<li><a href="index.do">网盘</a></li>
						<li><a href="index.do">分享</a></li>
						<li class="active"><a href="fileupload.jsp">正在上传</a></li>
						<li><a href="filedownload.jsp">正在下载</a></li>
					</ul>
				</div>
				<div class="bannerRight">
					<span class="person"><img src="./images/person.jpg"></span> <span>${sessionScope.user.userName }</span>
					<span style="margin-left: 10px; margin-right: 10px;">丨</span> <span>当前目录:${sessionScope.currentFolder.hdfsPath }</span>
					<span style="margin-left: 10px; margin-right: 10px;">丨</span> <span><a
						href="">客户端下载</a></span> <span class="center">会员中心</span>
				</div>
			</div>
			<div class="content">
				<div class="contentRight" id="contentRight" style="width: 95%">
					<div class="operat">
						<div class="operatLeft">
							<div onclick="showFileUpload('hdfs.do?type=upload')">
								<i class="operatLeftBg bg1"></i>上传
							</div>
							<div>
								<i class="operatLeftBg bg2"></i>新建文件夹
							</div>
						</div>
					</div>
					<div class="file">
						<table rules="rows" frame="below" bordercolor="#F2F6FD">
							<tr style="background-color: white;">
								<td colspan="2">全部文件</td>
								<td colspan="2" align="right">已加载全部，共10个</td>
							</tr>
						</table>
						<table id="uploadlist" rules="rows" frame="below"
							bordercolor="#F2F6FD">
							<tr style="background-color: silver;">
								<td>文件名</td>
								<td>上传路径</td>
								<td>大小</td>
								<td>进度</td>
								<td>状态</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form id="uploadForm" action="upload.do" method="post"
		enctype="multipart/form-data">
		<input type="file" name="uploadFile" id="uploadFile"
			style="visibility: hidden; position: absolute; top: 0px; width: 0px" />
	</form>
</body>
</html>