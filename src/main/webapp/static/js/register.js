/**
 * 
 */
function checkLoad() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var repass = document.getElementById("repass").value;
	var email = document.getElementById("email").value;
	var telephone = document.getElementById("telephone").value;
	var agreement = document.getElementById("agreement");

	if (username == null || username == "") {
		alert("用户名不能为空！");
		return false;
	}
	if (password == null || password == "") {
		alert("密码不能为空！");
		return false;
	}
	if (email == null || email == "") {
		alert("电子邮件不能为空！");
		return false;
	}
	if (telephone == null || telephone == "") {
		alert("电话号码不能为空！");
		return false;
	}
	if (repass == null || repass == "" || password != repass) {
		alert("密码两次输入不一致！");
		return false;
	}
	if (!agreement.checked) {
		alert("请先阅读用户协议！");
		return false;
	}
	return true;
}