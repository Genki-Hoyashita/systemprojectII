/*作成者 松井 星王子
*ランキングについてのjavaScript
*/
var xmlHttpRequest;


function receive() {
    //正常に動作する場合のみ
    if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
	//JSONの結果をオブジェクトに入れる
	var response = JSON.parse(xmlHttpRequest.responseText);
	//１位〜１０位の結果を出力する
	oneElement.innerHTML = response.one;//1位
	twoElement.innerHTML = response.two;//２位
	threeElement.innerHTML = response.three;//３位
	fourElement.innerHTML = response.four;//４位
	fiveElement.innerHTML = response.five;//５位
	sixElement.innerHTML = response.six; //６位
	sevenElement.innerHTML = response.seven;//７位
	eightElement.innerHTML = response.eight;//８位
	nineElement.innerHTML = response.nine;//９位
	tenElement.innerHTML = response.ten;//１０位
	}
}

//立ち上げた時実行
window.addEventListener("load", function() {
    //１位〜１０位のエレメントを作る
    var oneElement = document.getElementById("1");
    var twoElement = document.getElementById("2");
    var threeElement = document.getElementById("3");
    var fourElement = document.getElementById("4");
    var fiveElement = document.getElementById("5");
    var sixElement = document.getElementById("6");
    var sevenElement = document.getElementById("7");
    var eightElement = document.getElementById("8");
    var nineElement = document.getElementById("9");
    var tenElement = document.getElementById("10");

    //URL作成
    var url = "ranking?1=" + oneElement.value +
	"&=2" + twoElement.value + "&=3" + threeElement.value +
	"&=4" + fourElement.value + "&=5" + fiveElement.value +
	"&=6" + sixElement.value + "&=7" + sevenElement.value +
	"&=8" + eightElement + "&=9" + nineElement +
	"&=10" + tenElement.value + "&method=get";

    //オブジェクト作成
    xmlHttpRequest = new XMLHttpRequest();
    //receiveを実行して結果を代入
    xmlHttpRequest.onreadystatechange = receive;
    //メソッドGETにてブラウザを開く
    xmlHttpRequest.open("GET", url, true);
    xmlHttpRequest.send(null);

}, false);
