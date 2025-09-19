package quest.model;

import java.io.Serializable;

public class Player implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int gameCount;

    public Player(String name) {
        this.name = name;
        this.gameCount = 1;
    }

    public String getName() {
        return name;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void incrementGameCount() {
        this.gameCount++;
    }
}