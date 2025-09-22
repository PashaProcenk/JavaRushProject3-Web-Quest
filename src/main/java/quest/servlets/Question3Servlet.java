package quest.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import quest.model.Player;

import java.io.IOException;

public class Question3Servlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Question3Servlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("player") == null) {
            response.sendRedirect("index.jsp");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/jsp/question3.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");
        HttpSession session = request.getSession(false);
        Player player = (Player) session.getAttribute("player");

        if ("tell_truth".equals(answer)) {
            logger.info(player.getName() + " decided to tell the truth about myself. Victory!");
            response.sendRedirect("final?result=win");
        } else {
            logger.info(player.getName() + " decided to lie about myself ");
            response.sendRedirect("final?result=lose&reason=lie_exposed");
        }
    }
}
