package quiz;

public class NormalQuiz extends Quiz {
	public NormalQuiz(int point) {
		super(point);
		quiz = "ナックルの「ハコワレ」漢字でどう書く？";
		choice1 = "天上不知唯我独損";
		choice2 = "天井不知唯我独損";
		choice3 = "天下不知唯我独損";
		answer = 1;
		damage = 30;
	}

}
