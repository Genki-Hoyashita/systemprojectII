package skillcheck.digitanswerer;

import java.io.IOException;
import java.io.Writer;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/skillcheck/digitanswerer/execute")
public class DigitAnswererServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		String integer = (request.getParameter("integer") == null) ? ""
				: (String) request.getParameter("integer");
		String digit = null;

		Integer value = null;
		try {
			value = Integer.decode(integer);
		} catch (NumberFormatException e) {
		}

		if (value != null) {
			Number number = new Number();
			number.setValue(value.intValue());
			digit = String.valueOf(number.getDigit());
		} else {
			digit = "";
		}

		StringBuilder builder = new StringBuilder();
    builder.append('{');
    builder.append("\"digit\":\"").append(digit).append("\",");
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
