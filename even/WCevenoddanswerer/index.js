var xmlHttpRequest;

function sendWithGetMethod() {
        var numberElement = document.getElementById("number");
        var url = "execute?number=" + numberElement.value + "&method=get";

	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.onreadystatechange = receive;
	xmlHttpRequest.open("GET", url, true);
	xmlHttpRequest.send(null);
}

function receive() {
	if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
		var response = JSON.parse(xmlHttpRequest.responseText);
	    var answerElement = document.getElementById("answer");
	    answerElement.innerHTML = response.answer;
	}
}


window.addEventListener("load", function() {
    var getButtonElement = document.getElementById("execute_button");
    getButtonElement.addEventListener("click", sendWithGetMethod, false);
}, false);
