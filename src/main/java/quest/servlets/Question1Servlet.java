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

public class Question1Servlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(Question1Servlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("player") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/jsp/question1.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String answer = request.getParameter("answer");
        HttpSession session = request.getSession(false);
        Player player = (Player) session.getAttribute("player");

        if ("accept".equals(answer)) {
            logger.info(player.getName() + " Accepted the UFO challenge. Moving on to the next question. ");
            response.sendRedirect("q2");
        } else {
            logger.info(player.getName() + " Refused the UFO call. ");
            response.sendRedirect("final?result=lose&reason=decline_nlo");
        }
    }
}
