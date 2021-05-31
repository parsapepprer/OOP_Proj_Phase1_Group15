package model;

public class User {
    private final String username;
    private final byte[] hashPassword;
    private int lastUnlockedLevel;
    private int collectedCoins;

    public User(String username, byte[] hashPassword) {
        this.username = username;
        this.hashPassword = hashPassword;
        this.lastUnlockedLevel = 1;
        this.collectedCoins = 0;
    }

    public String getUsername() {
        return username;
    }

    public byte[] getHashPassword() {
        return hashPassword;
    }

    public int getLastUnlockedLevel() {
        return lastUnlockedLevel;
    }
}
