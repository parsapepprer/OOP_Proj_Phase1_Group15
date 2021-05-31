package view.game;

import controller.GameManager;
import controller.Logger;
import controller.MissionManager;
import model.User;
import view.AbstractMenu;

public class Menu extends AbstractMenu {

    private final GameManager gameManager;
    private final MissionManager missionManager;

    public Menu(User user) {
        super();
        this.gameManager = new GameManager(user);
        this.missionManager = new MissionManager();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Start");
            System.out.println("2. Settings");
            System.out.println("3. Log out");
            System.out.println("4. Exit");
            while (true) {
                try {
                    int nextMenuNum = Integer.parseInt(scanner.nextLine());
                    if (nextMenuNum == 1) {
                        try {
                            System.out.println();
                            Logger.log("info", "The user wanted to start the game.");
                            System.out.println("Enter the level:");
                            int level = Integer.parseInt(scanner.nextLine());
                            Logger.log("info", "The user entered the level.");

                            if (gameManager.checkInvalidLevel(level)) {
                                Logger.log("error", "The user entered a invalid level.");
                                System.out.println("The level is invalid!");
                                System.out.println();

                            } else if (gameManager.checkLockedLevel(level)) {
                                Logger.log("error", "The user entered a locked level.");
                                System.out.println("The level is locked!");
                                System.out.println();

                            } else {
                                System.out.println();
                                Logger.log("info", "The user started the game level " + level + ".");
                                new Start(gameManager, missionManager.getMission(level)).run();
                            }
                        } catch (Exception ignored) {
                            Logger.log("error", "The user entered a invalid level.");
                            System.out.println("The level is invalid!");
                            System.out.println();
                        }
                        break;

                    } else if (nextMenuNum == 2) {
                        System.out.println();
                        Logger.log("info", "The user wanted to go to the settings.");
                        new Settings(gameManager).run();
                        break;

                    } else if (nextMenuNum == 3) {
                        System.out.println();
                        Logger.log("info", "The user logged out.");
                        return;

                    } else if (nextMenuNum == 4) {
                        Logger.log("info", "The user closed the game.");
                        System.exit(1);

                    } else {
                        Logger.log("error", "An invalid number was entered.");
                        System.out.println("Invalid number!");
                    }
                } catch (Exception ignored) {
                    Logger.log("error", "An invalid number was entered.");
                    System.out.println("Invalid number!");
                }
            }
        }
    }
}
