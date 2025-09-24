package quest.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mockito;
import jakarta.servlet.http.HttpSession;
import quest.model.Player;

public class QuestServiceTest {
    private HttpSession mockSession;

    @BeforeEach
    void setUp() {
        mockSession = Mockito.mock(HttpSession.class);
    }

    @Test
    void testCreateNewPlayer() {
        Mockito.when(mockSession.getAttribute("player")).thenReturn(null);

        Player player = QuestService.getOrCreatePlayer(mockSession, "TestUser");

        assertNotNull(player);
        assertEquals("TestUser", player.getName());
        assertEquals(1, player.getGameCount());
        Mockito.verify(mockSession).setAttribute("player", player);
    }

    @Test
    void testIncrementGameCount() {
        Player existingPlayer = new Player("TestUser");
        Mockito.when(mockSession.getAttribute("player")).thenReturn(existingPlayer);

        Player player = QuestService.getOrCreatePlayer(mockSession, "TestUser");

        assertNotNull(player);
        assertEquals("TestUser", player.getName());
        assertEquals(2, player.getGameCount());
        Mockito.verify(mockSession, Mockito.never()).setAttribute(Mockito.anyString(), Mockito.any());
    }
}