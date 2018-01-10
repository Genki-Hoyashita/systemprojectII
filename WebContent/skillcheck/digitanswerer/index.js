var xmlHttpRequest;

function sendWithGetMethod() {
  var integerElement = document.getElementById("integer");

  var url = "execute?integer=" + integerElement.value + "&method=get";
  xmlHttpRequest = new XMLHttpRequest();
  xmlHttpRequest.onreadystatechange = receive;
  xmlHttpRequest.open("GET", url, true);
  xmlHttpRequest.send(null);
}



function receive() {
  if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
    var response = JSON.parse(xmlHttpRequest.responseText);

    var digitElement = document.getElementById("digit");
    digitElement.innerHTML = response.digit;// + "(" + response.method + ")";
  }
}

window.addEventListener("load", function() {
  var getButtonElement = document.getElementById("execute_button");
  getButtonElement.addEventListener("click", sendWithGetMethod, false);
}, false);
