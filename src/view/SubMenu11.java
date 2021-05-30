package main.menu;

public class SubMenu11 extends Menu {
    public SubMenu11(Menu parentMenu) {
        super("submenu11",parentMenu);
    }

    @Override
    public void show() {
        System.out.println("I'm sub-menu 1-1");
    }

    @Override
    public void execute() {
        System.out.println("execute in sub-menu 1-1");
        this.parentMenu.show();
        this.parentMenu.execute();
    }
}
