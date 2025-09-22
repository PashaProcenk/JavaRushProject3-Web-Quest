package quest.servlets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class FinalServlet extends HttpServlet {
    private static final Logger logger = LogManager.getLogger(FinalServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("player") == null) {
            response.sendRedirect("index.jsp");
            return;
        }

        String result = request.getParameter("result");
        String reason = request.getParameter("reason");
        String message;

        if ("win".equals(result)) {
            message = "You successfully told the truth about yourself and were returned home. **Victory!**";
            logger.info("The player won.");
        } else {
            switch (reason) {
                case "decline_nlo":
                    message = "You refused the UFO challenge and lost even more memory. **Defeat!**";
                    break;
                case "decline_bridge":
                    message = "You refused to come up to the bridge.Negotiations failed. **Defeat!**";
                    break;
                case "lie_exposed":
                    message = "Your lie has been exposed. **Defeat!**";
                    break;
                default:
                    message = "Game over. **Defeat!**";
                    break;
            }
            logger.info("Player lost. Reason: " + reason);
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("/WEB-INF/jsp/final.jsp").forward(request, response);
    }
}
