/**
 * 负责调用视频播放器API
 * 
 */
/**
 * 极酷播放器视频播放参数
 * 
 * @param {Object}
 *            width 视频宽度
 * @param {Object}
 *            height 视频高度
 * @param {Object}
 *            imgUrl 图片地址
 * @param {Object}
 *            videoUrl 视频文件地址
 * @param {Object}
 *            divID 显示的divID
 */

function getAddressURLParam(paramName)  
{  
     //构造一个含有目标参数的正则表达式的对象  
     var reg = new RegExp("(^|&)" + paramName + "=([^&]*)(&|$)");  
     //匹配目标参数  
     var url = window.location.search.substr(1).match(reg);  
    //返回参数值  
    if(url != null)  
     return unescape(url[2]);  
    return null;  
}  

var playerFunc = function() {
	var so = new SWFObject("player.swf", "CuSunPlayer", "700", "410", "9",
			"#000000");
	so.addParam("allowfullscreen", "true");
	so.addParam("allowscriptaccess", "always");
	so.addParam("wmode", "opaque");
	so.addParam("quality", "high");
	so.addParam("salign", "lt");
	// 播放器设置文件-----------------------------
	so.addVariable("JcScpFile", "CuSunV4setLive.xml"); // 配置文件
	so.addVariable("JcScpServer", "rtmp://localhost/myApp"); // 流媒体服务器
	so.addVariable("JcScpVideoPath", "firststream"); // 直播流名称
	so.addVariable("JcScpAutoPlay", "yes"); // 是否自动播放
	so.addVariable("JcScpSharetitle", "欢迎来到直播间"); // 视频标题
	so.write("CuPlayer");
}

var func = function() {
	var id = getAddressURLParam("id");
	alert(id);
}

$(func)
