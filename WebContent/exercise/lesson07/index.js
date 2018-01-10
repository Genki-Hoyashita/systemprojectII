var xmlHttpRequest;

function sendWithGetMethod() {
  var input1Element = document.getElementById("input1");
  var input2Element = document.getElementById("input2");

  var url = "execute?input1=" + input1Element.value + "&input2=" + input2Element.value + "&method=get";
  xmlHttpRequest = new XMLHttpRequest();
  xmlHttpRequest.onreadystatechange = receive;
  xmlHttpRequest.open("GET", url, true);
  xmlHttpRequest.send(null);
}



function receive() {
  if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
    var response = JSON.parse(xmlHttpRequest.responseText);

    var outputElement = document.getElementById("output");
    outputElement.innerHTML = response.output;// + "(" + response.method + ")";
  }
}

window.addEventListener("load", function() {
  var getButtonElement = document.getElementById("calculate_button");
  getButtonElement.addEventListener("click", sendWithGetMethod, false);

}, false);