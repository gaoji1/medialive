/**
 * 
 */

var func = function() {
	// 设置请求url
	var url = "/medialive/signUp"
	// 获取inpu标签
	var param = $(".signUpinput");
	// 发送post AJAX请求
	/**
	 * 请求成功执行 
	 * 1)生成<a>标签 
	 * 2)把传回的数据(直播间验证信息)加到<a>标签中 
	 * 3)设置<a>标签颜色为红色 
	 * 4)把<a>标签加入到表单最后
	 */
	$.post(url, {
		roomName : param[0].value,
		streamName : param[1].value
	}, function(data) {
		var a = $("<a></a>");
		a.text(data);
		a.css("color", "red");
		a.attr("class", "response");
		$("#signUpForm").children().filter(".response").remove();
		$("#signUpForm").append(a);
	});

}

$("#signUpButton").on("click", func);
