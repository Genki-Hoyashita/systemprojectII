package quiz;

public class HardQuiz extends Quiz {
	public HardQuiz(int point) {
		super(point);
		quiz = "1日に手の爪が伸びる速度はどれくらいか？";
		choice1 = "0.1mm";
		choice2 = "0.05mm";
		choice3 = "0.025mm";
		answer = 1;
		damage = 50;
	}
	
}
