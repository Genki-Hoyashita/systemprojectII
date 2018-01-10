package exercise.lesson07;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import exercise.lesson04.Adder;

@WebServlet("/exercise/lesson07/execute")
public class AdderServlet  extends HttpServlet {

  private static final long serialVersionUID = 1L;

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // String message = request.getParameter("message");
     String method = request.getParameter("method");

    String input1 = request.getParameter("input1");
    String input2 = request.getParameter("input2");
    String output = null;

    Integer augend = null;
    try {
      augend = Integer.decode(input1);
    } catch (NumberFormatException e) {
    }

    Integer addend = null;
    try {
      addend = Integer.decode(input2);
    } catch (NumberFormatException e) {
    }

    if (augend != null && addend != null) {
      Adder adder = new Adder();
      adder.setAugend(augend.intValue());
      adder.setAddend(addend.intValue());
      adder.execute();

      output = String.valueOf(adder.getSum());
    } else {
      output = "";
    }


    StringBuilder builder = new StringBuilder();
    builder.append('{');
    builder.append("\"output\":\"").append(output).append("\",");
    builder.append("\"method\":\"").append(method).append("\"");
    builder.append('}');
    String json = builder.toString();
    System.out.println(json);

    response.setContentType("application/json");
    PrintWriter writer = response.getWriter();
    writer.append(json);
    writer.flush();
     // this.echo(output, method, response);
  }

  // private void echo(String output, String method, HttpServletResponse response) throws IOException {
  //   StringBuilder builder = new StringBuilder();
  //   builder.append('{');
  //   builder.append("\"output\":\"").append(output).append("\",");
  //   builder.append("\"method\":\"").append(method).append("\"");
  //   builder.append('}');
  //   String json = builder.toString();
  //   System.out.println(json);
  //   response.setContentType("application/json");
  //   PrintWriter writer = response.getWriter();
  //   writer.append(json);
  //   writer.flush();
  // }
}
