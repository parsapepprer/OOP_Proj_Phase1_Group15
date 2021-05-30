package main.menu;

public class SubMenu12 extends Menu {
    public SubMenu12(Menu parentMenu) {
        super("submenu12", parentMenu);
    }
    @Override
    public void show() {
        System.out.println("I'm sub-menu 1-2");
    }

    @Override
    public void execute() {
        System.out.println("execute in sub-menu 1-1");
        this.parentMenu.show();
        this.parentMenu.execute();
    }

}
