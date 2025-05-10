package structural_pattern.composite_pattern.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import structural_pattern.composite_pattern.component.MenuComponent;
import structural_pattern.composite_pattern.composite.Menu;
import structural_pattern.composite_pattern.composite.ContextMenu;
import structural_pattern.composite_pattern.composite.VerticalMenu;
import structural_pattern.composite_pattern.leaf.MenuItem;
import structural_pattern.composite_pattern.leaf.Separator;

@Component// phải là spring bean thì dùng CommandLineRunner mới có tác dụng
@Order(1) // khi có nhiều runner thêm order để chỉ định thứ tự, nếu ko spring sẽ thực hiện thứ tự ngẫu nhiên
public class FirstRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---CLIENT FIRST---");
        // composite
        MenuComponent foodMenu = new Menu("Food menu");
        MenuComponent drinkMenu = new Menu("Drink menu");
        MenuComponent dessertMenu = new Menu("Dessert menu");
        MenuComponent specialMenu = new VerticalMenu("Composite other #1");

        // leaf
        MenuComponent chicken = new MenuItem("Chicken");
        MenuComponent beefSteak = new MenuItem("Beef Steak");

        MenuComponent gin = new MenuItem("Gin");
        MenuComponent vodka = new MenuItem("Vodka");
        MenuComponent rum = new MenuItem("Rum");
        MenuComponent vermouth = new MenuItem("Vermouth");

        MenuComponent apple = new MenuItem("Apple");
        MenuComponent orange = new MenuItem("Orange");

        MenuComponent randomItem = new MenuItem("Random Item");

        MenuComponent separator = new Separator("Leaf other");

        foodMenu.add(chicken);
        foodMenu.add(beefSteak);

        MenuComponent comboDealsDrink = new Menu("Combo deals");
        comboDealsDrink.add(gin);
        comboDealsDrink.add(vodka);

        drinkMenu.add(comboDealsDrink);
        drinkMenu.add(rum);
        drinkMenu.add(vermouth);

        dessertMenu.add(apple);
        dessertMenu.add(orange);

        MenuComponent allMenus = new Menu("All menus");
        allMenus.add(foodMenu);
        allMenus.add(drinkMenu);
        allMenus.add(dessertMenu);
        allMenus.add(specialMenu);

        MenuComponent test = new ContextMenu("Composite other #2");
        allMenus.add(test);
        allMenus.add(randomItem);
        allMenus.add(separator);
        // print
        allMenus.print(""); // Một hành vi print() nhưng là áp dụng cho mọi object (cả leaf lẫn composite) - đệ quy
    }
}
