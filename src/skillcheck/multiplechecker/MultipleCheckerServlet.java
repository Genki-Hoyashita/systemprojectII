package skillcheck.multiplechecker;

import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/skillcheck/multiplechecker/execute")
public class MultipleCheckerServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    String method = request.getParameter("method");
    String integer = (request.getParameter("integer") == null) ? ""
        : (String) request.getParameter("integer");
    String multiple = (request.getParameter("multiple") == null) ? ""
        : (String) request.getParameter("multiple");
    boolean result = true;

    Integer inte = null;
    try {
      inte = Integer.decode(integer);
    } catch (NumberFormatException e) {
    }
    Integer mul = null;
    try {
      mul = Integer.decode(multiple);
    } catch (NumberFormatException e) {
    }

    if (integer != null && multiple != null) {
      MultipleChecker checker = new MultipleChecker();
      checker.setInteger(inte.intValue());
      checker.setMultiple(mul.intValue());
      result = checker.check();
    } else {
      integer = "";
      multiple = "";
    }

    StringBuilder builder = new StringBuilder();
    builder.append('{');
    builder.append("\"result\":").append(result).append(",");
    builder.append("\"integer\":\"").append(integer).append("\",");
    builder.append("\"multiple\":\"").append(multiple).append("\",");
    builder.append("\"method\":\"").append(method).append("\"");
    builder.append('}');
    String json = builder.toString();
    System.out.println(json);

    response.setContentType("application/json");
    PrintWriter writer = response.getWriter();
    writer.append(json);
    writer.flush();
  }
}

