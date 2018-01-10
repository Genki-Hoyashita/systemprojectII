/**作成者　松井星王子
*ゲームスタート画面のクラス
*
*/
var xmlHttpRequest;

window.addEventListener("load", function() {
    var startElement = document.getElementById("start_button");
    startElement.addEventListener("click", nameSetMethod, false);
    
}, false);

function nameSetMethod(){
        var userNameElement = document.getElementById("user_name");
    

    var url = "top?name=" + userNameElement.value;
    	xmlHttpRequest = new XMLHttpRequest();
    xmlHttpRequest.open("GET", url, true);

}
