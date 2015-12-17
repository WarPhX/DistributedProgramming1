import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/nonblock"}, asyncSupported=true)
public class NonBlockingServlet extends HttpServlet {
  protected void doGet(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
    res.setContentType("text/html;charset=UTF-8");
    try (PrintWriter output = res.getWriter()) {
      output.println("<html>");
      output.println("<head>");
      output.println("<title>Servlet ReadTestServlet</title>");
      output.println("</head>");
      output.println("<body>");
      output.println("<h1>Servlet NonBlockingServlet at " + req.getContextPath() + "</h1>");

      AsyncContext context = req.startAsync();
      ServletInputStream input = req.getInputStream();

      input.setReadListener(new CmmdcListener(input, context, output));
      output.println("</body>");
      output.println("</html>");
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse res)
          throws ServletException, IOException {
    doGet(req, res);
  }
}
