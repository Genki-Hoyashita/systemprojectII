package quiz;

public class EasyQuiz extends Quiz{
	public EasyQuiz(int point) {
		super(point);
		quiz = "キメラアントの女王が打ち上げられた大陸は？";
		choice1 = "ネラシオン大陸";
		choice2 = "オルソ大陸";
		choice3 = "ヨルビアン大陸";
		answer = 3;
		damage = 10;
	}
}
