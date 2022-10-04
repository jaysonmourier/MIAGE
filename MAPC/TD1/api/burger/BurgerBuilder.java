package td1.original.api.burger;

public class BurgerBuilder {
    private String name;
    private static Burger burger;
    private static MenuSize size;

    private BurgerBuilder()
    {}

    public static BurgerBuilder order_menu(String name, MenuType type)
    {
        BurgerBuilder bb = new BurgerBuilder();
        burger = new Burger(name);
        switch (type)
        {
            case FISH_MENU:
                burger.add(BurgerMeat.WHITEFISH, 50);
                burger.add(BurgerSauce.BEARNAISE, 40);
                break;
            case MEAT_MENU:
                burger.add(BurgerMeat.BEEF, 100);
                burger.add(BurgerSauce.BURGER, 40);
                burger.add(BurgerIngredient.DEEPFRIEDONIONS, 10);
                burger.add(BurgerIngredient.CHEDDAR, 15);
                burger.add(BurgerIngredient.DEEPFRIEDONIONS, 10);
                burger.add(BurgerIngredient.CHEDDAR, 15);
                break;
            case CHEESE_MENU:
                burger.add(BurgerIngredient.CHEDDAR, 15);
                burger.add(BurgerMeat.BEEF, 100);
                burger.add(BurgerIngredient.CHEDDAR, 15);
                burger.add(BurgerSauce.BURGER, 40);
                break;
        }
        return bb;
    }

    public static BurgerBuilder order_personal(String name, MenuSize size, BurgerMeat meat)
    {
        BurgerBuilder bb = new BurgerBuilder();
        Burger b = new Burger(name);

        return bb;
    }

    public String toString()
    {
        return "" + burger.name() + " " + burger;
    }
}
