import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Files;
import java.nio.file.Paths;

@WebServlet("/displayHtml")
public class Task4 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String filePath = "C:\\Users\\madhan\\Desktop\\Tech M Task Java Full stack\\Core Java Consolidated Tasks - 22 Feb '25\\Task10\\Servlets\\index.html";
        String content = new String(Files.readAllBytes(Paths.get(filePath)));

        out.println(content);
    }
}
