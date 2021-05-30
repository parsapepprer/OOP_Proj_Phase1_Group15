package view.game;

import controller.GameManager;
import controller.Logger;
import view.AbstractMenu;

public class Start extends AbstractMenu {

    private GameManager manager;

    public Start(GameManager manager, int level) {
        super();
        this.manager = manager;
    }

    @Override
    public void run() {
        System.out.println("Start:");
        System.out.println("1. Back");

        while (true) {
            try {
                int nextMenuNum = Integer.parseInt(scanner.nextLine());
                if (nextMenuNum == 1) {
                    System.out.println();
                    Logger.log("info", "The user returned to the game menu.");
                    return;

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
