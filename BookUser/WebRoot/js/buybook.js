function fbtn() {
	// 1.����һ��XMLhttpRequest����
	var xhr = new XMLHttpRequest();
	// 2.�򿪺ͷ�����������
	xhr.open("POST", "ShopCarServlet", true);
	// ģ��form���ύ
	xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	// 3.�������󵽷�����
	xhr.send("action=gouwuche");
	// 4.������Ӧ��Ϣ
	xhr.onreadystatechange = function() {
		if (xhr.status == 200 && xhr.readyState == 4) {
			document.getElementById("count").innerHTML = xhr.responseText;
		}
	};
};
