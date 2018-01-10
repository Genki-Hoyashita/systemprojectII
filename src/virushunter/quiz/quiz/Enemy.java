package quiz;

import user.User;

public class Enemy {
	Quiz quiz = null;
	User user = null;
	String name = "";
	String[] quizList = null;
	String[] answerList = null;
	private int count = 0; //問題終了を判定（5回で終了）
	
	/**
	 * 問題の難易度別に問題を作成
	 * @param difficulty 難易度
	 * @return 問題のインスタンス
	 */
	public final String[] orderQuiz(String difficulty) {
		quiz = createQuiz(difficulty);
		System.out.println("「難易度"+difficulty+"の問題を出題するぜ」");
		quizList = quiz.getQuiz().split("\n");
		//		System.out.println(quiz.getQuiz());
		return quizList;
	}

	/** ポイントを返す **/
	public int getPoint() {
		return quiz.getPoint();
	}

	/** ダメージ量を返す **/
	public int getDamage() {
		return quiz.getDamage();
	}

	/** 答えを返す **/
	public int getAnswer() {
		return quiz.getAnswer();
	}

	/** ユーザーの情報（名前）を設定し，情報を表示 **/
	public User setName (String name) {
		user = new User(name);
		System.out.println("あなたの名前は"+user.getName()+"です．\n"+
				"HP:"+user.getHP()+"　スコア:" +user.getScore()+ " です．");
		return user;
	}

	/** 正解，不正解の結果を表示 **/
	public String[] judgeAnswer(int kaitou) {
		if (quiz.judgeAnswer(kaitou)) {
			return judgeAnswerString(true).split("\n");
		} else {
			return judgeAnswerString(false).split("\n");
		}
	}

	private String judgeAnswerString(boolean decision) {
		String result = "エラーjudgeAnswerString(Enemy)";
		incCount();
		if (decision) {
			user.setScore(quiz.getPoint());
			result = "正解! "+quiz.getPoint()+ "ポイント獲得です.\n" +
					user.getHP() + "\n"+
					user.getScore();

		} else {
			user.setDamage(quiz.getDamage());
			result =  "さんねーん不正解! "+quiz.getDamage()+ "ダメージです.\n" +
					user.getHP()+ "\n" +
					user.getScore();
		} return result;
	}

	/** 難易度別に問題を作成 **/
	protected Quiz createQuiz(String difficulty) {
		if      (difficulty.equals("easy"))   return new EasyQuiz(1);
		else if (difficulty.equals("normal")) return new NormalQuiz(3);
		else if (difficulty.equals("hard"))   return new HardQuiz(5);
		else System.out.println ("Difficulty/createQuiz(type:String)のエラー"); return null;
	}
	
	public void incCount() {
		count++;
	}
	
	public int getCount() {
		return count;
	}



}
