package structural_pattern.composite_pattern.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import structural_pattern.composite_pattern.component.MenuComponent;
import structural_pattern.composite_pattern.composite.ContextMenu;
import structural_pattern.composite_pattern.composite.Menu;
import structural_pattern.composite_pattern.leaf.MenuItem;
import structural_pattern.composite_pattern.leaf.Separator;

@Component
@Order(2)
public class SecondRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("---CLIENT SECOND---");
        MenuComponent contextMenu = new ContextMenu("Context menu");
        MenuComponent comboDeals = new Menu("Combo deals");

        MenuComponent item1 = new MenuItem("Item1");
        MenuComponent item2 = new Separator("Item2");
        comboDeals.add(item1);
        contextMenu.add(comboDeals);
        contextMenu.add(item2);

        contextMenu.print("[5/10/2025]");
    }
}
