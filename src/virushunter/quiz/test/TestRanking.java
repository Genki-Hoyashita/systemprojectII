package test;

import ranking.Ranking;
import user.User;

public class TestRanking {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Ranking ran = new Ranking();
		String[] ranking = null; 
		
		ran.addRanking("あ", 40);
		ran.addRanking("い", 60);
		ran.addRanking("う", 70);
		ran.addRanking("え", 10);
		ran.addRanking("お", 30);
		ran.addRanking("か", 440);
		ran.addRanking("き", 46);
		ran.addRanking("く", 55);
		ran.addRanking("け", 64);
		ran.addRanking("こ", 34);
		ran.addRanking("さ", 11);
		ran.addRanking("し", 45);
		ran.addRanking("す", 676);
		ran.addRanking("せ", 54);
		ran.addRanking("そ", 99);
		
		ranking = ran.showRanking();
		for (String data : ranking) {
			System.out.println(data);
		}
		

//		User user1 = new User("あ");
//		user1.setScore(200);
//		user1.addRanking();
//		user1.showRanking();
//
//		System.out.println();
//
//		User user2 = new User("い");
//		user2.setScore(201);
//		user2.addRanking();
//		user2.showRanking();
//
//		System.out.println();
//
//		User user3 = new User("う");
//		user3.setScore(0);
//		user3.addRanking();
//		user3.showRanking();
//
//		System.out.println();
//
//		User user4 = new User("え");
//		user4.setScore(999999999);
//		user4.addRanking();
//		user4.showRanking();
//
//		System.out.println();
//
//		User user5 = new User("お");
//		user5.setScore(199);
//		user5.addRanking();
//		user5.showRanking();
//
//		System.out.println();
//
//		User user6 = new User("か");
//		user6.setScore(-45);
//		user6.addRanking();
//		user6.showRanking();

	}

}
