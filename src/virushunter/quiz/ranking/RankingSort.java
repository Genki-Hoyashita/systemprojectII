package ranking;

import java.util.Comparator;
import user.User;

public class RankingSort implements Comparator<User> {

	//比較メソッド（データクラスを比較して-1, 0, 1を返すように記述する）
	public int compare(User a, User b) {
		int no1 = a.getScore();
		int no2 = b.getScore();

		//こうすると社員番号の降順でソートされる
		if (no1 < no2) return 1;
		else if (no1 == no2) return 0;
		else return -1;
	}

}
