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

@WebServlet("/virushunter/quiz/ranking")
public class RankingServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  private User user = null;

  protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    String[] rankList = null;
    String rank1 = "";
    String rank2 = "";
    String rank3 = "";
    String rank4 = "";
    String rank5 = "";
    String rank6 = "";
    String rank7 = "";
    String rank8 = "";
    String rank9 = "";
    String rank10 = "";

    TopServlet top = null;
    user = top.getUser();
    user.addRanking();
    rankList = user.showRanking();
    rank1 = rankList[0];
    rank2 = rankList[1];
    rank3 = rankList[2];
    rank4 = rankList[3];
    rank5 = rankList[4];
    rank6 = rankList[5];
    rank7 = rankList[6];
    rank8 = rankList[7];
    rank9 = rankList[8];
    rank10 = rankList[9];


    StringBuilder builder = new StringBuilder();
    builder.append('{');
    builder.append("\"one\":\"").append(rank1).append("\"").append(",");
    builder.append("\"two\":\"").append(rank2).append("\"").append(",");
    builder.append("\"three\":\"").append(rank3).append("\"").append(",");
    builder.append("\"four\":\"").append(rank4).append("\"").append(",");
    builder.append("\"five\":\"").append(rank5).append("\"").append(",");
    builder.append("\"six\":\"").append(rank6).append("\"").append(",");
    builder.append("\"seven\":\"").append(rank7).append("\"").append(",");
    builder.append("\"eight\":\"").append(rank8).append("\"").append(",");
    builder.append("\"nine\":\"").append(rank9).append("\"").append(",");
    builder.append("\"ten\":\"").append(rank10).append("\"");
    builder.append('}');
    String json = builder.toString();
    System.out.println(json);
    response.setContentType("application/json");
    PrintWriter writer = response.getWriter();
    writer.append(json);
    writer.flush();

  }
}
