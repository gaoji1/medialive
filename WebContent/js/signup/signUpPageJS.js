/**
 * 
 */

var func = function() {
	var url = "/medialive/signUp"
	var param = $(".signUpinput");
	console.log("roomName:"+param[0].value+","+"streamName:"+param[1].value)
	$.post(url,{ roomName: param[0].value, streamName: param[1].value },
			function(data){
		console.log(data);
	});

}

$("#signUpButton").on("click", func);
