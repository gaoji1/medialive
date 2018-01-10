/**
 * 直播信息展示页面JS
 */
var fun = function() {
	var url = "/medialive/live";
	var param = {name:"123", age:"12"};
	$.get(url,param,function(data){
		alert(1);
	});
}
$(fun);