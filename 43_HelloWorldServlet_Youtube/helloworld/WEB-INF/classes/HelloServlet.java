import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        printWriter.write("Hello World!");
    }
}
