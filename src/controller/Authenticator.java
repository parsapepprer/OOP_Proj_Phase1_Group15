package controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.HashMap;

public class Authenticator {

    private HashMap<String, byte[]> userPassList;

    public Authenticator() {
        userPassList = new HashMap<>();
        load();
    }

    public AuthenticationResult signup(String username, String password) {
        if (checkUserExists(username)) return AuthenticationResult.SIGNUP_DUPLICATE_USERNAME;
        if (!checkUsername(username)) return AuthenticationResult.SIGNUP_ERROR_USERNAME;
        if (!checkPassword(password)) return AuthenticationResult.SIGNUP_ERROR_PASSWORD;
        if (addUser(username, password)) return AuthenticationResult.SIGNUP_SUCCESS;
        return AuthenticationResult.UNSPECIFIED_ERROR;
    }

    public AuthenticationResult login(String username, String password) {
        if (!checkUserExists(username)) return AuthenticationResult.LOGIN_NOT_EXISTED_USERNAME;
        if (checkCorrectPassword(username, password)) return AuthenticationResult.LOGIN_SUCCESS;
        return AuthenticationResult.LOGIN_INCORRECT_PASSWORD;
    }

    public AuthenticationResult deleteAccount(String username, String password) {
        if (!checkUserExists(username)) return AuthenticationResult.LOGIN_NOT_EXISTED_USERNAME;
        if (!checkCorrectPassword(username, password)) return AuthenticationResult.LOGIN_INCORRECT_PASSWORD;
        userPassList.remove(username);
        save();
        return AuthenticationResult.DELETE_ACCOUNT_SUCCESS;
    }

    private boolean addUser(String username, String password) {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            userPassList.put(username, md.digest(password.getBytes(StandardCharsets.UTF_8)));
            save();
            return true;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean checkUserExists(String newUsername) {
        for (String username : userPassList.keySet()) {
            if (newUsername.equals(username)) return true;
        }
        return false;
    }

    private boolean checkCorrectPassword(String newUsername, String newPassword) {
        for (String username : userPassList.keySet()) {
            if (newUsername.equals(username)) {
                MessageDigest md;
                try {
                    md = MessageDigest.getInstance("SHA-256");
                    if (Arrays.equals(userPassList.get(newUsername), md.digest(newPassword.getBytes(StandardCharsets.UTF_8))))
                        return true;
                } catch (NoSuchAlgorithmException e) {
                    e.printStackTrace();
                }
                return false;
            }
        }
        return false;
    }

    private boolean checkPassword(String password) {
        /*if (password.length() > 20 || password.length() < 8) return false;
        else if (!password.matches(".*\\d.*")) return false;
        else if (!password.matches(".*[A-Z].*")) return false;
        else if (!password.matches(".*[a-z].*")) return false;
        else if (!password.matches(".*[\\^=+\\-()*&%$#@!].*")) return false;
        else return password.matches("\\S*");*/
        return true;
    }

    private boolean checkUsername(String username) {
        /*if (username.length() > 30 || username.length() < 6) return false;
        else if (!username.matches("^[A-Za-z].*")) return false;
        else return username.matches("[\\dA-Za-z_]+");*/
        return true;
    }

    private void load() {
        FileManager fileManager = new FileManager();
        String userListText = fileManager.read("users.json");
        if (!userListText.isEmpty())
            userPassList = new Gson().fromJson(userListText, new TypeToken<HashMap<String, byte[]>>() {
            }.getType());
    }

    private void save() {
        Gson gson = new Gson();
        String userListText = gson.toJson(userPassList);
        FileManager fileManager = new FileManager();
        fileManager.write("users.json", userListText);
    }
}