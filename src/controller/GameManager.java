package controller;

import model.User;

public class GameManager {

    private User user;
    private static int MAX_LEVEL = 5;

    public GameManager(User user) {
        this.user = user;
    }

    public boolean checkInvalidLevel(int level) {
        return level <= 0 || level > MAX_LEVEL;
    }

    public boolean checkLockedLevel(int level) {
        return false;
    }

    public User getUser() {
        return user;
    }
}
