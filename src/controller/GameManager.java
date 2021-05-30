package controller;

import model.User;

public class GameManager {

    private User user;
    private MissionManager missionManager;

    public GameManager(User user) {
        this.user = user;
        this.missionManager = new MissionManager();
    }

    public boolean checkInvalidLevel(int level) {
        return level <= 0 || level > missionManager.getNumberOfLevels();
    }

    public boolean checkLockedLevel(int level) {
        return level > user.getLastUnlockedLevel();
    }

    public User getUser() {
        return user;
    }
}
