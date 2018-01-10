package skillcheck.digitanswerer;

public class Number {
	private int value;


	public void setValue(int value) {
		this.value = value;
	}

	public int getDigit() {
		return String.valueOf(value).length();
	}
}
