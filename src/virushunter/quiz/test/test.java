package test;

import java.util.Scanner;

import quiz.Enemy;
import user.User;

public class test {
	public static void main(String[] args) {
		int kaitou = 0;
		String[] quizList = null;
		String[] answerList = null;
		String[] rankList = null;
		String difficulty = "";

		Enemy enem = new Enemy();
		
		/* ユーザ1人目の名前入力から問題を解いて，ランキングに追加までのシステムのテスト */
		System.out.println("======================ユーザ1=======================");
		@SuppressWarnings("resource")
		Scanner key1 = new Scanner(System.in);
		System.out.print("名前を入力して下さい。: ");
		String name1 = key1.nextLine();
		User user1 = enem.setName(name1);
		
		System.out.println("\n第1問！");
		System.out.print("難易度を入力して下さい。(easy-normal-hard): ");
		difficulty = key1.nextLine();
		quizList = enem.orderQuiz(difficulty);
		for (String quiz: quizList) {
			System.out.println(quiz);
		}

		System.out.println("1-3を選び回答してください");
		@SuppressWarnings("resource")
		Scanner scn11 = new Scanner(System.in);
		System.out.print("回答 : ");
		kaitou = scn11.nextInt();

		answerList = enem.judgeAnswer(kaitou);
		for (String answer: answerList) {
			System.out.println(answer);
		}
		
		System.out.println("\n続いて第2問！");
		System.out.print("難易度を入力して下さい。(easy-normal-hard): ");
		difficulty = key1.nextLine();
		quizList = enem.orderQuiz(difficulty);
		for (String quiz: quizList) {
			System.out.println(quiz);
		}

		System.out.println("1-3を選び回答してください");
		@SuppressWarnings("resource")
		Scanner scn12 = new Scanner(System.in);
		System.out.print("回答 : ");
		kaitou = scn12.nextInt();
		answerList = enem.judgeAnswer(kaitou);
		for (String answer: answerList) {
			System.out.println(answer);
		}

		user1.addRanking();

		System.out.println();
		System.out.println("ランキングを表示");
		rankList = user1.showRanking();
		for (String data: rankList) {
			System.out.println(data);
		}

		System.out.println();
		System.out.println();
		
		/* ユーザ2人目の名前入力から問題を解いて，ランキングに追加までのシステムのテスト */
		System.out.println("======================ユーザ2=======================");
		@SuppressWarnings("resource")
		Scanner key2 = new Scanner(System.in);
		System.out.print("名前を入力して下さい。: ");
		String name2 = key2.nextLine();
		User user2 = enem.setName(name2);

		System.out.println("\n第1問！");
		System.out.print("難易度を入力して下さい。(easy-normal-hard): ");
		difficulty = key2.nextLine();
		quizList = enem.orderQuiz(difficulty);
		for (String quiz: quizList) {
			System.out.println(quiz);
		}

		System.out.println("1-3を選び回答してください");
		@SuppressWarnings("resource")
		Scanner scn21 = new Scanner(System.in);
		System.out.print("回答 : ");
		kaitou = scn21.nextInt();

		answerList = enem.judgeAnswer(kaitou);
		for (String answer: answerList) {
			System.out.println(answer);
		}
		
		System.out.println("\n続いて第2問！");
		System.out.print("難易度を入力して下さい。(easy-normal-hard): ");
		difficulty = key1.nextLine();
		quizList = enem.orderQuiz(difficulty);
		for (String quiz: quizList) {
			System.out.println(quiz);
		}

		System.out.println("1-3を選び回答してください");
		@SuppressWarnings("resource")
		Scanner scn22 = new Scanner(System.in);
		System.out.print("回答 : ");
		kaitou = scn22.nextInt();

		answerList = enem.judgeAnswer(kaitou);
		for (String answer: answerList) {
			System.out.println(answer);
		}

		user2.addRanking();

		System.out.println();
		System.out.println("ランキングを表示");
		rankList = user2.showRanking();
		for (String data: rankList) {
			System.out.println(data);
		}
	}

}
