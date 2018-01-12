/**
 * 播放回放视频页面js
 */
function getAddressURLParam(paramName) {
	// 构造一个含有目标参数的正则表达式的对象
	var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)");
	// 匹配目标参数
	var url = window.location.search.substr(1).match(reg);
	// 返回参数值
	if (url != null)
		return unescape(url[2]);
	return null;
}

var playerFunc = function(red5URL, fileName) {
//	获取主机名称(不含端口号)
	var a = window.location.host;
	var host = "";
	for (e in a) {
		if (a[e] == ":") {
			break;
		}
		host += a[e];
	}
//	设置播放器
	var so = new SWFObject("player.swf", "myCuPlayer", "700", "410", "9",
			"#000000");
	so.addParam("allowfullscreen", "true");
	so.addParam("allowscriptaccess", "always");
	so.addParam("wmode", "opaque");
	so.addParam("quality", "high");
	so.addParam("salign", "lt");
	// 播放器设置文件-----------------------------
	so.addVariable("JcScpFile", "CuSunV4set.xml"); // 配置文件
	so.addVariable("JcScpServer", "rtmp://"+host+red5URL); // 流媒体服务器rtmp://localhost/myApp
	so.addVariable("JcScpVideoPath", "flv:"+fileName+".flv"); // 直播流名称  "flv:sample.flv"
	so.addVariable("JcScpAutoPlay", "yes"); // 是否自动播放
	so.addVariable("JcScpSharetitle", "欢迎来到观看回放页面"); // 视频标题
	so.write("CuPlayer");
}

var func = function() {
	var id = getAddressURLParam("id");
	$.post("/medialive/playback", {
		id : id,
	}, function(data) {

		var jsonOBJ = JSON.parse(data);
		if (!jsonOBJ.id) {
			var warning = $("<p></p>")
			warning.text("对不起,找不到您选择的回放信息");
			$("#CuPlayer").append(warning);
		} else {
			playerFunc(jsonOBJ.red5URL, jsonOBJ.fileName);
		}

	});
}

$(func)