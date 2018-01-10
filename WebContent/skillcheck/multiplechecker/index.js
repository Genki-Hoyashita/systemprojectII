var xmlHttpRequest;

function sendWithGetMethod() {
  var integerElement = document.getElementById("integer");
  var multipleElement = document.getElementById("multiple");

  var url = "execute?integer=" + integerElement.value + "&multiple="+multipleElement.value+"&method=get";
  xmlHttpRequest = new XMLHttpRequest();
  xmlHttpRequest.onreadystatechange = receive;
  xmlHttpRequest.open("GET", url, true);
  xmlHttpRequest.send(null);
}



function receive() {
  if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
    var response = JSON.parse(xmlHttpRequest.responseText);

    var resultElement = document.getElementById("result");
    if (response.result) {
      resultElement.innerHTML = response.integer+" is a multiple of "+response.multiple;
    } else {
      resultElement.innerHTML = response.integer+" is not a multiple of "+response.multiple;
    }
  }
}

window.addEventListener("load", function() {
  var getButtonElement = document.getElementById("execute_button");
  getButtonElement.addEventListener("click", sendWithGetMethod, false);
}, false);
