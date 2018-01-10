package virushunter.quiz;

import virushunter.quiz.TopServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import quiz.Enemy;
import user.User;

@WebServlet("/virushunter/quiz/question")
public class QuestionQuizServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    Enemy enem = null;
    String difficulty = request.getParameter("difficulty");
    String[] quizList = null;
    String quiz = null;
    String choice1 = null;
    String choice2 = null;
    String choice3 = null;
    int point = 0;
    int damage = 0;
    int answer = 0;

    if (difficulty != null) {
      TopServlet top = new  TopServlet();
      enem = top.getEnemy();
      quizList = enem.orderQuiz(difficulty);
      quiz = quizList[0];
      choice1 = quizList[1];
      choice2 = quizList[2];
      choice3 = quizList[3];
      point = enem.getPoint();
      damage = enem.getDamage();
      answer = enem.getAnswer();
    } else {

    }

    StringBuilder builder = new StringBuilder();

    builder.append('{');
    builder.append("\"quiz\":\"").append(quiz).append("\"").append(",");
    builder.append("\"choice1\":\"").append(choice1).append("\"").append(",");
    builder.append("\"choice2\":\"").append(choice2).append("\"").append(",");
    builder.append("\"choice3\":\"").append(choice3).append("\"").append(",");
    builder.append("\"point\":").append(point).append(",");
    builder.append("\"damage\":").append(damage).append(",");
    builder.append("\"answer\":").append(answer);
    builder.append('}');
    String json = builder.toString();
    System.out.println(json);
    response.setContentType("application/json");
    PrintWriter writer = response.getWriter();
    writer.append(json);
    writer.flush();

  }

}
