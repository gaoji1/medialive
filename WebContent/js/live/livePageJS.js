/**
 * 直播信息展示页面JS
 */
var fun = function() {
	var url = "/medialive/live";
	$.get(url,function(data){
		console.log(data);
	});
}
$(fun);