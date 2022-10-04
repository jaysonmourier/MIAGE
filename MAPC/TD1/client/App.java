package td1.original.client;

import td1.original.api.burger.BurgerBuilder;
import td1.original.api.burger.MenuType;

public class App {
    public static void main(String args[]) {
        BurgerBuilder bb = BurgerBuilder.order_menu("Menu1", MenuType.FISH_MENU);
        System.out.println(bb);
    }
}