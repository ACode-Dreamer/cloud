/**
 * 
 */
function showFullPage() {
	var contentRight = document.getElementById('contentRight');
	var fixedBtn = document.getElementById('fixedBtn');
	var contentLeft = document.getElementById('contentLeft');
	var hideBtn = document.getElementById('hideBtn');
	contentLeft.style.display = 'none';
	contentRight.style.width = '100%';
	hideBtn.style.display = '';
	fixedBtn.style.display = 'none';
}
function hideFullPage() {
	var contentRight = document.getElementById('contentRight');
	var fixedBtn = document.getElementById('fixedBtn');
	var contentLeft = document.getElementById('contentLeft');
	var hideBtn = document.getElementById('hideBtn');
	contentLeft.style.display = '';
	contentRight.style.width = '80.5%';
	fixedBtn.style.display = '';
	hideBtn.style.display = 'none';
}
function showFileUpload(url) {
	 //file的change事件
    $('#uploadFile').change(function () {
        //提交form表单的数据
        $('#uploadForm').submit();
        //alert($('#uploadFile').val());
        
        // 清空file标签的value，否则再次提交此文件时，onchange事件就不触发了
        $('#uploadFile').val(''); 
        
    }); 
    
	 //触发file的点击事件
    $('#uploadFile').click();
}
function getPath(obj) {
	if (obj) {
		if (window.navigator.userAgent.indexOf("MSIE") >= 1) {
			obj.select();
			return document.selection.createRange().text;
		} else if (window.navigator.userAgent.indexOf("Firefox") >= 1) {
			if (obj.files) {
				return obj.files.item(0).getAsDataURL();
			}
			return obj.value;
		} else {
			// 支持html5的浏览器,比如高版本的firefox、chrome、ie10
			if (obj.files && obj.files[0]) {
				var reader = new FileReader();
				reader.onload = function(e) {
					// alert(JSON.stringify(obj.files[0]));
					return e.target.result;
				};
				reader.readAsDataURL(obj.files[0]);
			}
		}
		return obj.value;
	}
}