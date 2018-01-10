/**
 * 回放信息页面JS
 */
var func = function(){
	var url = "/medialive/playback";
	$.get(url,function(data){
		var json = JSON.parse(data);
		for(x in json){
			var row = $("<tr></tr>");
			var id = $("<td>"+json[x].id+"</td>");
			var streamtd = $("<td></td>")
			var stream = $("<a>"+json[x].streamName+"</a>");
			stream.attr("href","./playbackPlay.html?id="+json[x].id);
			streamtd.append(stream);
			var date = $("<td>"+new Date(json[x].liveDate).toLocaleDateString()+"</td>");
			row.append(id).append(streamtd).append(date);
			$("#playbackTable").append(row);
		}
	});
}

$(func);