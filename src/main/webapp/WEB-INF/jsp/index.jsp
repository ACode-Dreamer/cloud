<%@ page import="com.ssm.pojo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<title><spring:message code="TITLE"/> </title>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/index.css">
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/jquery/easyui.css">
<%--<link rel="stylesheet" type="text/css" href="${basePath}/static/css/jquery/icon.css">--%>
<link rel="stylesheet" type="text/css" href="${basePath}/static/css/jquery/demo.css">
<script type="text/javascript" src="${basePath}/static/js/jquery/jquery.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/jquery/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${basePath}/static/js/index.js"></script>
<script type="text/javascript">
	function deleteFolderFun(folderId) {
		var res = window.confirm("确定要删除该文件吗？");
		if (res) {
			$.ajax({
				type: "post",
				url: "deleteFolder",
				data: {folderId:folderId},
				dataType: "json",
				success: function(result){
					console.log(result);
					alert(result);
					window.location.reload();
				},
				error:function () {
					alert('错误');
				}
			});
		}
	}

	function deleteFileFun(fileId) {
		var res = window.confirm("确定要删除该文件吗？");
		if (res) {
			//alert("删除了:" + fileId + "文件");
			// window.location = "hdfs.do?type=deleteFile&fileId=" + fileId;
		$.ajax({
			type: "post",
			url: "delete",
			data: {fileId:fileId},
			dataType: "json",
			success: function(result){
				console.log(result);
				alert(result);
				window.location.reload();
			},
			error:function () {
				alert('错误');
			}
		});
		}
	}
</script>
</head>
<body>
	<div id="index">
		<div class="cloud">
			<div class="banner">
				<div class="bannerLeft">
					<span class="logoBg"></span> <span
						style="font-size: 22px; font-weight: bold"><spring:message code="TITLE"/></span>
				</div>
				<div class="bannerCenter">
					<ul>
						<li class="active"><a href="index"><spring:message code="wp"/></a></li>
						<li><a href="index"><spring:message code="fx"/></a></li>
						<li><a href="fileupload"><spring:message code="zzsc"/></a></li>
						<li><a href="filedownload"><spring:message code="zzxz"/></a></li>
					</ul>
				</div>
				<div class="bannerRight">
					<span><a href="translate?local=zh">中文</a></span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<span><a href="translate?local=en">English</a></span>
					<span>&nbsp;&nbsp;&nbsp;&nbsp;</span>
					<span class="person"><img src="${basePath}/static/images/person.jpg"></span> <span>${sessionScope.user.username }</span>
					<span style="margin-left: 10px; margin-right: 10px;">丨</span> <span><spring:message code="dqml"/>:
					<c:choose>
						<c:when test="${sessionScope.currentFolder==''}">
							主界面
						</c:when>
						<c:otherwise>
							<c:out value="${sessionScope.currentFolder}"></c:out>
						</c:otherwise>
					</c:choose>
			</span>
					<span style="margin-left: 10px; margin-right: 10px;">丨</span> <span><a
						href=""><spring:message code="khdxz"/> </a></span> <span class="center"><spring:message code="hyzx"/> </span>
				</div>
			</div>
			<div class="content">
				<div class="contentLeft" id="contentLeft">
					<ul>
                        <li class="active"><span class="contentBg bg1"></span>
                            <a href="index"> 全部文件</a>
                        </li>
						<c:forEach var="rf" items="${sessionScope.sysFolderList }">
							<li
								<c:if test="${sessionScope.currentFolder==rf.typename }">class="active"</c:if>>
								<a href="index.do?typeId=${rf.typeid}"> <c:out
										value="${rf.typename }"></c:out></a>
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
							<form action="search" method="post" id="search">
							<input name="condition" type="text" placeholder="搜索您的文件(名称 时间)" />
								<span class="searchBg" onclick="document.getElementById('search').submit();"></span>
								<span class="sort"></span> <span
								class="sortTwo"></span>
							</form>
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
									<td>
										<form id="${rf.folderid}" method="post" action="switchFolder">
											<input type="hidden" name="folderid" value="${rf.folderid}" />
											<input type="hidden" name="foldername" value="${rf.foldername}" />
											<input type="checkbox" disabled="disabled"
												   style="margin-right: 10px; margin-right: 50px" />
											<a href="#" onclick="document.getElementById(${rf.folderid}).submit();"
											><span class="folder"></span> <c:out value="${rf.foldername }"></c:out></a>
										</form>
									</td>
									<td class="hideArea"><span class="huishouq"
															   onclick="deleteFolderFun(${rf.folderid})"></span> </td>
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
										href="download?fileId=${rf.fileid }"><span
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
		<form action="createFolder" method="post">
			<table>
				<input type="hidden" name="currentFolder" value="${sessionScope.currentFolder}">
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
	<form id="uploadForm" action="upload" method="post"
		enctype="multipart/form-data">
		<input type="file" name="uploadFile" id="uploadFile"
			style="visibility: hidden; position: absolute; top: 0px; width: 0px" />
	</form>
</body>
</html>