package model;

public class User {
    private final String username;
    private final byte[] hashPassword;

    public User(String username, byte[] hashPassword) {
        this.username = username;
        this.hashPassword = hashPassword;
    }

    public String getUsername() {
        return username;
    }

    public byte[] getHashPassword() {
        return hashPassword;
    }
}
