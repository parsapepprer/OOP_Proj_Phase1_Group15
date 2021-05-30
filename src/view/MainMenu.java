package main.menu;

import java.util.HashMap;

public class MainMenu extends Menu {
    public MainMenu() {
        super("model.Main Menu");
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new Menu1(this));
        submenus.put(2, new Menu2(this));
        this.setSubmenus(submenus);
    }
}
