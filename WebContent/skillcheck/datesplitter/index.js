var xmlHttpRequest;

function sendWithPostMethod() {
  var dateElement = document.getElementById("date");

  var url = "execute";
  xmlHttpRequest = new XMLHttpRequest();
  xmlHttpRequest.onreadystatechange = receive;
  xmlHttpRequest.open("POST", url, true);
  xmlHttpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  xmlHttpRequest.send("date=" +  dateElement.value + "&method=post");
}



function receive() {
  if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
    var response = JSON.parse(xmlHttpRequest.responseText);

    var yearElement = document.getElementById("year");
    var monthElement = document.getElementById("month");
    var dayElement = document.getElementById("day");
    yearElement.innerHTML = response.year;
    monthElement.innerHTML = response.month;
    dayElement.innerHTML = response.day;// + "(" + response.method + ")";
  }
}

window.addEventListener("load", function() {
  var getButtonElement = document.getElementById("execute_button");
  getButtonElement.addEventListener("click", sendWithPostMethod, false);
}, false);
