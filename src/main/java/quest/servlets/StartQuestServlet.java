package quest.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import quest.service.QuestService;

import java.io.IOException;

public class StartQuestServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(StartQuestServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String playerName = request.getParameter("playerName");
        if (playerName == null || playerName.trim().isEmpty()) {
            response.sendRedirect("index.jsp");
            return;
        }

        QuestService.getOrCreatePlayer(request.getSession(), playerName);
        logger.info("Player " + playerName + " started new game.");
        response.sendRedirect("q1");
    }
}
