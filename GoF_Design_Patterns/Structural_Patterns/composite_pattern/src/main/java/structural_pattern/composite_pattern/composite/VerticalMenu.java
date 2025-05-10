package structural_pattern.composite_pattern.composite;

import structural_pattern.composite_pattern.component.MenuComponent;

import java.util.ArrayList;
import java.util.List;

public class VerticalMenu extends MenuComponent {
    private final String title;
    private final List<MenuComponent> children = new ArrayList<>();

    public VerticalMenu(String title) {
        this.title = title;
    }

    @Override
    public void add(MenuComponent component) {
        children.add(component);
    }

    @Override
    public MenuComponent getChild(int index) {
        return children.get(index);
    }

    @Override
    public void print(String prefix) {
        System.out.println(prefix + "⬇️ " + title);
        for (MenuComponent c : children) {
            c.print(prefix + "    ");
        }
    }
}
