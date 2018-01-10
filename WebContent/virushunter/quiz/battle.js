/**
*作成者　松井星王子
*このクラスは問題の出力を行う。具体的な処理の流れあは以下のとおりである。
*①まず、ページを開くと難易度選択画面が現れる
*②難易度を選択すると次に問題が開かれる
*③A, B, C, Dのいずれかを選択する
*④正解かどうかを判定する
*⑤答え、残り体力、スコアを表示する
*⑥①〜⑤を繰り返す(体力がなくなった場合問題が開かれずに終わる)
*/

var xmlHttpRequest;




//難易度選択するメソッド
function choice(){
     //簡単なモード
    var EasyElement = document.getElementById("easy_button");
    EasyElement.addEventListener("click",easy, false);

    //普通なモード
     var NomalElement = document.getElementById("nomal_button");
    NomalElement.addEventListener("click",nomal, false);

    //難しいモード
     var HardElement = document.getElementById("Hard_button");
    HardElement.addEventListener("click",hard, false);
   
}

//答え、残り体力、スコアを出力する
function answer() {
       if(xmlHttpRequest.readyState == 4 && xmlHttpRequest.status == 200) {
      var response = JSON.parse(xmlHttpRequest.responseText);
      
       var HPElement = document.getElementById("HP");
       HPElement.innerHTML = response.hp;

       var SCOREElement = document.getElementById("SCORE");
       SCOREElement.innerHTML = response.score;
       
       var AnswerElement = document.getElementById("ANSWER");
	   AnswerElement.innerHTML = response.answer;

	       //もし残り体力があれば、難易度を選択する
	   if(response.HP <= 0 && respons.count > 5){
	       choice();
	   }
	   //体力がなければ終了
	   else finish();
	   
       }


}

//ゲームオーバーまたはゲームをやめる
//現在のスコアと体力を表示して終わる
function finish(){
     var response = JSON.parse(xmlHttpRequest.responseText);
      
       var HPElement = document.getElementById("HP");
       HPElement.innerHTML = response.hp;

       var SCOREElement = document.getElementById("SCORE");
       SCOREElement.innerHTML = response.score;
   
}


//簡単な問題を出す
    function easy(){
    var monsterElement = document.getElementById("monster");
    monsterElement.style.visibility = "visible";
	var url = "question?difficulty=easy";
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.open("GET", url, true);
	
	    var AButtonElement = document.getElementById("a_button");
    AButtonElement.addEventListener("click",answer, false);

      var BButtonElement = document.getElementById("b_button");
    BButtonElement.addEventListener("click",answer, false);

      var CButtonElement = document.getElementById("C_button");
    CButtonElement.addEventListener("click",answer, false);
}

//普通の問題を出す
    function normal(){
    var monsterElement = document.getElementById("monster");
    monsterElement.style.visibility = "visible";
	var url = "question?difficulty=nomal";
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.open("GET", url, true);
	
    var AButtonElement = document.getElementById("a_button");
    AButtonElement.addEventListener("click",answer, false);

      var BButtonElement = document.getElementById("b_button");
    BButtonElement.addEventListener("click",answer, false);

      var CButtonElement = document.getElementById("C_button");
    CButtonElement.addEventListener("click",answer, false);
 
}

//難しい問題を出す
    function hard(){
    var monsterElement = document.getElementById("monster");
    monsterElement.style.visibility = "visible";
	var url = "question?difficulty=hard";
	xmlHttpRequest = new XMLHttpRequest();
	xmlHttpRequest.open("GET", url, true);
	
      var AButtonElement = document.getElementById("a_button");
    AButtonElement.addEventListener("click",answer, false);

      var BButtonElement = document.getElementById("b_button");
    BButtonElement.addEventListener("click",answer, false);

      var CButtonElement = document.getElementById("C_button");
    CButtonElement.addEventListener("click",answer, false);
   
}




//はじめに難易度を選択する
window.addEventListener("load", function() {
    var monsterElement = document.getElementById("monster");
    monsterElement.style.visibility = "hidden";
    
    var questionTableElement = document.getElementById("questionTable");
    questionTableElement.style.visibility = "hidden";
    
    var stElement = document.getElementById("st")
    stElement.style.visibility = "hidden";
    choice();//難易度選択を行う
    
}, false);
