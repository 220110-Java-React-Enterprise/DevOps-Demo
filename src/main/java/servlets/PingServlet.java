package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PingServlet extends HttpServlet {
    /*
    This will take a simple GET request and respond with "Pong!" and status 202, indicating the request was accepted.
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try(FileReader jdbcFile = new FileReader("jdbc.properties")) {
            Properties props = new Properties();
            props.load(jdbcFile);
            resp.setStatus(202);
            resp.getWriter().write(props.getProperty("hostname"));
        } catch (IOException e) {
            resp.setStatus(500);
            resp.getWriter().print("IOException: " + e.getMessage());
        }

//        resp.setStatus(202);
//        resp.getWriter().print("Pong!");
    }
}