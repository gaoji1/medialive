/**
 * 直播信息展示页面JS
 */
var fun = function() {
	var url = "/medialive/live";
	$.get(url,function(data){
		
		var json = JSON.parse(data);
		for(x in json){
			var row = $("<tr></tr>");
			var id = $("<td>"+json[x].id+"</td>");
			var roomtd = $("<td></td>")
			var room = $("<a>"+json[x].roomName+"</a>");
			room.attr("href","/medialive/livePlay.html?id="+json[x].id);
			roomtd.append(room);
			var stream = $("<td>"+json[x].streamName+"</td>");
			row.append(id).append(roomtd).append(stream);
			$("#liveTable").append(row);
		}
	});
}
$(fun);