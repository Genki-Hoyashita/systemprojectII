package ranking;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import user.User;

public class Ranking {
	private static ArrayList<User> userRanking = new ArrayList<User>();
	private String rankData = "";
	
	
	public void addRanking(String name, int score) {
		userRanking.add(new User(name, score));
		scoreSort(userRanking);
	}
	
	public String[] showRanking() {
		Iterator<User> rankingData = userRanking.iterator();
		User data = null;
		String dataSplit = "";
		int count = 0;
        while (rankingData.hasNext() && count < 10) {
            data = rankingData.next();
            dataSplit = getRanking(setRanking(data.getName(), data.getScore()));
            count++;
        }
        return dataSplit.split("\n");
	}
	
	private String setRanking(String name, int score) {
		return name+ ":" + score+ "\n";
	}
	
	private String getRanking(String data) {
		return rankData += data;
	}
	
	private void scoreSort (ArrayList<User> userRanking) {
		Collections.sort(userRanking, new RankingSort());
	}
	
	
}
