package user;

import ranking.Ranking;

public class User {
	private String name = ""; //ユーザーの名前
	private int HP = 100; //HP最初は100
	private int score = 0; //スコア
	private Ranking ranking = null;
	
	public User (String name) {
		this.name = name;
	}
	
	/** ランキングで使用 **/
	public User (String name, int score) {
		this.name = name;
		this.score = score;
	}

	/** 名前を返す **/
	public String getName() {
		return name;
	}
	
	/** スコアを返す **/
	public int getScore() {
		return score;
	}

	/** HPを返す **/
	public int getHP() {
		return HP;
	}
	

	/** ダメージ計算を行う **/
	public void setDamage(int damage) {
		this.HP -= damage;
		if (HP <= 0) {
			System.out.println("GAME OVER");
			System.exit(0);
		}
	}

	/** 正解の時スコア計算を行う **/
	public void setScore(int point) {
		this.score += point*4 + HP*3;
	}
	
	public void addRanking() {
		ranking = new Ranking();
		ranking.addRanking(this.getName(), this.getScore());
	}
	
	public String[] showRanking() {
		return ranking.showRanking();
	}
	
}
