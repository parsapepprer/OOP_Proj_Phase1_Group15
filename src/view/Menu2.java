package main.menu;

public class Menu2 extends Menu {
    public Menu2(Menu parentMenu) {
        super("Menu2", parentMenu);
    }

    @Override
    public void execute() {
        String name = scanner.nextLine();
        System.out.println("name is : " + name);
        this.parentMenu.show();
        this.parentMenu.execute();
    }

    @Override
    public void show() {
        System.out.println("Enter your name : ");
    }
}
