package td1.original.api.burger;

public class BurgerBuilder {
    private String name;
    private MenuType menuType;
    private MenuSize menuSize;
    private BurgerMeat burgerMeat;

    private BurgerBuilder()
    {}

    public static BurgerBuilder order_menu(String name, MenuType type)
    {
        BurgerBuilder bb = new BurgerBuilder();
        bb.setName(name);
        bb.setMenuType(type);
        return bb;
    }

    public static BurgerBuilder order_personal(String name, MenuSize size, BurgerMeat meat)
    {
        BurgerBuilder bb = new BurgerBuilder();
        return bb;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }
}
