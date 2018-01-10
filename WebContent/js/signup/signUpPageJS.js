/**
 * 
 */

var func = function() {
	var url = "/medialive/signUp"
	var param = $(".signUpinput");
	console.log("roomName:" + param[0].value + "," + "streamName:"
			+ param[1].value)
	$.post(url, {
		roomName : param[0].value,
		streamName : param[1].value
	}, function(data) {
		var a = $("<a></a>");
		a.text(data);
		a.css("color","red");
		a.attr("class","response");
		$("#signUpForm").children().filter(".response").remove();
		$("#signUpForm").append(a);
	});

}

$("#signUpButton").on("click", func);
