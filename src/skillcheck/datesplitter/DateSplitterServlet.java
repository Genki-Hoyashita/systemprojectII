package skillcheck.datesplitter;

import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/skillcheck/datesplitter/execute")
public class DateSplitterServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doPost(HttpServletRequest request,
      HttpServletResponse response) throws ServletException, IOException {

    String method = request.getParameter("method");
    String date = (request.getParameter("date") == null) ? ""
        : (String) request.getParameter("date");
    String year = null;
    String month = null;
    String day = null;

    if (date != null) {
      DateSplitter days = new DateSplitter();
      days.setDate(date);
      days.execute();
      year = String.valueOf(days.getYear());
      month = String.valueOf(days.getMonth());
      day = String.valueOf(days.getDay());
    } else {
      year = "";
      month = "";
      day = "";
    }

    StringBuilder builder = new StringBuilder();
    builder.append('{');
    builder.append("\"year\":\"").append(year).append("\",");
    builder.append("\"month\":\"").append(month).append("\",");
    builder.append("\"day\":\"").append(day).append("\",");
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

