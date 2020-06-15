<%@ page import="com.ssm.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title>云端网盘</title>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/index.css">
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/jquery/easyui.css">
<%--<link rel="stylesheet" type="text/css" href="${basePath}/static/css/jquery/icon.css">--%>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/jquery/demo.css">
<script type="text/javascript" src="${basePath}/static/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/jquery/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${basePath}/static/js/index.js"></script>

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
						<li class="active"><a href="index">网盘</a></li>
						<li><a href="index">分享</a></li>
						<li><a href="fileupload.jsp">正在上传</a></li>
						<li><a href="filedownload.jsp">正在下载</a></li>
					</ul>
				</div>
				<div class="bannerRight">
					<span class="person"><img src="${basePath}/static/images/person.jpg"></span> <span>${sessionScope.user.username }</span>
					<span style="margin-left: 10px; margin-right: 10px;">丨</span> <span>当前目录:${sessionScope.currentFolder.hdfsPath }</span>
					<span style="margin-left: 10px; margin-right: 10px;">丨</span> <span><a
						href="">客户端下载</a></span> <span class="center">会员中心</span>
				</div>
			</div>
			<div class="content">
				<div class="contentLeft" id="contentLeft">
					<ul>
						<c:forEach var="rf" items="${sessionScope.sysFolderList }">
							<li
									<c:if test="${sessionScope.currentFolder.hdfsPath==rf.hdfsPath }">class="active"</c:if>>
								<a href="index.do?folderId=${rf.folderId}"> <c:out
										value="${rf.folderName }"></c:out></a>
							</li>
						</c:forEach>
						<li><span class="contentBg bg2"></span><a href="">我的分享</a></li>
						<li><span class="contentBg bg3"></span><a href="recycle">回收站</a></li>
					</ul>
				</div>
				<div class="contentRight" id="contentRight">
					<div class="fixedBtn" id="fixedBtn" onclick="showFullPage()">显示全部</div>
					<div class="fixedBtn" id="hideBtn" onclick="hideFullPage()"
						 style="display: none;">显示目录</div>
					<div class="operat">
						<div class="operatLeft">
							<div onclick="showFileUpload()">
								<i class="operatLeftBg bg1"></i> <a href="javascript:void(0)">上传</a>
							</div>
							<div>
								<i class="operatLeftBg bg2"></i><a href="javascript:void(0)"
																   onclick="$('#createFileWindow').window('open')">新建文件夹</a>
							</div>
							<div>
								<i class="operatLeftBg bg3"></i>离线下载
							</div>
							<div>
								<i class="operatLeftBg bg4"></i>我的设备
							</div>
						</div>
						<div class="operatRight">
							<input type="text" placeholder="搜索您的文件" /> <span
								class="searchBg"></span> <span class="sort"></span> <span
								class="sortTwo"></span>
						</div>
						<div style="clear: both;"></div>
					</div>
					<div class="file">
						<table rules="rows" frame="below" bordercolor="#F2F6FD">
							<tr>
								<td colspan="2">全部文件</td>
								<td colspan="2" align="right">已加载全部，共${fn:length(sessionScope.folderList)+fn:length(sessionScope.fileList) }个</td>
							</tr>
							<tr>
								<td colspan="2" width="200px"><input type="checkbox"
																	 disabled="disabled" style="margin-right: 10px" />文件名</td>
								<td>类型</td>
								<td>大小</td>
								<td>修改日期</td>
							</tr>
							<c:forEach var="rf" items="${sessionScope.folderList }">
								<tr>
									<td><input type="checkbox" disabled="disabled"
											   style="margin-right: 10px; margin-right: 50px" /> <a
											href="index.do?folderId=${rf.folderid}"><span
											class="folder"></span> <c:out value="${rf.foldername }"></c:out></a></td>
									<td class="hideArea"><a
											href="index.do?folderId=${rf.folderid}"><span
											class="share"></span></a></td>
									<td>目录</td>
									<td>-</td>
									<td><c:out value="${rf.createtime }"></c:out></td>
								</tr>
							</c:forEach>
							<c:forEach var="rf" items="${sessionScope.fileList }">
								<tr>
									<td><input type="checkbox" value="${rf.fileid }"
											   style="margin-right: 10px; margin-right: 50px" /> <span
											class="myfile"></span> <c:out value="${rf.filename }"></c:out></td>
									<td class="hideArea"><span class="huishouq"
															   onclick="deleteFileFun(${rf.fileid})"></span> <a
											href="hdfs.do?type=download&fileId=${rf.fileid }"><span
											class="download"></span></a></td>
									<td>文件</td>
									<td><c:out value="${rf.filesize }"></c:out></td>
									<td><c:out value="${rf.createtime }"></c:out></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

	<div id="createFileWindow" class="easyui-window" title="Modal Window"
		data-options="modal:true,closed:true,iconCls:'icon-save'"
		style="width: 300px; height: 120px; padding: 10px;">
		<form action="hdfs.do?type=createFolder" method="post">
			<table>
				<tr>
					<td>请输入文件夹名称:</td>
					<td><input id="folderName" name="folderName" type="text" /></td>
				</tr>
				<tr>
					<td></td>
					<td><button type="submit">提交</button></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>