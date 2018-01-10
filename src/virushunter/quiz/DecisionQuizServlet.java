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

@WebServlet("/virushunter/quiz/decision")
public class DecisionQuizServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    String kaitou = request.getParameter("kaitou");
    Enemy enem = null;
    String[] answerList = null;
    TopServlet top = null;
    String decision = "";
    String hp = "";
    String score = "";
    int count = 0;

    if (kaitou != null) {
      top = new  TopServlet();
      enem = top.getEnemy();
      answerList = enem.judgeAnswer(Integer.parseInt(kaitou));
      decision = answerList[0];
      hp = answerList[1];
      score = answerList[2];
      count = enem.getCount();
    } else {

    }

    StringBuilder builder = new StringBuilder();
    builder.append('{');
    builder.append("\"answer\":\"").append(decision).append("\"").append(",");
    builder.append("\"hp\":\"").append(hp).append("\"").append(",");
    builder.append("\"score\":\"").append(score).append("\"").append(",");
    builder.append("\"count\":").append(count);
    builder.append('}');
    String json = builder.toString();
    System.out.println(json);
    response.setContentType("application/json");
    PrintWriter writer = response.getWriter();
    writer.append(json);
    writer.flush();

  }
}
