package quiz;

public class Quiz {
	protected String quiz = ""; //問題
	protected String choice1 = ""; //選択肢1
	protected String choice2 = ""; //選択肢2
	protected String choice3 = ""; //選択肢13
	protected int answer = 0; //答え
	protected int point = 0; //問題の点数
	protected int damage = 0; //難易度別のダメージ量
	
	public Quiz(int point) {
		this.point = point;
	}
	
	/** クイズを出題する **/
	public String getQuiz() {
		return "問題:  " + 
				quiz+"\n" +
				"1: " + choice1+"\n" +
				"2: " + choice2+"\n" +
				"3: " + choice3+"\n";
	}
	
	/** ポイントを返す **/
	public int getPoint() {
		return point;
	}
	
	/** ダメージ量を返す **/
	public int getDamage() {
		return damage;
	}
	
	/** 答えを返す **/
	public int getAnswer() {
		return answer;
	}
	
	/** 答え合わせ **/
	public boolean judgeAnswer(int kaitou) {
		if (answer == kaitou) return true;
		else return false;
	}
}
