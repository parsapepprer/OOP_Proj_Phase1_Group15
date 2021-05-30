package main.menu;

import java.util.HashMap;

public class Menu1 extends Menu{
    public Menu1(Menu parentMenu) {
        super("Menu1", parentMenu);
        HashMap<Integer, Menu> submenus = new HashMap<>();
        submenus.put(1, new SubMenu11(this));
        submenus.put(2, new SubMenu12(this));
        this.setSubmenus(submenus);
    }
}
