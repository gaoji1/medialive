/**
 * 回放信息页面JS
 */
var func = function(){
	var url = "/medialive/playback";
	$.get(url,function(data){
//		var json = JSON.parse(data);
//		for(x in json){
//			var row = $("<tr></tr>");
//			var id = $("<td>"+json[x].id+"</td>");
//			var roomtd = $("<td></td>")
//			var room = $("<a>"+json[x].roomName+"</a>");
//			room.attr("href","./livePlay.html?id="+json[x].id);
//			roomtd.append(room);
//			var stream = $("<td>"+json[x].streamName+"</td>");
//			row.append(id).append(roomtd).append(stream);
//			$("#liveTable").append(row);
//		}
	});
}

$(func);