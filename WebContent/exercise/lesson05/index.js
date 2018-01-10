window.addEventListener("load", function () {
    var secondHand = 100; // 秒針の長さを設定
    var date = new Date(); // 現時点の日付と時刻を保持したDateオブジェクトを取得
    var s = date.getSeconds(); // Dateオブジェクトから秒数を取得
    var angle = 2 * Math.PI * s / 60; // 秒数から秒針の角度(ラジアン)を計算.円周率にはMathオブジェクトのPIプロパティの値を使用.
    var x = Math.round(secondHand * Math.sin(angle)); // 秒針のX座標を計算.X座標は小数点第1位で四捨五入
    var y = Math.round(secondHand * Math.cos(angle)); // 秒針のY座標を計算.Y座標は小数点第1位で四捨五入
    document.write(s + "秒のときの秒針の位置は(" + x + ", " + y + ")です"); // メッセージを表示

}, false);
