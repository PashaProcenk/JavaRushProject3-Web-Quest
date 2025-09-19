package quest.service;

import jakarta.servlet.http.HttpSession;
import quest.model.Player;

public class QuestService {
    public static Player getOrCreatePlayer(HttpSession session, String name) {
        Player player = (Player) session.getAttribute("player");
        if (player == null) {
            player = new Player(name);
            session.setAttribute("player", player);
        } else {
            player.incrementGameCount();
        }
        return player;
    }
}
