package test;
import java.util.Scanner;

import quiz.Enemy;

public class TestQuiz {
	
	public static void main(String[] args) {
		int kaitou = 0;
		String name = "";
		String[] quizList = null;
		String[] answerList = null;
		
		Enemy enem = new Enemy();
		 @SuppressWarnings("resource")
		Scanner key = new Scanner(System.in);
		System.out.print("名前を入力して下さい。: ");
	    name = key.nextLine();
	    enem.setName(name);

		quizList = enem.orderQuiz("hard");
		for (String quiz: quizList) {
			System.out.println(quiz);
		}
		System.out.println("ポイントの表示: "+ enem.getPoint());
		System.out.println("ダメージの表示: "+ enem.getDamage());
		System.out.println("答えの表示: "+ enem.getAnswer());
		
		System.out.println("1-3を選び回答してください");
		@SuppressWarnings("resource")
		Scanner scn = new Scanner(System.in);
        System.out.print("回答 : ");
        kaitou = scn.nextInt();
        
        answerList = enem.judgeAnswer(kaitou);
        for (String answer: answerList) {
			System.out.println(answer);
		}
        System.out.println();
        
        enem.orderQuiz("easy");	
		System.out.println("1-3を選び回答してください");
		@SuppressWarnings("resource")
		Scanner scn1 = new Scanner(System.in);
        System.out.print("回答 : ");
        kaitou = scn1.nextInt();
        enem.judgeAnswer(kaitou);
        	
	}

}
