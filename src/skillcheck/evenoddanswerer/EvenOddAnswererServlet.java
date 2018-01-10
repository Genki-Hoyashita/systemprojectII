package skillcheck.evenoddanswerer;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/skillcheck/evenoddanswerer/execute")
public class EvenOddAnswererServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
    String method = request.getParameter("method");
		String number = (request.getParameter("number") == null) ? ""
				: (String) request.getParameter("number");

		String answer = null;
		Integer evenodd = null;
		try {
			evenodd = Integer.decode(number);
		} catch (NumberFormatException e) {
		}

		if (evenodd != null) {
			EvenOddAnswer eo = new EvenOddAnswer();
			eo.setNumber(evenodd.intValue());
      eo.execute();
      answer = eo.getAnswer();

		} else {
			answer = "";
		}

        StringBuilder builder = new StringBuilder();
        builder.append('{');
        builder.append("\"answer\":\"").append(answer).append("\"");
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
