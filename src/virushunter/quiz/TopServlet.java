package virushunter.quiz;

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

@WebServlet("/virushunter/quiz/top")
public class TopServlet extends HttpServlet{

  private static final long serialVersionUID = 1L;

  private Enemy enem = null;
  private User user = null;

  protected void doGet(HttpServletRequest request,
    HttpServletResponse response) throws ServletException, IOException {
    String userName = request.getParameter("name");


    if (userName != null) {
      enem = new Enemy();
      user = enem.setName(userName);
    } else {

    }

    StringBuilder builder = new StringBuilder();
    builder.append('{');
    builder.append("\"name\":\"").append(userName).append("\"");
    builder.append('}');
    String json = builder.toString();
    System.out.println(json);
    response.setContentType("application/json");
    PrintWriter writer = response.getWriter();
    writer.append(json);
    writer.flush();

  }

  public Enemy getEnemy() {
    return enem;
  }

  public User getUser() {
    return user;
  }
}
