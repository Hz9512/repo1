window.onload = function() {
	var usernameText = document.getElementsByName("username")[0];
	usernameText.focus();

	usernameText.onblur = function() {
		// 1.创建一个XMLhttpRequest对象
		var xhr = new XMLHttpRequest();
		// 2.打开和服务器的连接
		var username = usernameText.value;
		xhr.open("POST", "RegistServlet", true);
		// 模拟form表单提交
		xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
		// 3.发送请求到服务器
		xhr.send("action=isExitUsername&username=" + username);
		// 4.接收响应信息
		xhr.onreadystatechange = function() {
			if (xhr.status == 200 && xhr.readyState == 4) {
				document.getElementById("span1").innerHTML = xhr.responseText;
			}
		}
	}
}